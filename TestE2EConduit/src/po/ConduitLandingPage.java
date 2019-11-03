package po;

import java.util.List;

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

public class ConduitLandingPage {
	
	public WebDriver driver;
		
	public ConduitLandingPage(WebDriver driver){
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
		
	/**
	* 
	* All elements/locators on the page
	* Here, we are using page object model without using Page Factory
	* 
	*/
	
	By navbarHomeLink = By.linkText("Home");
	By navSignInLink = By.linkText("Sign in");
	By navSignUpLink = By.linkText("Sign up");
	By globalFeedLink = By.linkText("Global Feed");
	By conduitHeader = By.tagName("h1");
	By conduitHeaderPara = By.tagName("p");
	By conduitHomeLink = By.cssSelector("a[class=\"navbar-brand\"]");
	By popularTags = By.xpath("//div[@class=\"tag-list\"]/preceding-sibling::p");
	By allArticles = By.cssSelector("div[class=\"article-preview\"]");
	By allPopularTags = By.xpath("//a[contains(@class, \"tag-pill\")]");
	By paginationAllPageLinks = By.className("page-link");
	
	/**
	* 
	* Getters for getting all the locators as WebElement
	* 
	*/
	
	public WebElement getHomeLink(){
		return driver.findElement(navbarHomeLink);
	}
	
	public WebElement getSignInLink(){
		return driver.findElement(navSignInLink);
	}
	
	public WebElement getSignUpLink(){
		return driver.findElement(navSignUpLink);
	}
	
	public WebElement getGlobalFeedLink(){
		return driver.findElement(globalFeedLink);
	}
	
	public WebElement getConduitHomeLink(){
		return driver.findElement(conduitHomeLink);
	}
	
	public WebElement getConduitHeader(){
		return driver.findElement(conduitHeader);
	}
	
	public WebElement getConduitHeaderPara(){
		return driver.findElement(conduitHeaderPara);
	}
	
	public WebElement getPopularTags(){
		return driver.findElement(popularTags);
	}
	
	public List<WebElement> getAllArticles(){
		return driver.findElements(allArticles);
	}
	
	public List<WebElement> getAllPopularTags(){
		return driver.findElements(allPopularTags);
	}
	
	public List<WebElement> getAllPageLinks(){
		return driver.findElements(paginationAllPageLinks);
	}

}
