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

public class ConduitSignUpPage {

	WebDriver driver;

	public ConduitSignUpPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	* 
	* All elements/locators on the page
	* Here, we are using page object model without using Page Factory
	* 
	*/
	
	By signUpHeader = By.tagName("h1");
	By haveAnAccountLink = By.linkText("Have an account?");
	By userNameInputBox = By.xpath("//input[@type=\"text\"]");
	By signUpButton = By.tagName("button");
	
	/**
	* 
	* Getters for getting all the locators as WebElement
	* 
	*/
	
	public WebElement getSignUpHeader(){
		return driver.findElement(signUpHeader);
	}
	
	public WebElement getHaveAnAccountLink(){
		return driver.findElement(haveAnAccountLink);
	}
	
	public WebElement getUserNameInputBox(){
		return driver.findElement(userNameInputBox);
	}
	
	public WebElement getSignUpButton() {
		return driver.findElement(signUpButton);
	}

}
