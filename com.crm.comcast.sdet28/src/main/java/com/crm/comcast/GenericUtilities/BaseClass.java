package com.crm.comcast.GenericUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
/**
 * It contains configuration annotations
 * @author Deepthi
 *
 */
public class BaseClass 
{
	
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility futil=new FileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public ExcelUtility eutil=new ExcelUtility();
   
    
	/**
	 * This method is used to connect to database
	 */
	@BeforeSuite(groups= {"smoke test","regression test"})
	public void dataBaseConnection()
	{
		System.out.println("connection to database");
	}
	
	/**
	 * This method is used to launch the browser
	 * @throws Throwable
	 */
	@BeforeClass(groups= {"smoke test","regression test"})
	public void launchBrowser() throws Throwable
	{
		String browser = futil.getPropertyFileData("browser");
	    String url = futil.getPropertyFileData("url");
	    
	    System.setProperty(IpathConstants.CHROME_KEY, IpathConstants.CHROME_PATH);
	    driver=new ChromeDriver();
	    sdriver=driver;
	   // driver.manage().window().maximize();
	    //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	 }
	
	
	/**
	 * This method is used to perform login operation
	 * @throws Throwable
	 */
	@BeforeMethod(groups= {"smoke test","regression test"})
	public void login() throws Throwable
	{
		LoginPage login=new LoginPage(driver);
		String username = futil.getPropertyFileData("username");
	    String password = futil.getPropertyFileData("password");
	    
	    login.loginToApplication(username, password);
	}
	
	/**
	 * This method is used to perform logout operation
	 */
	@AfterMethod(groups= {"smoke test","regression test"})
	public void logout()
	{
		HomePage home=new HomePage(driver);
		home.logOut();
	}
	
	/**
	 * this method is performed to close browser
	 */
	@AfterClass(groups= {"smoke test","regression test"})
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite(groups= {"smoke test","regression test"})
	public void closeDb()
	{
		System.out.println("database connection is closed");
	}

}
