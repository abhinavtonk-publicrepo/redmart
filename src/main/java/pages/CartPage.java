package pages;

import org.testng.Assert;

public class CartPage extends Header{

	private final String removeCartItemButton_xpath = "(//div[@class='productCartControl']//button[@class='remove'])[#]";
	private final String itemTitle_xpath = "(//div[@class='productCartControl']//button[@class='remove'])[#]/ancestor::li[@class='productPreview horizontal']//h4";
	private final String checkoutButton_xpath = "//div[contains(text(),'Check out')]";

	private String itemTitle;
	private int totalItemsInTheCart;

	public CartPage cleanupCart() {
		try {
			int totalItemsToBeRemovedFromCart = countTotalWebElementsByXpath(removeCartItemButton_xpath.substring(0, removeCartItemButton_xpath.indexOf("#")-1));
			System.out.println("totalItemsToBeRemovedFromCart" + totalItemsToBeRemovedFromCart);
			for(int i=1; i<=totalItemsToBeRemovedFromCart ;i++) {
				//waitFor(2000);
				System.out.println("Iteration = " + i + "xpath = " + removeCartItemButton_xpath.replace("#", String.valueOf(i)));
				clickJSByXpath(findElementByXpath(removeCartItemButton_xpath.replace("#", String.valueOf(i))));
				waitForWebElementToBecomeInvisible(removeCartItemButton_xpath.replace("#", String.valueOf(i)));
			}
			//waitFor(2000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return this;
	}

	public CartPage removeItemFromCart(int itemToBeRemovedFromCartFromTop) {
		itemTitle = captureText(findElementByXpath(itemTitle_xpath.replace("#", String.valueOf(itemToBeRemovedFromCartFromTop))));
		totalItemsInTheCart = countTotalWebElementsByXpath(removeCartItemButton_xpath.substring(0, removeCartItemButton_xpath.indexOf("#")-1));

		click(findElementByXpath(removeCartItemButton_xpath.replace("#", String.valueOf(itemToBeRemovedFromCartFromTop))));
		waitFor(3000L);
		return this;
	}

	public CartPage verifyRemovalOfItem(int itemRemovedFromCartFromTop) {
		try {
			System.out.println("item title removed=" +  itemTitle);
			System.out.println("current captured title"+captureText(findElementByXpath(itemTitle_xpath.replace("#", String.valueOf(itemRemovedFromCartFromTop)))));
			Assert.assertNotEquals(captureText(findElementByXpath(itemTitle_xpath.replace("#", String.valueOf(itemRemovedFromCartFromTop)))), itemTitle);
		}
		catch (Throwable t) {

			System.out.println("captured count="+ countTotalWebElementsByXpath(removeCartItemButton_xpath.substring(0, removeCartItemButton_xpath.indexOf("#")-1)));
			System.out.println("totalItemsInTheCart ="+ totalItemsInTheCart);
			Assert.assertEquals(countTotalWebElementsByXpath(removeCartItemButton_xpath.substring(0, removeCartItemButton_xpath.indexOf("#")-1)),totalItemsInTheCart-1);
			totalItemsInTheCart--;
		}
		return this;
	}

	public CheckoutPage proceedToCheckout() {
		clickJSByXpath(findElementByXpath(checkoutButton_xpath));
		return new CheckoutPage();
	}

	public CartPage verifyAddedItemsInCart(int totalItemsAdded) {
		waitFor(2000L);
		Assert.assertEquals(countTotalWebElementsByXpath(removeCartItemButton_xpath.substring(0, removeCartItemButton_xpath.indexOf("#")-1)), totalItemsAdded);

		return this;
	}



}
