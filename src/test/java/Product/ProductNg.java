package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass1;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.CreateProductPage;
import POMrepository.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(Generic_Utilities.ListenerImplementation1.class)
public class ProductNg extends BaseClass1 {

	@Test(groups = "smokeTest")
	public void ProductNg() throws Throwable {
//		WebDriver driver = null;
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
//		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSelCommData.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//	    String URL = pro.getProperty("url");
//	    String USERNAME = pro.getProperty("username");
//	    String PASSWORD = pro.getProperty("password");
//	    	driver.get(URL);
//	    	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	    	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	    	driver.findElement(By.id("submitButton")).click();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
//---------------------------------------------------------------------------------------------		
	    //xpath for product
		HomePage home = new HomePage(driver);
		home.productLink();
//	    driver.findElement(By.linkText("Products")).click();
		CreateProductPage prod = new CreateProductPage(driver);
		prod.ClickProdPlus();
		Thread.sleep(3000);
	   // driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
//----------------------------------------------------------------------------------------------
//	    Random ran = new Random();
//	    int ranNum = ran.nextInt(1000);
		Java_Utility jlib = new Java_Utility();
	  	int ranNum = jlib.getRandomNum();
	    
	   Excel_Utility excel = new Excel_Utility();
	   String prodName = excel.getExcelDataUsingDataFormatter1("product", 0, 0)+ranNum;
	    
//	    FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
//	    Workbook book = WorkbookFactory.create(fis1);
//	    Sheet sheet = book.getSheet("Product");
//	    Row row = sheet.getRow(0);
//	    Cell cell = row.getCell(0);
//	    String prdName = cell.getStringCellValue()+ranNum;
//	    driver.findElement(By.name("productname")).sendKeys(prodName);
	   prod.ProdNameField(prodName);
	   
	  // Assert.assertEquals(false, true);//--------------------------------------------------add for Listener
	   
	    Thread.sleep(2000);
//------------------------------------------------------------------------------------------------------	    
//	    //xpath for save button scroll down
//	    WebElement element = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
//	    //create action class object
//	   Actions act = new Actions(driver);
//	   act.moveToElement(element).perform();
//	   element.click();
	    prod.SaveButton(driver);
	   
//	   //xpath for signout
//	   WebElement element2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//	   //using Action class
//	   act.moveToElement(element2).click().perform();
//	   driver.findElement(By.linkText("Sign Out")).click();
	    
//	    home.signout(driver);
	}
}
