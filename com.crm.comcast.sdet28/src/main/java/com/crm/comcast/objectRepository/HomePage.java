package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtilities.WebDriverUtility;

/**
 * HomePage POM design
 * @author Deepthi
 *
 */
public class HomePage extends WebDriverUtility
{
	//Declaration of elements
	WebDriver driver;
	@FindBy(linkText="Products")
	private WebElement productslink;

    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement logoutImg;
    
    @FindBy(linkText="Sign Out")
    private WebElement signoutlink;
    
    //Initialization of elements
    public HomePage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }

    //getters
	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	//Businesslogic
	
	/**
	 * This method used to click on product
	 */
	public void clickOnProducts()
	{
		productslink.click();
	}
	
	/**
	 * This method is used to performlogout
	 */
	
	public void logOut()
	{
		mouseOver(driver, logoutImg);
		signoutlink.click();
	}
    
    

}