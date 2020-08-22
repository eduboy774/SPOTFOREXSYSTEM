package system;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Date;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import documentation.AccountSummary;
import documentation.AdministratorInformation;
import documentation.InvestorInformation;
import forms.Login;

public class SFXInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblClock;
	String todaysDate;
	// //
	private JTextField firstname;
	private JTextField secondname;
	private JTextField lastname;
	private JTextField emailaddress;
	private JTextField physicalAddress;
	
	
	private JPasswordField password;
	private JTextField mobilenumber;
	private JTextField amount;
	private String userType[];
	//Home panel variables //
	private JTextField newsPostTitle;
	private JTextField newsPostDate;
	private TextArea newsUpdates;
	private JTextField systemUpdateTitle;
	private JTextField systemUpdateDate;
	private JButton btnDisplayUpdates;
	private JButton btnSysUpdate;
	private TextArea systemUpdates;
	private String selectedGender;
	private JLabel lblSecondName;
	
	
	/**
	 * Launch the application.
	 */
	static public void main(String []args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SFXInterface frame = new SFXInterface(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 	
	/**
	 * Create the frame.
	 */
	public SFXInterface(String[] getUser) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Yona\\Desktop\\PROJECT LOGO.PNG"));
		setTitle("Spot FX System");
		//INDEX ZERO REPRESENT USERTYPE AND INDEX ONE REPRESENT USERID//
		
		userType = getUser;
		setExtendedState(getExtendedState() | Frame.MAXIMIZED_BOTH);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		setExtendedState(getExtendedState() | Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1456, 868);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		navigationPanel.setBackground(Color.GRAY);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		topPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel logPanel = new JPanel();
		
		logPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		logPanel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(logPanel, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
						.addComponent(navigationPanel, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE)
						.addComponent(topPanel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1208, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(topPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(logPanel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(navigationPanel, GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)))
		);
		logPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(10, 11, 206, 103);
		logPanel.add(lblLogo);
		Image img = new ImageIcon(this.getClass().getResource("/PROJECT LOGO.png")).getImage();
		//lblLogo.seti
		lblLogo.setIcon(new ImageIcon(img));
		topPanel.setLayout(null);
		
		JLabel lblForexSpot = new JLabel("SPOT FOREX TRADER");
		lblForexSpot.setForeground(new Color(0, 191, 255));
		lblForexSpot.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 55));
		lblForexSpot.setBounds(10, 11, 487, 61);
		topPanel.add(lblForexSpot);
		
		/*Timer time = new Timer();
		try {
			time.wait(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, time);
		*/
		
		/*
		 * Gets the date of today
		 */
		
		lblClock = new JLabel("Clock..");
		lblClock.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		lblClock.setBounds(10, 94, 118, 20);
		topPanel.add(lblClock);
		date();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 63, 110, 20);
		topPanel.add(panel);
		panel.setLayout(null);
		
		/*
		 * Displays user first name at top panel
		 */
		JLabel lblFirstName = new JLabel("");
		lblFirstName.setBounds(0, 0, 48, 14);
		panel.add(lblFirstName);
		
		lblSecondName = new JLabel("");
		lblSecondName.setBounds(58, 0, 48, 14);
		panel.add(lblSecondName);
		
		
		/*
		 * Logout session
		 */
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBackground(SystemColor.menu);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int getResponce = JOptionPane.showConfirmDialog(null, "Are you sure to logout?");
				/*
				 * 0 represents "Yes"
				 * 1 represents "No"
				 * 2 represents "Cancel"
				 */
				if(getResponce == 0) {
					Login.main(null);
					closeInterface();
				}
			}
		});
		btnLogout.setBounds(130, 63, 89, 23);
		topPanel.add(btnLogout);
		contentPanel.setLayout(new CardLayout(0, 0));
		
		/*
		 * System home panel
		 */
		JPanel homePanel = new JPanel();
		homePanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(homePanel, "name_47301233612042");
		
		JPanel wordldNewsPanel = new JPanel();
		wordldNewsPanel.setBounds(0, 0, 1198, 448);
		wordldNewsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		wordldNewsPanel.setBackground(Color.LIGHT_GRAY);
		wordldNewsPanel.setLayout(null);
		
		JLabel lblWorldNews = new JLabel("World News  ");
		lblWorldNews.setForeground(new Color(72, 61, 139));
		lblWorldNews.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 37));
		lblWorldNews.setBounds(10, 11, 236, 46);
		wordldNewsPanel.add(lblWorldNews);
		
		/*
		 * Text area for news updates
		 */
		newsUpdates = new TextArea();
		newsUpdates.setFont(new Font("Verdana", Font.PLAIN, 14));
		newsUpdates.setEditable(false);
		newsUpdates.setBounds(10, 89, 969, 349);
		wordldNewsPanel.add(newsUpdates);
		
		JButton btnUpdateNews = new JButton("Post");
		btnUpdateNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnUpdateNews.getText().equals("Update")) {
					newsUpdates.setEditable(true);
					btnUpdateNews.setText("Post");
					newsUpdates.setText("");
				}else {
					if(newsPostTitle.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "* Please input post title. *");
					}else if(newsPostDate.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "* Please input post date. *");
					}else if(newsUpdates.getText().isBlank() ) {
						JOptionPane.showMessageDialog(null, "* You can't post nothing! *");
					}else {
						newsUpdates.setEditable(false);
						btnUpdateNews.setText("Update");
						updateNews();
					}
				}
			}
		});
		btnUpdateNews.setFont(new Font("Calibri", Font.BOLD, 14));
		btnUpdateNews.setBounds(985, 157, 124, 23);
		wordldNewsPanel.add(btnUpdateNews);
		btnUpdateNews.setVisible(false);
		
		JPanel systemUpdatesPanel = new JPanel();
		systemUpdatesPanel.setBounds(0, 445, 1198, 262);
		systemUpdatesPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		systemUpdatesPanel.setBackground(Color.LIGHT_GRAY);
		systemUpdatesPanel.setLayout(null);
		
		JLabel lblSystemUpdates = new JLabel("System   Updates");
		lblSystemUpdates.setForeground(new Color(72, 61, 139));
		lblSystemUpdates.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 37));
		lblSystemUpdates.setBounds(10, 11, 296, 40);
		systemUpdatesPanel.add(lblSystemUpdates);
		
		/*
		 * System updates text area
		 */
		systemUpdates = new TextArea();
		systemUpdates.setFont(new Font("Verdana", Font.PLAIN, 14));
		systemUpdates.setBounds(10, 70, 970, 171);
		systemUpdatesPanel.add(systemUpdates);
		systemUpdates.setEditable(false);
		
		btnDisplayUpdates = new JButton("Display Updates");
		btnDisplayUpdates.setForeground(new Color(0, 0, 0));
		btnDisplayUpdates.setVisible(true);
		btnDisplayUpdates.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDisplayUpdates.setBounds(986, 70, 138, 23);
		
		btnDisplayUpdates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnDisplayUpdates.getText().equals("Display Updates")) {
					systemUpdates.setText("");
					btnDisplayUpdates.setText("Today's updates");
					retrieveSysUpdates("*");
				}else {
					btnDisplayUpdates.setText("Display Updates");
					systemUpdates.setText("");
					retrieveSysUpdates(todaysDate);
				}
				systemUpdates.setEditable(false);
				btnSysUpdate.setText("Update");
			}
		});
		
		systemUpdatesPanel.add(btnDisplayUpdates);
		homePanel.setLayout(null);
		homePanel.add(wordldNewsPanel);
		
		JButton btnDisplayPosts = new JButton("Display Posts");
		btnDisplayPosts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnDisplayPosts.getText().equals("Display Posts")) {
					newsUpdates.setText("");
					btnDisplayPosts.setText("Today's posts");
					//Here this method retrieves news for all dates 
					retrieveNews("*");
				}else {
					newsUpdates.setText("");
					btnDisplayPosts.setText("Display Posts");
					//Here this method retrieves news for all dates 
					//JOptionPane.showMessageDialog(null, todaysDate);
					retrieveNews(todaysDate);
				}
				newsUpdates.setEditable(false);
				btnUpdateNews.setText("Update");
			}
		});
		btnDisplayPosts.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDisplayPosts.setBounds(985, 89, 124, 23);
		wordldNewsPanel.add(btnDisplayPosts);
		
		newsPostTitle = new JTextField();
		newsPostTitle.setBounds(80, 63, 124, 20);
		newsPostTitle.setColumns(10);
		newsPostTitle.setVisible(false);
		wordldNewsPanel.add(newsPostTitle);
		
		JLabel lblPostTitle = new JLabel("Post Title:");
		lblPostTitle.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPostTitle.setForeground(new Color(72, 61, 139));
		lblPostTitle.setBounds(10, 68, 72, 14);
		lblPostTitle.setVisible(false);
		wordldNewsPanel.add(lblPostTitle);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Calibri", Font.BOLD, 14));
		lblDate.setForeground(new Color(72, 61, 139));
		lblDate.setBounds(214, 68, 48, 14);
		lblDate.setVisible(false);
		wordldNewsPanel.add(lblDate);
		
		newsPostDate = new JTextField();
		newsPostDate.setBounds(272, 63, 124, 20);
		newsPostDate.setColumns(10);
		newsPostDate.setVisible(false);
		wordldNewsPanel.add(newsPostDate);
		
		JButton btnNewsClearWindow = new JButton("Clear Window");
		btnNewsClearWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newsUpdates.setText("");
			}
		});
		btnNewsClearWindow.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewsClearWindow.setBounds(985, 123, 124, 23);
		wordldNewsPanel.add(btnNewsClearWindow);
		homePanel.add(systemUpdatesPanel);
		
		JLabel lblUpdateTitlte = new JLabel("Update Titlte:");
		lblUpdateTitlte.setFont(new Font("Calibri", Font.BOLD, 14));
		lblUpdateTitlte.setForeground(new Color(72, 61, 139));
		lblUpdateTitlte.setBounds(10, 50, 81, 14);
		systemUpdatesPanel.add(lblUpdateTitlte);
		lblUpdateTitlte.setVisible(false);
		
		systemUpdateTitle = new JTextField();
		systemUpdateTitle.setBounds(101, 45, 121, 20);
		systemUpdatesPanel.add(systemUpdateTitle);
		systemUpdateTitle.setColumns(10);
		systemUpdateTitle.setVisible(false);
		
		JLabel lblUpdateDate = new JLabel("Update Date:");
		lblUpdateDate.setFont(new Font("Calibri", Font.BOLD, 14));
		lblUpdateDate.setForeground(new Color(72, 61, 139));
		lblUpdateDate.setBounds(232, 48, 81, 14);
		systemUpdatesPanel.add(lblUpdateDate);
		lblUpdateDate.setVisible(false);
		
		systemUpdateDate = new JTextField();
		systemUpdateDate.setBounds(323, 45, 121, 20);
		systemUpdatesPanel.add(systemUpdateDate);
		systemUpdateDate.setColumns(10);
		systemUpdateDate.setVisible(false);
		
		JButton btnSysClearWindow = new JButton("Clear Window");
		btnSysClearWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				systemUpdates.setText("");
			}
		});
		btnSysClearWindow.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSysClearWindow.setBounds(986, 104, 138, 23);
		systemUpdatesPanel.add(btnSysClearWindow);
		
		btnSysUpdate = new JButton("Post");
		btnSysUpdate.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSysUpdate.setBounds(986, 138, 138, 23);
		btnSysUpdate.setVisible(false);
		systemUpdatesPanel.add(btnSysUpdate);
		btnSysUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnSysUpdate.getText().equals("Update")) {
					systemUpdates.setText("");
					btnSysUpdate.setText("Post");
					systemUpdates.setEditable(true);
				}else {
					if(systemUpdateTitle.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "* Please input update title. *");
					}else if(systemUpdateDate.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "* Please input update date. *");
					}else if(systemUpdates.getText().isBlank() ) {
						JOptionPane.showMessageDialog(null, "* You have to write something! *");
					}else {
						systemUpdates.setEditable(false);
						btnSysUpdate.setText("Update");
						updateSysUpdates();
					}
				}
			}
		});
		
		JPanel profilePanel = new JPanel();
		profilePanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(profilePanel, "name_47301277941545");
		profilePanel.setLayout(null);
		
		JPanel editprofilePanel = new JPanel();
		editprofilePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editprofilePanel.setBackground(Color.LIGHT_GRAY);
		editprofilePanel.setBounds(302, 60, 534, 544);
		profilePanel.add(editprofilePanel);
		editprofilePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setBounds(52, 38, 78, 14);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		editprofilePanel.add(lblNewLabel);
		
		JLabel lblsecondname = new JLabel("Second Name: ");
		lblsecondname.setBounds(52, 90, 103, 14);
		lblsecondname.setFont(new Font("Calibri", Font.BOLD, 14));
		editprofilePanel.add(lblsecondname);
		
		JLabel lbllastname = new JLabel("Last Name :");
		lbllastname.setBounds(52, 142, 100, 14);
		lbllastname.setFont(new Font("Calibri", Font.BOLD, 14));
		editprofilePanel.add(lbllastname);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setBounds(52, 194, 100, 14);
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 14));
		editprofilePanel.add(lblNewLabel_3);
		
		
		
		firstname = new JTextField();
		firstname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		firstname.setBounds(209, 38, 140, 20);
		editprofilePanel.add(firstname);
		firstname.setColumns(10);
		firstname.setEnabled(false);
		
		secondname = new JTextField();
		secondname.setBounds(209, 85, 140, 20);
		editprofilePanel.add(secondname);
		secondname.setColumns(10);
		secondname.setEnabled(false);
		
		lastname = new JTextField();
		lastname.setBounds(209, 137, 140, 20);
		editprofilePanel.add(lastname);
		lastname.setColumns(10);
		lastname.setEnabled(false);
		
		emailaddress = new JTextField();
		emailaddress.setBounds(209, 241, 140, 20);
		editprofilePanel.add(emailaddress);
		emailaddress.setColumns(10);
		emailaddress.setEnabled(false);
		
		JLabel lblPhysicalAddress = new JLabel("Physical Address:");
		lblPhysicalAddress.setBounds(52, 402, 123, 14);
		lblPhysicalAddress.setFont(new Font("Calibri", Font.BOLD, 14));
		editprofilePanel.add(lblPhysicalAddress);
		
		JLabel lblEmailaddress = new JLabel("E-mail-Address:");
		lblEmailaddress.setBounds(52, 246, 127, 14);
		lblEmailaddress.setFont(new Font("Calibri", Font.BOLD, 14));
		editprofilePanel.add(lblEmailaddress);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(44, 303, 90, -7);
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 14));
		editprofilePanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(52, 298, 144, 14);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		editprofilePanel.add(lblNewLabel_1);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setBounds(52, 350, 107, 14);
		lblCountry.setFont(new Font("Calibri", Font.BOLD, 14));
		editprofilePanel.add(lblCountry);
		
		JComboBox<String> country = new JComboBox<String>();
		country.setEditable(true);
		country.setBounds(209, 344, 140, 22);
		editprofilePanel.add(country);
		country.setEnabled(false);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number :");
		lblMobileNumber.setBounds(52, 454, 100, 14);
		lblMobileNumber.setFont(new Font("Calibri", Font.BOLD, 14));
		editprofilePanel.add(lblMobileNumber);
		
		password = new JPasswordField();
		password.setBounds(209, 293, 140, 20);
		editprofilePanel.add(password);
		password.setEnabled(false);
		
		mobilenumber = new JTextField();
		mobilenumber.setBounds(209, 449, 140, 20);
		editprofilePanel.add(mobilenumber);
		mobilenumber.setColumns(10);
		mobilenumber.setEnabled(false);
		
		physicalAddress = new JTextField();
		physicalAddress.setBounds(209, 397, 140, 20);
		editprofilePanel.add(physicalAddress);
		physicalAddress.setColumns(10);
		physicalAddress.setEnabled(false);
		
		JButton btnsaves = new JButton("Edit Profile");
		btnsaves.setBounds(209, 517, 123, 27);
		editprofilePanel.add(btnsaves);
		btnsaves.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Calibri", Font.BOLD, 14));
		rdbtnFemale.setBackground(Color.LIGHT_GRAY);
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Calibri", Font.BOLD, 14));
		rdbtnMale.setBackground(Color.LIGHT_GRAY);
		
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnFemale.setSelected(true);
				rdbtnMale.setSelected(false);
				selectedGender = "Female";
			}
		});
		rdbtnFemale.setBounds(269, 188, 69, 23);
		editprofilePanel.add(rdbtnFemale);
		rdbtnFemale.setEnabled(false);
		
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMale.setSelected(true);
				rdbtnFemale.setSelected(false);
				selectedGender = "Male";
			}
		});
		rdbtnMale.setBounds(209, 188, 58, 23);
		editprofilePanel.add(rdbtnMale);
		rdbtnMale.setEnabled(false);
		
		JLabel lblProfile = new JLabel(" Profile");
		lblProfile.setForeground(new Color(72, 61, 139));
		lblProfile.setFont(new Font("Calibri", Font.BOLD, 32));
		lblProfile.setBounds(302, 12, 104, 37);
		profilePanel.add(lblProfile);
		
		JPanel investmentPanel = new JPanel();
		investmentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(investmentPanel, "name_47301325486742");
		
		JPanel accountPanel = new JPanel();
		accountPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		accountPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel simulationPanel = new JPanel();
		simulationPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		simulationPanel.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_investmentPanel = new GroupLayout(investmentPanel);
		gl_investmentPanel.setHorizontalGroup(
			gl_investmentPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(accountPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE)
				.addComponent(simulationPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE)
		);
		gl_investmentPanel.setVerticalGroup(
			gl_investmentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_investmentPanel.createSequentialGroup()
					.addComponent(accountPanel, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(simulationPanel, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
		);
		simulationPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(" Amount: $");
		lblNewLabel_2.setBounds(10, 68, 75, 14);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		simulationPanel.add(lblNewLabel_2);
		
		amount = new JTextField();
		amount.setBounds(95, 63, 113, 20);
		simulationPanel.add(amount);
		amount.setColumns(10);
		
		JLabel simulationProfit = new JLabel("Expected  Profit: ");
		simulationProfit.setFont(new Font("Calibri", Font.BOLD, 14));
		simulationProfit.setBounds(10, 125, 113, 14);
		simulationPanel.add(simulationProfit);
		accountPanel.setLayout(null);
		
		JLabel lblProfit = new JLabel("");
		lblProfit.setBounds(133, 123, 48, 14);
		simulationPanel.add(lblProfit);
		
		JButton btnSimulate = new JButton("Simulate");
		btnSimulate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amount.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Please input amount to simulate final expected profit in a year.");
				}else {
					//Average true range
					double d_ATR = 62.54;
					//2% of balance
					double d_investment = Double.parseDouble(amount.getText())*((double)(2)/(double)(100));
					double d_lotSize = d_investment/(1.5 * d_ATR);
					double d_pips = 6392;
					double d_expectedProfit = d_lotSize * d_pips;
					String s_expectedProfit = String.valueOf(d_expectedProfit);
			
					lblProfit.setText("$" + s_expectedProfit);
				}
		}
				
		});
		btnSimulate.setBounds(218, 64, 125, 18);
		btnSimulate.setFont(new Font("Calibri", Font.BOLD, 14));
		simulationPanel.add(btnSimulate);
		
		JLabel lblWelcomeToSee = new JLabel("Simulation");
		lblWelcomeToSee.setBounds(10, 11, 201, 46);
		simulationPanel.add(lblWelcomeToSee);
		lblWelcomeToSee.setForeground(new Color(72, 61, 139));
		lblWelcomeToSee.setFont(new Font("Calibri", Font.BOLD, 37));
		
		JLabel lblAccountDetails = new JLabel("ACCOUNT DETAILS");
		lblAccountDetails.setBounds(425, 11, 285, 46);
		accountPanel.add(lblAccountDetails);
		lblAccountDetails.setFont(new Font("Calibri", Font.BOLD, 37));
		lblAccountDetails.setForeground(new Color(72, 61, 139));
		
		JLabel lblExpectedProfit = new JLabel("Expected  Profit:");
		lblExpectedProfit.setFont(new Font("Calibri", Font.BOLD, 16));
		lblExpectedProfit.setBounds(425, 201, 135, 30);
		accountPanel.add(lblExpectedProfit);
		
		/*
		 * USER IS REQUIRED TO UPLOAD HIS/HER PAY SLIP NUMBER
		 */
		
		JLabel lblAttachPaySlip = new JLabel("Attach pay slip");
		lblAttachPaySlip.setFont(new Font("Calibri", Font.BOLD, 16));
		lblAttachPaySlip.setBounds(692, 127, 112, 14);
		accountPanel.add(lblAttachPaySlip);
		
		JButton btnAttach = new JButton("Pay-slip numbers");
		btnAttach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String paySlipNum = JOptionPane.showInputDialog("Please input your pay slip number.");
			}
		});
		btnAttach.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAttach.setBounds(817, 123, 135, 23);
		accountPanel.add(btnAttach);
		
		JLabel lblMinimumAmountRequired = new JLabel("Advised deposit amount: $100 ");
		lblMinimumAmountRequired.setFont(new Font("Calibri", Font.BOLD, 16));
		lblMinimumAmountRequired.setBounds(425, 160, 223, 30);
		accountPanel.add(lblMinimumAmountRequired);
		
		JLabel lblBalance = new JLabel("Balance: ");
		lblBalance.setForeground(Color.BLACK);
		lblBalance.setFont(new Font("Calibri", Font.BOLD, 16));
		lblBalance.setBounds(425, 119, 77, 30);
		accountPanel.add(lblBalance);
		
		JLabel balance = new JLabel("");
		balance.setBounds(512, 125, 48, 14);
		accountPanel.add(balance);
		
		JLabel expectedProfit = new JLabel("");
		expectedProfit.setBounds(570, 207, 48, 14);
		accountPanel.add(expectedProfit);
		investmentPanel.setLayout(gl_investmentPanel);
		
		JPanel finance_detailsPanel = new JPanel();
		finance_detailsPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(finance_detailsPanel, "name_47301380288055");
		finance_detailsPanel.setLayout(null);
		
		JTabbedPane tabbedPaneFinanceDetails = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneFinanceDetails.setBounds(0, 0, 1198, 699);
		finance_detailsPanel.add(tabbedPaneFinanceDetails);
		
		JPanel accountSummaryPanel = new JPanel();
		accountSummaryPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		accountSummaryPanel.setBackground(Color.LIGHT_GRAY);
		tabbedPaneFinanceDetails.addTab("ACCOUNT SUMMARY", null, accountSummaryPanel, null);
		accountSummaryPanel.setLayout(null);
		
		JLabel lblAccountSummary = new JLabel("ACCOUNT SUMMARY");
		lblAccountSummary.setForeground(new Color(72, 61, 139));
		lblAccountSummary.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 38));
		lblAccountSummary.setBounds(131, 11, 377, 52);
		accountSummaryPanel.add(lblAccountSummary);
		
		JLabel lblPrintAccountSummary = new JLabel("Print Account Summary");
		lblPrintAccountSummary.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPrintAccountSummary.setBounds(74, 95, 182, 14);
		accountSummaryPanel.add(lblPrintAccountSummary);
		
		/*
		 * ACCOUNT SUMMARY PRINTING SESSION
		 */
		AccountSummary accSummary = getAccSummary(expectedProfit.getText());
		
		JTextPane accountSummary = new JTextPane();
		accountSummary.setFont(new Font("Calibri", Font.PLAIN, 14));
		accountSummary.setBounds(10, 127, 783, 533);
		accountSummaryPanel.add(accountSummary);
		
		accountSummary.setText(
				"\tSPOT FOREX INVESTOR ACCOUNT SUMMARY\n\n"
				+ "\tNames: " + accSummary.getFirstName() + " " +  accSummary.getSecondName() + " " + accSummary.getLastName()+
				"\n\n \tPhysical Addrress:" + accSummary.getPhysicalAddress()+"\n\n\tEmailAddress:" + accSummary.getEmailAddress()+" \n\n\tCountry:"+accSummary.getCountry()+"\n\n\tMobileNumber:"+accSummary.getMobileNumber()
		
				
				);
		
		JButton btnprintsummary = new JButton("Print");
		btnprintsummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					accountSummary.print();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnprintsummary.setBounds(303, 89, 89, 23);
		accountSummaryPanel.add(btnprintsummary);
		

		JPanel accountHistoryPanel = new JPanel();
		accountHistoryPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		accountHistoryPanel.setBackground(Color.LIGHT_GRAY);
		tabbedPaneFinanceDetails.addTab("ACCOUNT History", null, accountHistoryPanel, null);
		accountHistoryPanel.setLayout(null);
		
		JLabel lblAccountHi = new JLabel("ACCOUNT HISTORY");
		lblAccountHi.setFont(new Font("Calibri", Font.BOLD, 37));
		lblAccountHi.setBounds(96, 11, 326, 43);
		accountHistoryPanel.add(lblAccountHi);
		
		JLabel lblPrintAccountHistory = new JLabel("Print Account History");
		lblPrintAccountHistory.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPrintAccountHistory.setBounds(101, 113, 169, 14);
		accountHistoryPanel.add(lblPrintAccountHistory);
		
		JButton btnprinthistory = new JButton("Print");
		btnprinthistory.setBounds(293, 107, 89, 23);
		accountHistoryPanel.add(btnprinthistory);
		
		JPanel updatesAndEvents = new JPanel();
		updatesAndEvents.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(updatesAndEvents, "name_47301435735699");
		updatesAndEvents.setLayout(null);
		
		JTabbedPane evenupdatesPane = new JTabbedPane(JTabbedPane.TOP);
		evenupdatesPane.setBackground(Color.LIGHT_GRAY);
		evenupdatesPane.setBounds(0, 0, 1198, 559);
		updatesAndEvents.add(evenupdatesPane);
		
		JPanel systemupdatesPanel = new JPanel();
		systemupdatesPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		systemupdatesPanel.setBackground(Color.LIGHT_GRAY);
		evenupdatesPane.addTab(" SYSTEM UPDATES", null, systemupdatesPanel, null);
		systemupdatesPanel.setLayout(null);
		
		JLabel lblWelcomeForSystem = new JLabel(" WELCOME FOR SYSTEM UPDATES");
		lblWelcomeForSystem.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 35));
		lblWelcomeForSystem.setBounds(87, 40, 531, 44);
		systemupdatesPanel.add(lblWelcomeForSystem);
		
		JButton btnSystemUpdates = new JButton("SYSTEM UPDATES");
		btnSystemUpdates.setForeground(Color.WHITE);
		btnSystemUpdates.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSystemUpdates.setBounds(200, 119, 176, 23);
		systemupdatesPanel.add(btnSystemUpdates);
		
		JPanel companyEventPanel = new JPanel();
		companyEventPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		companyEventPanel.setBackground(Color.LIGHT_GRAY);
		evenupdatesPane.addTab("COMPANY EVENT", null, companyEventPanel, null);
		companyEventPanel.setLayout(null);
		
		JLabel lblWelcomeForCompany = new JLabel("WELCOME FOR COMPANY EVENT");
		lblWelcomeForCompany.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 37));
		lblWelcomeForCompany.setBounds(102, 53, 577, 39);
		companyEventPanel.add(lblWelcomeForCompany);
		
		JButton btnCompanyEvent = new JButton("COMPANY EVENT");
		btnCompanyEvent.setForeground(Color.WHITE);
		btnCompanyEvent.setFont(new Font("Calibri", Font.BOLD, 14));
		btnCompanyEvent.setBounds(312, 126, 165, 23);
		companyEventPanel.add(btnCompanyEvent);
		getContentPane().setLayout(groupLayout);
		
		JButton btnhome = new JButton("Home");
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			homePanel.setVisible(true);
			profilePanel.setVisible(false);
			investmentPanel.setVisible(false);
			finance_detailsPanel.setVisible(false);
			updatesAndEvents.setVisible(false);
			}
		});
		btnhome.setForeground(Color.WHITE);
		btnhome.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btnprofile = new JButton("Profile");
		btnprofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				homePanel.setVisible(false);
				profilePanel.setVisible(true);
				investmentPanel.setVisible(false);
				finance_detailsPanel.setVisible(false);
				updatesAndEvents.setVisible(false);
			}
		});
		btnprofile.setForeground(Color.WHITE);
		btnprofile.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btninvestment = new JButton("Investment");
		btninvestment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				profilePanel.setVisible(false);
				investmentPanel.setVisible(true);
				finance_detailsPanel.setVisible(false);
				updatesAndEvents.setVisible(false);
			}
		});
		btninvestment.setFont(new Font("Calibri", Font.BOLD, 14));
		btninvestment.setForeground(Color.WHITE);
		
		JButton btnfinance_details = new JButton("Finance & Details");
		btnfinance_details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				profilePanel.setVisible(false);
				investmentPanel.setVisible(false);
				finance_detailsPanel.setVisible(true);
				updatesAndEvents.setVisible(false);
			}
		});
		btnfinance_details.setFont(new Font("Calibri", Font.BOLD, 14));
		btnfinance_details.setForeground(Color.WHITE);
		
		JButton btnevent_update = new JButton("Event & Updates");
		btnevent_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				profilePanel.setVisible(false);
				investmentPanel.setVisible(false);
				finance_detailsPanel.setVisible(false);
				updatesAndEvents.setVisible(true);
			}
		});
		btnevent_update.setForeground(Color.WHITE);
		btnevent_update.setFont(new Font("Calibri", Font.BOLD, 14));
		GroupLayout gl_navigationPanel = new GroupLayout(navigationPanel);
		gl_navigationPanel.setHorizontalGroup(
			gl_navigationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_navigationPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_navigationPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnhome, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
						.addComponent(btnprofile, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
						.addComponent(btninvestment, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
						.addComponent(btnfinance_details, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
						.addComponent(btnevent_update, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_navigationPanel.setVerticalGroup(
			gl_navigationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_navigationPanel.createSequentialGroup()
					.addGap(34)
					.addComponent(btnhome)
					.addGap(18)
					.addComponent(btnprofile)
					.addGap(18)
					.addComponent(btninvestment)
					.addGap(18)
					.addComponent(btnfinance_details)
					.addGap(18)
					.addComponent(btnevent_update)
					.addContainerGap(360, Short.MAX_VALUE))
		);
		navigationPanel.setLayout(gl_navigationPanel);
		
		/*
		 * All buttons features
		 */
		JButton buttons[] = {btnhome, btnprofile, btninvestment, btnfinance_details, btnevent_update,btnAttach,btnsaves ,btnCompanyEvent,
				btnSystemUpdates,btnprinthistory,btnprintsummary,btnUpdateNews,btnDisplayUpdates,btnSimulate, btnDisplayPosts, btnNewsClearWindow,
				btnDisplayUpdates, btnSysClearWindow, btnSysUpdate, btnLogout};
	
		changeButtonsColor(buttons);
		navigationPanel.setLayout(gl_navigationPanel);
		getContentPane().setLayout(groupLayout);
		
	        /*
	         * Load user names into the top panel of the system interface
	         */
		
			
			if(userType[0] == "Administrator") {
				/*
				 * ADMINISTRATOR PROFILE LOADING
				 */
				
				//News and system updates post buttons are shown to administrator
				btnUpdateNews.setVisible(true);
				btnSysUpdate.setVisible(true);
				
				//Text areas are set editable for the administrator
				newsUpdates.setEditable(true);
				systemUpdates.setEditable(true);
				
				//News and system updates title/date labels and text fields are shown to administrator
				/*
				 * labels
				 */
				//News
				lblPostTitle.setVisible(true);
				lblDate.setVisible(true);
				//System updates
				lblUpdateTitlte.setVisible(true);
				lblUpdateDate.setVisible(true);
				/*
				 * Text fields
				 */
				newsPostDate.setVisible(true);
				newsPostTitle.setVisible(true);
				systemUpdateTitle.setVisible(true);
				systemUpdateDate.setVisible(true);
				
				AdministratorInformation takeInfo = getAdminInfo();
				JOptionPane.showMessageDialog(null, "Welcome," + takeInfo.getFirstName());
				firstname.setText(takeInfo.getFirstName());
    			secondname.setText(takeInfo.getSecondName());
				lastname.setText(takeInfo.getLastName());
				if(takeInfo.getGender().equals("Male"))
				{
					rdbtnMale.setSelected(true);
					selectedGender = "Male";
				}
				else
				{
					rdbtnFemale.setSelected(true);
					selectedGender = "Female";
				}
				btnsaves.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
						if(btnsaves.getText().equals("Edit Profile")) {
							String password=JOptionPane.showInputDialog("Input password.");
							if(takeInfo.getPassword().equals(password)) {
								btnsaves.setText("Save");
								
								firstname.setEnabled(true);
								secondname.setEnabled(true);
								lastname.setEnabled(true);
								rdbtnFemale.setEnabled(true);
								rdbtnMale.setEnabled(true);
								emailaddress.setEnabled(true);
								country.setEnabled(true);
								SFXInterface.this.password.setEnabled(true);
								mobilenumber.setEnabled(true);
								physicalAddress.setEnabled(true);
								//profile button//
							}else {
								JOptionPane.showMessageDialog(null, "Incorrect password ...");
							}
						}else {
							takeInfo.setAdminstratorInfo(userType[1], password.getText(), firstname.getText(), secondname.getText(), lastname.getText(), selectedGender, physicalAddress.getText(), emailaddress.getText(), country.getSelectedItem().toString(), mobilenumber.getText());
							updteAdminInfo(takeInfo);
							btnsaves.setText("Edit Profile");
					
							firstname.setEnabled(false);
							secondname.setEnabled(false);
							lastname.setEnabled(false);
							rdbtnFemale.setEnabled(false);
							rdbtnMale.setEnabled(false);
							emailaddress.setEnabled(false);
							country.setEnabled(false);
							SFXInterface.this.password.setEnabled(false);
							mobilenumber.setEnabled(false);
							physicalAddress.setEnabled(false);
						}}});
				
				emailaddress.setText(takeInfo.getEmailAddress());
				physicalAddress.setText(takeInfo.getPhysicalAddress());
				password.setText(takeInfo.getUserPassword());
				country.setSelectedItem(takeInfo.getCountry());
				mobilenumber.setText(takeInfo.getMobileNumber());
				//Fetches administrator first name into top panel
				lblFirstName.setText(takeInfo.getFirstName());
				//Fetches administrator second name into top panel
				lblSecondName.setText(takeInfo.getSecondName());
			}else if(userType[0] == "Investor") {
				InvestorInformation takeInfo = getInvestorInfo();
				/*
				 * INVESTOR ACCOUNT DETAILS
				 */
				//Investor balance
				balance.setText("$" + takeInfo.getsBalance());
				
				//Investor expected profit
				//Average true range
				double d_ATR = 62.54;
				//2% of balance
				double d_investment = takeInfo.getdBalance()*((double)(2)/(double)(100));
				double d_lotSize = d_investment/(1.5 * d_ATR);
				double d_pips = 6392;
				double d_expectedProfit = d_lotSize * d_pips * 10;
				String s_expectedProfit = String.valueOf(d_expectedProfit);
				
				expectedProfit.setText("$" + s_expectedProfit);
				/*
				 * INVESTOR PROFILE LOADING
				 */
				
				
				JOptionPane.showMessageDialog(null, "Welcome," + takeInfo.getFirstName());
				firstname.setText(takeInfo.getFirstName());
    			secondname.setText(takeInfo.getSecondName());
				lastname.setText(takeInfo.getLastName());
				if(takeInfo.getGender().equals("Male"))
				{
					rdbtnMale.setSelected(true);
					selectedGender = "Male";
				}
				else
				{
					rdbtnFemale.setSelected(true);
					selectedGender = "Female";
				}
				btnsaves.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
						if(btnsaves.getText().equals("Edit Profile")) {
							String password=JOptionPane.showInputDialog("Input password.");
							if(takeInfo.getPassword().equals(password)) {
								btnsaves.setText("Save");
								
								firstname.setEnabled(true);
								secondname.setEnabled(true);
								lastname.setEnabled(true);
								rdbtnFemale.setEnabled(true);
								rdbtnMale.setEnabled(true);
								emailaddress.setEnabled(true);
								country.setEnabled(true);
								SFXInterface.this.password.setEnabled(true);
								mobilenumber.setEnabled(true);
								physicalAddress.setEnabled(true);
								//profile button//
							}else {
								JOptionPane.showMessageDialog(null, "Incorrect password ...");
							}
						}else {
							takeInfo.setInvestorInfo(userType[1], password.getText(), firstname.getText(), secondname.getText(), lastname.getText(), selectedGender, physicalAddress.getText(), emailaddress.getText(), country.getSelectedItem().toString(), mobilenumber.getText(), "2019-09-01");
							updteInvestorInfo(takeInfo);
							btnsaves.setText("Edit Profile");
					
							firstname.setEnabled(false);
							secondname.setEnabled(false);
							lastname.setEnabled(false);
							rdbtnFemale.setEnabled(false);
							rdbtnMale.setEnabled(false);
							emailaddress.setEnabled(false);
							country.setEnabled(false);
							SFXInterface.this.password.setEnabled(false);
							mobilenumber.setEnabled(false);
							physicalAddress.setEnabled(false);
						}}});
				
				emailaddress.setText(takeInfo.getEmailAddress());
				physicalAddress.setText(takeInfo.getPhysicalAddress());
				password.setText(takeInfo.getUserPassword());
				country.setSelectedItem(takeInfo.getCountry());
				mobilenumber.setText(takeInfo.getMobileNumber());
				
				//Fetches investor first name into top panel
				lblFirstName.setText(takeInfo.getFirstName());
				//Fetches investor second name into top panel
				lblSecondName.setText(takeInfo.getSecondName());
			}else {
				/*
				 * Trader codes go here
				 */
			}
	}
	
	private AccountSummary getAccSummary(String expextedProfit) {
		AccountSummary fetchSummary = new AccountSummary();
		try {
		Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/spotfxdb", "root", "");
		String query = "SELECT * FROM `investors`";
		PreparedStatement statement = (PreparedStatement)connection.prepareStatement(query);
		
		ResultSet getSummary = statement.executeQuery(query);
		
		String userID;
		String s_firstName;
		String s_secondName;
		String s_lastName;
		String s_physicalAddress;
		String s_emailAddress;
		String s_country;
		String s_mobileNumber;
		String s_balance;
		
		while(getSummary.next()) {
			userID = getSummary.getString("userID");
			s_firstName = getSummary.getString("firstName");
			s_secondName = getSummary.getString("secondName");
			s_lastName = getSummary.getString("lastName");
			s_physicalAddress = getSummary.getString("physicalAddress");
			s_emailAddress = getSummary.getString("eMailAddress");
			s_country = getSummary.getString("country");
			s_mobileNumber = getSummary.getString("mobileNumber");
			s_balance = getSummary.getString("balance");
			
			if(userID.equals(userType[1])) {
				fetchSummary.setAccSummary(s_firstName, s_secondName, s_lastName, s_physicalAddress, s_emailAddress, s_country, s_mobileNumber, s_balance, expextedProfit);
				break;
			}
		}
		
		getSummary.close();
		statement.close();
		connection.close();
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: Failed to connect with database.\n" + ex);
		}
		
		return fetchSummary;
	}
	
	private void closeInterface() {
		this.dispose();
	}
	 
	private InvestorInformation getInvestorInfo() {
		InvestorInformation getInfo = new InvestorInformation();
		try {
		Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/spotfxdb","root","");
		
		String query ="SELECT * FROM `investors`";
		PreparedStatement statement = (PreparedStatement)connection.prepareStatement(query);
		ResultSet investorInfo =  statement.executeQuery(query);
		String userIDdb;
		
		while(investorInfo.next())
		{
			userIDdb =  investorInfo.getString("userID");
			if(userIDdb.equals(userType[1]))
			{
				 getInfo.setInvestorInfo(
						 investorInfo.getString("userID"),
						 investorInfo.getString("password"), 
						 investorInfo.getString("firstName"),
						 investorInfo.getString("secondName"),
						 investorInfo.getString("lastName"),
						 investorInfo.getString("gender"),
						 investorInfo.getString("physicalAddress"),
						 investorInfo.getString("eMailAddress"),
						 investorInfo.getString("country"),
						 investorInfo.getString("mobileNumber"),
						 "2019-09-01"
						 );
				 getInfo.setsBalance(investorInfo.getString("balance"));
				 getInfo.setdBalance(investorInfo.getDouble("balance"));
				 
				 break;
			}
		}
		statement.close();
		investorInfo.close();
		connection.close();
		 
		 
		}catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null, " grabbing " + ex);
		}
		
		return getInfo;
	}
	
	private  AdministratorInformation getAdminInfo() {
		
		AdministratorInformation getInfo = new AdministratorInformation();
		try {
		Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/spotfxdb","root","");
		
		String query ="SELECT * FROM `administrators`";
		PreparedStatement statement = (PreparedStatement)connection.prepareStatement(query);
		ResultSet adminInfo =  statement.executeQuery(query);
		String userIDdb;
		
		while(adminInfo.next())
		{
			userIDdb =  adminInfo.getString("userID");
			if(userIDdb.equals(userType[1]))
			{
				 getInfo.setAdminstratorInfo(adminInfo.getString("userID"),
						 
						 adminInfo.getString("password"), 
						 adminInfo.getString("fName"),
						 adminInfo.getString("sName"),
						 adminInfo.getString("lName"),
						 adminInfo.getString("gender"),
						 adminInfo.getString("physicalAddress"),
						 adminInfo.getString("eMailAddress"),
						 adminInfo.getString("country"),
						 adminInfo.getString("mobileNumber"));
				 break;
			}
		}
		statement.close();
		 adminInfo.close();
		 connection.close();
		 
		 
		}catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null, " grabbing "+ex);
		}
		
		return getInfo;
	}
	
	
	/*
	 * Updating users profiles
	 */
	//Updating investor profile 
	private  void updteInvestorInfo(InvestorInformation fetchInfo ) {
		try {
		Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/spotfxdb","root","");
		
		String query ="UPDATE investors SET firstName = '" + fetchInfo.getFirstName() + "', secondName = '" + fetchInfo.getSecondName() +
				"', lastName = '" + fetchInfo.getLastName() + "' , gender = '" + fetchInfo.getGender() + "', physicalAddress = '" + fetchInfo.getPhysicalAddress() +
				"', eMailAddress = '" + fetchInfo.getEmailAddress() + "', password = '" + fetchInfo.getPassword() + "', country = '" + fetchInfo.getCountry() + 
				"', mobileNumber = '" + fetchInfo.getMobileNumber() + "' WHERE userID = '" + fetchInfo.getUserID() + "'";
		PreparedStatement statement = (PreparedStatement)connection.prepareStatement(query);
		statement.execute();
		statement.close();
		connection.close();
		
		JOptionPane.showMessageDialog(null, "Updated profile successfully!");
		}catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null, " Error: Failed updating database...\n"+ex);
		}
	}
	
	//Updating administrator profile 
	private  void updteAdminInfo(AdministratorInformation fetchInfo ) {
		try {
		Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/spotfxdb","root","");
		
		String query ="UPDATE administrators SET fName='"+fetchInfo.getFirstName()+"',sName='"+fetchInfo.getSecondName()+"',lName='"+
		fetchInfo.getLastName()+"',gender='"+fetchInfo.getGender()+"',physicalAddress='"+fetchInfo.getPhysicalAddress()+"',eMailAddress='"+
		fetchInfo.getEmailAddress()+"',password='"+fetchInfo.getPassword()+"',country='"+fetchInfo.getCountry()+"',mobileNumber='"+
		fetchInfo.getMobileNumber()+"' WHERE userID = '"+fetchInfo.getUserID()+"' ";
		PreparedStatement statement = (PreparedStatement)connection.prepareStatement(query);
		statement.execute();
		statement.close();
		connection.close();
		
		JOptionPane.showMessageDialog(null, "Updated profile successfully!");
		}catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null, " Error: Failed updating database...\n"+ex);
		}
	}
	
	
	private void retrieveNews(String date) {
		try {
		Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/spotfxdb", "root", "");
		String query = "SELECT * FROM `worldnews`";
		PreparedStatement statement = (PreparedStatement)connection.prepareStatement(query);
		ResultSet getNews = statement.executeQuery(query);
		
		/*
		 * News variables from database
		 */
		String newsPostTitledb;
		String newsPostDatedb;
		String newsUpdatesdb;
		
		while(getNews.next()) {
			
			newsPostTitledb = getNews.getString("title");
			newsPostDatedb  = getNews.getString("date");
			newsUpdatesdb   = getNews.getString("post");
			
			if(date.contains("*")) {
				/*
				 * Here fetched new is placed first in order to appear on top of all other news since it must be the latest one as fetched last
				 * from database 
				 */
				newsUpdates.setText("Title: " + newsPostTitledb + "\nDate: " + newsPostDatedb + "\n\n" + newsUpdatesdb +  "\n\n\n" +
				 newsUpdates.getText());
			}else {
				if(newsPostDatedb.equals(date)) {
					/*
					 * Here fetched new is placed first in order to appear on top of all other news since it must be the latest one as fetched last
					 * from database 
					 */
					newsUpdates.setText("Title: " + newsPostTitledb + "\nDate: " + newsPostDatedb + "\n\n" + newsUpdatesdb +  "\n\n\n" +
					 newsUpdates.getText());
				}
			}
		}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: Failed to retrieve news from database...\n" + ex);
		}
	}
	
	private void date()
	{
		Calendar cal = new GregorianCalendar();
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String s_day = String.valueOf(day);
		//We add 1 to month in order to correct its error of 1 month lag
		int month  = cal.get(Calendar.MONTH) + 1;
		String s_month = String.valueOf(month);
		//++month;
		int year = cal.get(Calendar.YEAR);
		
		//Since we added 1, in case month reaches 12 ours will show 13. We set it to 1(January)
		if(month > 12) {
			month = 1;
		}
		//int second = cal.get(Calendar.SECOND);
		//int minute= cal.get(Calendar.MINUTE);
		//int hour = cal.get(Calendar.HOUR);
		//"Time "+hour+":"+minute+":"+second+"
		if(month < 10) {
			s_month = "0" + s_month;
		}
		
		if(day < 10) {
			s_day = "0" + s_day;
		}
		todaysDate = year + "-" + s_month + "-" + s_day;
		lblClock.setText( " Date : " + todaysDate);
	}

	private void retrieveSysUpdates(String date) {
		try {
		Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/spotfxdb", "root", "");
		String query = "SELECT * FROM `systemupdates`"; 
		PreparedStatement statement = (PreparedStatement)connection.prepareStatement(query);
		ResultSet getUpdates = statement.executeQuery(query);
		String titledb;
		String descriptiondb;
		String datedb;
		
		while(getUpdates.next()) {
			titledb = getUpdates.getString("title");
			descriptiondb = getUpdates.getString("description");
			datedb = getUpdates.getString("date");
			
			if(date.contains("*")) {
				systemUpdates.setText("Title: " + titledb + "\nDate: " + datedb + "\n\n" + descriptiondb + "\n\n\n" + systemUpdates.getText());
			}else {
				if(datedb.equals(date)) {
					systemUpdates.setText("Title: " + titledb + "\nDate: " + datedb + "\n\n" + descriptiondb + "\n\n\n" + systemUpdates.getText());
				}
			}
		}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: Failed to get data from database...\n" + ex);
		}
	}
	
	/*
	 * UPDATING METHODS
	 */
	private void updateSysUpdates() {
		try {
			Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/spotfxdb", "root", "");
			String query = "INSERT INTO `systemupdates`(`title`, `description`, `date`) VALUES (?,?,?)";
			PreparedStatement statement = (PreparedStatement)connection.prepareStatement(query);
			statement.setString(1, systemUpdateTitle.getText());
			statement.setString(2, systemUpdates.getText());
			statement.setString(3, systemUpdateDate.getText());
			statement.executeUpdate();
			statement.close();
			connection.close();
			JOptionPane.showMessageDialog(null, "Updated successfully...");
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: Failed to update...\n" + ex);
		}
	}
	
	private void updateNews() {
		try {
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/spotfxdb", "root", "");
		String query = "INSERT INTO `worldnews`(`title`, `date`, `post`) VALUES (?,?,?)";
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
		statement.setString(1, newsPostTitle.getText());
		statement.setString(2, newsPostDate.getText());
		statement.setString(3, newsUpdates.getText());
		statement.executeUpdate();
		statement.close();
		connection.close();
		JOptionPane.showMessageDialog(null, " Posted...");
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, " Error: Failed to post...\n" + ex);
		}
	}

	private void changeButtonsColor(JButton buttons[]) {
		//Colors color;
		int redBackground =72 , blueBackground = 61, greenBackground = 139;
		int redForeground =255 , blueForeground = 255, greenForeground = 255;
		
		int Home = 0, btnProfile = 1, btnInvestment = 2, btnFinance_Details = 3, btnEvent_updates = 4 , btnAttach = 5 ,btnSaves = 6 ,btnCompanyEvent = 7,
				btnSystemUpdates = 8, btnPrintHistory = 9, btnPrintSummary = 10, btnNews = 11 , btnUpdates = 12 , btnSimulate = 13, btnUpdateNews = 14, btnClearWindow = 15,
				btnSystemUpdateInfo = 16, btnSysClearWindow = 17, btnSysUpdate = 18, btnLogout = 19;
		/*
		 * Buttons background
		 */
		buttons[Home].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnProfile].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnInvestment].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnFinance_Details].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnEvent_updates].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnAttach].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnSaves].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnCompanyEvent].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnSystemUpdates].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnPrintHistory].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnPrintSummary].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnNews].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnUpdates].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnSimulate].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnUpdateNews].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnClearWindow].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnSystemUpdateInfo].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnSysClearWindow].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnSysUpdate].setBackground(new Color(redBackground, blueBackground, greenBackground));
		buttons[btnLogout].setBackground(new Color(redBackground, blueBackground, greenBackground));
		
		/*
		 * Buttons foreground
		 */
		buttons[Home].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnProfile].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnInvestment].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnFinance_Details].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnEvent_updates].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnAttach].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnSaves].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnCompanyEvent].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnSystemUpdates].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnPrintHistory].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnPrintSummary].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnNews].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnUpdates].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnSimulate].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnUpdateNews].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnClearWindow].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnClearWindow].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnSystemUpdateInfo].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnSysClearWindow].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnSysUpdate].setForeground(new Color(redForeground, blueForeground, greenForeground));
		buttons[btnLogout].setForeground(new Color(redForeground, blueForeground, greenForeground));
	}
}
