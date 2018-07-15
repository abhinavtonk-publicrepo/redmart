package pages;

import org.openqa.selenium.Keys;
import org.testng.Assert;

public class CheckoutPage extends Header{
	private final String addNewAddressLink_xpath = "//a[@class='addBtn editMode']";
	private final String enterPostalCode_id ="ADDRESS_WIZARD_SUGGESTIONS_INPUT";
	private final String firstAutoSuggestionText_xpath ="//input[@id='ADDRESS_WIZARD_SUGGESTIONS_INPUT']//li[1]/div";
	private final String selectThisAddress_xpath ="//a[contains(text(),'Select This Address')]";
	
	private final String firstName_id ="ADDRESS_WIZARD_FIRST_NAME";
	private final String lastName_id ="ADDRESS_WIZARD_LAST_NAME";
	private final String saveButton_xpath ="//a[contains(text(),'Save')]";
	
	
	private final String addedAddressApartment_xpath ="//div[@class='apartment']";
	private final String addedAddressPostcode_xpath ="//div[@class='postcode']";
	private final String editAddressButton_xpath ="//button[@class='editMode editBtn']";
	private final String deleteAddressButton_xpath ="//button[@class='deleteAddress']";
	//private final String nextButton_xpath ="//a[@class='button nextBtn']";
	
	public CheckoutPage addNewAddress(String address, String firstName, String lastName) {
		clickJSByXpath(findElementByXpath(addNewAddressLink_xpath));
		enterText(findElementByID(enterPostalCode_id), address);
		
		
		//scrollToWebElementJS(findElementByXpath(selectThisAddress_xpath));
		changeWebElementAttribute(findElementByID(enterPostalCode_id), "autocomplete" , "on");
		waitFor(3000L);
		//clickJSByXpath(findElementByXpath(firstAutoSuggestionText_xpath));
		enterText(findElementByID(enterPostalCode_id), Keys.DOWN);
		enterText(findElementByID(enterPostalCode_id), Keys.ENTER);
		
		clickJSByXpath(findElementByXpath(selectThisAddress_xpath));
		
		enterText(findElementByID(firstName_id), firstName);
		enterText(findElementByID(lastName_id), lastName);
		clickJSByXpath(findElementByXpath(saveButton_xpath));
		
		return this;
	}

	public CheckoutPage verifyNewlyAddedAddress(String expectedAddress) {
		String actualAddress = captureText(findElementByXpath(addedAddressApartment_xpath));
		System.out.println("actualAddress =" + actualAddress);
		Assert.assertTrue(expectedAddress.contains(actualAddress));
		
		return this;
	}

	public CheckoutPage cleanupAddress() {
		clickJSByXpath(findElementByXpath(editAddressButton_xpath));
		clickJSByXpath(findElementByXpath(deleteAddressButton_xpath));
		
		return this;
	}
	
	//6 Fishery Port Road 619747

}
