package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrgTest 
{
  @BeforeClass
  public void bc()
  {
	  System.out.println("launvh the browser");
  }
  
  @AfterClass
  public void ac()
  {
	  System.out.println("close the browser");
  }
  
  @BeforeMethod
  public void bm()
  {
	  System.out.println("Login to application");
  }
  @AfterMethod
  public void am()
  {
	  System.out.println("Logout from application");
  }
  
  @Test(priority=1)
  public void org()
  {
	  System.out.println("Navigate to organization");
	  System.out.println("Create  organization");
      System.out.println("Verifyorganization");
  }
  
  @Test(priority=2)
  public void contact()
  {
	  System.out.println("Navigate to Contact");
	  System.out.println("Create  Contact");
      System.out.println("Verify Contact");
  }
  
  @Test(priority=3)
  public void product()
  {
	  System.out.println("Navigate to Product");
	  System.out.println("Create  Product");
      System.out.println("Verify  Product");
  }
  }
  
  
  
  
  
  

