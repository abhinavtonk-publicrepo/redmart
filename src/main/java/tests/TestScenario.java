package tests;


import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import framework.FrameworkBase;
import pages.LandingPage;
import pages.PageBase;

public class TestScenario {

	private static final String filePathTestData = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.properties";
	private static Properties testDataProperties;

	protected enum TESTDATA_PROPERTIES{
		USERNAME(testDataProperties.getProperty("username")),
		PASSWORD(testDataProperties.getProperty("password")),
		TOTAL_ITEMS_TO_BE_ADDED_IN_CART(testDataProperties.getProperty("totalItemsThatNeedsToBeAddedInCart")),
		ITEMS_TO_BE_REMOVED_FROM_CART_FROM_TOP(testDataProperties.getProperty("itemToBeRemovedFromCartFromTop")),
		ADDRESS(testDataProperties.getProperty("address")),
		FIRST_NAME(testDataProperties.getProperty("firstName")),
		LAST_NAME(testDataProperties.getProperty("lastName"))
		;

		private String value;

		TESTDATA_PROPERTIES(String value){
			this.value = value;
		}

		public String getValue(){
			return value;
		}
	}

	@BeforeSuite
	public void beforeSuite(){
		FrameworkBase.initializeFrameworkPropertyFile();
	}

	@BeforeClass
	public void beforeClass() {
		testDataProperties = FrameworkBase.initializePropertyFile(filePathTestData);
	}

	@BeforeMethod
	public void beforeMethod(){
		PageBase.initializeWebDriver();
	}

	@Test
	public void addingItemsInTheCartAfterLogin(){
		LandingPage landingPage = new LandingPage();
		int totalItemsAdded = Integer.parseInt(TESTDATA_PROPERTIES.TOTAL_ITEMS_TO_BE_ADDED_IN_CART.getValue());

		landingPage
		// 1. Click Sign in link on Landing Page
		.clickLogin()

		// 2. Enter Username
		.enterUserName(TESTDATA_PROPERTIES.USERNAME.getValue())

		// 3. Enter Password
		.enterPassword(TESTDATA_PROPERTIES.PASSWORD.getValue())

		// 4. Click Log In Button
		.doLogin()

		// 5. Goto Cart
		.gotoCart()

		// 6. Delete all items form cart in case the last run was failed and items are there in cart
		.cleanupCart()

		// 7. Click "On Sale" Category
		.clickOnSale()

		// 8. Add Items to the Cart based on input
		.addItemsToCart(Integer.parseInt(TESTDATA_PROPERTIES.TOTAL_ITEMS_TO_BE_ADDED_IN_CART.getValue()))

		// 9. Goto Cart
		.gotoCart()

		// 10. Verify whether items are added in cart
		.verifyAddedItemsInCart(totalItemsAdded)
		;
	}

	@Test (dependsOnMethods ="addingItemsInTheCartAfterLogin")
	public void removingSecondItemFromTheCart(){

		int itemRemovedFromCartFromTop = Integer.parseInt(TESTDATA_PROPERTIES.ITEMS_TO_BE_REMOVED_FROM_CART_FROM_TOP.getValue());

		LandingPage landingPage = new LandingPage();

		landingPage
		// 1. Click Sign in link on Landing Page
		.clickLogin()

		// 2. Enter Username
		.enterUserName(TESTDATA_PROPERTIES.USERNAME.getValue())

		// 3. Enter Password
		.enterPassword(TESTDATA_PROPERTIES.PASSWORD.getValue())

		// 4. Click Log In Button
		.doLogin()

		// 5. Goto Cart Page
		.gotoCart()

		// 6. Remove the nth Item from top
		.removeItemFromCart(Integer.parseInt(TESTDATA_PROPERTIES.ITEMS_TO_BE_REMOVED_FROM_CART_FROM_TOP.getValue()))

		// 7. Verify that the Items is removed successfully
		.verifyRemovalOfItem(itemRemovedFromCartFromTop)

		// 8. Empty the Cart
		//.cleanupCart()
		;
	}

	@Test(dependsOnMethods = {"addingItemsInTheCartAfterLogin" , "removingSecondItemFromTheCart"})
	public void proceedToCheckoutAndAddAddress(){
		LandingPage landingPage = new LandingPage();
		
		landingPage
		// 1. Click Sign in link on Landing Page
		.clickLogin()

		// 2. Enter Username
		.enterUserName(TESTDATA_PROPERTIES.USERNAME.getValue())

		// 3. Enter Password
		.enterPassword(TESTDATA_PROPERTIES.PASSWORD.getValue())

		// 4. Click Log In Button
		.doLogin()

		// 5. Goto Cart Page
		.gotoCart()

		// 6. Proceed to checkout
		.proceedToCheckout()

		// 7. Add New Address
		.addNewAddress(TESTDATA_PROPERTIES.ADDRESS.getValue(), TESTDATA_PROPERTIES.FIRST_NAME.getValue(), TESTDATA_PROPERTIES.LAST_NAME.getValue())

		// 8. Verify the Newly Added Address
		.verifyNewlyAddedAddress(TESTDATA_PROPERTIES.ADDRESS.getValue())

		// 9. Delete the Newly added address as a cleanup action
		.cleanupAddress()

		// 10. Goto Cart
		.gotoCart()

		// 12. Delete the items from the cart as a clean up action
		.cleanupCart()
		;
	}

	@AfterMethod
	public void afterMethod(){
		PageBase.quitBrowser();
	}

}
