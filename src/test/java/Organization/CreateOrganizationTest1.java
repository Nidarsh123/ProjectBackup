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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

/*program for CreateOrganization using generic utility AND Launching multiple browser*/
public class CreateOrganizationTest1 {

	public static void main(String[] args) throws Throwable {
	
	WebDriver driver;
	
	//import from file_utility
	File_Utility flib = new File_Utility();
	String BROWSER = flib.getKeyAndValue("browser");
	
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	//default browser
	else{
		driver=new ChromeDriver();
	}
	
	//import from file_utility
	driver.manage().window().maximize();
	
	String URL = flib.getKeyAndValue("url");
	String USERNMAE = flib.getKeyAndValue("username");
	String PASSWORD = flib.getKeyAndValue("password");
		
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNMAE);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	//click organization module
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
	/*Create java_utility Object*/
	Java_Utility jlib=new Java_Utility();
	int ranNum = jlib.getRandomNum();
		
		//Organization field filling using excel
		//FileInputStream fis2 = new FileInputStream("./src/test/resources/OrganizationExcel.xlsx");
		//Workbook book = WorkbookFactory.create(fis2);
		// Sheet sheet = book.getSheet("Organization");
		//Row row = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		//String OrgName = cell.getStringCellValue()+ranNum;
	/*Create Excel_utility Object*/
	Excel_Utility elib=new Excel_Utility();
	//String OrgName = elib.getExcelData("Organization", 0, 0)+ranNum; OR
	String OrgName = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
	driver.findElement(By.name("accountname")).sendKeys(OrgName);
	Thread.sleep(2000);
		
		/*Row row1 = sheet.getRow(1);
		Cell cell2 = row1.getCell(0);
		DataFormatter format = new DataFormatter();
		String OrgNum = format.formatCellValue(cell2);*/
	/*we use excel object for phn number field*/
	String OrgNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
	driver.findElement(By.id("phone")).sendKeys(OrgNum);
	Thread.sleep(3000);
				
		//for email field
		/*Row row2 = sheet.getRow(2);
		Cell cell3 = row2.getCell(0);
		//String OrgEmail = cell3.getStringCellValue(); OR
		String OrgEmail = format.formatCellValue(cell3);*/
	String OrgEmail = elib.getExcelData("Organization", 2, 0);
	driver.findElement(By.id("email1")).sendKeys(OrgEmail);
	Thread.sleep(3000);
		//xpath for save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(3000);
		
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
