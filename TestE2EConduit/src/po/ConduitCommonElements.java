package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConduitCommonElements {
	
	WebDriver driver;
	
	public ConduitCommonElements(WebDriver driver) {
		this.driver = driver;
	}
	
	By emailInputBox = By.xpath("//input[@type=\"email\"]");
	By passwordInputBox = By.xpath("//input[@type=\"password\"]");
	
	public WebElement getEmailInputBox() {
		return driver.findElement(emailInputBox);
	}
	
	public WebElement getPasswordInputBox() {
		return driver.findElement(passwordInputBox);
	}

}
