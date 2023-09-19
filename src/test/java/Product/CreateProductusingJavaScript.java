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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductusingJavaScript {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSelCommData.properties");
		Properties pro = new Properties();
		pro.load(fis);
	    String URL = pro.getProperty("url");
	    String USERNAME = pro.getProperty("username");
	    String PASSWORD = pro.getProperty("password");
	    	driver.get(URL);
	    	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    	driver.findElement(By.id("submitButton")).click();
	    //xpath for product
	    driver.findElement(By.linkText("Products")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	    
	    Random ran = new Random();
	    int ranNum = ran.nextInt(1000);
	    
	    FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
	    Workbook book = WorkbookFactory.create(fis1);
	    Sheet sheet = book.getSheet("Product");
	    Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	    String prdName = cell.getStringCellValue()+ranNum;
	    driver.findElement(By.name("productname")).sendKeys(prdName);
	    Thread.sleep(2000);
	    
	    //xpath for save button scroll down
	    WebElement SaveButton = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
	   
	    //import from WebDriver_utility
	   	WebDriver_Utility wlib = new WebDriver_Utility();
	   	wlib.scrollPage(driver, SaveButton);
	   	
	   	/*Rectangle rect = SaveButton.getRect();
	    //run it and we get x and y Rectangle
	    System.out.println(rect.getX());//436
	    System.out.println(rect.getY());//1156
	     
	    //create javascriptExecutor upcasting
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    //0-horizontal bar 1156-vertical tool bar
	    js.executeScript("window.scrollBy(0,1156)");*/
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	    
	    //xpath for signout
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	    driver.findElement(By.linkText("Sign Out")).click();
	}

}
