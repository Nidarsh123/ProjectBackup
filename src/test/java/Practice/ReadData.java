package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//program for ReadData from xcel using map
public class ReadData {

	public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/Myexcel.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	Sheet sheet = book.getSheet("Sheet1");
	int rows = sheet.getLastRowNum();
	System.out.println(rows);
	
	LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
	//LinkedHashMap<String, String> map1 = new LinkedHashMap<String, String>();

	for(int i = 0;i<=rows;i++) {
		//cast and we using Integer so we can use getNumericValue
		Integer key = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
		String value = sheet.getRow(i).getCell(1).toString();
		map.put(key, value);
		}
	//for printing using for each LOOP
	for(Entry<Integer, String> m:map.entrySet()) {
		System.out.println(m.getKey()+" "+m.getValue());
		}
	}

}
