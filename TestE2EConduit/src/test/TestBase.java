package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import utils.DriverClass;
import utils.PropertyFile;

/**
* This test class is to setup a base setup for all tests
*
* @author  Ankur Dubey
* @version 1.0
* @since   2019-11-03
*/

public class TestBase {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		
		System.out.println("::::In BeforeClass::::");
		driver = DriverClass.getDriverClassInstance().getDriverInstance(PropertyFile.BROWSER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(PropertyFile.URL);
		driver.manage().window().maximize();
		
	}

	@AfterClass
	public void afterClass() {
		
		System.out.println("::::In AfterClass::::");
		//driver.close();
		//driver.quit();
		
	}

	@BeforeTest
	public void beforeTest() {
		
		System.out.println("::::In BeforeTest::::");
		
	}

	@AfterTest
	public void afterTest() {
		
		System.out.println("::::In AfterTest::::");
		
	}

	@BeforeSuite
	public void beforeSuite() {
		
		System.out.println("::::In BeforeSuite::::");
		
	}

	@AfterSuite
	public void afterSuite() {
		
		System.out.println("::::In AfterSuite::::");
		
	}

}
