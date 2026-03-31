package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.CartPage;
import pages.FirstProductPage;
import pages.HomePageAmazon;
import pages.LoginPage;
import pages.PaymentCheckoutPage;
import pages.SearchResultPage;
import utility.ListenersLogic;
import utility.LoginDataProviderFromExcel;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)
public class TC12_VerifyPaymentCheckout_PaymentMethod extends BaseClass{

	 Logger log=LogManager.getLogger(TC12_VerifyPaymentCheckout_PaymentMethod.class);
     
		@Test(dataProvider = "loginDataprovider", dataProviderClass = LoginDataProviderFromExcel.class, 
				retryAnalyzer = RetryLogic.class)
		public void verifyPaymentCheckout_PaymentMethod(String username, String password, String type)  {
		
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
			search.click1stProduct_MovingControl(driver);
			log.info("Control moved to search result page");
			Reporter.log("Control moved to search result page");
			
			FirstProductPage firstproduct=new FirstProductPage(driver);
			firstproduct.addingToCart();
			log.info("Product added to cart");
			Reporter.log("Product added to cart");
			
			CartPage cart=new CartPage(driver);
			cart.clickingOnProceedToBuy();
			log.info("Clicked on proceed to buy");
			Reporter.log("Clicked on proceed to buy");
			
			log.info("Checking payment method displayed");
			Reporter.log("Checking payment method displayed");
			
			PaymentCheckoutPage payment=new PaymentCheckoutPage(driver);
			SoftAssert sa=new SoftAssert();
			sa.assertTrue(payment.checkingPaymentMethod());
			sa.assertAll();
			
			
		}
}
