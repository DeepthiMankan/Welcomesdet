package com.crm.comcast.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * 
 * @author Deepthi
 *
 */
public class FileUtility 
{
/**
 * This method is used to get data from property file
 * @param key
 * @return
 * @throws Throwable
 */
	public String getPropertyFileData(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.PROPERTYFILEPATH);
		Properties property=new Properties();
		property.load(fis);
		return property.getProperty(key);
		
	}

}