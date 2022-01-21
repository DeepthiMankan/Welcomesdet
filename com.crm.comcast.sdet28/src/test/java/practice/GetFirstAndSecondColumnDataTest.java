package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetFirstAndSecondColumnDataTest {

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigertestdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
	    Sheet sheet = workbook.getSheet("sheet1");
	     int rowno = sheet.getLastRowNum();
	     for(int i=1;i<=rowno;i++)
	     {
	    	 Row row = sheet.getRow(i);
	    	 String FirstColumnData = row.getCell(0).getStringCellValue();
	         String SecondColumnData = row.getCell(1).getStringCellValue();
	         System.out.println(FirstColumnData+"\t"+SecondColumnData);
	     }
	
	}
}
		
	


