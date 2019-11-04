package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import po.ConduitLandingPage;
import po.ConduitSignInPage;
import po.ConduitSignUpPage;
import po.ConduitUserHomePage;
import po.ConduitUserNavbarPage;
import po.ConduitUserNewPostPage;
import po.ConduitUserSettingsPage;
import utils.BrowserUtils;
import utils.PropertyFile;

/**
* This test class is to test Conduit user settings page
*
* @author  Ankur Dubey
* @version 1.0
* @since   2019-11-03
*/

public class TestConduitUserSettingsPage extends TestBase{
	
	ConduitLandingPage cLandingPageObject;
	ConduitSignInPage cSignInPageObject;
	ConduitSignUpPage cSignUpPageObject;
	ConduitUserNavbarPage cUserNavbarPageObject;
	ConduitUserHomePage cUserHomePageObject;
	ConduitUserNewPostPage cUserNewPostPageObject;
	ConduitUserSettingsPage cUserSettingsPageObject;
	
	// To verify Page and it's locators/components
	@Test
	public void tc17VerifyUserSettingsPageTest() {
		
		cLandingPageObject = new ConduitLandingPage(driver);
		cSignInPageObject = new ConduitSignInPage(driver);
		cUserHomePageObject = new ConduitUserHomePage(driver);
		cUserSettingsPageObject = new ConduitUserSettingsPage(driver);
		
		cLandingPageObject.getSignInLink().click();
		cSignInPageObject.getEmailInputBox().sendKeys(PropertyFile.EMAIL);
		cSignInPageObject.getPasswordInputBox().sendKeys(PropertyFile.PASSWORD);
		cSignInPageObject.getSubmitButton().click();
		
		BrowserUtils.waitForVisibilityOfElement(driver, cUserHomePageObject.getUserNavbarSettingsLink(), 30);
		cUserHomePageObject.getUserNavbarSettingsLink().click();
		
		Assert.assertEquals(cUserSettingsPageObject.getProfilePictureInputBox().getAttribute("placeholder"), "URL of profile picture");
		Assert.assertEquals(cUserSettingsPageObject.getEmailInputBox().getAttribute("value"), PropertyFile.EMAIL);
		Assert.assertEquals(cUserSettingsPageObject.getNewPasswordInputBox().getAttribute("placeholder"), "New Password");
		Assert.assertEquals(cUserSettingsPageObject.getShortBioAboutYouTextArea().getAttribute("placeholder"), "Short bio about you");
		Assert.assertEquals(cUserSettingsPageObject.getUserNameInputBox().getAttribute("value"), PropertyFile.USERNAME);
		Assert.assertEquals(cUserSettingsPageObject.getUpdateSettingsButton().getText(), "Update Settings");
		Assert.assertEquals(cUserSettingsPageObject.getYourSettingsHeader().getText(), "Your Settings");
		Assert.assertEquals(cUserSettingsPageObject.getLogoutButton().getText(), "Or click here to logout.");
		
		Assert.assertTrue(cUserSettingsPageObject.getProfilePictureInputBox().isEnabled());
		Assert.assertTrue(cUserSettingsPageObject.getEmailInputBox().isEnabled());
		Assert.assertTrue(cUserSettingsPageObject.getNewPasswordInputBox().isEnabled());
		Assert.assertTrue(cUserSettingsPageObject.getShortBioAboutYouTextArea().isEnabled());
		Assert.assertTrue(cUserSettingsPageObject.getUserNameInputBox().isEnabled());
		Assert.assertTrue(cUserSettingsPageObject.getUpdateSettingsButton().isEnabled());
		Assert.assertTrue(cUserSettingsPageObject.getYourSettingsHeader().isEnabled());
		Assert.assertTrue(cUserSettingsPageObject.getLogoutButton().isEnabled());
		
	}
	
	// To verify user logout
	@Test(dependsOnMethods = {"tc17VerifyUserSettingsPageTest"})
	public void tc18VerifyLogoutUserTest() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		cUserSettingsPageObject = new ConduitUserSettingsPage(driver);				
		cUserHomePageObject.getUserNavbarSettingsLink().click();
		js.executeScript("window.scrollBy(0,1000)");
		cUserSettingsPageObject.getLogoutButton().click();
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertTrue(cLandingPageObject.getConduitHeaderPara().isDisplayed());
		
		sa.assertAll();
		
		
	}

}
