package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelUsingMap {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvanceSelenium.xlsx");
	    Workbook book = WorkbookFactory.create(fis);
	    Sheet sheet = book.getSheet("Sheet4");
	    
	  LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
	   map.put(1, "Nidarsh");
	   map.put(2, "Adarsh");
	   map.put(3, "Sumalatha");
	   //initializing rowNo=0
	   int rowNo=0;
	   
	   for(Entry<Integer, String> m:map.entrySet()) {
		   Row Row = sheet.createRow(rowNo++);
		   //set 1 using Integer
		   Row.createCell(0).setCellValue((Integer)m.getKey());//1
		   //set Nidarsh using String
		   Row.createCell(1).setCellValue((String)m.getValue());//Nidarsh
	   }
	   FileOutputStream fos = new FileOutputStream("./src/test/resources/AdvanceSelenium.xlsx");  
			   book.write(fos);
	   		   book.close();
	}

}
