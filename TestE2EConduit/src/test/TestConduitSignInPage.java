package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import po.ConduitCommonElements;
import po.ConduitErrorMessages;
import po.ConduitLandingPage;
import po.ConduitSignInPage;
import po.ConduitSignUpPage;
import po.ConduitUserHomePage;
import utils.BrowserUtils;
import utils.ErrorMessages;
import utils.PropertyFile;

/**
* This test class is to test Conduit sign in page
*
* @author  Ankur Dubey
* @version 1.0
* @since   2019-11-03
*/

public class TestConduitSignInPage extends TestBase{
	
	ConduitLandingPage cLandingPageObject;
	ConduitSignInPage cSignInPageObject;
	ConduitSignUpPage cSignUpPageObject;
	ConduitCommonElements cCommonPageObject;
	ConduitErrorMessages cErrorMessagesObject;
	ConduitUserHomePage cUserHomePageObject;
	
	// To verify Page and it's locators/components
	@Test
	public void tc03VerifySignInPageTest() {

		cLandingPageObject = new ConduitLandingPage(driver);
		cSignInPageObject = new ConduitSignInPage(driver);
		cCommonPageObject = new ConduitCommonElements(driver);
		
		SoftAssert sa = new SoftAssert();

		cLandingPageObject.getSignInLink().click();
		sa.assertTrue(cSignInPageObject.getSignInHeader().getText().equals("Sign In"));
		sa.assertTrue(cSignInPageObject.getNeedAnAccountLink().getText().equals("Need an account?"));
		sa.assertTrue(cSignInPageObject.getSubmitButton().getText().equals("Sign in"));
		sa.assertTrue(cCommonPageObject.getEmailInputBox().getAttribute("placeholder").equals("Email"));
		sa.assertTrue(cCommonPageObject.getPasswordInputBox().getAttribute("placeholder").equals("Password"));
		
		sa.assertTrue(cCommonPageObject.getEmailInputBox().isEnabled());
		sa.assertTrue(cCommonPageObject.getPasswordInputBox().isEnabled());
		sa.assertTrue(cSignInPageObject.getNeedAnAccountLink().isEnabled());
		sa.assertTrue(cSignInPageObject.getSubmitButton().isEnabled());
		
		sa.assertAll();

	}
	
	// To verify Error messages on page
	@Test(dependsOnMethods = {"tc03VerifySignInPageTest"}, priority = 0)
	public void tc04VerifyErrorMessageOnLogin() {
		
		cSignInPageObject = new ConduitSignInPage(driver);
		cCommonPageObject = new ConduitCommonElements(driver);
		cErrorMessagesObject = new ConduitErrorMessages(driver);
		
		SoftAssert sa = new SoftAssert();

		cSignInPageObject.getSubmitButton().click();
		sa.assertTrue(cErrorMessagesObject.getInvalidEmailOrPassword().isDisplayed());
		sa.assertTrue(cErrorMessagesObject.getInvalidEmailOrPassword().getText().contains(ErrorMessages.INVALID_EMAIL_OR_PASSWORD));
		
		sa.assertAll();
		
	}
	
	// To verify navigation between page
	@Test(dependsOnMethods = {"tc03VerifySignInPageTest"}, priority = 1)
	public void tc05VerifyNavigationOnSignUpPageFromNeedAnAccountLink() {
		
		cSignInPageObject = new ConduitSignInPage(driver);
		cSignUpPageObject = new ConduitSignUpPage(driver);
		
		SoftAssert sa = new SoftAssert();
		
		cSignInPageObject.getNeedAnAccountLink().click();
		sa.assertEquals(cSignUpPageObject.getSignUpHeader().getText(), "Sign Up");
		sa.assertTrue(cSignUpPageObject.getHaveAnAccountLink().isDisplayed());
		sa.assertTrue(cSignUpPageObject.getSignUpButton().isDisplayed());
		
		sa.assertAll();
		
	}
	
	// To verify successful sign in
	@Test(dependsOnMethods = {"tc05VerifyNavigationOnSignUpPageFromNeedAnAccountLink"})
	public void tc06VerifySuccessfulSignInTest() {

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

		sa.assertAll();
	}

}
