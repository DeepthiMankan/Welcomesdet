package com.crm.comcast.GenericUtilities;


import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Deepthi
 *
 */
public class JavaUtility 
{
	/**
	 * This method is used to generate random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random=new Random();
		 int randomno = random.nextInt(3000);
		 return randomno;
	}

	/**
	 * This method used to return system date and time
	 * @return
	 */
	public String systemDateAndTime()
	{
		Date date=new Date();
		String dateandtime = date.toString();
		return dateandtime;
	}
}
