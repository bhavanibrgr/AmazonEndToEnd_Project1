package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.HomePageAmazon;
import pages.LoginPage;
import utility.LoginDataProviderFromExcel;
import utility.ListenersLogic;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)
public class TC2_LoginFailWithInvalidCred extends BaseClass{
	Logger log= LogManager.getLogger(TC2_LoginFailWithInvalidCred.class);
	
     @Test(dataProvider = "loginDataprovider", dataProviderClass = LoginDataProviderFromExcel.class,
    		 retryAnalyzer = RetryLogic.class)
	public void loginWithInvalidCred(String username, String password, String type) {
		
    	HomePageAmazon home=new HomePageAmazon(driver);
 		home.hoverOverOnAccountAndList(driver);
 		log.info("hover over is done");
 		home.signInClick();
 		
 		LoginPage login=new LoginPage(driver);
 		login.enteringValidUsername(username);
 		login.continueClick();
 		login.enteringInvalidPassword(password);
 		login.signInButtonClick();
 		log.info("valid username and invalid password entered successfully");
 		
 		SoftAssert sa=new SoftAssert();
 		sa.assertEquals(driver.getCurrentUrl(), "https://www.amazon.in/ap/signin", "Assertion failed as url is not matching");
 	    sa.assertAll();
	}
}
