package Practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass1;

//not run successfully
public class SampleAssert extends BaseClass1 {

	@Test
	public void verifyHomePage ()
	{
		System.out.println("==test start===");
		String expectedTitle = "Home".trim();
		System.out.println("cpature page title");
		String actTitle = driver.getTitle().trim();
		Assert.assertEquals(actTitle, expectedTitle);
		System.out.println("==test End===");
	}
	
	@Test
	public void verifyLogoInHomePage()
	{
		System.out.println("==test start===");
		System.out.println("capture the logo status");
		boolean actstatus = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).equals(driver);
		Assert.assertTrue(actstatus);
		
		System.out.println("==test end====");
	}
}
