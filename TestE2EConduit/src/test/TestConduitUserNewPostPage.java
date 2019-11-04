package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import po.ConduitLandingPage;
import po.ConduitPostArticlePage;
import po.ConduitSignInPage;
import po.ConduitSignUpPage;
import po.ConduitUserHomePage;
import po.ConduitUserNavbarPage;
import po.ConduitUserNewPostPage;
import po.ConduitUserSettingsPage;
import utils.BrowserUtils;
import utils.PropertyFile;

/**
* This test class is to test Conduit new post page
*
* @author  Ankur Dubey
* @version 1.0
* @since   2019-11-03
*/

public class TestConduitUserNewPostPage extends TestBase{
	
	ConduitLandingPage cLandingPageObject;
	ConduitSignInPage cSignInPageObject;
	ConduitSignUpPage cSignUpPageObject;
	ConduitUserNavbarPage cUserNavbarPageObject;
	ConduitUserHomePage cUserHomePageObject;
	ConduitUserNewPostPage cUserNewPostPageObject;
	ConduitUserSettingsPage cUserSettingsPageObject;
	ConduitPostArticlePage cPostArticlePageObject;
	
	// To verify Page and it's locators/components
	@Test
	public void tc13VerifyUserNewPostPageTest() {
		
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
	
	// To verify new post by user
	@Test(dependsOnMethods = {"tc13VerifyUserNewPostPageTest"})
	public void tc14VerifyPostedNewPostTest() {
	
		cUserNewPostPageObject = new ConduitUserNewPostPage(driver);
		cPostArticlePageObject = new ConduitPostArticlePage(driver);
		
		cUserNewPostPageObject.getArticleTitleInputBox().sendKeys("Article_Title");
		cUserNewPostPageObject.getArticleAboutInputBox().sendKeys("Article_About");
		cUserNewPostPageObject.getArticleTextArea().sendKeys("Article123");
		cUserNewPostPageObject.getArticleTagsInputBox().sendKeys("Article_Tag");
		cUserNewPostPageObject.getPublishArticleButton().click();
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(cPostArticlePageObject.getPostArticleHeader().getText(), "Article_Title");
		sa.assertEquals(cPostArticlePageObject.getPostArticleAuthorLink().getText(), PropertyFile.USERNAME);
		sa.assertEquals(cPostArticlePageObject.getPostArticleText().getText(), "Article123");
		sa.assertEquals(cPostArticlePageObject.getPostArticleEditLink().getText(), "Edit Article");
		sa.assertEquals(cPostArticlePageObject.getPostArtileDeleteButton().getText(), "Delete Article");
		sa.assertEquals(cPostArticlePageObject.getPostArticlePostCommentButton().getText(), "Post Comment");
		
		sa.assertTrue(cPostArticlePageObject.getPostArticleEditLink().isEnabled());
		sa.assertTrue(cPostArticlePageObject.getPostArtileDeleteButton().isEnabled());
		sa.assertTrue(cPostArticlePageObject.getPostArticlePostCommentButton().isEnabled());
		
		sa.assertAll();
		
		
	}
	
	// To verify edit post
	@Test(dependsOnMethods = {"tc14VerifyPostedNewPostTest"})
	public void tc15VerifyEditArticleTest() throws InterruptedException {
	
		cUserNewPostPageObject = new ConduitUserNewPostPage(driver);
		cPostArticlePageObject = new ConduitPostArticlePage(driver);
		
		cPostArticlePageObject.getPostArticleEditLink().click();
		BrowserUtils.waitForVisibilityOfElement(driver, cUserNewPostPageObject.getArticleTitleInputBox(), 10);
		BrowserUtils.waitForVisibilityOfElement(driver, cUserNewPostPageObject.getArticleTextArea(), 10);
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(cUserNewPostPageObject.getArticleAboutInputBox().isEnabled());
		sa.assertTrue(cUserNewPostPageObject.getArticleTagsInputBox().isEnabled());
		sa.assertTrue(cUserNewPostPageObject.getArticleTextArea().isEnabled());
		sa.assertTrue(cUserNewPostPageObject.getArticleTitleInputBox().isEnabled());
		
		Thread.sleep(2000);
		cUserNewPostPageObject.getArticleTitleInputBox().clear();
		cUserNewPostPageObject.getArticleTitleInputBox().sendKeys("Edit_Article_Title");
		cUserNewPostPageObject.getArticleTextArea().clear();
		cUserNewPostPageObject.getArticleTextArea().sendKeys("EditArticle123");
		cUserNewPostPageObject.getPublishArticleButton().click();
				
		BrowserUtils.waitForVisibilityOfElement(driver, cPostArticlePageObject.getPostArticleHeader(), 10);
		sa.assertTrue(cPostArticlePageObject.getPostArticleHeader().getText().contains("Edit_Article_Title"));
		sa.assertEquals(cPostArticlePageObject.getPostArticleAuthorLink().getText(), PropertyFile.USERNAME);
		sa.assertTrue(cPostArticlePageObject.getPostArticleText().getText().contains("EditArticle123"));
				
		sa.assertAll();
		
		
	}
	
	// To verify delete post
	@Test(dependsOnMethods = {"tc15VerifyEditArticleTest"})
	public void tc16VerifyDeleteArticleTest() throws InterruptedException {
	
		cUserHomePageObject = new ConduitUserHomePage(driver);	
		cPostArticlePageObject.getPostArtileDeleteButton().click();
		
		SoftAssert sa = new SoftAssert();
		
		BrowserUtils.waitForVisibilityOfElement(driver, cUserHomePageObject.getNoArticleMessage(), 5);
		sa.assertTrue(cUserHomePageObject.getNoArticleMessage().isDisplayed());
		
		sa.assertAll();
		
		
	}

}
