package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POMrepository.HomePage;
import POMrepository.Login1Page;
import POMrepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {

	public static WebDriver driver;
	
	//reinistialize for static driver for Listener
		public static WebDriver Sdriver;//add one more statement
	
	//we use (group) for group execution
	@BeforeSuite (groups = {"smokeTest","regressionTest"})
	public void beforeSuite()
	{
		System.out.println("DataBase connection");
	}
//--------------------------------------------------------------------
	@BeforeTest (groups = {"smokeTest","regressionTest"})
	public void beforeTest() throws Throwable
	{
		System.out.println("Parallel Execution");
	}
//-------------------------------------------------------------------------------	
	//@Parameters("BROWSER") is used for execution CrossBrowserParallelTestng
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	//below method for CrossBrowserParallelTestng
//	public void beforeClass(String BROWSER) throws Throwable
//	{
	public void beforeClass() throws Throwable
	{
		//import from file_utility
		//we commit below 2 statements and method also for execution of CrossBrowserParallelTestng and add @Parameter("BROWSER")
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) 
		{
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
		Sdriver=driver;//for Listener
////		WebDriverManager.chromedriver().setup();
////		driver=new ChromeDriver();
		System.out.println("Launching Browser");
	}
//------------------------------------------------------------------------
	@BeforeMethod (groups = {"smokeTest","regressionTest"})
	public void beforeMethod() throws Throwable
	{
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		driver.get(URL);
		Login1Page login = new Login1Page(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		System.out.println("login To Application");
	}
//---------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------
	@AfterMethod (groups = {"smokeTest","regressionTest"})
	public void afterMethod()
	{
		HomePage home = new HomePage(driver);
		home.signout(driver);
		System.out.println("logout from Apllication");
	}
//-------------------------------------------------------------------------
	@AfterClass (groups = {"smokeTest","regressionTest"})
	public void afterClass()
	{
		driver.quit();
		System.out.println("close Browser");
	}
//------------------------------------------------------------------------
	@AfterTest (groups = {"smokeTest","regressionTest"})
	public void afterTest()
	{
		System.out.println("parallel execution done");
	}
//------------------------------------------------------------------------
	@AfterSuite (groups = {"smokeTest","regressionTest"})
	public void afterSuite()
	{
		System.out.println("Data Base connection close");
	}
}
