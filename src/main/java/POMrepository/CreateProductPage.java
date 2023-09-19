package POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement ProductPlus;
	
	@FindBy(name="productname")
	private WebElement ProductName;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement SaveButton;
	
	//-------------------------------------------------------------------------------------
	//getter method
	
	public WebElement getProductPlus() {
		return ProductPlus;
	}

	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	//-------------------------------------------------------------------------------------
	//business logic
	
	public void ClickProdPlus() {
		ProductPlus.click();
	}
	
	public void ProdNameField(String ProdName1) {
		ProductName.sendKeys(ProdName1);
	}
	
	public void SaveButton(WebDriver driver) {
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.mouseOverOnElement(driver, SaveButton);
		SaveButton.click();
	}
}
