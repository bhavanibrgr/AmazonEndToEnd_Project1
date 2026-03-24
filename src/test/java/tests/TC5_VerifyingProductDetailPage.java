package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.HomePageAmazon;
import pages.LoginPage;
import pages.SearchResultPage;
import utility.ExcelSheet;
import utility.ListenersLogic;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)
public class TC5_VerifyingProductDetailPage extends BaseClass{

	Logger log = LogManager.getLogger(TC3_EditTheProfileInfo.class);
	@Test( dataProvider = "loginData", dataProviderClass = ExcelSheet.class
	   		  , retryAnalyzer = RetryLogic.class)
	public void verifyProductDetails(String username, String password, String comments){
		if(!comments.equals("valid-valid")) {
   		 throw new SkipException("Skipping non-valid data");
		}
		HomePageAmazon home=new HomePageAmazon(driver);
		home.hoverOverOnAccountAndList(driver);
		log.info("hover over is done");
		home.signInClick();
		
		LoginPage login=new LoginPage(driver);
		login.enteringUsername(username);
		login.continueClick();
		login.enteringPassword(password);
		login.signInButtonClick();
		log.info("username and password entered successfully");
		
		home.searchingProduct();
		log.info("product searched successfully");
		
		SearchResultPage search=new SearchResultPage(driver);
		search.click1stProduct_MovingControl(driver);
		log.info("Control moved to search result page");
		
		SoftAssert sa=new SoftAssert();
		search.verifyAddToCart();
		sa.assertTrue(search.verifyAddToCart(), "Assertion failed as the add to cart button not displayed");
		sa.assertAll();
	}
}
