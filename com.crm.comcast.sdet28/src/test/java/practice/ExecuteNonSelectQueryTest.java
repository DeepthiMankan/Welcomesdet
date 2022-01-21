package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws SQLException 
	{   Connection connection=null;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
	     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");;
		Statement statement = connection.createStatement();
		//int result=statement.executeUpdate("delete from student where sid=103");
		int result = statement.executeUpdate("insert into student  (104,'Deepthi','sql')");
		//int result=statement.executeUpdate("update student set sname='Deepthi' where sid=101");
		if(result==1)
		{
			System.out.println("Data is updated");
		}
		else
		{
			System.out.println("Data not updated");
		}
		}
	catch(Exception e)
	{
	
	}
		finally
		{
		connection.close();
		System.out.println("connection closed");
			
		}	
		}
	}


