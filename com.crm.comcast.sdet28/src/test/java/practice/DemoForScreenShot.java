package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.comcast.GenericUtilities.BaseClass;
@Listeners(com.crm.comcast.GenericUtilities.ListenerImpClass.class)
public class DemoForScreenShot extends BaseClass
{
  @Test
  public void sample() 
  {
	String expectedname = "Deepthi";
	String actualname = "yogesh";
	Assert.assertEquals(expectedname, actualname);
  }
}
