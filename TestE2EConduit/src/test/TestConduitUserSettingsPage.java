package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import po.ConduitLandingPage;
import po.ConduitSignInPage;
import po.ConduitSignUpPage;
import po.ConduitUserHomePage;
import po.ConduitUserNavbarPage;
import po.ConduitUserNewPostPage;
import po.ConduitUserSettingsPage;
import utils.BrowserUtils;
import utils.PropertyFile;

public class TestConduitUserSettingsPage extends TestBase{
	
	ConduitLandingPage cLandingPageObject;
	ConduitSignInPage cSignInPageObject;
	ConduitSignUpPage cSignUpPageObject;
	ConduitUserNavbarPage cUserNavbarPageObject;
	ConduitUserHomePage cUserHomePageObject;
	ConduitUserNewPostPage cUserNewPostPageObject;
	ConduitUserSettingsPage cUserSettingsPageObject;
	
	@Test
	public void tc07VerifyUserSettingsPageTest() {
		
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
		Assert.assertEquals(cUserSettingsPageObject.getEmailInputBox().getAttribute("value"), "aello@gmail.com");
		Assert.assertEquals(cUserSettingsPageObject.getNewPasswordInputBox().getAttribute("placeholder"), "New Password");
		Assert.assertEquals(cUserSettingsPageObject.getShortBioAboutYouTextArea().getAttribute("placeholder"), "Short bio about you");
		Assert.assertEquals(cUserSettingsPageObject.getUserNameInputBox().getAttribute("value"), "aello");
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

}
