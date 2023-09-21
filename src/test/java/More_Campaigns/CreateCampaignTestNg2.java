package More_Campaigns;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass1;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMrepository.CreateCamapaignsPage;
import POMrepository.HomePage;
import POMrepository.ValidationPage;

//its is used for RetryAnalyserImplementation
public class CreateCampaignTestNg2 extends BaseClass1 {

	@Test(retryAnalyzer = Generic_Utilities.RetryAnalyserImplementation.class)
	public void CreateCampaignTestNg2() throws Throwable
	{
		//impport from webdriver_utililty
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);

	//------------------------------------------------------------------------------------------------		
		
	//------------------------------------------------------------------------------------------------------------		
		//import from Homeage(POM)
		HomePage home = new HomePage(driver);
		home.clickMoreLink(driver);
		
		CreateCamapaignsPage cmpPage = new CreateCamapaignsPage(driver);
		cmpPage.clickCampPlus();
		
		//Assert.assertEquals(false, true);//-----------------------------------------------Add for Listener
		
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		Thread.sleep(1000);
	//----------------------------------------------------------------------------------------------------------------		
		//fetching data to Campaign name text field	
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		//xpath for Campaign name
		Excel_Utility elib = new Excel_Utility();
		String CmpName = elib.getExcelData1("Campaigns", 0, 0)+ranNum;
		Thread.sleep(2000);
		
		//xpath for Budget Cost
		String BudCost = elib.getExcelDataUsingDataFormatter1("Campaigns", 1, 0);
		
		//import from createCampaignsPage(POM)
		cmpPage.campField(CmpName, BudCost);
		
		Thread.sleep(2000);
	//--------------------------------------------------------------------------------------------------------------		
		//xpath for save button
		cmpPage.saveButton();
		Thread.sleep(3000);
	//-------------------------------------------------------------------------------------------------------------	
//		//validation of Campaign name (it is inspecting after campaign name enter)
//		String Actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
//		if(Actdata.contains(CmpName)) {
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("fail");
//		}

		//alternative method for validation 
		ValidationPage valid = new ValidationPage(driver);
		String ActData = valid.getCampValidate().getText();
		
		Assert.assertEquals(ActData, CmpName);
		
		Thread.sleep(2000);
	//-------------------------------------------------------------------------------------------------------------
		//xpath for image of signout
		//import from homePage
		home.getAdministrator();
		}
	}

