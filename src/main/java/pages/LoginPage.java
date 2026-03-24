package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage{
    WebDriver driver;
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    
    public LoginPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath="//input[@aria-label='Enter mobile number or email']")
	private WebElement userName;
	
	
	public void enteringUsername(String username) {
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(username);
	}
	public void enteringValidUsername(String username) {
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(username);
	}
	
	@FindBy(id="continue")
	private WebElement continueButton;
	
	public void continueClick() {
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
	}
	
	@FindBy(name="password")
	private WebElement passwordfield;
	
	public void enteringPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordfield));
		passwordfield.sendKeys(password);
	}
	public void enteringInvalidPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordfield));
		passwordfield.sendKeys(password);
	}
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement signInButton;
	
	public void signInButtonClick() {
		wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		signInButton.click();
	}
	 
}
