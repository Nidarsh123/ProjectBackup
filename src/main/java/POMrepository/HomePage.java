package POMrepository;

import javax.swing.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class HomePage {
	//Initialization
	public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement ProductLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveButton;
	
	//image for Administrator(signout)
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administrator;
	
	@FindBy(linkText="Sign Out")
	private WebElement signout;
	//-----------------------------------------------------------------------------------------
	//getterMethod
	
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}
	
	public WebElement getProductLink() {
		return ProductLink;
	}
	
	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
		
	public WebElement getAdminstrator() {
		return Administrator;
	}
	
	public WebElement getsaveButton() {
		return saveButton;
	}
	public WebElement getSignout() {
		return signout;
	}
	//-------------------------------------------------------------------------------------------
	//BusinessLogic
	public void OrganizationLink() {
		OrganizationLink.click();
	}

	public void productLink()
	{
		ProductLink.click();
	}
	
	public void clickMoreLink(WebDriver driver)
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
	wlib.ActionsMoveToElement(driver, moreLink);
	campaignsLink.click();
	}
	
	public void clickCampLink()
	{
		campaignsLink.click();
	}
	
	public void saveButton(WebDriver driver) {
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.mouseOverOnElement(driver, saveButton);
		saveButton.click();
	}
	
	public WebElement getAdministrator() {
		return Administrator;
	}
				//or	
//	public void getAdministrator(WebDriver driver) {
//		WebDriver_Utility wlib = new WebDriver_Utility();
//		wlib.mouseOverOnElement(driver, Administrator);
//		Administrator.click();

	public void signout(WebDriver driver) {
		/*Actions act = new Actions(driver);
		act.moveToElement(Administrator).perform();
		signout.click();*/
		/*or*/
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.ActionsMoveToElement(driver, Administrator);
		signout.click();
	}

}
