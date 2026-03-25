package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.HomePageAmazon;
import pages.LoginPage;
import pages.SearchResultPage;
import utility.LoginDataProviderFromExcel;
import utility.ListenersLogic;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)
public class TC5_VerifyingProductDetailPage extends BaseClass{

	Logger log = LogManager.getLogger(TC5_VerifyingProductDetailPage.class);
	@Test( dataProvider = "loginDataprovider", dataProviderClass = LoginDataProviderFromExcel.class
	   		  , retryAnalyzer = RetryLogic.class)
	public void verifyProductDetails(String username, String password, String type){
	
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
