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

public class ConduitUserNewPostPage {
	
	WebDriver driver;
	
	public ConduitUserNewPostPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	* 
	* All elements/locators on the page
	* Here, we are using page object model without using Page Factory
	* 
	*/
	
	By articleTitleInputBox = By.xpath("//form//fieldset/fieldset[1]/input");
	By articleAboutInputBox = By.xpath("//form//fieldset/fieldset[2]/input");
	By articleTextArea = By.xpath("//form//fieldset/fieldset[3]/textarea");
	By articleTagsInputBox = By.xpath("//form//fieldset/fieldset[4]/input");
	By publishArticleButton = By.tagName("button");
	
	/**
	* 
	* Getters for getting all the locators as WebElement
	* 
	*/
	
	public WebElement getArticleTitleInputBox() {
		return driver.findElement(articleTitleInputBox);
	}
	
	public WebElement getArticleAboutInputBox() {
		return driver.findElement(articleAboutInputBox);
	}
	
	public WebElement getArticleTextArea() {
		return driver.findElement(articleTextArea);
	}
	
	public WebElement getArticleTagsInputBox() {
		return driver.findElement(articleTagsInputBox);
	}
	
	public WebElement getPublishArticleButton() {
		return driver.findElement(publishArticleButton);
	}
	

}
