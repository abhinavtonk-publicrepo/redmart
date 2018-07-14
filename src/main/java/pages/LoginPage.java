package pages;

public class LoginPage extends PageBase{

	private final String userName_name = "email";
	private final String userName_xpath = "html/body/div[4]/div/span/div/div/div/div/div[1]/div/input";
	private final String password_name = "password";
	private final String password_xpath = "html/body/div[4]/div/span/div/div/div/div/div[2]/div/input";
	private String logInButton_xpath = "//div[contains(text(),'Log In')]";
	private String logInButton_xpathAbsolute = "html/body/div[4]/div/span/div/div/div/div/div[3]/div";
	
	public LoginPage enterUserName(String username) {
		enterTextJSByXpath(userName_xpath, username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		enterTextJSByXpath(password_xpath, password);
		return this;
	}

	public HomePage doLogin() {
		enableWebElementJSByXpath(logInButton_xpathAbsolute);
		clickJSByXpath(logInButton_xpathAbsolute);
		return new HomePage();
	}



}
