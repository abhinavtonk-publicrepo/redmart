package pages;

public class ProductListPage extends Header{

	private final String addToCartItem_xpath = "(//li[@class='productPreview  '])[#]//span[contains(text(),'Add to cart')]/..";
	
	public ProductListPage addItemToCart() {
		click(findElementByXpath(addToCartItem_xpath));		
		return this;
	}

	public ProductListPage addItemsToCart(int totalItemsToBeAdded) {
		for(int i =1; i<=totalItemsToBeAdded;i++) {
			//scrollToWebElementJS(findElementByXpath(addToCartItem_xpath.replace("#", String.valueOf(i))));
			waitFor(1000L);
			clickJSByXpath(findElementByXpath(addToCartItem_xpath.replace("#", String.valueOf(i))));
		}
		waitFor(1000L);
		
		return this;
	}




}
