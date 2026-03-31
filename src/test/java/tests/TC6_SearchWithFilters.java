package tests;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.HomePageAmazon;
import pages.LoginPage;
import pages.SearchResultPage;
import utility.ListenersLogic;
import utility.LoginDataProviderFromExcel;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)
public class TC6_SearchWithFilters extends BaseClass{
     Logger log=LogManager.getLogger(TC6_SearchWithFilters.class);
     
	@Test(dataProvider = "loginDataprovider", dataProviderClass = LoginDataProviderFromExcel.class, 
			retryAnalyzer = RetryLogic.class)
	public void searchProductWithFilters(String username, String password, String type) {
	
		HomePageAmazon home=new HomePageAmazon(driver);
		home.hoverOverOnAccountAndList(driver);
		log.info("hover over is done");
		home.signInClick();
		Reporter.log("hover over is done");
		
		LoginPage login=new LoginPage(driver);
		Reporter.log("Running vali-valid data");
		login.enteringUsername(username);
		login.continueClick();
		login.enteringPassword(password);
		login.signInButtonClick();
		log.info("username and password entered successfully");
		Reporter.log("username and password entered successfully");
		home.searchingProduct();
		
		log.info("product searched successfully");
		Reporter.log("product searched successfully");
		
		
		SearchResultPage search=new SearchResultPage(driver);
		search.filterWithBrand();
		
		log.info("Filtered required brand name successfully");
		Reporter.log("Filtered required brand name successfully");
		SoftAssert sa=new SoftAssert();
		
		List<String> productnames=search.brandNameCheck();
		for (String name: productnames) {
			sa.assertTrue(name.contains("puma"), "product name mismatched "+name);
		}
		sa.assertAll();
		
	}
}
