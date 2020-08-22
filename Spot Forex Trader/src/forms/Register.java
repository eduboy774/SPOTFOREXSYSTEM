package forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import documentation.InvestorInformation;
import documentation.TermsAndConditions;
import system.SFXInterface;

public class Register extends JFrame {

	/**
	 * Variables
	 */
	private static final long serialVersionUID = 1441321723774601034L;
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField secondName;
	private JTextField lastName;
	private JTextField physicalAddress;
	private JTextField eMailAddress;
	private JPasswordField passwordField;
	private JPasswordField confirmPassword;
	private static boolean registered;
	private boolean fNameHasSpecialChar, sNameHasSpecialChar, lNameHasSpecialChar, unwantedCharsinPAddress, unwantedCharsinEMail, unwantedCharsinPassword;
	private boolean unmatchedPasswords = false, unwantedCharsinMobNum;
	private String selectedGender = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public Register() {
		/*
		 * START OF CONSTRUCTOR
		 */
		//setExtendedState(getExtendedState() | Frame.MAXIMIZED_BOTH);
		setBackground(UIManager.getColor(new Color(240,240,240)));
		setTitle("Spot Forex Trader Registration");
		//this.setLocation(5500, 200);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 578);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
		/*
		 * All warning texts
		 */
		
		//First name warning text
		JLabel fNameWarning = new JLabel("");
		fNameWarning.setBounds(302, 19, 29, 14);
		panel.add(fNameWarning);
		
		//Second name warning text
		JLabel sNameWarning = new JLabel("");
		sNameWarning.setBounds(302, 51, 30, 14);
		panel.add(sNameWarning);
		
		JLabel lNameWarning = new JLabel("");
		lNameWarning.setBounds(302, 88, 32, 14);
		panel.add(lNameWarning);
		
		JLabel genderWarning = new JLabel("");
		genderWarning.setBounds(302, 117, 29, 14);
		panel.add(genderWarning);
		
		JLabel pAddressWarning = new JLabel("");
		pAddressWarning.setBounds(302, 163, 30, 14);
		panel.add(pAddressWarning);
		
		JLabel eMailAddressWarning = new JLabel("");
		eMailAddressWarning.setBounds(302, 199, 30, 14);
		panel.add(eMailAddressWarning);
		
		JLabel passwordWarning = new JLabel("");
		passwordWarning.setBounds(302, 230, 30, 14);
		panel.add(passwordWarning);
		
		JLabel cPasswordWarning = new JLabel("");
		cPasswordWarning.setBounds(302, 265, 30, 14);
		panel.add(cPasswordWarning);
		
		JLabel mobNumWarning = new JLabel("");
		mobNumWarning.setBounds(302, 336, 30, 14);
		panel.add(mobNumWarning);
		
		JLabel countryWarning = new JLabel("");
		countryWarning.setBounds(302, 299, 30, 14);
		panel.add(countryWarning);
		
		/*
		 * Error panels
		 */
		JPanel fNameErrorPanel = new JPanel();
		fNameErrorPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel sNameErrorPanel = new JPanel();
		sNameErrorPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel lNameErrorPanel = new JPanel();
		lNameErrorPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel genderErrorPanel = new JPanel();
		genderErrorPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel phyAddrErrorPanel = new JPanel();
		phyAddrErrorPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel eMailErrorPanel = new JPanel();
		eMailErrorPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel pwdErrorPanel = new JPanel();
		pwdErrorPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel cpwdErrorPanel = new JPanel();
		cpwdErrorPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel countryErrorPanel = new JPanel();
		countryErrorPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel mobNumErrorPanel = new JPanel();
		mobNumErrorPanel.setBackground(Color.LIGHT_GRAY);
		
		/*
		 * Error labels
		 */
		JLabel mobNumErrorTxt = new JLabel("");
		mobNumErrorPanel.add(mobNumErrorTxt);
		
		JLabel countryErrorTxt = new JLabel("");
		countryErrorPanel.add(countryErrorTxt);
		
		JLabel cpwdErrorTxt = new JLabel("");
		cpwdErrorPanel.add(cpwdErrorTxt);
		
		JLabel pwdErrorTxt = new JLabel("");
		pwdErrorPanel.add(pwdErrorTxt);
		
		JLabel eMailErrorTxt = new JLabel("");
		eMailErrorPanel.add(eMailErrorTxt);
		
		JLabel phyAddrErrorTxt = new JLabel("");
		phyAddrErrorPanel.add(phyAddrErrorTxt);
		
		JLabel genderErrorTxt = new JLabel("");
		genderErrorPanel.add(genderErrorTxt);
		
		JLabel lNameErrorTxt = new JLabel("");
		lNameErrorPanel.add(lNameErrorTxt);
		
		JLabel sNameErrorTxt = new JLabel("");
		sNameErrorPanel.add(sNameErrorTxt);
		
		JLabel fNameErrorTxt = new JLabel("");
		fNameErrorPanel.add(fNameErrorTxt);
		
		JComboBox<String> countries = new JComboBox<String>();
		countries.setEditable(true);
		countries.setModel(new DefaultComboBoxModel(new String[] {"...", "", "Afghanistan (+93)", "Albania (+355)", "Algeria (+213)", "American Samoa (+1-684)", "Andorra (+376)", "Angola (+244)", "Anguilla (+1-264)", "Antarctica (+672)", "Antigua and Barbuda (+1-268)", "Argentina (+54)", "Armenia (+374)", "Aruba (+297)", "Australia(+61)", "Austria (+43)", "Azerbaijan (+994)", "Bahamas (+1-242)", "Bahrain (+973)", "Bangladesh\t (+880)", "Barbados (+1-246)", "Belarus (+375)", "Belgium (+32)", "Belize (+501)", "Benin (+229)", "Bermuda (+1-441)", "Bhutan (+975)", "Bolivia (+591)", "Bonaire (+599)", "Bosnia and Herzegovina (+387)", "Botswana (+267)", "Bouvet Island (+47)", "Brazil (+55)", "British Indian Ocean Territory (+246)", "Brunei Darussalam (+673)", "Bulgaria (+359)", "Burkina Faso (+226)", "Burundi (+257)", "Cambodia (+855)", "Cameroon (+237)", "Canada (+124\t1)", "Cape Verde (+238)", "Cayman Islands\tKY (+1-345)", "Central African Republic (+236)", "Chad (+235)", "Chile (+56)", "China (+86)", "Christmas Island (+61)", "Cocos (Keeling) Islands\t(+61)", "Colombia (+57)", "Comoros (+269)", "Congo (+242)", "Democratic Republic of the Congo (+243)", "Cook Islands (+682)", "Costa Rica (+506)", "Croatia (+385)", "Cuba (+53)", "Curacao (+599)", "Cyprus (+357)", "Czech Republic (+420)", "Cote d'Ivoire (+225)", "Denmark (+45)", "Djibouti (+253)", "Dominica (+1-767)", "Dominican Republic (+1-849)", "Ecuador (+593)", "Egypt (+20)", "El Salvador (+503)", "Equatorial Guinea (+240)", "Eritrea (+291)", "Estonia (+372)", "Ethiopia (+251)", "Falkland Islands (Malvinas) (+500)", "Faroe Islands (+298)", "Fiji (+679)", "Finland (+358)", "France (+33)", "French Guiana (+594)", "French Polynesia (+689)", "French Southern Territories (+262)", "Gabon (+241)", "Gambia (+220)", "Georgia (+995)", "Germany (+49)", "Ghana (+233)", "Gibraltar (+350)", "Greece (+30)", "Greenland (+299)", "Grenada (+1-473)", "Guadeloupe (+590)", "Guam (+1-671)", "Guatemala (+502)", "Guernsey (+44)", "Guinea (+224)", "Guinea-Bissau (+245)", "Guyana (+592)", "Haiti (+509)", "Heard Island and McDonald Islands (+672)", "Holy See (Vatican City State) (+379)", "Honduras (+504)", "Hong Kong (+852)", "Hungary (+36)", "Iceland (+354)", "India (+91)", "Indonesia (+62)", "Iran, Islamic Republic of (+98)", "Iraq (+964)", "Ireland (+353)", "Isle of Man (+44)", "Israel (+972)", "Italy (+39)", "Jamaica (+1-876)", "Japan (+81)", "Jersey (+44)", "Jordan (+962)", "Kazakhstan (+7)", "Kenya (+254)", "Kiribati (+686)", "Korea, Democratic People's Republic of (+850)", "Korea, Republic of (+82)", "Kuwait (+965)", "Kyrgyzstan (+996)", "Lao People's Democratic Republic (+856)", "Latvia (+371)", "Lebanon (+961)", "Lesotho (+266)", "Liberia (+231)", "Libya (+218)", "Liechtenstein (+423)", "Lithuania (+370)", "Luxembourg (+352)", "Macao (+853)", "Macedonia, the Former Yugoslav Republic of (+389)", "Madagascar (+261)", "Malawi (+265)", "Malaysia (+60)", "Maldives (+960)", "Mali (+223)", "Malta (+356)", "Marshall Islands (+692)", "Martinique (+596)", "Mauritania (+222)", "Mauritius (+230)", "Mayotte (+262)", "Mexico (+52)", "Micronesia, Federated States of (+691)", "Moldova, Republic of (+373)", "Monaco (+377)", "Mongolia (+976)", "Montenegro (+382)", "Montserrat (+1-664)", "Morocco (+212)", "Mozambique (+258)", "Myanmar (+95)", "Namibia (+264)", "Nauru (+674)", "Nepal (+977)", "Netherlands (+31)", "New Caledonia (+687)", "New Zealand (+64)", "Nicaragua (+505)", "Niger (+227)", "Nigeria (+234)", "Niue (+683)", "Norfolk Island (+672)", "Northern Mariana Islands (+1-670)", "Norway (+47)", "Oman (+968)", "Pakistan (+92)", "Palau (+680)", "Palestine, State of (+970)", "Panama (+507)", "Papua New Guinea (+675)", "Paraguay (+595)", "Peru (+51)", "Philippines (+63)", "Pitcairn (+870)", "Poland\tPL\tPOL\t616\t48", "Portugal (+351)", "Puerto Rico (+1)", "Qatar (+974)", "Romania (+40)", "Russian Federation (+7)", "Rwanda (+250)", "Reunion (+262)", "Saint Barthelemy (+590)", "Saint Helena (+290)", "Saint Kitts and Nevis (+1-869)", "Saint Lucia (+1-758)", "Saint Martin (French part) (+590)", "Saint Pierre and Miquelon (+508)", "Saint Vincent and the Grenadines (+1-784)", "Samoa\t(+685)", "San Marino (+378)", "Sao Tome and Principe (+239)", "Saudi Arabia (+966)", "Senegal\t (+221)", "Serbia (+381)", "Seychelles (+248)", "Sierra Leone (+232)", "Singapore (+65)", "Sint Maarten (Dutch part) (+1-721)", "Slovakia (+421)", "Slovenia (+386)", "Solomon Islands (+677)", "Somalia (+252)", "South Africa (+27)", "South Georgia and the South Sandwich Islands (+500)", "South Sudan (+211)", "Spain (+34)", "Sri Lanka (+94)", "Sudan (+249)", "Suriname (+597)", "Svalbard and Jan Mayen (+47)", "Swaziland (+268)", "Sweden\tSE (+46)", "Switzerland (+41)", "Syrian Arab Republic (+963)", "Taiwan (+886)", "Tajikistan (+992)", "United Republic of Tanzania (+255)", "Thailand (+66)", "Timor-Leste (+670)", "Togo (+228)", "Tokelau (+690)", "Tonga (+676)", "Trinidad and Tobago (+1-868)", "Tunisia (+216)", "Turkey (+90)", "Turkmenistan (+993)", "Turks and Caicos Islands (+1-649)", "Tuvalu (+688)", "Uganda\t (+256)", "Ukraine (+380)", "United Arab Emirates (+971)", "United Kingdom (+44)", "United States (+1)", "United States Minor Outlying Islands (+1)", "Uruguay (+598)", "Uzbekistan (+998)", "Vanuatu (+678)", "Venezuela (+58)", "Viet Nam (+84)", "British Virgin Islands (+1-284)", "US Virgin Islands (+1-340)", "Wallis and Futuna (+681)", "Western Sahara (+212)", "Yemen (+967)", "Zambia (+260)", "Zimbabwe (+263)"}));
		
		countries.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				countryWarning.setText("");
				countryErrorTxt.setText("");
				countryErrorPanel.setBackground(Color.LIGHT_GRAY);
			}
		});
		countries.setBounds(121, 296, 171, 23);
		panel.add(countries);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblFirstName.setBounds(10, 19, 85, 14);
		panel.add(lblFirstName);
		
		
		
		
		
		/*
		 * First name field
		 */
		firstName = new JTextField();
		firstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String fName = firstName.getText();
				fNameHasSpecialChar = hasUnwantedChar(fName, "names");
				if(fNameHasSpecialChar == true) {
					fNameWarning.setText("*");
					fNameWarning.setForeground(Color.RED);
					fNameWarning.setFont(new Font("calibri", Font.BOLD, 14));
					fNameErrorTxt.setText("* Please use letters only. *");
					fNameErrorTxt.setForeground(Color.RED);
					fNameErrorTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
					fNameErrorPanel.setBackground(Color.WHITE);
				}else {
					fNameWarning.setText("");
					fNameErrorTxt.setText("");
					fNameErrorPanel.setBackground(Color.LIGHT_GRAY);
				}
			}
		});
		firstName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fNameWarning.setText("");
			}
		});
		
		firstName.setBounds(121, 14, 171, 20);
		panel.add(firstName);
		firstName.setColumns(10);
		
		JLabel lblSecondName = new JLabel("Second Name:");
		lblSecondName.setForeground(Color.WHITE);
		lblSecondName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblSecondName.setBounds(10, 53, 85, 14);
		panel.add(lblSecondName);
		
		/*
		 * Second name text field
		 */
		secondName = new JTextField();
		secondName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String sName = secondName.getText();
				fNameHasSpecialChar = hasUnwantedChar(sName, "names");
				if(fNameHasSpecialChar == true) {
					sNameWarning.setText("*");
					sNameWarning.setForeground(Color.RED);
					sNameWarning.setFont(new Font("calibri", Font.BOLD, 14));
					sNameErrorTxt.setText("* Please use letters only. *");
					sNameErrorTxt.setForeground(Color.RED);
					sNameErrorTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
					sNameErrorPanel.setBackground(Color.WHITE);
				}else {
					sNameWarning.setText("");
					sNameErrorTxt.setText("");
					sNameErrorPanel.setBackground(Color.LIGHT_GRAY);
				}
			}
		});
		secondName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sNameWarning.setText("");
			}
		});
		secondName.setBounds(121, 48, 171, 20);
		panel.add(secondName);
		secondName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblLastName.setBounds(10, 87, 85, 14);
		panel.add(lblLastName);
		
		/*
		 * Last name text field
		 */
		lastName = new JTextField();
		lastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String lName = lastName.getText();
				fNameHasSpecialChar = hasUnwantedChar(lName, "names");
				if(fNameHasSpecialChar == true) {
					lNameWarning.setText("*");
					lNameWarning.setForeground(Color.RED);
					lNameWarning.setFont(new Font("calibri", Font.BOLD, 14));
					lNameErrorTxt.setText("* Please use letters only. *");
					lNameErrorTxt.setForeground(Color.RED);
					lNameErrorTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
					lNameErrorPanel.setBackground(Color.WHITE);
				}else {
					lNameWarning.setText("");
					lNameErrorTxt.setText("");
					lNameErrorPanel.setBackground(Color.LIGHT_GRAY);
				}
			}
		});
		
		lastName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lNameWarning.setText("");
			}
		});
		lastName.setBounds(121, 82, 171, 20);
		panel.add(lastName);
		lastName.setColumns(10);
		
		/*
		 * Gender
		 */
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Calibri", Font.BOLD, 14));
		lblGender.setBounds(10, 123, 48, 14);
		panel.add(lblGender);
		
		
		
		JLabel lblPhysicalAddress = new JLabel("Physical Address:");
		lblPhysicalAddress.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPhysicalAddress.setForeground(Color.WHITE);
		lblPhysicalAddress.setBackground(new Color(0, 191, 255));
		lblPhysicalAddress.setBounds(10, 165, 115, 14);
		panel.add(lblPhysicalAddress);
		
		/*
		 * Physical address field
		 */
		physicalAddress = new JTextField();
		physicalAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String fetchedAddr = physicalAddress.getText();
				fNameHasSpecialChar = hasUnwantedChar(fetchedAddr, "password & physical address");
				if(fNameHasSpecialChar == true) {
					pAddressWarning.setText("*");
					pAddressWarning.setForeground(Color.RED);
					pAddressWarning.setFont(new Font("calibri", Font.BOLD, 14));
					phyAddrErrorTxt.setText("* Use letters and numbers only. *");
					phyAddrErrorTxt.setForeground(Color.RED);
					phyAddrErrorTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
					phyAddrErrorPanel.setBackground(Color.WHITE);
				}else {
					pAddressWarning.setText("");
					phyAddrErrorTxt.setText("");
					phyAddrErrorPanel.setBackground(Color.LIGHT_GRAY);
				}
			}
		});
		
		physicalAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pAddressWarning.setText("");
			}
		});
		physicalAddress.setBounds(121, 160, 171, 20);
		panel.add(physicalAddress);
		physicalAddress.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("E-mail Address:");
		lblEmailAddress.setForeground(Color.WHITE);
		lblEmailAddress.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEmailAddress.setBackground(new Color(0, 191, 255));
		lblEmailAddress.setBounds(10, 201, 95, 14);
		panel.add(lblEmailAddress);
		
		eMailAddress = new JTextField();
		eMailAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!eMailAddress.getText().contains("@") || !eMailAddress.getText().contains(".")) {
					eMailAddressWarning.setText("*");
					eMailAddressWarning.setForeground(Color.RED);
					eMailAddressWarning.setFont(new Font("calibri", Font.BOLD, 14));
					eMailErrorTxt.setText("* Invalid e-Mail *");
					eMailErrorTxt.setForeground(Color.RED);
					eMailErrorTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
					eMailErrorPanel.setBackground(Color.WHITE);
				}
			}
		});
		eMailAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String fetchedMail = eMailAddress.getText();
				unwantedCharsinEMail = hasUnwantedChar(fetchedMail, "email");
				if(unwantedCharsinEMail == true) {
					eMailAddressWarning.setText("*");
					eMailAddressWarning.setForeground(Color.RED);
					eMailAddressWarning.setFont(new Font("calibri", Font.BOLD, 14));
					eMailErrorTxt.setText("* Invalid e-Mail *");
					eMailErrorTxt.setForeground(Color.RED);
					eMailErrorTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
					eMailErrorPanel.setBackground(Color.WHITE);
				}else {
					eMailAddressWarning.setText("");
					eMailErrorTxt.setText("");
					eMailErrorPanel.setBackground(Color.LIGHT_GRAY);
				}
			}
		});
		
		eMailAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eMailAddressWarning.setText("");
			}
		});
		eMailAddress.setBounds(121, 194, 171, 20);
		panel.add(eMailAddress);
		eMailAddress.setColumns(10);
		
		//Password label
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPassword.setBackground(new Color(0, 191, 255));
		lblPassword.setBounds(10, 232, 85, 14);
		panel.add(lblPassword);
		
		/*
		 * Password fields
		 */
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String fetchedPassword = passwordField.getText();
				unwantedCharsinPassword = hasUnwantedChar(fetchedPassword, "password & physical address");
				if(unwantedCharsinPassword == true) {
					passwordWarning.setText("*");
					passwordWarning.setForeground(Color.RED);
					passwordWarning.setFont(new Font("Calibri", Font.BOLD, 14));
					pwdErrorTxt.setText("* Use letters and numbers only. *");
					pwdErrorTxt.setForeground(Color.RED);
					pwdErrorTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
					pwdErrorPanel.setBackground(Color.white);
				}else {
					passwordWarning.setText("");
					pwdErrorTxt.setText("");
					pwdErrorPanel.setBackground(Color.LIGHT_GRAY);
				}
			}
		});
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getText().toCharArray().length < 8) {
					pwdErrorTxt.setText("* Eight or more characters are required. *");
					pwdErrorTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
					pwdErrorTxt.setForeground(Color.red);
					pwdErrorPanel.setBackground(Color.white);
					passwordWarning.setText("*");
					passwordWarning.setForeground(Color.RED);
					passwordWarning.setFont(new Font("Calibri", Font.BOLD, 14));
				}
			}
		});
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordWarning.setText("");
			}
		});
		passwordField.setBounds(121, 228, 171, 20);
		panel.add(passwordField);
		
		//Confirm password label
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		lblConfirmPassword.setBackground(new Color(0, 191, 255));
		lblConfirmPassword.setBounds(10, 267, 115, 14);
		panel.add(lblConfirmPassword);
		
		confirmPassword = new JPasswordField();
		confirmPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!confirmPassword.getText().equals(passwordField.getText())) {
					cPasswordWarning.setText("*");
					cPasswordWarning.setFont(new Font("Calibri", Font.BOLD, 14));
					cPasswordWarning.setForeground(Color.red);
					cpwdErrorTxt.setText("* Password does not match. *");
					cpwdErrorTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
					cpwdErrorTxt.setForeground(Color.red);
					cpwdErrorPanel.setBackground(Color.white);
					unmatchedPasswords = true;
				}else {
					unmatchedPasswords = false;
				}
			}
		});
		confirmPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cPasswordWarning.setText("");
				cpwdErrorTxt.setText("");
				cpwdErrorPanel.setBackground(Color.LIGHT_GRAY);
			}
		});
		confirmPassword.setBounds(121, 262, 171, 20);
		panel.add(confirmPassword);
		
		TextField mobileNumber = new TextField();
		mobileNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String fetchedMobNum = mobileNumber.getText();
				unwantedCharsinMobNum = hasUnwantedChar(fetchedMobNum, "mobileNumber");
				if(unwantedCharsinMobNum == true) {
					mobNumWarning.setText("*");
					mobNumWarning.setForeground(Color.RED);
					mobNumWarning.setFont(new Font("Calibri", Font.BOLD, 14));
					mobNumErrorTxt.setText("* Please use numbers only. *");
					mobNumErrorTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
					mobNumErrorTxt.setForeground(Color.red);
					mobNumErrorPanel.setBackground(Color.white);
				}else {
					mobNumWarning.setText("");
					mobNumErrorTxt.setText("");
					mobNumErrorPanel.setBackground(Color.LIGHT_GRAY);
				}
			}
		});
		
		mobileNumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mobNumWarning.setText("");
				mobNumErrorTxt.setText("");
				mobNumErrorPanel.setBackground(Color.LIGHT_GRAY);
			}
		});
		mobileNumber.setBounds(121, 330, 171, 20);
		panel.add(mobileNumber);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCountry.setBackground(new Color(0, 191, 255));
		lblCountry.setBounds(10, 301, 95, 14);
		panel.add(lblCountry);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		lblMobileNumber.setForeground(Color.WHITE);
		lblMobileNumber.setFont(new Font("Calibri", Font.BOLD, 14));
		lblMobileNumber.setBackground(new Color(0, 191, 255));
		lblMobileNumber.setBounds(10, 336, 102, 14);
		panel.add(lblMobileNumber);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setForeground(new Color(72, 61, 139));
		lblRegistration.setFont(new Font("Calibri", Font.BOLD, 20));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(271)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRegistration)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(mobNumErrorPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(countryErrorPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(cpwdErrorPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(pwdErrorPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(genderErrorPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
										.addComponent(lNameErrorPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
										.addComponent(sNameErrorPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
										.addComponent(fNameErrorPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
										.addComponent(phyAddrErrorPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(eMailErrorPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))))))
					.addGap(9))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRegistration)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addComponent(fNameErrorPanel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(sNameErrorPanel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lNameErrorPanel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(genderErrorPanel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(phyAddrErrorPanel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(eMailErrorPanel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(pwdErrorPanel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cpwdErrorPanel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(countryErrorPanel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(mobNumErrorPanel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		
		contentPane.setLayout(gl_contentPane);
		
		JButton registerButton = new JButton("Register Now");
		registerButton.setEnabled(false);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(
						firstName.getText().isBlank() ||
						secondName.getText().isBlank() ||
						lastName.getText().isBlank() ||
						physicalAddress.getText().isBlank() ||
						eMailAddress.getText().isBlank() ||
						passwordField.getPassword().toString().isBlank() ||
						mobileNumber.getText().isBlank() ||
						selectedGender == ""
				)
				{
					JOptionPane.showMessageDialog(null, "* Please fill all required fields. *");
				}
				else
				{
					if(selectedGender == "") {
						genderWarning.setText("*");
						genderWarning.setForeground(Color.RED);
						genderWarning.setFont(new Font("calibri", Font.BOLD, 14));
						genderErrorTxt.setText("* Please select sex. *");
						genderErrorTxt.setForeground(Color.RED);
						genderErrorTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
						genderErrorPanel.setBackground(Color.WHITE);
					}
					
					if(countries.getSelectedItem().toString().equals("..."))
					{
						countryWarning.setText("*");
						countryWarning.setForeground(Color.red);
						countryErrorTxt.setText("* Please select your country. *");
						countryErrorPanel.setBackground(Color.white);
					}
					
					if(
						fNameHasSpecialChar | sNameHasSpecialChar | lNameHasSpecialChar | unwantedCharsinPAddress | unwantedCharsinEMail |
						unwantedCharsinPassword | unmatchedPasswords | unwantedCharsinMobNum
					) {
						JOptionPane.showMessageDialog(null, "* Please check all marked fields *");
					}else {
						try {
							Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/spotfxdb", "root", "");
							/*
							 * 	SQL statements
							 */
							
							String insertionQuery = "INSERT INTO `Investors`(`userID`, `firstName`, `secondName`, `lastName`, `gender`, `physicalAddress`, `eMailAddress`, `password`, `country`, `mobileNumber`, `balance`,`balanceDate`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
							String retrievalQuery = "select * from `Investors`";
							PreparedStatement preparedInsertion = (PreparedStatement) connection.prepareStatement(insertionQuery);
							PreparedStatement preparedRetrieval = (PreparedStatement) connection.prepareStatement(retrievalQuery);
							
							ResultSet getResults = preparedRetrieval.executeQuery(retrievalQuery);
							
							/*
							 * Prepares investor userID
							 */
							int lastInvestor = 0;
							while(getResults.next()) {
								lastInvestor = getResults.getInt("ID");
							}
							getResults.close();
							
							//Makes userID with text and number
							String userID = "FXI" + lastInvestor;
							
							InvestorInformation investorData = new InvestorInformation();
									/*
									 * Loads investor data into object profile
									 */
									investorData.setInvestorInfo(
									userID,
									passwordField.getText(),
									firstName.getText(),
									secondName.getText(),
									lastName.getText(),
									selectedGender,
									physicalAddress.getText(),
									eMailAddress.getText(),
									countries.getSelectedItem().toString(),
									mobileNumber.getText(),
									date()
											);
							/*
							 * Injects data into the database
							 */
							preparedInsertion.setString(1, investorData.getUserID());
							preparedInsertion.setString(2, investorData.getFirstName());
							preparedInsertion.setString(3, investorData.getSecondName());
							preparedInsertion.setString(4, investorData.getLastName());
							preparedInsertion.setString(5, investorData.getGender());
							preparedInsertion.setString(6, investorData.getPhysicalAddress());
							preparedInsertion.setString(7, investorData.getEmailAddress());
							preparedInsertion.setString(8, investorData.getPassword());
							preparedInsertion.setString(9, investorData.getCountry());
							preparedInsertion.setString(10, investorData.getMobileNumber());
							preparedInsertion.setDouble(11, investorData.getdBalance());
							preparedInsertion.setString(12, investorData.getsDate());
							
							preparedInsertion.executeUpdate();
							
							connection.close();
							preparedInsertion.close();
							
							JOptionPane.showMessageDialog(null, "* Registered successfully! *\n\n" + investorData.getUserID() + " is your user ID, use it for logging into your account.");
							String []userType = new String[2];
							userType[0] = "Investor";
							userType[1] = userID;
							
							loadSystem(userType);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "* Error: Failed to register! *" + e1);
						}
						closeRegistration();
					}
				}
			}
		});
		registerButton.setForeground(new Color(255, 255, 255));
		registerButton.setBackground(new Color(72, 61, 139));
		registerButton.setBounds(110, 418, 115, 23);
		panel.add(registerButton);
		
		JLabel lblTermsAndConditions = new JLabel("Terms and conditions.");
		lblTermsAndConditions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTermsAndConditions.setForeground(new Color(72, 61,139));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTermsAndConditions.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				openTermsandConditions();
			}
		});
		lblTermsAndConditions.setFont(new Font("Calibri", Font.BOLD, 14));
		lblTermsAndConditions.setForeground(Color.WHITE);
		lblTermsAndConditions.setBounds(121, 370, 171, 14);
		panel.add(lblTermsAndConditions);
		
		JCheckBox acceptTermsAndConditions = new JCheckBox("Accept terms and conditions.");
		acceptTermsAndConditions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(acceptTermsAndConditions.isSelected()) {
					registerButton.setEnabled(true);
				}else {
					registerButton.setEnabled(false);
				}
			}
		});
		
		acceptTermsAndConditions.setForeground(new Color(255, 255, 255));
		acceptTermsAndConditions.setBackground(Color.GRAY);
		acceptTermsAndConditions.setBounds(121, 388, 201, 23);
		panel.add(acceptTermsAndConditions);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Calibri", Font.BOLD, 14));
		rdbtnMale.setBackground(Color.GRAY);
		rdbtnMale.setForeground(Color.WHITE);
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Calibri", Font.BOLD, 14));
		rdbtnFemale.setBackground(Color.GRAY);
		rdbtnFemale.setForeground(Color.WHITE);
		
		rdbtnMale.setBounds(121, 117, 55, 23);
		panel.add(rdbtnMale);
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMale.setSelected(true);
				rdbtnFemale.setSelected(false);
				selectedGender = "Male";
			}
		});
		
		
		rdbtnFemale.setBounds(178, 117, 67, 23);
		panel.add(rdbtnFemale);
		
		/*
		 * This takes user to the login window
		 */
		JLabel lblLoginWindow = new JLabel("I have an account.");
		lblLoginWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLoginWindow.setForeground(new Color(72, 61, 139));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLoginWindow.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				gotoLogin();
			}
		});
		lblLoginWindow.setFont(new Font("Calibri", Font.BOLD, 14));
		lblLoginWindow.setForeground(Color.WHITE);
		lblLoginWindow.setBounds(110, 452, 115, 14);
		panel.add(lblLoginWindow);
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnFemale.setSelected(true);
				rdbtnMale.setSelected(false);
				selectedGender = "Female";
			}
		});
		/*
		 * END OF CONSTRUCTOR
		 */
	}
	
	public String date()
	{
		Calendar cal = new GregorianCalendar();
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		//We add 1 to month in order to correct its error of 1 month lag
		int month  = cal.get(Calendar.MONTH) + 1;
		//++month;
		int year = cal.get(Calendar.YEAR);
		
		//Since we added 1, in case month reaches 12 ours will show 13. We set it to 1(January)
		if(month > 12) {
			month = 1;
		}
		
		return String.valueOf(year + "-" + month + "-" + day);
	}
	
	private void loadSystem(String[] userType) {
		//Opens system features
		SFXInterface.main(userType);
	}
	
	private void openTermsandConditions() {
		TermsAndConditions readTerms = new TermsAndConditions();
		readTerms.setVisible(true);
	}
	
	public void gotoLogin() {
		Login.main(null);
		this.dispose();
	}
	
	public boolean isRegistered()
	{
		return registered;
	}
	public void closeRegistration() {
		this.dispose();
	}
	
	/*
	 * Check for unwanted characters
	 */
	public boolean hasUnwantedChar(String name, String field) {
		boolean unwantedCharacter = false;
		char checkName[] = name.toCharArray();
		if(field == "names") {
			int find = 0;
			while(find < checkName.length) {
				switch(checkName[find]) {
				case 'A':case 'a':case 'B':case 'b':case 'C':case 'c':case 'D':case 'd':case 'E':case 'e':case 'F':case 'f':case 'G':case 'g':
				case 'H':case 'h':case 'I':case 'i':case 'J':case 'j':case 'K':case 'k':case 'L':case 'l':case 'M':case 'm':case 'N':case 'n':
				case 'O':case 'o':case 'P':case 'p':case 'Q':case 'q':case 'R':case 'r':case 'S':case 's':case 'T':case 't':case 'U':case 'u':
				case 'V':case 'v':case 'W':case 'w':case 'X':case 'x':case 'Y':case 'y':case 'Z':case 'z':
					break;
				default:
					unwantedCharacter = true;
				}
				if(unwantedCharacter == true)
				{
					break;
				}
				++find;
			}	
		}else if(field == "password & physical address") {
			int find = 0;
			while(find < checkName.length) {
				switch(checkName[find]) {
				case 'A':case 'a':case 'B':case 'b':case 'C':case 'c':case 'D':case 'd':case 'E':case 'e':case 'F':case 'f':case 'G':case 'g':
				case 'H':case 'h':case 'I':case 'i':case 'J':case 'j':case 'K':case 'k':case 'L':case 'l':case 'M':case 'm':case 'N':case 'n':
				case 'O':case 'o':case 'P':case 'p':case 'Q':case 'q':case 'R':case 'r':case 'S':case 's':case 'T':case 't':case 'U':case 'u':
				case 'V':case 'v':case 'W':case 'w':case 'X':case 'x':case 'Y':case 'y':case 'Z':case 'z':	
				case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':case '0':case ' ':case '-':
					break;
				default:	
					unwantedCharacter = true;
				}
				if(unwantedCharacter == true)
				{
					break;
				}
				++find;
			}	
		}else if(field == "email") {
			int find = 0;
			while(find < checkName.length) {
				switch(checkName[find]) {
				case 'A':case 'a':case 'B':case 'b':case 'C':case 'c':case 'D':case 'd':case 'E':case 'e':case 'F':case 'f':case 'G':case 'g':
				case 'H':case 'h':case 'I':case 'i':case 'J':case 'j':case 'K':case 'k':case 'L':case 'l':case 'M':case 'm':case 'N':case 'n':
				case 'O':case 'o':case 'P':case 'p':case 'Q':case 'q':case 'R':case 'r':case 'S':case 's':case 'T':case 't':case 'U':case 'u':
				case 'V':case 'v':case 'W':case 'w':case 'X':case 'x':case 'Y':case 'y':case 'Z':case 'z':	
				case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':case '0':case '@':case '.':
					break;
				default:
					unwantedCharacter = true;
				}
				if(unwantedCharacter == true)
				{
					break;
				}
				++find;
			}
		}else if(field == "mobileNumber") {
			int find = 0;
			while(find < checkName.length) {
				switch(checkName[find]) {
				case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':case '0':case ' ':
					break;
				default:
					unwantedCharacter = true;
				}
				if(unwantedCharacter == true)
				{
					break;
				}
				++find;
			}
		}
		
		return unwantedCharacter;
	}
}