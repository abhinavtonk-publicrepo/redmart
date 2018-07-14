package pages;

public class LandingPage extends PageBase{
	
	//private String logInLink_xpath = "//span[contains(text(),'Log in')]";
	private String logInLink_xpath_absolute = "html/body/div[1]/header/div/div/section/div/div[2]/div[3]/div[1]/a/span";
	private String logInLink_id = "NAVBAR_SIGNIN_BTN";
	private String searchBar_xpath = "html/body/div[1]/header/div/div/section/div/div[1]/div[3]/div/div/input";
	private String searchIcon_xpath = "html/body/div[1]/header/div/div/section/div/div[1]/div[3]/div/div/button";

	public LoginPage clickLogin() {
		
		//clickJSById(logInLink_id);
		clickJSByXpath(logInLink_xpath_absolute);
		
		return new LoginPage();
	}

	public ProductListPage searchItem(String item) {
		navigateTo("search/"+item );
		//enterTextJSByXpath(searchBar_xpath, item);
		//clickJSByXpath(searchIcon_xpath);
		return new ProductListPage();
	}



	

}
