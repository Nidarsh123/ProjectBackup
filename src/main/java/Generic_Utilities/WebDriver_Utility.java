package Generic_Utilities;

import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
	/**
	 * this method used for maximizing window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
	}
	
//	/**
//	 * this method will the element to load in GUI
//	 * @param driver
//	 */
//	public void implicityWait(WebDriver driver) {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	}
	
	/**
	 * used to wait for element to be clickable in GUI and check for specific element for every 500 milli
	 * @param driver
	 * @param element
	 * @param pollingTime
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method use for Action class
	 * @param driver
	 * @return
	 */
	public Actions Actions(WebDriver driver) {
		
		Actions act = new Actions(driver);
		return act;
	}
	
	/**
	 * this method used for switchingWindows
	 * @param driver
	 * @param visibleText
	 */
	public void SwitchingWindows(WebDriver driver,String visibleText) {
		   Set<String> allwindows = driver.getWindowHandles();
		    Iterator<String> id = allwindows.iterator();
		    while(id.hasNext()) {
		    	String win = id.next();
		    	driver.switchTo().window(win);
		    	String title = driver.getTitle();
		    	
		    if(title.contains(visibleText)) {
		    	break;
		    	}
		    }
		    
		 }
	/**
	 * this method used for scrollPage
	 * @param driver
	 * @param element
	 */
	public void scrollPage(WebDriver driver,WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	/**
	 * this method used to AlertWindow and Accept(click on OK Button) alert popup
	 * @param driver
	 */
	public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method used to AlertWindow and dismiss(click on cancel Button)
	 * @param driver
	 */
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to switch to frame based on id or name attribute
	 * @param driver
	 * @param id_name_Attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute) {
		driver.switchTo().frame(id_name_Attribute);
	}
	
	/**
	 * used to select the value from the dropDown based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropDown based on text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	
	/**
	 * used for right clcik on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void ActionsMoveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * used for 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveByOffest(WebDriver driver, int x,int y)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	
	public String takeScreenshot(WebDriver sDriver, String methodName)
	{
		Date date = new Date();
		date.toString().replace(" ", " ").replace(":", "-");
		return null;
	}

}

