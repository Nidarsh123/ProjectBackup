package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/*frame work practice*/
public class HandlingFrames {

	public static void main(String[] args) throws Throwable {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Frames.html");

		/*switch the frame using index value because we can't access without switchTo method so type //iframe first on ctrl+f*/
		//driver.switchTo().frame(0);
		//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Nidarsh");
		
		/*switching the frame using id attributes*/
		driver.switchTo().frame("singleframe");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");

		//get back to the paren frame
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[.='Iframe with in an Iframe']")).click();
	}

}
