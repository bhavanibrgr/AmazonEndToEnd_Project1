package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.FirstProductPage;
import pages.HomePageAmazon;
import pages.SearchResultPage;
import utility.ListenersLogic;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)
public class TC10_ReachTillCartWithoutLogin extends BaseClass {

	Logger log = LogManager.getLogger(TC10_ReachTillCartWithoutLogin.class);

	@Test(retryAnalyzer = RetryLogic.class)
	public void withoutLoginReachCart() {
		HomePageAmazon home = new HomePageAmazon(driver);
		home.searchingProduct();
		log.info("product searched successfully");
		Reporter.log("product searched successfully");

		SearchResultPage search = new SearchResultPage(driver);
		search.click1stProduct_MovingControl(driver);
		log.info("Control moved to search result page");
		Reporter.log("Control moved to search result page");

		FirstProductPage firstproduct = new FirstProductPage(driver);
		firstproduct.addingToCart();
		log.info("Product added to cart");
		Reporter.log("Product added to cart");
        
		log.info("Reached till cart page without login");
		Reporter.log("Reached till cart page without login");
		
		  SoftAssert sa=new SoftAssert();
		  sa.assertTrue(driver.getTitle().contains("Cart"), "Assertion failed as the title not matched");
		  sa.assertAll();
		 

	}
}
