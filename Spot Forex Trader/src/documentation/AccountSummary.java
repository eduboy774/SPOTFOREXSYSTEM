package documentation;

import documentation.InvestorInformation;

public class AccountSummary extends InvestorInformation {
	private String expectedProfit;
	
	public AccountSummary(){
		setExpectedProfit("0");
	}
	
	public void setAccSummary(
			String s_firstName,
			String s_secondName,
			String s_lastName,
			String s_physicalAddress,
			String s_emailAddress,
			String s_country,
			String s_mobileNumber,
			String s_balance,
			String s_expectedProfit
			) {
		super.firstName = s_firstName;
		super.secondName = s_secondName;
		super.lastName = s_lastName;
		super.physicalAddress = s_physicalAddress;
		super.emailAddress = s_emailAddress;
		super.country = s_country;
		super.mobileNumber = s_mobileNumber;
		super.sbalance = s_balance;
		this.setExpectedProfit(s_expectedProfit);
	}

	public String getExpectedProfit() {
		return expectedProfit;
	}

	public void setExpectedProfit(String expectedProfit) {
		this.expectedProfit = expectedProfit;
	}
}
