package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import framework.FrameworkBase;
import pages.LandingPage;
import pages.PageBase;

public class TestScenario {
	
	@BeforeSuite
	public void beforeSuite(){
		FrameworkBase.initializeFrameworkPropertyFile();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		PageBase.initializeWebDriver();
	}
	
	@Test
	public void addingItemsInTheCartAfterLogin(){
		LandingPage landingPage = new LandingPage();
		
		landingPage.clickLogin()
		.enterUserName("march27_testing@outlook.com")
		.enterPassword("red12345")
		.doLogin()
		.clickOnSale()
		.addItemToCart();
	}
	
	@Test
	public void addingAndRemovingSecondItemFromTheCart(){
		LandingPage landingPage = new LandingPage();
		
		landingPage.searchItem("eggs")
		.addItemsToCart()
		.gotoCart();
		//.removeSecondItem();
	}
	
	@Test
	public void proceedToCheckoutAndAddAddress(){
		
	}
	
	@AfterMethod
	public void afterMethod(){
		//PageBase.quitBrowser();
	}

}
