package ProductScriptsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.IpathConstants;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateNewProductPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.ProductInformationPage;
import com.crm.comcast.objectRepository.ProductsPage;
/**
 * This method is used to create product by giving price information
 * @author Deepthi
 *
 */
public class PriceInformation {

	@Test
	public void PricingInformation() throws Throwable
	
	{
		
		//Object creation for utility
	       FileUtility futil=new FileUtility();
	       ExcelUtility eutil=new ExcelUtility();
	       WebDriverUtility utility=new WebDriverUtility();
		   
	     //Getting data from property file
	       String browser = futil.getPropertyFileData("browser");
	       String url = futil.getPropertyFileData("url");
	       String username = futil.getPropertyFileData("username");
	       String password = futil.getPropertyFileData("password");
	        
	     //Getting data from excel sheet 
	       String ProductName=eutil.getStringCellData("sheet1",5,2);
	       String currency=eutil.getStringCellData("sheet1",7,3);
	       String commissionrate=eutil.getStringCellData("sheet1",7,4);
	        
		
		//  How to use browser value and launch the browser 
			System.setProperty(IpathConstants.CHROME_KEY, IpathConstants.CHROME_PATH);
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			utility.waitForPageLoad(driver);
			driver.get(url);
			
		//Login
			LoginPage login=new LoginPage(driver);
			login.loginToApplication(username, password);
			
		// Clicking on Product Module	
			HomePage home=new HomePage(driver);
			home.clickOnProducts();
		    
		  //clicking on Creating product 
			ProductsPage product=new ProductsPage(driver);
		     product.createProductAndMassEdit();
			
		   //creating product by giving priceInformation
			CreateNewProductPage create=new CreateNewProductPage(driver);
			create.createProduct(ProductName);
			create.unitPrice(currency);
			create.commission(commissionrate);
			create.saveButton();
			
			//Verification
			ProductInformationPage info=new ProductInformationPage(driver);
			info.verification(driver);
			
			//Logout
			home.logOut();
			
			
			
	}

			
		  
			  /* WebElement unit = driver.findElement(By.id("unit_price"));
			   unit.clear();
			   
			   create.moreCurrencyLink();
			 
			    WebElement currency1 = driver.findElement(By.id("curname1"));
			   currency1.clear();
			   currency1.sendKeys(currency);
			   driver.findElement(By.xpath("(//img[@src='themes/images/close.gif'])[3]")).click();
			   
			     
				
				String title2 = driver.getTitle();
				System.out.println(title2);
				if(title2.contains("vtiger CRM 5"))
			     {
			    	 System.out.println("login page displayed");
			     }
			     else
			    	 System.out.println("login page is not displayed");
		     */
		     
				
					
	}

