package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteSingleDataToExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvanceSelenium.xlsx");

		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.createRow(5);
		Cell cell = row.createCell(4);
		cell.setCellValue("puma");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/AdvanceSelenium.xlsx");
		book.write(fos);
		book.close();
	}

}
