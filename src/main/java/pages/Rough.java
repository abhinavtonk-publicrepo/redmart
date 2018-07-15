package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rough extends PageBase{
	
	/*private int i;
	public void method1(){
		i=2;
		System.out.println(i);
	}*/

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		/*System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();*/
		
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://redmart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();
		/*String xpath = "html/body/div[1]/header/div/div/section/div/div[1]/div[3]/div/div/input";
		String value = "eggs";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.evaluate('"+xpath +"', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='"+value+"';");
		*/
	}
}
