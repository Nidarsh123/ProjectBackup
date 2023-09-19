package More_Campaigns;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass1;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.CreateCamapaignsPage;
import POMrepository.CreateOrganizationPage;
import POMrepository.CreateProductPage;
import POMrepository.HomePage;

public class CreateCampaignTestNg1 extends BaseClass1 {

	@Test(groups = {"smokeTest","regressionTest"})
	public void CreateCampaignTestNg1() throws Throwable {
//		WebDriver driver;
//		
//		//import from file_utility
//		File_Utility flib = new File_Utility();
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
	//impport from webdriver_utililty
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.maximizeWindow(driver);
	//driver.manage().window().maximize();
	//wlib.implicityWait(driver);
//------------------------------------------------------------------------------------------------		
//	File_Utility flib = new File_Utility();
//	String URL = flib.getKeyAndValue("url");
//	String USERNAME = flib.getKeyAndValue("username");
//	String PASSWORD = flib.getKeyAndValue("password");
	
//	FileInputStream fis = new FileInputStream("./src/test/resources/AdvSelCommData.properties");
//	Properties pro = new Properties();
//	pro.load(fis);
//	String URL = pro.getProperty("url");
//	String USERNAME = pro.getProperty("username");
//	String PASSWORD = pro.getProperty("password");
//driver.get(URL);
	//import from LoginPage
//LoginPage login = new LoginPage(driver);
//login.LoginToVtiger(USERNAME, PASSWORD);
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
//------------------------------------------------------------------------------------------------------------		
	//import from Homeage(POM)
	HomePage home = new HomePage(driver);
	home.clickMoreLink(driver);
	//xpath for more
	//WebElement moreElement = driver.findElement(By.linkText("More"));
	
	//shome.clickCampLink();
	//xpath for campaigne
	//driver.findElement(By.name("Campaigns")).click();
	
	CreateCamapaignsPage cmpPage = new CreateCamapaignsPage(driver);
	cmpPage.clickCampPlus();
	
	//Assert.assertEquals(false, true);//-----------------------------------------------for LISTENER
	
	//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	Thread.sleep(1000);
//----------------------------------------------------------------------------------------------------------------		
	//fetching data to Campaign name text field	
	Java_Utility jlib = new Java_Utility();
	int ranNum = jlib.getRandomNum();
	
//	FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
//	Workbook book= WorkbookFactory.create(fis1);
//	Sheet sheet = book.getSheet("Campaigns");
//	Row row = sheet.getRow(0);
//	Cell cell = row.getCell(0);
//	String CmpName = cell.getStringCellValue()+ranNum;
	//xpath for Campaign name
	Excel_Utility elib = new Excel_Utility();
	String CmpName = elib.getExcelData1("Campaigns", 0, 0)+ranNum;
	
	//driver.findElement(By.name("campaignname")).sendKeys(CmpName);
	Thread.sleep(2000);
	
	//fetching data to Budget cost text field
//	Row row2 = sheet.getRow(1);
//	Cell cell2 = row2.getCell(0);
//	DataFormatter formate= new DataFormatter();
//	String BudCost = formate.formatCellValue(cell2);
//	//xpath for Budget Cost
	String BudCost = elib.getExcelDataUsingDataFormatter1("Campaigns", 1, 0);
	//driver.findElement(By.name("budgetcost")).sendKeys(BudCost);
	
	//import from createCampaignsPage(POM)
	cmpPage.campField(CmpName, BudCost);
	Thread.sleep(2000);
//--------------------------------------------------------------------------------------------------------------		
	//xpath for save button
	// WebElement element = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
	cmpPage.saveButton();
	Thread.sleep(3000);
//-------------------------------------------------------------------------------------------------------------	
	//validation of Campaign name
	String Actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	if(Actdata.contains(CmpName)) {
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	Thread.sleep(2000);
//-------------------------------------------------------------------------------------------------------------
	//xpath for image of signout
	// WebElement element2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	//import from homePage
	home.getAdministrator();

	//xpath for sign out
	//driver.findElement(By.linkText("Sign Out")).click();
	//home.signout(driver);
	}
//===================================================================================================================
	@Test(groups = "regressionTest")
	public void CreateOrganizationTestNg() throws Throwable {
//	WebDriver driver;
//	
//	//import from file_utility
//	File_Utility flib = new File_Utility();
//	String BROWSER = flib.getKeyAndValue("browser");
//	
//	if(BROWSER.equalsIgnoreCase("chrome")) {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//	}
//	else if(BROWSER.equalsIgnoreCase("firefox")) {
//		WebDriverManager.firefoxdriver().setup();
//		driver=new FirefoxDriver();
//	}
//	else if(BROWSER.equalsIgnoreCase("edge")) {
//		WebDriverManager.edgedriver().setup();
//		driver=new EdgeDriver();
//	}
//	//default browser
//	else{
//		driver=new ChromeDriver();
//	}
	
	//import from WebDriver_Utility
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.maximizeWindow(driver);
	//wlib.implicityWait(driver);
//---------------------------------------------------------------------------------------------------
//	File_Utility flib = new File_Utility();
//	String URL = flib.getKeyAndValue("url");
//	String USERNMAE = flib.getKeyAndValue("username");
//	String PASSWORD = flib.getKeyAndValue("password");
////		
//	driver.get(URL);
//	
//	//create object of POM LoginPage
//	LoginPage login = new LoginPage(driver);
//	//calling the getter method
////	login.getUserTextField().sendKeys(USERNMAE);
////	login.getPasswordTextField().sendKeys(PASSWORD);
////	login.getLoginButton().click();
//	
//	//calling using Business Logics
//	login.LoginToVtiger(USERNMAE, PASSWORD);
//	driver.findElement(By.name("user_name")).sendKeys(USERNMAE);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
//-------------------------------------------------------------------------------------------------------------	

	//calling from HomePage
	HomePage home = new HomePage(driver);
	home.OrganizationLink();
	//driver.findElement(By.linkText("Organizations")).click();
//----------------------------------------------------------------------------------------------------------------
	Thread.sleep(2000);
	//calling from CreateOrganizationPage
	CreateOrganizationPage org = new CreateOrganizationPage(driver);
	org.clickOrgPlus();
	
	//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
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
	//xpath for accountname
	//driver.findElement(By.name("accountname")).sendKeys(OrgName);
	Thread.sleep(2000);
		
	/*Row row1 = sheet.getRow(1);
	Cell cell2 = row1.getCell(0);
	DataFormatter format = new DataFormatter();
	String OrgNum = format.formatCellValue(cell2);*/
	/*we use excel object for phn number field*/
	String OrgNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
	//driver.findElement(By.id("phone")).sendKeys(OrgNum);
	Thread.sleep(2000);
				
	//for email field
	/*Row row2 = sheet.getRow(2);
	Cell cell3 = row2.getCell(0);
	//String OrgEmail = cell3.getStringCellValue(); OR
	String OrgEmail = format.formatCellValue(cell3);*/
	String OrgEmail = elib.getExcelData("Organization", 2, 0);
	//driver.findElement(By.id("email1")).sendKeys(OrgEmail);
	Thread.sleep(2000);
	
	//calling from CreateOrganizationPage
	org.OrganizationField(OrgName, OrgNum, OrgEmail);
//------------------------------------------------------------------------------------------------------------------
	//xpath for save
	//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	//import from CreateOrganizationPage
	org.saveButton(driver);
	
	Thread.sleep(3000);
//------------------------------------------------------------------------------------------------------------------		
	//xpath for image for Adminstrator(signout)
	//WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	//import from HomePage
	home.getAdministrator();
	Thread.sleep(3000);
//------------------------------------------------------------------------------------------------------------------		
	//import from HomePage
	//home.signout(driver);
	//create action method object
	//Actions act = new Actions(driver);
	//act.moveToElement(element).click().perform();
	//xpath for signout
	//driver.findElement(By.linkText("Sign Out")).click();
								//OR
		//xpath for image of user
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//xpath for sign-out
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}
//==================================================================================================================
	@Test(groups = "smokeTest")
	public void ProductNg() throws Throwable {
//		WebDriver driver = null;
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
//		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSelCommData.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//	    String URL = pro.getProperty("url");
//	    String USERNAME = pro.getProperty("username");
//	    String PASSWORD = pro.getProperty("password");
//	    	driver.get(URL);
//	    	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	    	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	    	driver.findElement(By.id("submitButton")).click();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
//---------------------------------------------------------------------------------------------		
	    //xpath for product
		HomePage home = new HomePage(driver);
		home.productLink();
//	    driver.findElement(By.linkText("Products")).click();
		CreateProductPage prod = new CreateProductPage(driver);
		prod.ClickProdPlus();
		Thread.sleep(3000);
	   // driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
//----------------------------------------------------------------------------------------------
//	    Random ran = new Random();
//	    int ranNum = ran.nextInt(1000);
		Java_Utility jlib = new Java_Utility();
	  	int ranNum = jlib.getRandomNum();
	    
	   Excel_Utility excel = new Excel_Utility();
	   String prodName = excel.getExcelDataUsingDataFormatter1("product", 0, 0)+ranNum;
	    
//	    FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
//	    Workbook book = WorkbookFactory.create(fis1);
//	    Sheet sheet = book.getSheet("Product");
//	    Row row = sheet.getRow(0);
//	    Cell cell = row.getCell(0);
//	    String prdName = cell.getStringCellValue()+ranNum;
//	    driver.findElement(By.name("productname")).sendKeys(prodName);
	   prod.ProdNameField(prodName);
	    Thread.sleep(2000);
//------------------------------------------------------------------------------------------------------	    
//	    //xpath for save button scroll down
//	    WebElement element = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
//	    //create action class object
//	   Actions act = new Actions(driver);
//	   act.moveToElement(element).perform();
//	   element.click();
	    prod.SaveButton(driver);
	   
//	   //xpath for signout
//	   WebElement element2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//	   //using Action class
//	   act.moveToElement(element2).click().perform();
//	   driver.findElement(By.linkText("Sign Out")).click();
	    
//	    home.signout(driver);
	}
}
