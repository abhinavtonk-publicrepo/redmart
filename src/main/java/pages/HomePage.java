package pages;

public class HomePage extends PageBase{
	private final String onSaleLink_xpath = "//a[contains(text(),'On Sale')]";

	public ProductListPage clickOnSale() {
		click(findElementByXpath(onSaleLink_xpath));
		return new ProductListPage();
	}

}
