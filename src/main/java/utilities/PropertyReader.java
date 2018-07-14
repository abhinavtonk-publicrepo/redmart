package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import interfaces.DataManager;

public class PropertyReader implements DataManager{
	
	public Properties properties;
	
	public PropertyReader getData(String filePath) {
		// TODO Auto-generated method stub
		properties = new Properties();
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return this;
	}

}
