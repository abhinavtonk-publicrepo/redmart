package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rough extends PageBase{

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://redmart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[4]/ul/li/ul/li[1]/a/div[1]")).click();
		String xpath = "html/body/div[1]/header/div/div/section/div/div[1]/div[3]/div/div/input";
		String value = "eggs";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.evaluate('"+xpath +"', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='"+value+"';");
		
	}
}
