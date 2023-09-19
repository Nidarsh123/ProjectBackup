package CampaignUsingProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.CreateCamapaignsPage;
import POMrepository.CreateProductPage;
import POMrepository.HomePage;
import POMrepository.LoginPage;
import POMrepository.ProductWindowPage;
import io.github.bonigarcia.wdm.WebDriverManager;

//Using POM
public class CreateCampaignWithProduct1UsingPOM {

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
//--------------------------------------------------------------------------------		
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		
		driver.get(URL);
		//import from LoginPage
		LoginPage login = new LoginPage(driver);
		login.LoginToVtiger(USERNAME, PASSWORD);//line 32 and 33
//	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	    driver.findElement(By.id("submitButton")).click();
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
		
		int ranNum = jlib.getRandomNum();
		
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
	   Thread.sleep(3000);
	  //xpath for more
	  //driver.findElement(By.linkText("More")).click();
	  // driver.findElement(By.name("Campaigns")).click();
	  //driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
//---------------------------------------------------------------------------------------------
	  
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
	    //take product name Dynamic xpath means "+value+"
	    //driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();//driver still focus on product window
	    //from webDriver_utility//
	    //wlib.SwitchingWindows(driver, "Campaigns&action");//
//------------------------------------------------------------------------------------------------------
	    Thread.sleep(3000);
	    //fetching data to Campaign name text field
	    String CmpName = elib.getExcelDataUsingDataFormatter1("Campaigns", 0, 0)+ranNum;
	    
	    //import from CreateCampaignPage
	    campPage.campName(CmpName);
	    //xpath for Campaign name
	  	//driver.findElement(By.name("campaignname")).sendKeys(CmpName);
	    Thread.sleep(3000);
//-----------------------------------------------------------------------------------------------------	  		
	    //import from CreateCampaignPage
	    campPage.saveButton();
	    //xpath for save button
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		Thread.sleep(3000);
			
//-----------------------------------------------------------------------------------------------------
		//import from HomePage
		home.getAdministrator();
		home.signout(driver);
		//xpath for signout
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();

	}

}
