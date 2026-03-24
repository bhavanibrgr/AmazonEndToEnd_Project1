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
import utility.ExcelSheet;
import utility.ListenersLogic;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)
public class TC4_SearchingProductShoe extends BaseClass{
	
	Logger log = LogManager.getLogger(TC3_EditTheProfileInfo.class);
	@Test( dataProvider = "loginData", dataProviderClass = ExcelSheet.class
	   		  , retryAnalyzer = RetryLogic.class)
	public void searchingTheProduct(String username, String password, String comments) {
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
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(driver.getTitle(), "Amazon.in : shoe", "Assertion failed as the title is not matching");
		sa.assertAll();
	}
}
