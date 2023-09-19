package Practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEX2 {

	@Test(dataProvider = "getData")
	public void Vtiger(String orgName, String PhnNum, String email) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(PhnNum);
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(email);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		Object[][] objarr = new Object[3][3];
		
		objarr[0][0]="NNN";
		objarr[0][1]="87226388";
		objarr[0][2]="nida@gmail.com";
		
		objarr[1][0]="MMM";
		objarr[1][1]="87226388";
		objarr[1][2]="ada@gmail.com";
		
		objarr[2][0]="VVV";
		objarr[2][1]="87226388";
		objarr[2][2]="vik@gamil.com";
		
		return objarr;	
	}
}
