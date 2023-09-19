package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {

	public static void main(String[] args) throws Throwable {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//div[@class='sc-hUpaCq fKFvYE']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 dRQhOp']")).click();
		//xpath for departure
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		Thread.sleep(2000);
		
		String month = "August 2023";
		String date = "15";
		//xpath for monthand date
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']"
				+ "/descendant::p[text()='"+date+"']")).click();
		//xpath for done don't use it for for loop
//		driver.findElement(By.xpath("//span[text()='Done']")).click();
//		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		
		//xpath for Traveller and class
		driver.findElement(By.xpath("//span[text()='Travellers & Class']")).click();
		
		int numberOfAdults = 3;
		int numberOfChildrens = 1;
		int numberOfInfants = 1;
		
		for(int i = 0; i<numberOfAdults - 1; i++) {
			//xpath for increasing numberofadults and minimum already 1
			WebElement AddAdultButton = driver.findElement(By.xpath("//div[@class='sc-12foipm-78 dLDesG']/div[1]//span[3]//*[name()='svg']"));
			AddAdultButton.click();
		}
		
		for(int i = 0; i<numberOfChildrens; i++) {
			//xpath for increasing numberOfChildrens
			WebElement addChildButton = driver.findElement(By.xpath("//div[@class='sc-12foipm-78 dLDesG']/div[2]//span[3]//*[name()='svg']"));
			addChildButton.click();
		}

		for(int i = 0; i<numberOfInfants; i++) {
			//xpath for increasing numberOfInfants
			WebElement addInfantButton = driver.findElement(By.xpath("//div[@class='sc-12foipm-78 dLDesG']/div[3]//span[3]//*[name()='svg']"));
			addInfantButton.click();
		}
	}
}
