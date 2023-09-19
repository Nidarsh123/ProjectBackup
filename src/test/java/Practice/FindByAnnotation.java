package Practice;

import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.Login1Page;

//import from POMrepositry Login1Page
public class FindByAnnotation {

	public static void main(String[] args) throws Throwable {
		ChromeDriver driver = new ChromeDriver();
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		//wlib.implicityWait(driver);
		
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		 
		Thread.sleep(2000);
		driver.get(URL);
		Login1Page login = new Login1Page(driver);
		login.loginToApplication(USERNAME, PASSWORD);
	}

}
