package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.collections4.Get;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//program for fetching multiple data from excel
public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		/*FileInputStream fis = new FileInputStream("./src/test/resources/AdvanceSelenium.xlsx");
		Workbook book = WorkbookFactory.create(fis);*/
		 /*or upcasting*/
		Workbook wb = WorkbookFactory.create(new FileInputStream("./src/test/resources/AdvanceSelenium.xlsx"));
		Sheet sheet = wb.getSheet("Sheet2");
		
		//row
		for(int i=0;i<=sheet.getLastRowNum();i++) //226
		{
			Row row = sheet.getRow(i);
			
				//cell(column)
				for(int j=0;j<=row.getLastCellNum();j++)//0
				{
					Cell cell = row.getCell(j);
			
			DataFormatter dataformatter = new DataFormatter();
			String data = dataformatter.formatCellValue(cell);
			System.out.println(data);
				}
		}
	}

}
