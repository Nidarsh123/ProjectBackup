package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import javax.swing.ActionMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct {

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
	    WebElement element = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
	    //create action class object
	   Actions act = new Actions(driver);
	   act.moveToElement(element).perform();
	   element.click();
	   
	   //xpath for signout
	   WebElement element2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	   //using Action class
	   act.moveToElement(element2).click().perform();
	   driver.findElement(By.linkText("Sign Out")).click();
	   
	}

}
