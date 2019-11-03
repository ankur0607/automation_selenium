package test;

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

public class TestConduitUserHomePage extends TestBase{
	
	ConduitLandingPage cLandingPageObject;
	ConduitSignInPage cSignInPageObject;
	ConduitSignUpPage cSignUpPageObject;
	ConduitUserNavbarPage cUserNavbarPageObject;
	ConduitUserHomePage cUserHomePageObject;
	ConduitUserNewPostPage cUserNewPostPageObject;
	ConduitUserSettingsPage cUserSettingsPageObject;
	
	@Test
	public void tc05VerifyUserHomePageTest() {

		cLandingPageObject = new ConduitLandingPage(driver);
		cSignInPageObject = new ConduitSignInPage(driver);
		cUserHomePageObject = new ConduitUserHomePage(driver);
		SoftAssert sa = new SoftAssert();
		
		cLandingPageObject.getSignInLink().click();
		cSignInPageObject.getEmailInputBox().sendKeys(PropertyFile.EMAIL);
		cSignInPageObject.getPasswordInputBox().sendKeys(PropertyFile.PASSWORD);
		cSignInPageObject.getSubmitButton().click();
		
		BrowserUtils.waitForVisibilityOfElement(driver, cUserHomePageObject.getNoArticleMessage(), 30);
				
		sa.assertEquals(cUserHomePageObject.getUserNavbarConduitLink().getText(), "conduit");
		sa.assertTrue(cUserHomePageObject.getUserNavbarHomeLink().getText().contains("Home"));
		sa.assertTrue(cUserHomePageObject.getUserNavbarNewpostLink().getText().contains("New Post"));
		sa.assertTrue(cUserHomePageObject.getUserNavbarSettingsLink().getText().contains("Settings"));
		sa.assertTrue(cUserHomePageObject.getUserNavbarUsernameLink().getText().contains("aello"));

		sa.assertTrue(cUserHomePageObject.getGlobalFeedList().getText().contains("Global Feed"));
		sa.assertTrue(cUserHomePageObject.getYourFeedList().getText().contains("Your Feed"));
		sa.assertTrue(cUserHomePageObject.getNoArticleMessage().getText().contains("No articles are here... yet."));

		sa.assertAll();
	}

}
