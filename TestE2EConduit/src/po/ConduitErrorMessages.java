package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConduitErrorMessages {
	
	WebDriver driver;
	
	public ConduitErrorMessages(WebDriver driver) {
		this.driver = driver;
	}
	
	By invalidEmailOrPassword = By.xpath("//ul[@class=\"error-messages\"]/li");
	By emailCantBeBlank = By.xpath("//ul[@class=\"error-messages\"]/li[1]");
	By passwordCantBeBlank = By.xpath("//ul[@class=\"error-messages\"]/li[2]");
	By usernameCantBeBlank = By.xpath("//ul[@class=\"error-messages\"]/li[3]");
	
	public WebElement getInvalidEmailOrPassword() {
		return driver.findElement(invalidEmailOrPassword);
	}
	
	public WebElement getEmailCantBeBlank() {
		return driver.findElement(emailCantBeBlank);
	}
	
	public WebElement getPasswordCantBeBlank() {
		return driver.findElement(passwordCantBeBlank);
	}
	
	public WebElement getUsernameCantBeBlank() {
		return driver.findElement(usernameCantBeBlank);
	}

}
