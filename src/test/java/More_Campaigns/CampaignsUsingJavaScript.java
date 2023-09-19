package More_Campaigns;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignsUsingJavaScript {

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
		
		//xpath for more
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")); or
		driver.findElement(By.linkText("More")).click();
		//xpath for campaigne
		driver.findElement(By.name("Campaigns")).click();
		//xpath for-> "+" and driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click(); or
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		//fetching data to Campaign name text field
		FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
		Workbook book= WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("Campaigns");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String CmpName = cell.getStringCellValue()+ranNum;
		//xpath for Campaign name
		driver.findElement(By.name("campaignname")).sendKeys(CmpName);
		
		//xpath for save button
		WebElement saveButton = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
		Rectangle rect = saveButton.getRect();
		//run it and we get x and y Rectangle
		System.out.println(rect.getX());//602
		System.out.println(rect.getY());//743
		
		 //create javascriptExecutor upcasting
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    //0-horizontal bar 743-vertical tool bar
	    js.executeScript("window.scrollBy(0,743)");
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		Thread.sleep(2000);
		//xpath for image of signout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//xpath for sign out
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
