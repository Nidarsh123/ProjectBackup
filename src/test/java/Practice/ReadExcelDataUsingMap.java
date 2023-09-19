package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;

import org.apache.poi.poifs.filesystem.EntryUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Multiset.Entry;

import net.bytebuddy.build.EntryPoint;

//program for read data from excel only 2(key, value)data in excel 
public class ReadExcelDataUsingMap {

	public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/AdvanceSelenium.xlsx");
    Workbook book = WorkbookFactory.create(fis);
    Sheet sheet = book.getSheet("Sheet3");
    int rows = sheet.getLastRowNum();
    
  LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
    
    //foe each loop
    for(int i=0;i<rows;i++) {
    	String key = sheet.getRow(i).getCell(0).toString();
    	String value = sheet.getRow(i).getCell(1).toString();
    	map.put(key, value);
    	}
    
	for(java.util.Map.Entry<String, String> m:map.entrySet()) {
		System.out.println(m.getKey()+" "+m.getValue());
		
	}
    
	}

}
