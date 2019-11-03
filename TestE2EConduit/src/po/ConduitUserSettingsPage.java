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

public class ConduitUserSettingsPage {

	WebDriver driver;

	public ConduitUserSettingsPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	* 
	* All elements/locators on the page
	* Here, we are using page object model without using Page Factory
	* 
	*/
	By yourSettingsHeader = By.tagName("h1");
	By profilePictureInputBox = By.xpath("//form/fieldset/fieldset[1]/input");
	By userNameInputBox = By.xpath("//form/fieldset/fieldset[2]/input");
	By shortBioAboutYourTextArea = By.xpath("//form/fieldset/fieldset[3]/textarea");
	By emailInputBox = By.xpath("//form/fieldset/fieldset[4]/input");
	By newPasswordInputBox = By.xpath("//form/fieldset/fieldset[5]/input");
	By updateSettingsButton = By.tagName("button");
	By logoutButton = By.cssSelector("button[class$='danger']");

	/**
	* 
	* Getters for getting all the locators as WebElement
	* 
	*/
	public WebElement getYourSettingsHeader() {
		return driver.findElement(yourSettingsHeader);
	}

	public WebElement getProfilePictureInputBox() {
		return driver.findElement(profilePictureInputBox);
	}

	public WebElement getUserNameInputBox() {
		return driver.findElement(userNameInputBox);
	}

	public WebElement getShortBioAboutYouTextArea() {
		return driver.findElement(shortBioAboutYourTextArea);
	}

	public WebElement getEmailInputBox() {
		return driver.findElement(emailInputBox);
	}

	public WebElement getNewPasswordInputBox() {
		return driver.findElement(newPasswordInputBox);
	}

	public WebElement getUpdateSettingsButton() {
		return driver.findElement(updateSettingsButton);
	}
	
	public WebElement getLogoutButton() {
		return driver.findElement(logoutButton);
	}

}
