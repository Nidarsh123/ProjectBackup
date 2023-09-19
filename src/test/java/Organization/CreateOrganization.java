package Organization;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Avoide duplicate means using Random for executing wipro many times(accountname accept manytimes)
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		//we can use excel for fetching many times accountname
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvanceSelenium7amto9.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String orgNam = cell.getStringCellValue()+ranNum;
		
		driver.findElement(By.name("accountname")).sendKeys(orgNam);
		
		driver.findElement(By.id("phone")).sendKeys("8722638845");
		driver.findElement(By.id("email1")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
			//xpath for image of user
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			//xpath for sign-out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
