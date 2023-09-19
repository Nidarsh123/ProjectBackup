package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bouncycastle.jcajce.io.OutputStreamFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteMultipleDataToExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvanceSelenium.xlsx");

		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));//226
		
	//fetching multiple data so we using loop and 'size' we using for what ever size present in the "list" same exact-
		//-size maintain in row of excel also because insertion order is preserved. 
		for(int i = 0;i<allLinks.size();i++)
		{
			//write the data only on row because using i in row
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			//we get only attributes value of id/href(class name)
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
		}
		FileOutputStream fos = new FileOutputStream("./src/test/resources/AdvanceSelenium.xlsx");
		book.write(fos);
		book.close();
	}

}
