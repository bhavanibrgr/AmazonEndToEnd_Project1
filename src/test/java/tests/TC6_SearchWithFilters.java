package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.HomePageAmazon;
import pages.LoginPage;
import utility.LoginDataProviderFromExcel;
import utility.RetryLogic;
public class TC6_SearchWithFilters extends BaseClass{
     Logger log=LogManager.getLogger(TC6_SearchWithFilters.class);
     
	@Test(dataProvider = "loginDataProvider", dataProviderClass = LoginDataProviderFromExcel.class, 
			retryAnalyzer = RetryLogic.class)
	public void searchProductWithFilters(String username, String password, String type) {
	
		HomePageAmazon home=new HomePageAmazon(driver);
		home.hoverOverOnAccountAndList(driver);
		log.info("hover over is done");
		home.signInClick();
		
		LoginPage login=new LoginPage(driver);
		Reporter.log("Running vali-valid data");
		login.enteringUsername(username);
		login.continueClick();
		login.enteringPassword(password);
		login.signInButtonClick();
		log.info("username and password entered successfully");
	}
}
