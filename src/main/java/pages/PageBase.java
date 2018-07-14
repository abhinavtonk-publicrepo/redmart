package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
			driver = new FirefoxDriver();
			break;

		case "ie" :
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
			driver = new InternetExplorerDriver();
			break;

		case "chrome" :
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

		openBrowser(FRAMEWORK_PROPERTIES.URL.getValue());

		maximizeBrowser();

		if(FRAMEWORK_PROPERTIES.ANGULAR_MODE.equals("false")){
			setImplicitlywait(FRAMEWORK_PROPERTIES.IMPLICITLY_WAIT.getValue());
			setPageLoadTimeout(FRAMEWORK_PROPERTIES.PAGELOAD_TIMEOUT.getValue());
		}

	}

	public static void quitBrowser() {
		driver.quit();		
	}

	protected WebElement findElementByXpath(String xpathExpression) {
		/*try{*/
		if(FRAMEWORK_PROPERTIES.ANGULAR_MODE.equals("true")){
			WebDriverWait wait = new WebDriverWait(driver, 30);		 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
		}

		WebElement webElement = driver.findElement(By.xpath(xpathExpression));
		/*}
		catch(WebDriverException exception){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document", args)
		}*/

		return null;		
	}

	protected WebElement findElementByName(String name) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));

		WebElement webElement = driver.findElement(By.name(name));

		return webElement;		
	}
	
	protected WebElement findElementByID(String id) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

		WebElement webElement = driver.findElement(By.id(id));

		return webElement;		
	}
	

	protected void click(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 30);		 
		wait.until(ExpectedConditions.elementToBeClickable(webElement));

		webElement.click();
	}
	
	protected void clickJSById(String id) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('"+id+"').click();");
	}
	
	protected void clickJSByXpath(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.evaluate('"+xpath +"', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();");
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
		// TODO Auto-generated method stub
		driver.navigate().to(FRAMEWORK_PROPERTIES.URL.getValue()+ endPoint);
		
	}

}
