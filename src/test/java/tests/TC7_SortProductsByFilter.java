package tests;

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
public class TC7_SortProductsByFilter extends BaseClass{
     Logger log=LogManager.getLogger(TC7_SortProductsByFilter.class);
     
	@Test(dataProvider = "loginDataprovider", dataProviderClass = LoginDataProviderFromExcel.class, 
			retryAnalyzer = RetryLogic.class)
	public void applyingFilter(String username, String password, String type)  {
	
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
		
		search.genderFilter();
		log.info("Gender filter applied or sorted by gender");
		
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(search.verifyWomenCheckbox(), "Women filter not selected");
	    sa.assertAll();
		
	}
}
