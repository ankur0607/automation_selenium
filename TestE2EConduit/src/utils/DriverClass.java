package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
* This class is to have various webdriver's utilities
*
* @author  Ankur Dubey
* @version 1.0
* @since   2019-11-03
*/

public class DriverClass {

	private static WebDriver driverInstance = null;
	private static DriverClass driverClassInstance = null;

	private DriverClass() {

	}

	public static DriverClass getDriverClassInstance() {
		if (driverClassInstance == null) {
			driverClassInstance = new DriverClass();
		}
		return driverClassInstance;
	}

	public WebDriver getDriverInstance(String driverType) {

		if (driverInstance == null) {

			if (driverType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C://jars//chromedriver.exe");
				driverInstance = new ChromeDriver();
			} else if (driverType.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"C://jars//IEDriverServer.exe");
				driverInstance = new InternetExplorerDriver();
			}

		}
		return driverInstance;
	}
	
	public static WebDriver getDriverInstance() {
			return driverInstance;
	}

}
