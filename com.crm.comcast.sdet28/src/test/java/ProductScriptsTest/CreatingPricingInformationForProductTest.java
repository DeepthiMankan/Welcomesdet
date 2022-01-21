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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilities.BaseClass;
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
@Listeners(com.crm.comcast.GenericUtilities.ListenerImpClass.class)
public class CreatingPricingInformationForProductTest extends BaseClass {

	@Test(groups= {"smoke test"})
	public void PricingInformation() throws Throwable
	
	{
		 //Getting data from excel sheet 
	       String ProductName=eutil.getStringCellData("sheet1",5,2);
	       String currency=eutil.getStringCellData("sheet1",7,3);
	       String commissionrate=eutil.getStringCellData("sheet1",7,4);
	        
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
			
			
			
			
			
	}

			
		  
			  
	}


