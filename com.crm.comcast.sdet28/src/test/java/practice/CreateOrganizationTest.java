package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties property=new Properties();
		//Load the key and value from Property object
		property.load(fis);
		//String browser = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
	
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	     WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.get(url);
	    WebElement ele1 = driver.findElement(By.name("user_name"));
	    ele1.clear();
	    ele1.sendKeys(username);
	       
	    WebElement ele2 = driver.findElement(By.name("user_password"));
	    ele2.clear();
	    ele2.sendKeys(password);
	    driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("DeepthiYogesh37");
		
		driver.findElement(By.name("button")).click();
		WebElement ele4 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		//WebElement ele4 = driver.findElement(By.className("dvHeaderText"));
		String text=ele4.getText();
		System.out.println(text);
		if(text.contains("Organization"))
				{
			System.out.println("verification success");
				}
		else
		{
			System.out.println("not success");
		}
		
        Actions action = new Actions(driver);
		WebElement ele5 = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		action.moveToElement(ele5).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
	
	}

}
