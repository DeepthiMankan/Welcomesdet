package com.crm.comcast.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author deept
 *
 */
public class DataBaseUtility 
{

	Connection connection=null;
	/**
	 * This method is used to connect to database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
	}
	
	/**
	 * This method is used to close the database
	 * connection
	 * @throws Throwable
	 */
	public void closeConnection() throws Throwable
	{
		connection.close();
	}
	
	/**
	 * This method id used tofetch all data from database
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet getAllData(String query) throws Throwable
	{
		ResultSet result = connection.createStatement().executeQuery(query);
	    return result;
	}
	
	
	/**
	 * This method is used to update the data in database
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public boolean updateData(String query) throws Throwable
	{
		boolean flag=false;
		 int result = connection.createStatement().executeUpdate(query);
		 if(result==1)
		 {
			 System.out.println("Data is updated in database");
			 flag=true;
		 }
		 else
		 {
			 System.out.println("Data is not updated");
		 }
		 return flag;
	 }
	
	/**
	 * This method will verify the given data is present or not
	 * @param query
	 * @param columnnumber
	 * @param expecteddata
	 * @return
	 * @throws Throwable
	 */
	public String getTheData(String query,int columnnumber,String expecteddata) throws Throwable 
	{
		boolean flag=false;
		String actualdata=null;
		ResultSet result = connection.createStatement().executeQuery(query);
		while(result.next())
		{
			String data=result.getString(columnnumber);
			if(data.equals(expecteddata))
			{
				actualdata=data;
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("Data is present in database");
		}
		else
			System.out.println("Data is not present in database");
		return actualdata;
			}
	
	}
	
	
	
