package CampaignUsingProduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass1;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.CreateCamapaignsPage;
import POMrepository.CreateProductPage;
import POMrepository.HomePage;
import POMrepository.LoginPage;
import POMrepository.ProductWindowPage;

public class CreateCampaignwithProductTestNg extends BaseClass1{

	@Test(groups = {"smokeTest","regressionTest"})
	public void CreateCampaignwithProductTestNg() throws Throwable {
	
		//from file_utility
		File_Utility flib = new File_Utility();
//		WebDriver driver;
		
//		//import from file_utility
//		//File_Utility flib = new File_Utility();
//		String BROWSER = flib.getKeyAndValue("browser");
//		
//		if(BROWSER.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//		}
//		//default browser
//		else{
//			driver=new ChromeDriver();
//		}
//	
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
//	wlib.implicityWait(driver);
//--------------------------------------------------------------------------------		
//	String URL = flib.getKeyAndValue("url");
//	String USERNAME = flib.getKeyAndValue("username");
//	String PASSWORD = flib.getKeyAndValue("password");
//	
//	driver.get(URL);
//	//import from LoginPage
//	LoginPage login = new LoginPage(driver);
//	login.LoginToVtiger(USERNAME, PASSWORD);//line 32 and 33
//    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//    driver.findElement(By.id("submitButton")).click();
//----------------------------------------------------------------------------------
    //import from homePage
	HomePage home = new HomePage(driver);
	home.productLink();
	//xpath for product
	//driver.findElement(By.linkText("Products")).click();
	
	//import from CreateProductPage
	CreateProductPage prod = new CreateProductPage(driver);
	prod.ClickProdPlus();
	//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
//--------------------------------------------------------------------------------------------
	//from java_utility
	Java_Utility jlib = new Java_Utility();
	int ranNum = jlib.getRandomNum();
	
	//from Excel_utility
	Excel_Utility elib = new Excel_Utility();
	
	String prdName = elib.getExcelDataUsingDataFormatter1("Product", 0, 0)+ranNum;
	
	prod.ProdNameField(prdName);
    //driver.findElement(By.name("productname")).sendKeys(prdName);
    Thread.sleep(2000);
    prod.SaveButton(driver);
    //driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
//-------------------------------------------------------------------------------------------
 
   home.clickMoreLink(driver);
   home.clickCampLink();
   
   CreateCamapaignsPage campPage = new CreateCamapaignsPage(driver);
   campPage.clickCampPlus();
  //xpath for more
  //driver.findElement(By.linkText("More")).click();
  // driver.findElement(By.name("Campaigns")).click();
  //driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
//---------------------------------------------------------------------------------------------
	
//   //import from webdriver_utility
//	WebDriver_Utility wlib = new WebDriver_Utility();
  //import from ProductWindowPage
   ProductWindowPage prodWinPage = new ProductWindowPage(driver);
   prodWinPage.ClickOnSelectSign(driver, wlib);
  //xpath for img in camapaign module for product name
  //driver.findElement(By.xpath("//img[@title='Select']")).click();
    Thread.sleep(3000);
  //from webDriver_utility
  // wlib.SwitchingWindows(driver, "Products&action");
   
    prodWinPage.productName(prdName);
    //xpath for search bar
    //driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(prdName);
   
    prodWinPage.searchPrdData();
    Thread.sleep(3000);
    //xpath for search
    //driver.findElement(By.xpath("//input[@name='search']")).click();
    
    prodWinPage.selectProduct(driver, prdName, wlib);
    Thread.sleep(6000);
    //take product name Dynamic xpath means "+value+"
    //driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();//driver still focus on product window
    //from webDriver_utility//
    //wlib.SwitchingWindows(driver, "Campaigns&action");//
//------------------------------------------------------------------------------------------------------
    
    //fetching data to Campaign name text field
    String CmpName = elib.getExcelDataUsingDataFormatter1("Campaigns", 0, 0)+ranNum;
    
    //import from CreateCampaignPage
    campPage.campName(CmpName);
    //xpath for Campaign name
  	//driver.findElement(By.name("campaignname")).sendKeys(CmpName);
    Thread.sleep(2000);
//-----------------------------------------------------------------------------------------------------	  		
    //import from CreateCampaignPage
    campPage.saveButton();
    //xpath for save button
	//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	Thread.sleep(2000);
		
//-----------------------------------------------------------------------------------------------------
	//import from HomePage
	home.getAdministrator();
	//home.signout(driver);
	//xpath for signout
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	//driver.findElement(By.linkText("Sign Out")).click();

	}
}
