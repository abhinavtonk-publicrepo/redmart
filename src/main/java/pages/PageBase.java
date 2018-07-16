package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.FrameworkBase;

public class PageBase extends FrameworkBase{
	protected static WebDriver driver;

	public PageBase(){
		//initializeFrameworkPropertyFile();
	}

	protected static void setImplicitlywait(String timeLimit){
		driver.manage().timeouts().implicitlyWait(Long.parseLong(timeLimit), TimeUnit.SECONDS);
	}

	protected static void setPageLoadTimeout(String timeLimit){
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(timeLimit), TimeUnit.SECONDS);
	}

	protected static void maximizeBrowser(){
		driver.manage().window().maximize();
	}

	protected static void openBrowser(String url){
		driver.get(url);
	}


	public static void initializeWebDriver(){
		switch(FRAMEWORK_PROPERTIES.BROWSER.getValue()){

		case "firefox" :
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "ie" :
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;

		case "chrome" :
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

		openBrowser(FRAMEWORK_PROPERTIES.URL.getValue());

		maximizeBrowser();

		if(FRAMEWORK_PROPERTIES.ANGULAR_MODE.getValue().equals("false")){
			setImplicitlywait(FRAMEWORK_PROPERTIES.IMPLICITLY_WAIT.getValue());
			setPageLoadTimeout(FRAMEWORK_PROPERTIES.PAGELOAD_TIMEOUT.getValue());
		}

	}

	public static void quitBrowser() {
		driver.quit();		
	}

	protected WebElement findElementByXpath(String xpathExpression) {

		if(FRAMEWORK_PROPERTIES.ANGULAR_MODE.getValue().equals("true")){
			WebDriverWait wait = new WebDriverWait(driver, 30);		 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
		}

		WebElement webElement = driver.findElement(By.xpath(xpathExpression));

		return webElement;		
	}

	protected WebElement findElementByName(String name) {
		if(FRAMEWORK_PROPERTIES.ANGULAR_MODE.getValue().equals("true")){
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
		}

		WebElement webElement = driver.findElement(By.name(name));

		return webElement;		
	}

	protected WebElement findElementByID(String id) {
		if(FRAMEWORK_PROPERTIES.ANGULAR_MODE.getValue().equals("true")){
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		}

		WebElement webElement = driver.findElement(By.id(id));

		return webElement;		
	}


	protected void click(WebElement webElement) {
		if(FRAMEWORK_PROPERTIES.ANGULAR_MODE.getValue().equals("true")){
			WebDriverWait wait = new WebDriverWait(driver, 30);		 
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		}

		webElement.click();
	}

	protected void clickByXpath(String xpathExpression) {

		WebElement webElement = findElementByXpath(xpathExpression);

		if(FRAMEWORK_PROPERTIES.ANGULAR_MODE.getValue().equals("true")){
			WebDriverWait wait = new WebDriverWait(driver, 30);		 
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		}

		webElement.click();
	}

	protected void clickById(String id) {

		WebElement webElement = findElementByID(id);

		if(FRAMEWORK_PROPERTIES.ANGULAR_MODE.getValue().equals("true")){
			WebDriverWait wait = new WebDriverWait(driver, 30);		 
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		}

		webElement.click();
	}

	protected void clickByName(String name) {

		WebElement webElement = findElementByName(name);

		if(FRAMEWORK_PROPERTIES.ANGULAR_MODE.getValue().equals("true")){
			WebDriverWait wait = new WebDriverWait(driver, 30);		 
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		}

		webElement.click();
	}

	protected void enterText(WebElement webElement, String text) {
		webElement.sendKeys(text);
	}

	protected void enterText(WebElement webElement, Keys key) {
		webElement.sendKeys(key);
	}

	protected void clickJSById(String id) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('"+id+"').click();");
	}

	protected void clickJSByXpath(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.evaluate('"+xpath +"', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();");
	}

	protected void clickJSByXpath(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webElement);
	}

	protected void clickJSByName(String name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('"+name+"').click();");
	}

	protected void enterTextJSByName(String name, String username) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('"+name+"').value= '"+username+"';");	
	}

	protected void enterTextJSByXpath(String xpath, String username) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.evaluate('"+xpath +"', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='"+username+"';");
	}


	protected void clearTextJSByXpath(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.evaluate('"+xpath +"', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.clear();");

	}

	protected void enableWebElementJSByXpath(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.evaluate('"+xpath +"', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).removeAttribute(\"disabled\");");

	}

	protected void navigateTo(String endPoint) {
		driver.navigate().to(FRAMEWORK_PROPERTIES.URL.getValue()+ endPoint);

	}

	protected String captureText(WebElement webElement) {
		String capturedText = webElement.getText();
		return capturedText;
	}

	protected int countTotalWebElementsByXpath(String xpathExpression) {
		if(FRAMEWORK_PROPERTIES.ANGULAR_MODE.getValue().equals("true")){
			WebDriverWait wait = new WebDriverWait(driver, 30);		 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
		}

		List<WebElement> webElements = driver.findElements(By.xpath(xpathExpression));

		return webElements.size();

	}

	protected void scrollToWebElementJS(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",webElement);
	}

	protected void waitForWebElementToBecomeInvisible(String xpathExpression) {
		WebDriverWait wait = new WebDriverWait(driver, 30);		 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathExpression)));
	}

	protected void changeWebElementAttribute(WebElement webElement, String attribute, String changedValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", webElement, attribute, changedValue);
	}

}
