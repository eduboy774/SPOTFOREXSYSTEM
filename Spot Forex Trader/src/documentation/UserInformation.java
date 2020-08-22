package documentation;

public class UserInformation {
	protected String userID;
	protected String password;
	private boolean isPwdCorrect;
	
	public UserInformation(){
		userID = "No information";
		password = "No information";
		isPwdCorrect = false;
	}
	
	public void setUserInfo(String userID, String password){
		this.userID = userID;
		this.password = password;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public String getUserPassword() {
		return password;
	}
	
	public void setPwdCorrectness(boolean isPwdCorrect) {
		this.isPwdCorrect = isPwdCorrect;
	}
	
	public boolean getPwdCorrectness() {
		return isPwdCorrect;
	}
}
