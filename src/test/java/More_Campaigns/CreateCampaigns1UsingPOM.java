package More_Campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.CreateCamapaignsPage;
import POMrepository.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

//POM and Validation
public class CreateCampaigns1UsingPOM {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//impport from webdriver_utililty
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		//driver.manage().window().maximize();
		//wlib.implicityWait(driver);
//------------------------------------------------------------------------------------------------		
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		
//		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSelCommData.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
//------------------------------------------------------------------------------------------------------------		
		//import from Homeage(POM)
		HomePage home = new HomePage(driver);
		home.clickMoreLink(driver);
		//xpath for more
		//WebElement moreElement = driver.findElement(By.linkText("More"));
		
		home.clickCampLink();
		//xpath for campaigne
		//driver.findElement(By.name("Campaigns")).click();
		
		CreateCamapaignsPage cmpPage = new CreateCamapaignsPage(driver);
		cmpPage.clickCampPlus();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		Thread.sleep(1000);
//----------------------------------------------------------------------------------------------------------------		
		//fetching data to Campaign name text field	
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
//		FileInputStream fis1 = new FileInputStream("./src/test/resources/QtigerModules.xlsx");
//		Workbook book= WorkbookFactory.create(fis1);
//		Sheet sheet = book.getSheet("Campaigns");
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		String CmpName = cell.getStringCellValue()+ranNum;
		//xpath for Campaign name
		Excel_Utility elib = new Excel_Utility();
		String CmpName = elib.getExcelData1("Campaigns", 0, 0)+ranNum;
		
		//driver.findElement(By.name("campaignname")).sendKeys(CmpName);
		Thread.sleep(2000);
		
		//fetching data to Budget cost text field
//		Row row2 = sheet.getRow(1);
//		Cell cell2 = row2.getCell(0);
//		DataFormatter formate= new DataFormatter();
//		String BudCost = formate.formatCellValue(cell2);
//		//xpath for Budget Cost
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
		home.signout(driver);
	}

}
