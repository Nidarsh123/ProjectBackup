package POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCamapaignsPage {

	public CreateCamapaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement CampaignsPlus;
	
	@FindBy(name="campaignname")
	private WebElement camapaignsName;
	
	@FindBy(name="budgetcost")
	private WebElement campaignPhn;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveButton;
//-------------------------------------------------------------------------------
	//getter method (right clcik->source->Generate getter and setter->Select getter)
	public WebElement getCampaignsPlus() {
		return CampaignsPlus;
	}

	public WebElement getCamapaignsName() {
		return camapaignsName;
	}

	public WebElement getCampaignPhn() {
		return campaignPhn;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
//---------------------------------------------------------------------------------
	//Business logic
	
	public void clickCampPlus() {
		CampaignsPlus.click();
	}
	
	public void campField(String CampName,String budgetCost) {
		camapaignsName.sendKeys(CampName);
		campaignPhn.sendKeys(budgetCost);
	}
	
	public void campName(String campName) {
		camapaignsName.sendKeys(campName);
	}
	
	public void saveButton(){
		saveButton.click();
	}
}
