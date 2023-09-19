package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEX1 {
	
	@Test(dataProvider = "dataProviderExecute")
	public void bookTicket(String src,String dest)
	{
		System.out.println("book ticket from "+src+" to "+dest);
	}

	@DataProvider
	public Object[][] dataProviderExecute()
	{
		//[3] row, [2] column
		Object[][] objarr = new Object[3][2];
		
		//col.initial 0, row.initial 0
		objarr[0][0]="Bangalore";
		objarr[0][1]="Mumbai";
		
		objarr[1][0]="Bangalore";
		objarr[1][1]="Goa";
		
		objarr[2][0]="Bangalore";
		objarr[2][1]="Mysore";
		
		return objarr;
	}
}
