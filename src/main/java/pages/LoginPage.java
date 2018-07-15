package pages;

public class LoginPage extends Header{

	private final String userName_name = "email";
	private final String password_name = "password";
	private String logInButton_xpath = "//div[contains(text(),'Log In')]";
	private String logInButton_xpathAbsolute = "html/body/div[4]/div/span/div/div/div/div/div[3]/div";
	
	public LoginPage enterUserName(String username) {
		enterText(findElementByName(userName_name), username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		enterText(findElementByName(password_name), password);
		return this;
	}

	public HomePage doLogin() {
		click(findElementByXpath(logInButton_xpath));		
		waitForWebElementToBecomeInvisible(logInButton_xpath);
		
		return new HomePage();
	}



}
