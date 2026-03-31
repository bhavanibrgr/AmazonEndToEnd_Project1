package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//initialize constructor
    public CartPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
	//Click on proceed to buy
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	private WebElement proceedToBuyClick;
	
	public void clickingOnProceedToBuy() {
		wait.until(ExpectedConditions.elementToBeClickable(proceedToBuyClick)).click();
		
	}
}
