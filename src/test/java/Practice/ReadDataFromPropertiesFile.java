package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.Module.SetupContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertiesFile {

	/*program for proprties file*/
	public static void main(String[] args) throws Throwable {
	
	//fileInputStream-to get the java representation object of a physical file and creation of path
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleCommonData1.properties");
		/*object creation for properties*/
		Properties pro = new Properties();
		/*load for what ever properties are present in the inside the properties file*/
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.id("loginButton")).click();
	}

}
