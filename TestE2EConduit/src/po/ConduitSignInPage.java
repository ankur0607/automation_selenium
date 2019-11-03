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

public class ConduitSignInPage {
	
	WebDriver driver;
	
	public ConduitSignInPage(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	* 
	* All elements/locators on the page
	* Here, we are using page object model without using Page Factory
	* 
	*/
	
	By signInHeader = By.tagName("h1");
	By needAnAccountLink = By.partialLinkText("Need an account?");
	By emailInputBox = By.xpath("//input[@type=\"email\"]");
	By passwordInputBox = By.xpath("//input[@type=\"password\"]");
	By submitButton = By.xpath("//button[@type=\"submit\"]");
	
	/**
	* 
	* Getters for getting all the locators as WebElement
	* 
	*/
	
	public WebElement getSignInHeader(){
		return driver.findElement(signInHeader);
	}
	
	public WebElement getNeedAnAccountLink(){
		return driver.findElement(needAnAccountLink);
	}
	
	public WebElement getEmailInputBox(){
		return driver.findElement(emailInputBox);
	}
	
	public WebElement getPasswordInputBox(){
		return driver.findElement(passwordInputBox);
	}
	
	public WebElement getSubmitButton(){
		return driver.findElement(submitButton);
	}
	
	
}
