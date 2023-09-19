package More_Campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaigns1 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		
//		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSelCommData.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//xpath for more
		WebElement moreElement = driver.findElement(By.linkText("More"));
		//action class
		WebDriver_Utility wlib = new WebDriver_Utility();
		Actions act = wlib.Actions(driver);
		act.moveToElement(moreElement).click().perform();
		//xpath for campaigne
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		Thread.sleep(1000);
		
		//fetching data to Campaign name text field	
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
//		FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
//		Workbook book= WorkbookFactory.create(fis1);
//		Sheet sheet = book.getSheet("Campaigns");
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		String CmpName = cell.getStringCellValue()+ranNum;
		//xpath for Campaign name
		Excel_Utility elib = new Excel_Utility();
		String CmpName = elib.getExcelData1("Campaigns", 0, 0)+ranNum;
		driver.findElement(By.name("campaignname")).sendKeys(CmpName);
		Thread.sleep(2000);
		
		//fetching data to Budget cost text field
//		Row row2 = sheet.getRow(1);
//		Cell cell2 = row2.getCell(0);
//		DataFormatter formate= new DataFormatter();
//		String BudCost = formate.formatCellValue(cell2);
//		//xpath for Budget Cost
		String BudCost = elib.getExcelDataUsingDataFormatter1("Campaigns", 1, 0);
		driver.findElement(By.name("budgetcost")).sendKeys(BudCost);
		Thread.sleep(2000);
		
		//xpath for save button
		 WebElement element = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
		//action class
		 act.moveToElement(element).perform();
		element.click();
		Thread.sleep(3000);
		
		//xpath for image of signout
		 WebElement element2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(element2).click().perform();
		//xpath for sign out
		driver.findElement(By.linkText("Sign Out")).click();
		
	}

}
