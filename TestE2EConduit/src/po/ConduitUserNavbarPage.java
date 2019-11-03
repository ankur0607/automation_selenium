package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
* This class is to have components/elements this specific page
*
* @author  Ankur Dubey
* @version 1.0
* @since   2019-11-03
*/

public class ConduitUserNavbarPage {
	
	protected WebDriver driver;
	
	public ConduitUserNavbarPage(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	* 
	* All elements/locators on the page
	* Here, we are using page object model without using Page Factory
	* 
	*/
	
	By userNavbarConduitLink = By.xpath("//div[@class='container']/a");
	By userNavbarHomeLink = By.xpath("//div[@class='container']/ul/li[1]");
	By userNavbarNewpostLink = By.partialLinkText("New Post");//By.xpath("//div[@class='container']/ul/li[2]/a");
	By userNavbarSettingsLink = By.partialLinkText("Settings");
	By userNavbarUsernameLink = By.xpath("//div[@class='container']/ul/li[4]");

	/**
	* 
	* Getters for getting all the locators as WebElement
	* 
	*/
	
	public WebElement getUserNavbarConduitLink(){
		return driver.findElement(userNavbarConduitLink);
	}
	
	public WebElement getUserNavbarHomeLink(){
		return driver.findElement(userNavbarHomeLink);
	}
	
	public WebElement getUserNavbarNewpostLink(){
		return driver.findElement(userNavbarNewpostLink);
	}
	
	public WebElement getUserNavbarSettingsLink(){
		return driver.findElement(userNavbarSettingsLink);
	}
	
	public WebElement getUserNavbarUsernameLink(){
		return driver.findElement(userNavbarUsernameLink);
	}

}
