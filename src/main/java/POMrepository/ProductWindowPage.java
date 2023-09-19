package POMrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class ProductWindowPage {

	public ProductWindowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Select']")//or //img[@src='themes/softed/images/select.gif']
	private WebElement selectProductPlusSign;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement ProductTextBox;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement ProductSearchBox;
	
	//------------------------------------------------------------------------------------------

	public WebElement getSelectProductPlusSign() {
		return selectProductPlusSign;
	}

	public WebElement getProductTextBox() {
		return ProductTextBox;
	}

	public WebElement getProductSearchBox() {
		return ProductSearchBox;
	}
	
	//----------------------------------------------------------------------------------------
	
	//Business logic
	public void ClickOnSelectSign(WebDriver driver, WebDriver_Utility wlib)
	{
		selectProductPlusSign.click();
		 wlib.SwitchingWindows(driver, "Products&action");
	}
	
	public void productName(String PrdName)
	{
		ProductTextBox.sendKeys(PrdName);
	}
	
	public void searchPrdData()
	{
		ProductSearchBox.click();
	}
	
	public void selectProduct(WebDriver driver,String prdName,WebDriver_Utility wlib)
	{
		 driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();
		 wlib.SwitchingWindows(driver, "Campaigns&action");
	}
}
