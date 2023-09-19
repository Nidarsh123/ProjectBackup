package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Test
//Using priority
public class TestNgClass {

	public static WebDriver driver;
	
	@Test(enabled=false)
	public void CreatedProductName()
	{
		System.out.println("ProdName Created");
	}
	
	@Test(priority=-1)
	public void ModifyProductName()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		System.out.println("ProdName Modify");
	}
	
	@Test(priority=1)
	public void DeleteProdName()
	{
		System.out.println("ProdName Delete");
	}
}
