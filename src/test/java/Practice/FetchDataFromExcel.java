package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Myexcel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		
		//fetching only string value
		//String exceldata = cell.getStringCellValue();
		//System.out.println(exceldata);
		
		//Fetching as it is single data from excel
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(cell);
		System.out.println(data);
		
	}

}
