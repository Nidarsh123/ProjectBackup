package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ObjectArrays;

import Generic_Utilities.Excel_Utility;

public class DataProviderEx3 {
	
	@Test(dataProvider = "getData")
	public void bookTickets(String src,String dest)
	{
		System.out.println("book ticket from "+src+"to "+dest);
	}

	@DataProvider
	public Object[][] getData() throws Throwable
	{
		Excel_Utility elib = new Excel_Utility();
		//DataProvider is the SheetName
		Object[][] value = elib.readMultipleData("DataProvider");
		return value;
	}
}
