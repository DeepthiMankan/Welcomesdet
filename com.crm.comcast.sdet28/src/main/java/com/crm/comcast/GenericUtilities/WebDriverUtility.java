package com.crm.comcast.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility 
{
	private static final String E = null;

	/**
	 * It will wait 20 seconds till the element load on DOM
	 * @param driver
	 */
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	/**
	 * This method will wait till the element visible
	 * @param driver
	 * @param element
	 */
	public void waitForVisibilityOfElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This method waits untill element is clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to wait for element and do click operation
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable
	{
		int count=0;
		while(count<50)
		{
			try
			{
				element.click();
			}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	
			
	/**
	 * This method is used to select an item based on text	
	 * @param ele
	 * @param text
	 */
	public void dropDown(WebElement ele, String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
		
	}
	
	
	/**
	 * This method is used to select value by index
	 * @param ele
	 * @param index
	 */
	public void dropDown(WebElement ele, int index)
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
		
	}
	
	/**
	 * This method is used to selectoption by value 
	 * @param text
	 * @param ele
	 */
	public void dropDown(String text,WebElement ele)
	{
		Select s=new Select(ele);
		s.selectByValue(text);
		
	}
	
	/**
	 * This method is used to mouseover on element
	 * @param driver
	 * @param ele
	 */
	public void mouseOver(WebDriver driver, WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	/**
	 * This method is used to doubleclick on element
	 * @param driver
	 * @param ele
	 */
	
	public void doubleClick(WebDriver driver, WebElement ele)
	{
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	
	/**
	 * This method is used to drag and drop
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement src,WebElement target)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src,target).perform();
	}
	
	/**
	 * This method id used to switch to the frames
	 * @param driver
	 */
	public void switchtoFrame(WebDriver driver)
	{
		driver.switchTo().frame(0);
	}
	
	
	/**
	 * This method is used to switch back from frame
	 * @param driver
	 */
	public void switchbackFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to accept the alert
	 * @param driver
	 */
	public void alertPopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to dismiss the alert
	 * @param driver
	 */
	public void dismissalertPopup(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to switch between windows
	 * @param driver
	 */
	public void switchTabs(WebDriver driver)
	{    
		 Set<String> child = driver.getWindowHandles();
		 for(String b:child)
		 {
			 driver.switchTo().window(b);
		 }
		 
		 
	}
	
	
	
	/**
	 * This method is used to scroll down to the page
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollBar(WebDriver driver,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		 
	}
	
	/**
	 * This method is used to switch frames by elements
	 * @param driver
	 * @param element
	 */
	
	public void switchFrames(WebDriver driver,WebElement element)
	 {
		driver.switchTo().frame(element); 
	 }
	
	/**
	 * This method used to switch frames on index passed
	 * @param driver
	 * @param index
	 */
	 public void switchFrames(WebDriver driver,int index)
	 
	{
		driver.switchTo().frame(index);
	}
	 
	 /**
	  * This method is used to get screenshot of failed test scripts
	  * @param driver
	  * @param testcasename
	  * @return
	  * @throws Throwable
	  */
	 public String screenshot(WebDriver driver, String testcasename) throws Throwable
	 {
		 JavaUtility jutil=new JavaUtility();
		 String FilePath="./errorshot"+testcasename+jutil.systemDateAndTime()+".png";
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dest = new File(FilePath);
		 Files.copy(src, dest);
		 return FilePath;
	 }	
	 
	 
	 /**
	  * This method is used to send data using java script executor
	  * @param driver
	  * @param valueToEnter
	  * @param element
	  */
	 public void enterDataUsingJs(WebDriver driver,String valueToEnter, WebElement element)
	 {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].value='"+valueToEnter+"'", element);
	 }
	 
	 public void switchWindow(WebDriver driver,String partialWindowTitle)
	 {
		Set<String> child = driver.getWindowHandles();
	    Iterator<String> it = child.iterator();
	    while(it.hasNext())
	    {
	    	String child1 = it.next();
	    	String title = driver.switchTo().window(child1).getTitle();
		
		if(title.contains(partialWindowTitle))
		{
			break;
		}
	 }
	 }} 

		 
	 


