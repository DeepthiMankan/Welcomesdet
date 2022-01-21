package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * MassEdit POM design
 * @author Deepthi
 *
 */
public class ProductInformationPage 

{
	//Declaration of element
	
	@FindBy(xpath="//td[text()='Mass Edit - Records Fields']")
     private WebElement massEditPagetext;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement createdproducttext;
	
	@FindBy(linkText="Keyboard")
	private WebElement productNameText;

	
	//Initialization
	
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	//Getters
	
	public WebElement getMassEditPagetext() 
	{
		return massEditPagetext;
	}
	
	
	public WebElement getCreatedproducttext() {
		return createdproducttext;
	}
	
	
	
	public WebElement getProductNameText() {
		return productNameText;
	}


	///Business logic
	public String getTextOfMassEditPage()
	{
		return massEditPagetext.getText();
	   
	}
	
	public String getCreatedProductText()
	{
		return createdproducttext.getText();
	}
	
	
	public void verification(WebDriver driver)
	{
		String title2 = driver.getTitle();
		System.out.println(title2);
		if(title2.contains("vtiger CRM 5"))
	     {
	    	 System.out.println("login page displayed");
	     }
	     else
	    	 System.out.println("login page is not displayed");
	}
	
	public void productText()
	{
		String actualtext = "Keyboard";
	    String expectedtext = productNameText.getText();
	    System.out.println(expectedtext);
	    if(actualtext.equals(expectedtext))
	    {
	 	   System.out.println("Matchimg record displayed");
	    }
	    else
	 	   System.out.println("Matching record not displayed");
	    }
	
	public void getCreateProductText(String expectedText)
	{
		String ActualText = createdproducttext.getText();
		
	     System.out.println(ActualText);
	     if(ActualText.contains(expectedText))
	     {
	    	 System.out.println("Pass:product created by accepting all values");
	     }
	     else
	    	 System.out.println("fail");
	} 
	     public String MasseditText()
	     {
	    	 String Actualpage = massEditPagetext.getText();
	    	 return Actualpage;
	    	/* if(Actualpage.equals(Expectedpage))
			    {
			    	System.out.println("pass:Massedit page is displayed");
			    	
			    }
			    else
			    	System.out.println("Fail");*/
	     }
	     
	}
	
	

	
	
	
	
	

