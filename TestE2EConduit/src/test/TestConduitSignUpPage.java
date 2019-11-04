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
* This test class is to test Conduit sign up page
*
* @author  Ankur Dubey
* @version 1.0
* @since   2019-11-03
*/

public class TestConduitSignUpPage extends TestBase{
	
	ConduitLandingPage cLandingPageObject;
	ConduitSignUpPage cSignUpPageObject;
	ConduitCommonElements cCommonPageObject;
	ConduitErrorMessages cErrorMessagesObject;
	ConduitSignInPage cSignInPageObject;
	ConduitUserHomePage cUserHomePageObject;
	
	// To verify Page and it's locators/components
	@Test
	public void tc07VerifySignUpPageTest() {

		cLandingPageObject = new ConduitLandingPage(driver);
		cSignUpPageObject = new ConduitSignUpPage(driver);
		cCommonPageObject = new ConduitCommonElements(driver);
		
		SoftAssert sa = new SoftAssert();

		cLandingPageObject.getSignUpLink().click();
		sa.assertTrue(cSignUpPageObject.getSignUpHeader().getText().equals("Sign Up"));
		sa.assertTrue(cSignUpPageObject.getHaveAnAccountLink().getText().equals("Have an account?"));
		sa.assertTrue(cSignUpPageObject.getUserNameInputBox().getAttribute("placeholder").equals("Username"));
		sa.assertTrue(cCommonPageObject.getEmailInputBox().getAttribute("placeholder").equals("Email"));
		sa.assertTrue(cCommonPageObject.getPasswordInputBox().getAttribute("placeholder").equals("Password"));
		
		sa.assertTrue(cSignUpPageObject.getUserNameInputBox().isEnabled());
		sa.assertTrue(cCommonPageObject.getEmailInputBox().isEnabled());
		sa.assertTrue(cCommonPageObject.getPasswordInputBox().isEnabled());
		
		sa.assertAll();

	}
	
	// To verify error messages on page
	@Test(dependsOnMethods = {"tc07VerifySignUpPageTest"}, priority = 0)
	public void tc08VerifyErrorMessagesWhenSignUp() {
		
		cSignUpPageObject = new ConduitSignUpPage(driver);
		cCommonPageObject = new ConduitCommonElements(driver);
		cErrorMessagesObject = new ConduitErrorMessages(driver);
		
		SoftAssert sa = new SoftAssert();

		cSignUpPageObject.getSignUpButton().click();
		sa.assertTrue(cErrorMessagesObject.getEmailCantBeBlank().isDisplayed());
		sa.assertTrue(cErrorMessagesObject.getPasswordCantBeBlank().isDisplayed());
		sa.assertTrue(cErrorMessagesObject.getUsernameCantBeBlank().isDisplayed());
		
		sa.assertTrue(cErrorMessagesObject.getEmailCantBeBlank().getText().contains(ErrorMessages.EMAIL_CANT_BE_BLANK));
		sa.assertTrue(cErrorMessagesObject.getPasswordCantBeBlank().getText().contains(ErrorMessages.PASSWORD_CANT_BE_BLANK));
		sa.assertTrue(cErrorMessagesObject.getUsernameCantBeBlank().getText().contains(ErrorMessages.USERNAME_CANT_BE_BLANK));
		
	}
	
	// To verify navigation between pages
	@Test(dependsOnMethods = {"tc07VerifySignUpPageTest"} , priority = 1)
	public void tc09VerifyNavigationOnSignInPageFromHaveAnAccountLink() {
		
		cSignUpPageObject = new ConduitSignUpPage(driver);
		cSignInPageObject = new ConduitSignInPage(driver);
		
		SoftAssert sa = new SoftAssert();
		
		cSignUpPageObject.getHaveAnAccountLink().click();
		sa.assertEquals(cSignInPageObject.getSignInHeader().getText(), "Sign In");
		sa.assertTrue(cSignInPageObject.getNeedAnAccountLink().isDisplayed());
		sa.assertTrue(cSignInPageObject.getSubmitButton().isDisplayed());
		
		
	}
	
	// To verify error message fro already taken properties i.e. username and email
	@Test(dependsOnMethods = {"tc09VerifyNavigationOnSignInPageFromHaveAnAccountLink"})
	public void tc10VerifySignUpForAlreadyTakenErrorTest() {

		cLandingPageObject = new ConduitLandingPage(driver);
		cSignInPageObject = new ConduitSignInPage(driver);
		cUserHomePageObject = new ConduitUserHomePage(driver);
		cCommonPageObject = new ConduitCommonElements(driver);
		
		SoftAssert sa = new SoftAssert();
		
		cLandingPageObject.getSignUpLink().click();
		cSignUpPageObject.getUserNameInputBox().sendKeys(PropertyFile.USERNAME);
		cCommonPageObject.getEmailInputBox().sendKeys(PropertyFile.EMAIL);
		cCommonPageObject.getPasswordInputBox().sendKeys(PropertyFile.PASSWORD);
		cSignUpPageObject.getSignUpButton().click();
		
		sa.assertEquals(cErrorMessagesObject.getEmailAleadyTaken().getText(), ErrorMessages.EMAIL_ALREADY_TAKEN);
		sa.assertEquals(cErrorMessagesObject.getUsernameAlreadyTaken().getText(), ErrorMessages.USERNAME_ALREADY_TAKEN);
		
		sa.assertAll();
	}
	
	// To verify successful sign up
	@Test(dependsOnMethods = {"tc10VerifySignUpForAlreadyTakenErrorTest"})
	public void tc11VerifySuccessfulSignUpTest() {

		cLandingPageObject = new ConduitLandingPage(driver);
		cCommonPageObject = new ConduitCommonElements(driver);
		cUserHomePageObject = new ConduitUserHomePage(driver);
		SoftAssert sa = new SoftAssert();
		
		int randomNumber = (int)(Math.random() * 100);
		String randomEmail = "aello"+randomNumber+"@gmail.com";
		
		cLandingPageObject.getSignInLink().click();
		BrowserUtils.waitForVisibilityOfElement(driver, cSignInPageObject.getSignInHeader(), 10);
		cLandingPageObject.getSignUpLink().click();
		
		BrowserUtils.waitForVisibilityOfElement(driver, cSignUpPageObject.getSignUpHeader(), 10);
		cSignUpPageObject.getUserNameInputBox().sendKeys(PropertyFile.USERNAME+randomNumber);
		cCommonPageObject.getEmailInputBox().sendKeys(randomEmail);
		cCommonPageObject.getPasswordInputBox().sendKeys(PropertyFile.PASSWORD);
		cSignUpPageObject.getSignUpButton().click();
		
		sa.assertEquals(cUserHomePageObject.getUserNavbarConduitLink().getText(), "conduit");
		sa.assertTrue(cUserHomePageObject.getUserNavbarHomeLink().getText().contains("Home"));
		sa.assertTrue(cUserHomePageObject.getUserNavbarNewpostLink().getText().contains("New Post"));
		sa.assertTrue(cUserHomePageObject.getUserNavbarSettingsLink().getText().contains("Settings"));
		sa.assertTrue(cUserHomePageObject.getUserNavbarUsernameLink().getText().contains(PropertyFile.USERNAME));
		
		sa.assertAll();
	}

}
