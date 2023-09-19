package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.CreateProductPage;
import POMrepository.HomePage;
import POMrepository.LoginPage;
import POMrepository.ProductValidationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/*Generic method and validation*/
public class CreateProductandDelete2 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//import from webdriver_utility
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		//wlib.implicityWait(driver);
		/*driver.manage().window().maximize();*/
//-------------------------------------------------------------------------------		
		//import from file_utility
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		
		driver.get(URL);
		//import from LoginPage
		LoginPage login = new LoginPage(driver);
		login.LoginToVtiger(USERNAME, PASSWORD);
		
	    
//	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	    driver.findElement(By.id("submitButton")).click();
//-----------------------------------------------------------------------------------------	
	    //import from homePage
	    HomePage home = new HomePage(driver);
	    home.productLink();
	    //xpath for product
		// driver.findElement(By.linkText("Products")).click();
	    
	    //import from CreateProductPage
	    CreateProductPage prod = new CreateProductPage(driver);
	    prod.ClickProdPlus();
	    //driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
//------------------------------------------------------------------------------------------	   
	  //from java_utility
	  	Java_Utility jlib = new Java_Utility();
	  	int ranNum = jlib.getRandomNum();
	    /*Random ran = new Random();
	    int ranNum = ran.nextInt(1000);*/
	   
	  //from Excel_utility
	  	Excel_Utility elib = new Excel_Utility();
	  	String prdName = elib.getExcelDataUsingDataFormatter1("Product", 0, 0)+ranNum;
	   /* FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
	    Workbook book = WorkbookFactory.create(fis1);
	    Sheet sheet = book.getSheet("Product");
	    Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	    String prdName = cell.getStringCellValue()+ranNum;*/
	  	
	  	prod.ProdNameField(prdName);
	    //driver.findElement(By.name("productname")).sendKeys(prdName);
	    Thread.sleep(2000);
//-------------------------------------------------------------------------------------------------
	    prod.SaveButton(driver);
	    //xpath for save button scroll down
	    //driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	  
	    home.productLink();
	    //again xpath for product
	    //driver.findElement(By.linkText("Products")).click();
//---------------------------------------------------------------------------------------------------
	    //import from ProductValidationPage
	    ProductValidationPage prodValid = new ProductValidationPage(driver);
	    prodValid.checkPrdName(driver, prdName);
	    Thread.sleep(3000);
	    //xpath for selecting checkbox
	    //driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prdName+"']/../preceding-sibling::td/input")).click();
	   
	    prodValid.deletePrdClick(driver, wlib);
	    //xpath for delete
	    //driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
//	    //alert popup import fron webdriver_utility
	    //wlib.switchToAlertAccept(driver);
//	    /*Alert alt = driver.switchTo().alert();
//	    alt.accept();*/
	     Thread.sleep(3000);
	   
	    //using validation for checking the product is present or not
	   List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
	   boolean flag=false;
	   
	   for(WebElement prdname:productList)
	   {
		   String actData = prdname.getText();
		   
		   if(actData.contains(prdName)) //dell
		   {
			   flag=true;
			   break;
		   }
	   }
	   if(flag)
	   {
		   System.out.println("product data is deleted");
	   }
	   else
	   {
		   System.out.println("product data not deleted");
	   }
//---------------------------------------------------------------------------------------------------	    
	   Thread.sleep(3000);
	   home.getAdministrator();
	   home.signout(driver);
	   //xpath for signout
	   //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	   //driver.findElement(By.linkText("Sign Out")).click();
		
	}

}
