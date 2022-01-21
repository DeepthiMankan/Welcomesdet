
package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

/**
 * Advanced SearchPage POM design
 * @author Deepthi
 *
 */
public class AdvancedSearchPage extends WebDriverUtility
{
    //Declaration
	@FindBy(id="fcol0")
	private WebElement searchByVendorname;
	
	@FindBy(id="fop0")
	private WebElement noneField;
	
	@FindBy(id="fval0")
	private WebElement blankTextField;
	
	@FindBy(xpath="//b[text()='Advanced Search']/ancestor::div[@id='advSearch']/descendant::input[@class='crmbutton small create']")
	private WebElement searchNowbutton;
	
	//Initialization
	
	public AdvancedSearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Getters

	public WebElement getSearchByVendorname() {
		return searchByVendorname;
	}

	public WebElement getNoneField() {
		return noneField;
	}

	public WebElement getBlankTextField() {
		return blankTextField;
	}

	public WebElement getSearchNowbutton() {
		return searchNowbutton;
	}
	
	//Business Logic
	
	public void advansedSearchByVendorname(String value,String text,String text2)
	{
		searchByVendorname.sendKeys(value);
		dropDown(noneField,text);
		blankTextField.sendKeys(text2);
		//searchNowbutton.click();
		
		
	}
	
	
	
	
	
	
	
	
	
}
