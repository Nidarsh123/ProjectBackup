package CampaignUsingProduct;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProduct {

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
	   	
	  //xpath for more
	    driver.findElement(By.linkText("More")).click();
	    driver.findElement(By.name("Campaigns")).click();
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	    
	  //xpath for img in camapaign module for product name
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	 
	   //window handle method
	    Set<String> allwindows = driver.getWindowHandles();
	   //iterator loop using for fetching data each window and taking the windows one by one randomly
	    Iterator<String> id = allwindows.iterator();
	    //hasnext->using check window present or not
	    while(id.hasNext()) {
	    	//next() using for start the action
	    	String win = id.next();
	    	driver.switchTo().window(win);
	    	String title = driver.getTitle();
	    	//System.out.println(title);
	    	
	    if(title.contains("Products&action")) {
	    	break;
	    	}
	    }
	    Thread.sleep(2000);
	    //xpath for search bar
	    driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(prdName);
	    //xpath for search
	    driver.findElement(By.xpath("//input[@name='search']")).click();
	    Thread.sleep(2000);
	    //take product name Dynamic xpath means "+value+"
	    driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();//driver still focus on product window
	    

		//window handle method
		Set<String> allwindows1 = driver.getWindowHandles();
	    //switch back to campaign page
	    Iterator<String> id1 = allwindows1.iterator();
	    while(id1.hasNext()) {
	    	String win1 = id1.next();
	    	driver.switchTo().window(win1);
	    	String title1 = driver.getTitle();
	    	
	    if(title1.contains("Campaigns&action")) {
	    	break;
	    	}
	    }
	    Thread.sleep(2000);
	  //fetching data to Campaign name text field
	  		FileInputStream fis2 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
	  		Workbook book2= WorkbookFactory.create(fis2);
	  		Sheet sheet2 = book2.getSheet("Campaigns");
	  		Row row2 = sheet2.getRow(0);
	  		Cell cell2 = row2.getCell(0);
	  		String CmpName = cell2.getStringCellValue()+ranNum;
	  		//xpath for Campaign name
	  		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(CmpName);
	  		
	  		//xpath for save button
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
			Thread.sleep(2000);
			
			 //xpath for signout
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
	    
	}

}
