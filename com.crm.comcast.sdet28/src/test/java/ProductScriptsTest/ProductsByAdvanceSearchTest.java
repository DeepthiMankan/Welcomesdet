package ProductScriptsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilities.BaseClass;
import com.crm.comcast.GenericUtilities.ExcelUtility;
import com.crm.comcast.GenericUtilities.FileUtility;
import com.crm.comcast.GenericUtilities.IpathConstants;
import com.crm.comcast.GenericUtilities.WebDriverUtility;
import com.crm.comcast.objectRepository.AdvancedSearchPage;
import com.crm.comcast.objectRepository.CreateNewProductPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.ProductInformationPage;
import com.crm.comcast.objectRepository.ProductsPage;
/**
 * This class is used to perform advance search by giving vendor name in product module
 * @author Deepthi
 *
 */
@Listeners(com.crm.comcast.GenericUtilities.ListenerImpClass.class)
public class ProductsByAdvanceSearchTest extends BaseClass
{
	@Test
	public void productByAdvanceSearch() throws Throwable
	
	 {
		
	      //getting data from excel sheet
	       String Searchby=eutil.getStringCellData("sheet1",3,2);
	       String nonefield=eutil.getStringCellData("sheet1",3,3);
	       String text=eutil.getStringCellData("sheet1",3,4);
	        	
   
	      //clicking on products module in home page
           HomePage home=new HomePage(driver);
           home.clickOnProducts();
    
         //Clicking on advance search link in Products module
          ProductsPage product=new ProductsPage(driver);
          product.advanceSearchLink();
    
        //Advance search by giving vendor name
         AdvancedSearchPage search=new AdvancedSearchPage(driver);
         search.advansedSearchByVendorname(Searchby,nonefield,text);
         WebElement searchnow = driver.findElement(By.xpath("//b[text()='Advanced Search']/ancestor::div[@id='advSearch']/descendant::input[@class='crmbutton small create']"));
         searchnow.click();
    
       //verification
         ProductInformationPage info=new ProductInformationPage(driver);
         info.productText();
    
   
    
    
    
	}
	
}	



