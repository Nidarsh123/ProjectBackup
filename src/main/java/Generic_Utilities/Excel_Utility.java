package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.ObjectArrays;

public class Excel_Utility {
	/**
	 * This method is used to fetch data from Excel sheet
	 * @parameter sheetName
	 * @parameter rowNum
	 * @parameter cellNum
	 * @return
	 * @throws Throwable
	 * @author Dell
	 *
	 */

	/*for Organization and email field*/
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable {
		//Organization field filling using excel
				FileInputStream fis = new FileInputStream("./src/test/resources/OrganizationExcel.xlsx");
				Workbook book = WorkbookFactory.create(fis);
				 Sheet sheet = book.getSheet(sheetName);
				Row row = sheet.getRow(rowNum);
				Cell cell = row.getCell(cellNum);
				String ExcelData = cell.getStringCellValue();
				return ExcelData;			
	}
	/*for phone number*/
	public String getExcelDataUsingDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/OrganizationExcel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		 Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter formatter = new DataFormatter();
		String ExcelData = formatter.formatCellValue(cell);
		return ExcelData;
	}
	
	//for data from QtigerModules.xlsx
		public String getExcelData1(String sheetname,int rowNum,int cellNum) throws Throwable {
			FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
			Workbook book= WorkbookFactory.create(fis1);
			Sheet sheet = book.getSheet(sheetname);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			String ExcelData = cell.getStringCellValue();
			return ExcelData;
		}
		/*for budgetcost*/
		public String getExcelDataUsingDataFormatter1(String sheetname,int rowNum,int cellNum) throws Throwable{
			FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
			Workbook book= WorkbookFactory.create(fis1);
			Sheet sheet = book.getSheet(sheetname);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			DataFormatter formatter = new DataFormatter();
			String ExcelData = formatter.formatCellValue(cell);
			return ExcelData;
		}
//===================================================================================================================
		public Object[][] readMultipleData(String SheetName) throws Throwable {
			FileInputStream fis1 = new FileInputStream("./src/test/resources/ExcelData7to9.xlsx");
			Workbook book = WorkbookFactory.create(fis1);
			 Sheet sheet = book.getSheet(SheetName);
			 int lastrow = sheet.getLastRowNum()+1;
			 int lastcell = sheet.getRow(0).getLastCellNum();
			 
			Object[][] obj = new Object[lastrow][lastcell];
			
			for(int i=0;i<lastrow;i++)
			{
				for(int j=0;j<lastcell;j++)
				{
					obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			 
			return obj;
			
		}
}
