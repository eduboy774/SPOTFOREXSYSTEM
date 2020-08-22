package documentation;

public class TraderInformation extends  UserInformation{
	private String firstName;
	private String secondName;
	private String lastName;
	private String gender;
	private String physicalAddress;
	private String emailAddress;
	private String country;
	private String mobileNumber;
	
	public TraderInformation(){
		super();
		this.firstName = "No information";
		this.secondName = "No information";
		this.lastName = "No information";
		this.gender = "No information";
		this.physicalAddress = "No information";
		this.emailAddress = "No information";
		this.country = "No information";
		this.mobileNumber = "No information";
	}
	
	public void setTraderInfo(
			String userID,
			String password,
			String firstName,
			String secondName,
			String lastName,
			String gender,
			String physicalAddress,
			String emailAddress,
			String country,
			String mobileNumber
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
