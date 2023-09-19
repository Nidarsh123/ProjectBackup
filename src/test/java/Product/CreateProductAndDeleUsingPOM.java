package Product;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.CreateProductPage;
import POMrepository.HomePage;
import POMrepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductAndDeleUsingPOM {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//import from webdriver_utility
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		//wlib.implicityWait(driver);
		/*driver.manage().window().maximize();*/
		
		//import from file_utility
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		
	    driver.get(URL);
	  //create object of POM LoginPage
	  	LoginPage login = new LoginPage(driver);
	  //calling business logic of LoginPage
	  	login.LoginToVtiger(USERNAME, PASSWORD);
//	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	    driver.findElement(By.id("submitButton")).click();
//----------------------------------------------------------------------------------------------------	
	  //create object of POM HomePage
	  	HomePage Home = new HomePage(driver);
	  	Home.productLink();
	  //  driver.findElement(By.linkText("Products")).click();
	  	
	  //import from CreateProductPage
	  	CreateProductPage prodPage = new CreateProductPage(driver);
	  	prodPage.ClickProdPlus();
	  //  driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
//----------------------------------------------------------------------------------------------------------	  	
	   
	  //from java_utility
	  	Java_Utility jlib = new Java_Utility();
	  	int ranNum = jlib.getRandomNum();
	    /*Random ran = new Random();
	    int ranNum = ran.nextInt(1000);*/
	   
	  //from Excel_utility
	  	Excel_Utility elib = new Excel_Utility();
	  	String prdName2 = elib.getExcelDataUsingDataFormatter1("Product", 0, 0)+ranNum;
	   /* FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
	    Workbook book = WorkbookFactory.create(fis1);
	    Sheet sheet = book.getSheet("Product");
	    Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	    String prdName = cell.getStringCellValue()+ranNum;*/
	    //driver.findElement(By.name("productname")).sendKeys(prdName);
	  	prodPage.ProdNameField(prdName2);
	    Thread.sleep(2000);
 //-----------------------------------------------------------------------------------------
	    prodPage.SaveButton(driver);
	    //xpath for save button scroll down
	    //driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
//--------------------------------------------------------------------------------------------------	   
	    //again xpath for product using POM
	    Home.productLink();
	   // driver.findElement(By.linkText("Products")).click();
	   
	   
	    //xpath for selecting checkbox
	    driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prdName2+"']/../preceding-sibling::td/input")).click();
	    //xpath for delete
	    driver.findElement(By.xpath("//input[@value='Delete']")).click();
	    
	    //alert popup import fron webdriver_utility
	    wlib.switchToAlertAccept(driver);
	    /*Alert alt = driver.switchTo().alert();
	    alt.accept();*/
//----------------------------------------------------------------------------------------------------    
	    Thread.sleep(2000);
	    //xpath for signout
	    //import from HomePage
	    Home.getAdministrator().click();
	    Home.signout(driver);
	 
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();

	}

}
