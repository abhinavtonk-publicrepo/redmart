package pages;

public class ProductListPage extends PageBase{

	//private final String firstAddToCartItem_xpath = "(//li[@class='productPreview'])[1]//span[contains(text(),'Add to cart')]";
	private final String cartIcon_xpath = "html/body/div[1]/header/div/div/section/div/div[2]/div[2]/a/div";
	
	private final String firstAddToCartItem_xpath = "html/body/div[1]/div/section/section[3]/article/div/article/div[2]/div/div/ul[1]/li[1]/div[3]/div/a/span";
	private final String secondAddToCartItem_xpath = "html/body/div[1]/div/section/section[3]/article/div/article/div[2]/div/div/ul[1]/li[2]/div[3]/div/a/span";
	private final String thirdAddToCartItem_xpath = "html/body/div[1]/div/section/section[3]/article/div/article/div[2]/div/div/ul[1]/li[3]/div[3]/div/a/span";
	
	public ProductListPage addItemToCart() {
		click(findElementByName(firstAddToCartItem_xpath));		
		return this;
	}

	public ProductListPage addItemsToCart() {
		clickJSByXpath(firstAddToCartItem_xpath);
		clickJSByXpath(secondAddToCartItem_xpath);
		clickJSByXpath(thirdAddToCartItem_xpath);
		return this;
	}

	public CartPage gotoCart() {
		// TODO Auto-generated method stub
		clickJSByXpath(cartIcon_xpath);
		return new CartPage();
	}

}
