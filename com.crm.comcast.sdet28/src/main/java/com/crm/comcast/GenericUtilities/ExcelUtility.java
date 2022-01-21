package com.crm.comcast.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Deepthi
 *
 */
public class ExcelUtility 
{
/**
 * This method fetches data from excel sheet	
 * @param sheetname
 * @param rowno
 * @param cellno
 * @return
 * @throws Throwable
 */

  public String getStringCellData(String sheetname,int rowno,int cellno) throws Throwable
  {
	  
	 FileInputStream fis=new FileInputStream("./src/test/resources/vtigerproductmoduletestdata.xlsx");
	 Workbook workbook = WorkbookFactory.create(fis);
	 Sheet sheet = workbook.getSheet(sheetname);
	 Row row = sheet.getRow(rowno);
	 Cell cell = row.getCell(cellno);
	 return cell.getStringCellValue();
  }
  /**
   * This method used to fetch numeric data
   * @param sheetname
   * @param rowno
   * @param cellno
   * @return
   * @throws Throwable
   */
  public double getNumericCellValue(String sheetname,int rowno,int cellno) throws Throwable
  {
	  FileInputStream fis=new FileInputStream("./src/test/resources/vtigerproductmoduletestdata.xlsx");
		 Workbook workbook = WorkbookFactory.create(fis);
		 return workbook.getSheet(sheetname).getRow(rowno).getCell(cellno).getNumericCellValue();
  }
  /**
   * This Method used to fetch multiple data
   * @param sheetname
   * @throws Throwable
   */
  public void getMultipleData(String sheetname) throws Throwable
  {
	  FileInputStream fis=new FileInputStream("./src/test/resources/vtigerproductmoduletestdata.xlsx");
		 Workbook workbook = WorkbookFactory.create(fis);
		 Sheet sheet = workbook.getSheet(sheetname);
		 int rowno = sheet.getLastRowNum();
		 int cellno=sheet.getRow(0).getLastCellNum();
		 Object[][] data=new Object[rowno][cellno];
		 for(int i=0;i<rowno;i++)
		 {
			 for(int j=0;j<cellno;j++)
			 {
				 data[i][j]=sheet.getRow(i).getCell(j).toString();
			 }
		 }
 
  }
  /**
   * This method used to write data into excel sheet
   * @param sheetname
   * @param rowno
   * @param cellno
   * @param value
   * @throws Throwable
   */
  public void writeDataToExcel(String sheetname,int rowno,int cellno,String value) throws Throwable
  {
	  FileInputStream fis=new FileInputStream("./src/test/resources/vtigerproductmoduletestdata.xlsx");
	  Workbook workbook = WorkbookFactory.create(fis);
	  workbook.createSheet(sheetname).createRow(rowno).createCell(cellno).setCellValue(value);
	  FileOutputStream fout=new FileOutputStream("\"./src/test/resources/vtigerproductmoduletestdata.xlsx");
      workbook.write(fout);
      workbook.close();
  }
}
