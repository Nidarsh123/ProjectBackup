package POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage {

	public ValidationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement campValidate;
	
	//getter method
	public WebElement getCampValidate() {
		return campValidate;
	}
	
	//Business Logics
	public String validateCampname()
	{
		return campValidate.getText();
	}
}
