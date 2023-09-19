package POMrepository;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class CreateOrganizationPage {

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrganizationImg;
	
	@FindBy(name="accountname")
	private WebElement OrganizationName;
	
	@FindBy(id="phone")
	private WebElement OrganizationPhoneNum;
	
	@FindBy(id="email1")
	private WebElement OrganizationEmail;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveButton;

//	//image for signOut
//	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
//	private WebElement Administrator;
//		
//	@FindBy(linkText="Sign Out")
//	private WebElement signout;
	
	//----------------------------------------------------------------------------
	//getter method
	
	public  WebElement getCreateOrganizationImg() {
		return CreateOrganizationImg;
	}
	
	public WebElement getOrganizationName() {
		return OrganizationName;
	}
	
	public WebElement getOrganizationPhoneNum() {
		return OrganizationPhoneNum;
	}
	
	public  WebElement getOrganizationEmail() {
		return OrganizationEmail;
	}
	
	public WebElement getsaveButton() {
		return saveButton;
	}
//	
//	public WebElement getAdministrator() {
//		return Administrator;
//	}
//	
//	public WebElement getsignout() {
//		return signout;
//	}
	
	//----------------------------------------------------------------------------
	//business logic
	
	public void clickOrgPlus() {
		CreateOrganizationImg.click();
	}
	
	public void OrganizationField(String orgName,String orgPhn,String orgEmail) {
		OrganizationName.sendKeys(orgName);
		OrganizationPhoneNum.sendKeys(orgPhn);
		OrganizationEmail.sendKeys(orgEmail);
	}
	
	public void saveButton(WebDriver driver) {
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.mouseOverOnElement(driver, saveButton);
		saveButton.click();
	}
	
//	public void Administrator() {
//		Administrator.click();
//	}
//	
//	public void signout(WebDriver driver) {
//		WebDriver_Utility wlib = new WebDriver_Utility();
//		wlib.ActionsMoveToElement(driver, Administrator);
//		signout.click();
//	}
  }
		

