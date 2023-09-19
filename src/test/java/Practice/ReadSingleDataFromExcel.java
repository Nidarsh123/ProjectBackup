package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadSingleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		/*step1: set the path*/
		//FileInputStream fis = new FileInputStream("./src/test/resources/AdvanceSelenium.xlsx");
		//we can using this type location also first go to location of excel file copy and name copy it with extension .xlsx
		FileInputStream fis = new FileInputStream("G:\\advanceSelenium\\AdvanceSelenium.xlsx");
		
		//step2: open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step3:get control to the sheet
		Sheet sheet = book.getSheet("Sheet1");
		
		//step4:get control to row
		Row row = sheet.getRow(1);
		
		//step5:get control to cell
		Cell cell = row.getCell(1);
		
		String excelData = cell.getStringCellValue();
		System.out.println(excelData);

	}

}
