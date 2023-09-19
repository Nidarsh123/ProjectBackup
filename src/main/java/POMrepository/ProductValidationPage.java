package POMrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

//check in CreateProductandDelete2
public class ProductValidationPage {

	public ProductValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@value='Delete'])[1]")
	private WebElement DeleteProd;
//-----------------------------------------------------------------------------
	//business logic
	
	public void checkPrdName(WebDriver driver,String prdName) {
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+prdName+"']/../preceding-sibling::td/input"))
		.click();
	}
	
	public void deletePrdClick(WebDriver driver,WebDriver_Utility wlib) {
		DeleteProd.click();
		wlib.switchToAlertAccept(driver);
	}
}
