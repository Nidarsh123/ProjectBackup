package POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Login1Page {

	public Login1Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement userNameTextField;
	
	//@FindBys using both xpath are true
	//@FindBys({@FindBy(xpath="//input[@type='password']"),@FindBy(name="user_password")})
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	//@FindAll using anyone xpath true
	//@FindAll({@FindBy(xpath="//input[@type='submit']"),@FindBy(id="submitButton")})
	@FindBy(id="submitButton")
	private WebElement loginButton;
//--------------------------------------------------------------------------------------------------
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
//--------------------------------------------------------------------------------------------------------	
	public void loginToApplication(String username,String password)
	{
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
}
