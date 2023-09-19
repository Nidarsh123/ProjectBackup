package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.CreateProductPage;
import POMrepository.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductUsingPOM {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//import from webdriver_utility
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		//wlib.implicityWait(driver);
//---------------------------------------------------------------------------------------------------		
		//import from File_Utility
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		/*FileInputStream fis = new FileInputStream("./src/test/resources/AdvSelCommData.properties");
		Properties pro = new Properties();
		pro.load(fis);
	    String URL = pro.getProperty("url");
	    String USERNAME = pro.getProperty("username");
	    String PASSWORD = pro.getProperty("password");*/
	    driver.get(URL);
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
//----------------------------------------------------------------------------------------------------------
	    //import from HomePage
	    HomePage home = new HomePage(driver);
	    home.productLink();
	    //xpath for product
	    //driver.findElement(By.linkText("Products")).click();
	    //import from productPage
	    CreateProductPage prod = new CreateProductPage(driver);
	    prod.ClickProdPlus();
	    //driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
//-----------------------------------------------------------------------------------------------------------	    
	    Random ran = new Random();
	    int ranNum = ran.nextInt(1000);
	    
	   /* FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
	    Workbook book = WorkbookFactory.create(fis1);
	    Sheet sheet = book.getSheet("Product");
	    Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	    String prdName = cell.getStringCellValue()+ranNum;*/
	    
	    //import from Excel_Utility
	    Excel_Utility elib = new Excel_Utility();
	    String PrdtName = elib.getExcelData1("Product", 0, 0)+ranNum;
	    
	    //driver.findElement(By.name("productname")).sendKeys(prdName);
	    prod.ProdNameField(PrdtName);
	    Thread.sleep(2000);
//--------------------------------------------------------------------------------------------------------------	    
	    //xpath for save button scroll down
	    //WebElement element = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
	    prod.SaveButton(driver);
	   
	    //import from HomePage
	    home.getAdministrator();
	    //WebElement element2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    
	    //driver.findElement(By.linkText("Sign Out")).click();
	    home.signout(driver);
	}

}
