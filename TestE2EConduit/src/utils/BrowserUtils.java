package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
* This class is to have various browser's utilities
*
* @author  Ankur Dubey
* @version 1.0
* @since   2019-11-03
*/

public class BrowserUtils {
	
	static WebDriverWait driverWaitInstance;
	
	public static void waitForVisibilityOfElement(WebDriver driver, WebElement element, int time) {
		
		driverWaitInstance = new WebDriverWait(driver, time);
		driverWaitInstance.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	

}
