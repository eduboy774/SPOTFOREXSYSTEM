package forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.PreparedStatement;

import documentation.UserInformation;
import system.SFXInterface;

public class Login {

	private JFrame frame;
	private JTextField userID;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Spot Forex Trader Login");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 698, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(350, 200);
		
		JLabel loginErrorTxt = new JLabel("");
		JPanel loginError = new JPanel();
		loginError.setBackground(Color.GRAY);
		JPanel Login_form = new JPanel();
		Login_form.setBackground(Color.GRAY);
		//userType.setSelectedItem("Customer");
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setFont(new Font("Calibri", Font.BOLD, 14));
		lblUserId.setForeground(Color.WHITE);
		
		userID = new JTextField("");
		/*userID.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				loginErrorTxt.setText("");
				loginError.setBackground(Color.GRAY);
			}
		});*/
		
		userID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btnSignin = new JButton("Signin");
		btnSignin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				boolean isPwdCorrect = false;
				String userType[] = new String[2];
				if(userID.getText().isBlank() && passwordField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "* Please fill all fields. *");
				}else if(userID.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "* Please fill userID. *");
				}else if(passwordField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "* Please fill password. *");
				}else if(userID.getText().contains("SFX")) {
					userType[0] = "Administrator";
					userType[1]= userID.getText();
					isPwdCorrect = checkCredentials(userType);
					loginMsg(isPwdCorrect, userType);

				}else if(userID.getText().contains("FXT")){
					userType[0] = "Trader";
					userType[1] = userID.getText();
					isPwdCorrect = checkCredentials(userType);
					loginMsg(isPwdCorrect, userType);
				}else if(userID.getText().contains("FXI")) {
					userType[0] = "Investor";
					userType[1] =userID.getText();
					isPwdCorrect = checkCredentials(userType);
					loginMsg(isPwdCorrect, userType);
				}
				else{
					JOptionPane.showConfirmDialog(null, "Mmm! It seems your userID is not in our system format, would you like to create an account?");
				}
			
			}
		});
		btnSignin.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSignin.setForeground(new Color(255, 255, 255));
		btnSignin.setBackground(new Color(72, 61, 139));
		
		passwordField = new JPasswordField();
		/*passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				loginErrorTxt.setText("");
				loginError.setBackground(Color.GRAY);
			}
		});*/
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setForeground(Color.WHITE);
		lblCreateAccount.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrationActivity();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCreateAccount.setForeground(new Color(72, 61, 139));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCreateAccount.setForeground(Color.WHITE);
			}
		});
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_Login_form = new GroupLayout(Login_form);
		gl_Login_form.setHorizontalGroup(
			gl_Login_form.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Login_form.createSequentialGroup()
					.addGap(112)
					.addGroup(gl_Login_form.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Login_form.createSequentialGroup()
							.addGroup(gl_Login_form.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Login_form.createSequentialGroup()
									.addComponent(lblUserId, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(userID, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Login_form.createSequentialGroup()
									.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
							.addGap(119))
						.addGroup(gl_Login_form.createSequentialGroup()
							.addGroup(gl_Login_form.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSignin, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Login_form.createParallelGroup(Alignment.LEADING)
									.addComponent(lblCreateAccount)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
				.addGroup(gl_Login_form.createSequentialGroup()
					.addGap(96)
					.addComponent(loginError, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
					.addGap(95))
		);
		gl_Login_form.setVerticalGroup(
			gl_Login_form.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Login_form.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_Login_form.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Login_form.createSequentialGroup()
							.addGap(6)
							.addComponent(lblUserId, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(userID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_Login_form.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Login_form.createSequentialGroup()
							.addGap(7)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addComponent(btnSignin, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCreateAccount)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addComponent(loginError, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
		);
		
		loginError.add(loginErrorTxt);
		Login_form.setLayout(gl_Login_form);
		
		JLabel lblLogin = new JLabel("System Login");
		lblLogin.setForeground(new Color(72, 61, 139));
		lblLogin.setFont(new Font("Calibri", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(104)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogin)
						.addComponent(Login_form, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogin)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Login_form, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void loadSystem(String[] userType) {
		frame.dispose();
		String []userTypeArray = userType;
		SFXInterface.main(userTypeArray);
	}
	
	private void loginMsg(boolean isPwdCorrect, String []userType) {
		if(isPwdCorrect == true) {
			loadSystem(userType);
		}else {
			JOptionPane.showMessageDialog(null, "* Incorrect userID or password *");
		}
	}
	
	/*
	 * Tries to match input userID and password with information in the data base
	 */
	private boolean checkCredentials(String []userType)
	{	
		UserInformation receiveInfo = null;
	
		String query = "";
		
		/*
		 * We check which user is trying to login 
		 */
		if(userType[0] == "Administrator") {
			query = "SELECT * FROM `administrators`";
			receiveInfo = dbConnection(query);
		}else if(userType[0] == "Investor") {
			query = "SELECT * FROM `Investors`";
			receiveInfo = dbConnection(query);
		}else if(userType[0] == "Trader") {
			query = "SELECT * FROM `Traders`";
			receiveInfo = dbConnection(query);
		}
		
		return receiveInfo.getPwdCorrectness();
	}
	
	private UserInformation dbConnection(String query) {
		UserInformation setInfo = new UserInformation();
		try {
			/*
			 * Connects to the database system
			 */
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/spotfxdb", "root", "");
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet getResults = preparedStatement.executeQuery(query);
			
			/*
			 * Prepares variables for user and database
			 */
			String userIDdb = "";
			String passworddb = "";
			String getuserID = userID.getText();
			@SuppressWarnings("deprecation")
			String getuserPassword = passwordField.getText();
			
			/*
			 * Tries to match userID with password
			 */
			while(getResults.next()) {
					userIDdb = getResults.getString("userID");
					passworddb = getResults.getString("password");
					if(userIDdb.equals(getuserID) && passworddb.equals(getuserPassword)) {
						setInfo.setUserInfo(userIDdb, passworddb);
						setInfo.setPwdCorrectness(true);
						break;
					}
			}
			
			/*
			 * Database connection ends here
			 */
			preparedStatement.close();
			getResults.close();
			connection.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "* Error: Failed to connect with database! *");
			//e1.printStackTrace();
		}
		
		return setInfo;
	}
	
	private void registrationActivity() {
		frame.setVisible(false);
		Register register = new Register();
		register.setVisible(true);
//		if(!register.isShowing()) {
//			frame.setVisible(true);
//		}
	}
}