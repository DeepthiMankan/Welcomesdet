package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class GetDataFromPropertyFileTest {

	public static void main(String[] args) throws Throwable 
	{
		//Java Object Representation of physical propertyfile
		FileInputStream fis=new FileInputStream("./src/test/resources/data.properties");
		//Create an object for properties class
		Properties property=new Properties();
		//Load the key and value from Property object
		property.load(fis);
		
		String browser = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}

}
