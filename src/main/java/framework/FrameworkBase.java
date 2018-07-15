// Framework Level Class
package framework;

import java.util.Properties;

import utilities.PropertyReader;

public class FrameworkBase {
	public static PropertyReader propertyReader;
	private static final String filePathFrameworkProperties = System.getProperty("user.dir") + "\\src\\main\\resources\\framework.properties";
	public static Properties frameworkProperties;
	
	protected enum FRAMEWORK_PROPERTIES{
		BROWSER(frameworkProperties.getProperty("browser")),
		URL(frameworkProperties.getProperty("url")),
		ANGULAR_MODE(frameworkProperties.getProperty("angularMode")),
		IMPLICITLY_WAIT(frameworkProperties.getProperty("implicitlyWait")),
		PAGELOAD_TIMEOUT(frameworkProperties.getProperty("pageLoadTimeout"))
		;

		private String value;

		FRAMEWORK_PROPERTIES(String value){
			this.value = value;
		}

		public String getValue(){
			return value;
		}
	}
	
	public static Properties initializePropertyFile(String filePath){
		propertyReader = new PropertyReader();
		propertyReader = propertyReader.getData(filePath);
				
		return propertyReader.properties;
	}
	
	public static void initializeFrameworkPropertyFile(){				
		if(frameworkProperties == null){
			frameworkProperties = new Properties();
			frameworkProperties = initializePropertyFile(filePathFrameworkProperties);
		}
		
	}
	
	protected static void printFrameworkProperties(){
		System.out.println(filePathFrameworkProperties);
		System.out.println(FRAMEWORK_PROPERTIES.BROWSER.getValue());
		System.out.println(FRAMEWORK_PROPERTIES.URL.getValue());
		System.out.println(FRAMEWORK_PROPERTIES.ANGULAR_MODE.getValue());
		System.out.println(FRAMEWORK_PROPERTIES.IMPLICITLY_WAIT.getValue());
		System.out.println(FRAMEWORK_PROPERTIES.PAGELOAD_TIMEOUT.getValue());
	}
	
	protected void waitFor(long timeToWait) {
		try {
			Thread.sleep(timeToWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
