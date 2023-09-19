package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductandDelete {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
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
	   
	    //invokes multiplewindows
	    multipleWindows(driver);
	}

	private static void multipleWindows(ChromeDriver driver) throws Throwable {
		//window handle method
				String maindow = driver.getWindowHandle();
				Set<String> allwindows = driver.getWindowHandles();
				//product window
					for( String lv:allwindows) {
						driver.switchTo().window(lv);
					  //close the window excluding main
					  if(!lv.equals(maindow)) {
						  driver.close();
					  }
					  Thread.sleep(2000);
					}
			    
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
			  //back to main window
				driver.switchTo().window(maindow);
				//path for product
				driver.findElement(By.linkText("Products")).click();
				//xpath for delete
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				//delete for selected product
				driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
				
				//switch control to the javascript popup
				Alert pop = driver.switchTo().alert();
				Thread.sleep(4000);
				//pop.accept();
				pop.dismiss();
				
				//xpath for signout
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				driver.findElement(By.linkText("Sign Out")).click();
	}
	


}
