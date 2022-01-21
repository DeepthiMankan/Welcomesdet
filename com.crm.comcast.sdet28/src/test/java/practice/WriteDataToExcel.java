package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {

	public static void main(String[] args) throws Throwable 
	{
		
        //object representation for physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigertestdata.xlsx");
		//create workbook for physical file representation
		
		Workbook workbook = WorkbookFactory.create(fis);
	    //get the control of sheet
		Sheet sheet = workbook.getSheet("sheet1");
	    Row row = sheet.getRow(2);
	    row.createCell(2).setCellValue("wipro");
	    FileOutputStream fos = new FileOutputStream("./src/test/resources/vtigertestdata.xlsx");
	workbook.write(fos);
	workbook.close();
	}

}
