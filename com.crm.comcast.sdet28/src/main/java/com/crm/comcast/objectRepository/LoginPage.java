package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * LoginPage POM design
 * @author Deepthi
 *
 */
public class LoginPage
{
	
	//element initialization
	@FindBy(name="user_name")
	private  WebElement usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	
	
	public WebElement getLoginButton() {
		return loginButton;
	}

	
	//business logic for logic action
	/**
	 * This method perform application login action
	 * @param username
	 * @param password
	 */
	public void loginToApplication(String username,String password)
	{
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
		
	}

	
	
	
	
	
	
	
	
	
	

}
