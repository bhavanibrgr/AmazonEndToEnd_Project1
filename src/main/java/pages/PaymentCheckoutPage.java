package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentCheckoutPage {

	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//initialize constructor
    public PaymentCheckoutPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
	@FindBy(xpath="//span[@id='deliver-to-address-text']")
	private WebElement addressCheck;
	
	public boolean checkingAddress() {
		wait.until(ExpectedConditions.visibilityOf(addressCheck));
		String address=addressCheck.getText();
		boolean b1=address.contains("Bangalore");
		return b1;
	}
	
	@FindBy(xpath="//div[contains(@class, 'a-box a-sp')]")
	private List<WebElement> paymentModecheck;
	
	public boolean checkingPaymentMethod() {
		wait.until(ExpectedConditions.visibilityOfAllElements(paymentModecheck));
		WebElement element=paymentModecheck.get(1);
		boolean b1=element.isDisplayed();
		return b1;
	}
	
	@FindBy(xpath="//span[text()='Order Total:']")
	private WebElement orderTotal;
	
	public boolean orderTotalChecking() {
		wait.until(ExpectedConditions.visibilityOf(orderTotal));
		boolean b1=orderTotal.isDisplayed();
		return b1;
	}
	
	@FindBy(xpath="//div[contains(@class, 'a-section a-spacing-none p')]/preceding-sibling::div//input[@type='radio']")
	private List<WebElement> eachPaymentMethod;
	
	public boolean eachPaymentMethodSelectionCheck() {
		wait.until(ExpectedConditions.visibilityOfAllElements(eachPaymentMethod));
		WebElement element=eachPaymentMethod.get(0);
		element.click();
		boolean b1=element.isSelected();
		return b1;
	}
	@FindBy(xpath="//input[@placeholder='Enter Code']")
	private WebElement couponCodeCheck;
	
	public boolean checkingCouponcodeAndApply() {
		wait.until(ExpectedConditions.visibilityOf(couponCodeCheck));
		couponCodeCheck.sendKeys("Bhav123"+Keys.ENTER);
		boolean b1=couponCodeCheck.isEnabled();
		return b1;
	}
}
