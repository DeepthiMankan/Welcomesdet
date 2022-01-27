package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

/**
 * ProductPage POM design
 * @author deept
 *
 */
public class ProductsPage extends WebDriverUtility
{
	// Declaration of element
	WebDriver driver;
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductPlusButton;
	
	@FindBy(name="search_text")
	private WebElement searchtext;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchfield;
	
	@FindBy(name="submit")
	private WebElement searchButton;
	
	@FindBy(id="60")
	private WebElement checkboxbutton;
	
	@FindBy(xpath="//input[@value='Mass Edit']")
	private WebElement massEditButton;
	
	@FindBy(name="button")
	private WebElement cancelbutton;
	
	@FindBy(linkText="Go to Advanced Search")
	private WebElement advancedSearchlink;
	
	
	
	
	
	
	//Initialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
    //Getters 
	public WebElement getCreateProductPlusButton() {
		return createProductPlusButton;
	}
	
	public WebElement getSearchtext() {
		return searchtext;
	}

	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getCheckboxbutton() {
		return checkboxbutton;
	}

	public WebElement getMassEditButton() {
		return massEditButton;
	}

	public WebElement getCancelbutton() {
		return cancelbutton;
	}
	
	

	//Business logic
	/**
	 * This method is used to click on create product 
	 */
	public void createProductAndMassEdit() 
	{
		createProductPlusButton.click();
		
	}
	
	/**
	 * This method is used search a product by giving its name in search field and click onMass edit
	 * @param productname
	 */
	public void searchProductAndMassedit(String productname)
	{
		searchtext.sendKeys(productname);
		
	}
	
	/**
	 * This method used to search a product by selecting as product name from dropdown and then after obtaining results calling massedit method to edit the product details
	 * @param text
	 */
	public void search(String text)
	{
	   dropDown(searchfield,text);
	   searchButton.click();
	   checkboxbutton.click();
		massEditButton.click();
		//cancelbutton.click();
	}
	
	public void cancelMassEditwindow()
	{
	
	  cancelbutton.click();
	}
	
	public void advanceSearchLink()
	{
		advancedSearchlink.click();
		
	}
	
	public WebElement getAdvancedSearchlink() {
		return advancedSearchlink;

	
	}
		
		
		
		
	}
	
	
	


