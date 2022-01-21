package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetTheDataFromExcelSheetTest {

	public static void main(String[] args) throws Throwable 
	{
		
	//java object representation for physical excel sheet
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigertestdata.xlsx");
	//create workbook for physical file object representation
		Workbook workbook = WorkbookFactory.create(fis);
    //get the control of sheet
		Sheet sheet = workbook.getSheet("sheet1");
	//get the row control
		Row row = sheet.getRow(1);
	//get cell control
		Cell cell = row.getCell(2);
		
	//fetch the value from cell
		String orgName = cell.getStringCellValue();
		System.out.println(orgName);
	//close the workbook
		workbook.close();
	}

}
