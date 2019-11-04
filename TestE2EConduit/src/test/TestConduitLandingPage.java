package test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import po.ConduitLandingPage;

/**
* This test class is to test Conduit landing page
*
* @author  Ankur Dubey
* @version 1.0
* @since   2019-11-03
*/

public class TestConduitLandingPage extends TestBase{
	
	ConduitLandingPage cLandingPageObject;
	
	// To verify title of the page
	@Test
	public void tc01TitleTest() {

		SoftAssert sa = new SoftAssert();
		String title = driver.getTitle();

		sa.assertTrue(title.equals("Conduit"));
		sa.assertAll();

	}

	// To verify Page and it's locators/components
	@Test
	public void tc02VerifyLandingPageTest() {

		cLandingPageObject = new ConduitLandingPage(driver);
		SoftAssert sa = new SoftAssert();
		
		sa.assertTrue(cLandingPageObject.getHomeLink().getText().equals("Home"));
		sa.assertTrue(cLandingPageObject.getSignInLink().getText().equals("Sign in"));
		sa.assertTrue(cLandingPageObject.getSignUpLink().getText().equals("Sign up"));
		sa.assertTrue(cLandingPageObject.getConduitHeader().getText().equals("conduit"));
		sa.assertTrue(cLandingPageObject.getConduitHeaderPara().getText().equals("A place to share your knowledge."));
		sa.assertTrue(cLandingPageObject.getConduitHomeLink().getText().equals("conduit"));
		sa.assertTrue(cLandingPageObject.getGlobalFeedLink().getText().equals("Global Feed"));
		sa.assertTrue(cLandingPageObject.getPopularTags().getText().equals("Popular Tags"));
		sa.assertEquals(cLandingPageObject.getAllArticles().size(), 10);
		sa.assertEquals(cLandingPageObject.getAllPopularTags().size(), 20);

		int allPaginationPages = cLandingPageObject.getAllPageLinks().size();
		List<WebElement> paginationLinks = cLandingPageObject.getAllPageLinks();
		for (int i = 0; i < allPaginationPages; i++) {
			int pageNumber = i + 1;
			sa.assertEquals(Integer.parseInt(paginationLinks.get(i).getText()), pageNumber);
		}

		sa.assertAll();
	}

}
