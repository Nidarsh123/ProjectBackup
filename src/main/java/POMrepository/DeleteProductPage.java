package POMrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {

	public DeleteProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement navigateProductTable;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement DeleteProduct;
//-------------------------------------------------------------------------------
	public WebElement getNavigateProductTable() {
		return navigateProductTable;
	}

	public WebElement getDeleteProduct() {
		return DeleteProduct;
	}
//--------------------------------------------------------------------------------
	
	public void productTable()
	{
		navigateProductTable.click();
	}
	
	public void deleteProdData()
	{
		DeleteProduct.click();
	}
	
	public void validateProduct(WebDriver driver, String prdName)
	{
		 List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		   boolean flag=false;
		   
		   for(WebElement prdname:productList)
		   {
			   String actData = prdname.getText();
			   
			   if(actData.contains(prdName)) //dell, prdName is different from prdname
			   {
				   flag=true;
				   break;
			   }
		   }
		   if(flag)
		   {
			   System.out.println("product data is deleted");
		   }
		   else
		   {
			   System.out.println("product data not deleted");
		   }
	}
}
