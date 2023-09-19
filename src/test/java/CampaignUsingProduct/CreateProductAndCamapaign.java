package CampaignUsingProduct;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductAndCamapaign {

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
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	   	Thread.sleep(2000);
	    
	    //xpath for more
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
	    driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Thread.sleep(2000);
		//fetching data to Campaign name text field
		FileInputStream fis2 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
		Workbook book1= WorkbookFactory.create(fis2);
		Sheet sheet1 = book1.getSheet("Campaigns");
		Row row1 = sheet1.getRow(0);
		Cell cell1 = row1.getCell(0);
		String CmpName1 = cell1.getStringCellValue()+ranNum;
		//xpath for Campaign name
		driver.findElement(By.name("campaignname")).sendKeys(CmpName1);
	    
		//xpath for img in camapaign module for product name
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		//window handle method
		String maindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		//product window
			for( String lv:allwindows) {
				driver.switchTo().window(lv);
			}	
		driver.findElement(By.id("search_txt")).sendKeys("Dell932");
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Dell932']")).click();
		
		//back to main window
		driver.switchTo().window(maindow);
		Thread.sleep(2000);
		
		//xpath for save button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		Thread.sleep(2000);
		
		 //xpath for signout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
