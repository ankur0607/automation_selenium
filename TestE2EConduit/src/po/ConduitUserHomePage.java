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

public class ConduitUserHomePage extends ConduitUserNavbarPage {
	
	protected WebDriver driver;
	
	public ConduitUserHomePage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	/**
	* 
	* All elements/locators on the page
	* Here, we are using page object model without using Page Factory
	* 
	*/
	
	By yourFeedList = By.xpath("//div[@class='feed-toggle']/ul/li[1]");
	By globalFeedList = By.xpath("//div[@class='feed-toggle']/ul/li[2]");
	By noArticleHerePreviewMessage = By.xpath("//div[@class='feed-toggle']/following-sibling::div");//By.xpath("//div[@class='article-preview']");
	
	/**
	* 
	* Getters for getting all the locators as WebElement
	* 
	*/
	
	public WebElement getYourFeedList(){
		return driver.findElement(yourFeedList);
	}
	
	public WebElement getGlobalFeedList(){
		return driver.findElement(globalFeedList);
	}
	
	public WebElement getNoArticleMessage(){
		return driver.findElement(noArticleHerePreviewMessage);
	}

}
