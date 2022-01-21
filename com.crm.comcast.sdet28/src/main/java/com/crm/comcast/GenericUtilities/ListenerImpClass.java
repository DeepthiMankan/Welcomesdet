package com.crm.comcast.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass extends BaseClass implements ITestListener
{

	public void onTestFailure(ITestResult result) 
	{
		// TODO Auto-generated method stub
		String testcaseName = result.getMethod().getMethodName();
		  System.err.println(testcaseName);
		   
		  //take screenshot code
		  EventFiringWebDriver event=new EventFiringWebDriver(BaseClass.sdriver);
		  File source = event.getScreenshotAs(OutputType.FILE);
		  File destination = new File("./errorshot/"+testcaseName+".png");
		  try 
		  {
			  
		    FileUtils.copyFile(source, destination);
		  }
		  catch(IOException e)
		  {
			  e.printStackTrace();
			  
		  }
		  
		  
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	  

	
  
	 
  
}







