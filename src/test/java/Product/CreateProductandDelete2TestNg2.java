package Product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass1;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.CreateProductPage;
import POMrepository.DeleteProductPage;
import POMrepository.HomePage;
import POMrepository.ProductValidationPage;

public class CreateProductandDelete2TestNg2 extends BaseClass1 {

	@Test
	public void CreateProductandDelete2TestNg2() throws Throwable
	{
	//import from webdriver_utility
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.maximizeWindow(driver);
	//wlib.implicityWait(driver);
//-----------------------------------------------------------------------------------------
//driver.get(URL);
//-----------------------------------------------------------------------------------------	
    //import from homePage
    HomePage home = new HomePage(driver);
    home.productLink();
    
    //import from CreateProductPage
    CreateProductPage prod = new CreateProductPage(driver);
    prod.ClickProdPlus();
//------------------------------------------------------------------------------------------	   
  //from java_utility
  	Java_Utility jlib = new Java_Utility();
  	int ranNum = jlib.getRandomNum();
   
  //from Excel_utility
  	Excel_Utility elib = new Excel_Utility();
  	String prdName = elib.getExcelDataUsingDataFormatter1("Product", 0, 0)+ranNum;
  	
  	prod.ProdNameField(prdName);
    Thread.sleep(2000);
//-------------------------------------------------------------------------------------------------
    prod.SaveButton(driver);
  
    home.productLink();
    Thread.sleep(3000);
//---------------------------------------------------------------------------------------------------
    //import from ProductValidationPage
    ProductValidationPage prodValid = new ProductValidationPage(driver);
    prodValid.checkPrdName(driver, prdName);
    Thread.sleep(3000);

    prodValid.deletePrdClick(driver, wlib);
     Thread.sleep(3000);
   
    //using validation for checking the product is present or not
     DeleteProductPage Dpage = new DeleteProductPage(driver);
     Dpage.validateProduct(driver, prdName);
     
//   List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
//   boolean flag=false;
//   
//   for(WebElement prdname:productList)
//   {
//	   String actData = prdname.getText();
//	   
//	   if(actData.contains(prdName)) //dell
//	   {
//		   flag=true;
//		   break;
//	   }
//   }
//   if(flag)
//   {
//	   System.out.println("product data is deleted");
//   }
//   else
//   {
//	   System.out.println("product data not deleted");
//   }
//---------------------------------------------------------------------------------------------------	    
   Thread.sleep(3000);
   home.getAdministrator();
   
  // home.signout(driver);
 
	}
}
