package Product;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass1;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.CreateProductPage;
import POMrepository.HomePage;

public class ProductNg2 extends BaseClass1 {

	@Test(retryAnalyzer = Generic_Utilities.RetryAnalyserImplementation.class)
	public void ProductNg2() throws Throwable
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
//---------------------------------------------------------------------------------------------		
	    //xpath for product
		HomePage home = new HomePage(driver);
		home.productLink();
		
		CreateProductPage prod = new CreateProductPage(driver);
		prod.ClickProdPlus();
		Thread.sleep(3000);
//----------------------------------------------------------------------------------------------
		Java_Utility jlib = new Java_Utility();
	  	int ranNum = jlib.getRandomNum();
	    
	   Excel_Utility excel = new Excel_Utility();
	   String prodName = excel.getExcelDataUsingDataFormatter1("product", 0, 0)+ranNum;
	    
	   prod.ProdNameField(prodName);
	   
//	  Assert.assertEquals(false, true);//--------------------------------------------------add for Listener
	   
	    Thread.sleep(2000);
//------------------------------------------------------------------------------------------------------	    
	    prod.SaveButton(driver);

	}
}
