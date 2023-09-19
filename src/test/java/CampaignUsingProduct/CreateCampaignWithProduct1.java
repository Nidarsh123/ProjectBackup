package CampaignUsingProduct;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProduct1 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//import from webdriver_utility
		WebDriver_Utility wlib = new WebDriver_Utility();
		//from Excel_utility
		Excel_Utility elib = new Excel_Utility();
		//import from file_utility
		File_Utility flib = new File_Utility();
		//from java_utility
		Java_Utility jlib = new Java_Utility();
		
		wlib.maximizeWindow(driver);
		//wlib.implicityWait(driver);
		
		
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
	   
	    driver.get(URL);
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    //xpath for product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		
		int ranNum = jlib.getRandomNum();
		
		
		String prdName = elib.getExcelDataUsingDataFormatter1("Product", 0, 0)+ranNum;
		
	    driver.findElement(By.name("productname")).sendKeys(prdName);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	   	
	  //xpath for more
	    driver.findElement(By.linkText("More")).click();
	    driver.findElement(By.name("Campaigns")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	    
	  //xpath for img in camapaign module for product name
	    driver.findElement(By.xpath("//img[@title='Select']")).click();
	    Thread.sleep(2000);
	  
	  //from webDriver_utility
	    wlib.SwitchingWindows(driver, "Products&action");
	    Thread.sleep(2000);
	    
	    //xpath for search bar
	    driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(prdName);
	    //xpath for search
	    driver.findElement(By.xpath("//input[@name='search']")).click();
	    //take product name Dynamic xpath means "+value+"
	    driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();//driver still focus on product window
	    
	    //from webDriver_utility
	    wlib.SwitchingWindows(driver, "Campaigns&action");
	    
	    //fetching data to Campaign name text field
	    String CmpName = elib.getExcelDataUsingDataFormatter1("Campaigns", 0, 0)+ranNum;
	    
	    //xpath for Campaign name
	  	driver.findElement(By.name("campaignname")).sendKeys(CmpName);
	  		
	  	//xpath for save button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		Thread.sleep(2000);
			
		//xpath for signout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
