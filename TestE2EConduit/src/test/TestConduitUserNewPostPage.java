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
public class TestConduitUserNewPostPage extends TestBase{
	
	ConduitLandingPage cLandingPageObject;
	ConduitSignInPage cSignInPageObject;
	ConduitSignUpPage cSignUpPageObject;
	ConduitUserNavbarPage cUserNavbarPageObject;
	ConduitUserHomePage cUserHomePageObject;
	ConduitUserNewPostPage cUserNewPostPageObject;
	ConduitUserSettingsPage cUserSettingsPageObject;
	
	
	@Test
	public void tc06VerifyUserNewPostPageTest() {
		
		cLandingPageObject = new ConduitLandingPage(driver);
		cSignInPageObject = new ConduitSignInPage(driver);
		cUserHomePageObject = new ConduitUserHomePage(driver);
		cUserNewPostPageObject = new ConduitUserNewPostPage(driver);
		
		cLandingPageObject.getSignInLink().click();
		cSignInPageObject.getEmailInputBox().sendKeys(PropertyFile.EMAIL);
		cSignInPageObject.getPasswordInputBox().sendKeys(PropertyFile.PASSWORD);
		cSignInPageObject.getSubmitButton().click();
		
		BrowserUtils.waitForVisibilityOfElement(driver, cUserHomePageObject.getUserNavbarNewpostLink(), 30);
		cUserHomePageObject.getUserNavbarNewpostLink().click();
		
		Assert.assertEquals(cUserNewPostPageObject.getArticleAboutInputBox().getAttribute("placeholder"), "What's this article about?");
		Assert.assertEquals(cUserNewPostPageObject.getArticleTitleInputBox().getAttribute("placeholder"), "Article Title");
		Assert.assertEquals(cUserNewPostPageObject.getArticleTagsInputBox().getAttribute("placeholder"), "Enter tags");
		Assert.assertEquals(cUserNewPostPageObject.getArticleTextArea().getAttribute("placeholder"), "Write your article (in markdown)");
		Assert.assertEquals(cUserNewPostPageObject.getPublishArticleButton().getText(), "Publish Article");
		
		Assert.assertTrue(cUserNewPostPageObject.getArticleAboutInputBox().isEnabled());
		Assert.assertTrue(cUserNewPostPageObject.getArticleTitleInputBox().isEnabled());
		Assert.assertTrue(cUserNewPostPageObject.getArticleTagsInputBox().isEnabled());
		Assert.assertTrue(cUserNewPostPageObject.getArticleTextArea().isEnabled());
		Assert.assertTrue(cUserNewPostPageObject.getPublishArticleButton().isEnabled());
		
	}

}
