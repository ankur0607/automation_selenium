package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import po.ConduitCommonElements;
import po.ConduitErrorMessages;
import po.ConduitLandingPage;
import po.ConduitSignInPage;
import po.ConduitSignUpPage;
import utils.ErrorMessages;

public class TestConduitSignUpPage extends TestBase{
	
	ConduitLandingPage cLandingPageObject;
	ConduitSignUpPage cSignUpPageObject;
	ConduitCommonElements cCommonPageObject;
	ConduitErrorMessages cErrorMessagesObject;
	ConduitSignInPage cSignInPageObject;
	
	@Test
	public void tc06VerifySignUpPageTest() {

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
	
	@Test(dependsOnMethods = {"tc06VerifySignUpPageTest"}, priority = 0)
	public void tc07VerifyErrorMessagesWhenSignUp() {
		
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
	
	@Test(dependsOnMethods = {"tc06VerifySignUpPageTest"} , priority = 1)
	public void tc08VerifyNavigationOnSignInPageFromHaveAnAccountLink() {
		
		cSignUpPageObject = new ConduitSignUpPage(driver);
		cSignInPageObject = new ConduitSignInPage(driver);
		
		SoftAssert sa = new SoftAssert();
		
		cSignUpPageObject.getHaveAnAccountLink().click();
		sa.assertEquals(cSignInPageObject.getSignInHeader().getText(), "Sign In");
		sa.assertTrue(cSignInPageObject.getNeedAnAccountLink().isDisplayed());
		sa.assertTrue(cSignInPageObject.getSubmitButton().isDisplayed());
		
		
	}

}
