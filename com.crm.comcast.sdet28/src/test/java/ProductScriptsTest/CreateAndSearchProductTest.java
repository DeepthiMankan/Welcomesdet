package ProductScriptsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
/**This class is used to create Product and the search the product by Product name
 * 
 * @author Deepthi
 *
 */
@Listeners(com.crm.comcast.GenericUtilities.ListenerImpClass.class)
public class CreateAndSearchProductTest extends BaseClass
{

	//public static void main(String[] args) throws Throwable 
	@Test(groups= {"smoke test"})
	public void CreateProduct() throws Throwable
	{          
		       		       
		      //Get the data from excel sheet
		        
		        String ProductName=eutil.getStringCellData("sheet1",1,2);
		        String SearchProduct=eutil.getStringCellData("sheet1",1,3);
		        String ProductByName=eutil.getStringCellData("sheet1",1,4);
		        String Expectedpage=eutil.getStringCellData("sheet1",1,5);
		        
		    
			   //click on Products module
			    
			    HomePage home=new HomePage(driver);
			    home.clickOnProducts();
			    
			    
			    //clicking on create product in products module
			    ProductsPage product=new ProductsPage(driver);
			    product.createProductAndMassEdit();
			    
			    //Creating a new Product by giving product name and clicking in save button.
			    CreateNewProductPage pro= new CreateNewProductPage(driver);
			    pro.createProduct(ProductName);
			    Thread.sleep(3000);
			    home.clickOnProducts();
			    
			    //Searching a product by selecting product name option from drop down and giving product name in search field
			    product.searchProductAndMassedit(ProductName);
			    product.search(ProductByName);
			    
			    
			    //verification
			    ProductInformationPage massedit=new ProductInformationPage(driver);
			    String Actualpage = massedit. MasseditText();
			    Assert.assertEquals(Actualpage,Expectedpage);
			    System.out.println("Massedit page is displayed");
			    product.cancelMassEditwindow();
			   
			    
				
				
			
			  }
			    

			    
	}


