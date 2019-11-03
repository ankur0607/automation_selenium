package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import po.ConduitCommonElements;
import po.ConduitErrorMessages;
import po.ConduitLandingPage;
import po.ConduitSignInPage;
import po.ConduitSignUpPage;
import utils.ErrorMessages;

public class TestConduitSignInPage extends TestBase{
	
	ConduitLandingPage cLandingPageObject;
	ConduitSignInPage cSignInPageObject;
	ConduitSignUpPage cSignUpPageObject;
	ConduitCommonElements cCommonPageObject;
	ConduitErrorMessages cErrorMessagesObject;
	
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

}
