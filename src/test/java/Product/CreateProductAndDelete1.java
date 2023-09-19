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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductAndDelete1 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
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
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	    Thread.sleep(3000);
	    //again xpath for product
	    driver.findElement(By.linkText("Products")).click();
	    Thread.sleep(3000);
	    
	    //xpath for selecting checkbox
	    driver.findElement(By.xpath("//table[@class='lvt small']//tr//td//a[text()='"+prdName+"']/../preceding-sibling::td/input")).click();
	    //xpath for delete
	    driver.findElement(By.xpath("//input[@value='Delete']")).click();
	    
	    //alert popup
	    Alert alt = driver.switchTo().alert();
	    alt.accept();
	    
	    Thread.sleep(2000);
	    //xpath for signout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
