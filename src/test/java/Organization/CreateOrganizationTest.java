package Organization;

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

import com.fasterxml.jackson.core.sym.Name;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//launching the application and fetching qtiger data using AdvSelCommData.properties
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
		//click organization module
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	//avoiding duplicates using in mandatory field
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
				//Organization field filling using excel
		FileInputStream fis2 = new FileInputStream("./src/test/resources/OrganizationExcel.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		 Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String OrgName = cell.getStringCellValue()+ranNum;
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		Thread.sleep(2000);
		
				//for phn number field
		//FileInputStream fis3 = new FileInputStream("./src/test/resources/OrganizationExcel.xlsx");
		//Workbook book1 = WorkbookFactory.create(fis3);
		//Sheet sheet1 = book1.getSheet("Organization");
		Row row1 = sheet.getRow(1);
		Cell cell2 = row1.getCell(0);
		DataFormatter format = new DataFormatter();
		String OrgNum = format.formatCellValue(cell2);
		driver.findElement(By.id("phone")).sendKeys(OrgNum);
		Thread.sleep(2000);
				
				//for email field
		Row row2 = sheet.getRow(2);
		Cell cell3 = row2.getCell(0);
		//String OrgEmail = cell3.getStringCellValue(); OR
		String OrgEmail = format.formatCellValue(cell3);
		driver.findElement(By.id("email1")).sendKeys(OrgEmail);
		Thread.sleep(2000);
			//xpath for save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		//xpath for image for signout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//create action method object
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
		//xpath for signout
		driver.findElement(By.linkText("Sign Out")).click();
								//OR
		//xpath for image of user
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//xpath for sign-out
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
