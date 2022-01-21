package ProductScriptsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
 * This class is used to create Product by entering inputs in all fields
 * @author Deepthi
 *
 */
@Listeners(com.crm.comcast.GenericUtilities.ListenerImpClass.class)
public class CreateProductByProductTest extends BaseClass{

	@Test(groups= {"regression Test"})
	public void CreateProduct() throws Throwable
	{
	
	   	    // Get the data from Excel sheet  
	        String ProductName=eutil.getStringCellData("sheet1",5,2);
	        String Partno=eutil.getStringCellData("sheet1",5,5);
	        String ProductCategory=eutil.getStringCellData("sheet1",5,7);
	        String VendorName=eutil.getStringCellData("sheet1",5,11);
	        String Website=eutil.getStringCellData("sheet1",5,12);
	        String ProductSheet=eutil.getStringCellData("sheet1",5,13);
	        String MfrPart=eutil.getStringCellData("sheet1",5,14);
	        String SerialNo=eutil.getStringCellData("sheet1",5,15);
	        String GLAccount=eutil.getStringCellData("sheet1",5,16);
	        String expectedText=eutil.getStringCellData("sheet1",5,17);
	        
	     
	     // clicking on Products module
	     HomePage home=new HomePage(driver);
	     home.clickOnProducts();
	     Thread.sleep(3000);
	    
	    //creating product by entering all data into all the fields
	     ProductsPage product=new ProductsPage(driver);
	     product.createProductAndMassEdit();
	     
	    //Entering the data in Create product page
	     CreateNewProductPage create=new CreateNewProductPage(driver);
	     create.createProduct(ProductName);
	     create.enterData(Partno);
	     create.dropDownManufacturer();
	     create.searchProduct(VendorName);
	     create.productcategorydropDown(ProductCategory);
	     create.dropDownManufacturer();
	     create.remainingDetails(ProductSheet, Website, MfrPart,SerialNo);
	     
	     //verification
	     
	     ProductInformationPage page=new ProductInformationPage(driver);
	     page. getCreateProductText(expectedText);
	     
	}  
	    
	}
	   
	


