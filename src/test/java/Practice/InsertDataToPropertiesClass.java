package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*passing data to the properties file from script*/
public class InsertDataToPropertiesClass {

	public static void main(String[] args) throws Throwable {
		Properties pro = new Properties();
		pro.setProperty("username", "admin");
		pro.setProperty("password", "manager");
		pro.setProperty("url", "https://demo.actitime.com/login.do");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/AdvSeleCommonData1.properties");
		/*we using store for storing the data into the properties file /"common data" or using any name instead of that*/
		pro.store(fos, "Common Data");
		System.out.println("data written Successfully");
		
	//fileInputStream-to get the java representation object of a physical file and creation of path
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleCommonData1.properties");
		/*object creation for properties*/
		Properties pro1= new Properties();
		/*load for what ever properties are present in the inside the properties file*/
		pro1.load(fis);
		String URL = pro1.getProperty("url");
		String USERNAME = pro1.getProperty("username");
		String PASSWORD = pro1.getProperty("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.id("loginButton")).click();

	}

}
