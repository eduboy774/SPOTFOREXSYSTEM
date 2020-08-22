package documentation;

import documentation.UserInformation;

public class InvestorInformation extends UserInformation {
	protected String firstName;
	protected String secondName;
	protected String lastName;
	protected String gender;
	protected String physicalAddress;
	protected String emailAddress;
	protected String country;
	protected String mobileNumber;
	protected String sbalance;
	protected String s_date;
	protected double dbalance;
	
	public InvestorInformation(){
		super();
		this.firstName = "No information";
		this.secondName = "No information";
		this.lastName = "No information";
		this.gender = "No information";
		this.physicalAddress = "No information";
		this.emailAddress = "No information";
		this.country = "No information";
		this.mobileNumber = "No information";
		this.sbalance = "0";
		this.s_date = "No information";
		this.dbalance = 0.0;
	}
	
	public void setInvestorInfo(
			String userID,
			String password,
			String firstName,
			String secondName,
			String lastName,
			String gender,
			String physicalAddress,
			String emailAddress,
			String country,
			String mobileNumber,
			String s_date
			) {
		super.setUserInfo(userID, password);
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
		this.gender = gender;
		this.physicalAddress = physicalAddress;
		this.emailAddress = emailAddress;
		this.country = country;
		this.mobileNumber = mobileNumber;
		this.s_date = s_date;
	}
	
	public String getsDate(){
		return s_date;
	}
	
	public void setdBalance(double balance){
		this.dbalance = balance;
	}
	
	public double getdBalance(){
		return dbalance;
	}
	
	public void setsBalance(String sbalance){
		this.sbalance = sbalance;
	}
	
	public String getsBalance(){
		return sbalance;
	}
	
	public String getUserID() {
		return super.userID;
	}
	
	public String getPassword() {
		return super.password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	};
}
