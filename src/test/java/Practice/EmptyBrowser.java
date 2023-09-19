package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
//import org.openqa.selenium.manager.SeleniumManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EmptyBrowser {

	public static void main(String[] args) throws Throwable {
		/*this for regular open browser*/
		
		/*String key="webdriver.chrome.driver";
		String Value="./src/main/resources/chromedriver.exe";
		System.setProperty(key, Value);
		WebDriver driver=new ChromeDriver();*/
		
		//WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		WebDriver driver=new ChromeDriver(options);
//		System.setProperty("wedriver.chrome.driver", "G:\\selenium_workspace(G)\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
//		ChromeOptions option = new ChromeOptions();
//		option.setBinary("G:\\selenium_workspace(G)\\chrome-win64\\chrome-win64\\chrome.exe");
		
		//System.setProperty("webdriver.chrome.driver", "G:\\selenium_workspace(G)\\AdvanceSelenium\\src\\main\\resources\\chromedriver.exe");
	//WebDriver driver = new ChromeDriver(option);
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
//		Thread.sleep(2000);
//		driver.quit();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();
		
		//WebDriverManager.edgedriver().setup();
		//WebDriver driver=new EdgeDriver();
		
		//WebDriver driver=new FirefoxDriver();
		 //driver.quit();
	}

}
