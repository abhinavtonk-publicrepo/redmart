package pages;

public class Header extends PageBase{

	private final String cartIcon_xpath = "//a[@id='cartPreviewInner']";
	private final String onSaleLink_xpath = "//a[contains(text(),'On Sale')]";

	public CartPage gotoCart() {
		// TODO Auto-generated method stub
		clickJSByXpath(findElementByXpath(cartIcon_xpath));
		return new CartPage();
	}


	public ProductListPage clickOnSale() {
		clickJSByXpath((findElementByXpath(onSaleLink_xpath)));
		waitFor(2000L);
		return new ProductListPage();
	}

}
