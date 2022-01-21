package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

/**
 * CreateNewProduct POM Design
 * @author deept
 *
 */
public class CreateNewProductPage extends WebDriverUtility
{
	WebDriver driver;
	//Declaration
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="sales_start_date")
	private WebElement salesstartdatefield;
	
	@FindBy(id="productcode")
	private WebElement productcodefield;
	
	@FindBy(name="productcategory")
	private WebElement productcategory;
	
	@FindBy(id="jscal_field_sales_end_date")
	private WebElement salesenddatefield;
	
	@FindBy(name="manufacturer")
	private WebElement manufacturer;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectbutton;
	
	@FindBy(id="search_txt")
	private WebElement searchtextfield;
	
	@FindBy(name="search")
	private WebElement searchbutton;
	
	@FindBy(linkText="Raj")
	private WebElement vendornamelink;
	
	@FindBy(id="vendor_part_no")
	private WebElement vendorpartno;
	
	@FindBy(id="productsheet")
	private WebElement productsheet;
	
	@FindBy(name="website")
	private WebElement website;
	
	@FindBy(id="mfr_part_no")
	private WebElement mfrpartno;
	
	@FindBy(id="serial_no")
	private WebElement serial_no;
	
	@FindBy(id="jscal_field_start_date")
	private WebElement startdate;
	
	@FindBy(id="jscal_field_expiry_date")
	private WebElement expirydate;
	
	@FindBy(name="glacct")
	private WebElement account;
	
	@FindBy(id="unit_price")
	private WebElement unitpricetextfield;
	
	@FindBy(linkText="more currencies »")
	private WebElement currencylink;
	
	@FindBy(id="curname1")
	private WebElement curname;
	
	@FindBy(xpath="//img[@src='themes/images/close.gif'])[3]")
	private WebElement resetbutton;
	
	@FindBy(id="commissionrate")
	private WebElement commissionratetextfiel;
	
	
	
	
	//Initialization
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	//Getters
	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getSalesstartdatefield() {
		return salesstartdatefield;
	}

	public WebElement getProductcodefield() {
		return productcodefield;
	}

	public WebElement getProductcategory() {
		return productcategory;
	}

	public WebElement getSalesenddatefield() {
		return salesenddatefield;
	}

	public WebElement getManufacturer() {
		return manufacturer;
	}

	public WebElement getSelectbutton() {
		return selectbutton;
	}

	public WebElement getSearchtextfield() {
		return searchtextfield;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getVendornamelink() {
		return vendornamelink;
	}

	public WebElement getVendorpartno() {
		return vendorpartno;
	}

	public WebElement getProductsheet() {
		return productsheet;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getMfrpartno() {
		return mfrpartno;
	}

	public WebElement getSerial_no() {
		return serial_no;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getExpirydate() {
		return expirydate;
	}

	public WebElement getAccount() {
		return account;
	}
	public WebElement getCommissionratetextfiel() {
		return commissionratetextfiel;
	}

	

	public WebElement getCurrencylink() {
		return currencylink;
	}

	public WebElement getCurname() {
		return curname;
	}



	/**
	 * This method is used to enter product name and click on save button to create product
	 * @param productname
	 */
	public void createProduct(String productname)
	{
		productNameTextField.sendKeys(productname);
	}
	
	/**
	 * This method is used to enter the data in text fields
	 * @param text1
	 */
	public void enterData(String text1) 
	{
		salesstartdatefield.sendKeys("2018-05-08");
		productcodefield.sendKeys(text1);
		salesenddatefield.sendKeys("2018-05-30");
	
	}
	/**
	 * This method is used to select data from dropdown
	 */
	public void dropDownManufacturer()
	{
		dropDown(manufacturer,"LexPon Inc.");
	}
	
	public void productcategorydropDown(String text)
       {
			dropDown(productcategory, text);
		}
	
	/**
	 * This method is used to search product by giving vendor name
	 * @param vendorname
	 */
	public void searchProduct(String vendorname)	
	{
		selectbutton.click();
		switchTabs(driver);
		searchtextfield.sendKeys(vendorname);
		searchbutton.click();
		vendornamelink.click();
		switchTabs(driver);
	}
	
	public void remainingDetails(String sheet,String web,String mfrno,String serno)
	{
		vendorpartno.sendKeys("12");
		productsheet.sendKeys(sheet);
		website.sendKeys(web);
		mfrpartno.sendKeys(mfrno);
		serial_no.sendKeys(serno);
		startdate.sendKeys("2018-05-09");
		expirydate.sendKeys("2018-10-12");
		saveButton.click();
		
	}
	public void saveButton()
	{
		saveButton.click();
		
	}
	
	/**
	 * This method is used to click on currency details
	 */
	public void unitPrice(String value)
	{
		unitpricetextfield.clear();
		unitpricetextfield.sendKeys(value);
		//switchTabs(driver);
	}
	
	public void commission(String Value1)
	{
		commissionratetextfiel.sendKeys(Value1);
	}
		
	
	}
	
	
	
	
	
	
	


