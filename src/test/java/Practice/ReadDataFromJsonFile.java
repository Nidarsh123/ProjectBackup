package Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//PROGRAM FOR JAON
public class ReadDataFromJsonFile {

	public static void main(String[] args) throws Throwable, Throwable {
		File file = new File("./src/test/resources/jasonFileData.json");
		ObjectMapper jsonData = new ObjectMapper();
		JsonNode data = jsonData.readTree(file);
		
		String URL = data.get("url").asText();
		String USERNAME = data.get("username").asText();
		String PASSWORD = data.get("password").asText();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get(URL);
		/*driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();*/
	}

}
