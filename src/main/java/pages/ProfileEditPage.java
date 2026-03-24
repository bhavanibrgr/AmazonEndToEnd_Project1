package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileEditPage {
	 WebDriver driver;
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    //initialize constructor
	    public ProfileEditPage(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    }
	    
	@FindBy(xpath="//button[@class='edit-pencil-icon-button']")
	private WebElement editProfileClick;
	
	public void clickOnEditProfile(){
		wait.until(ExpectedConditions.elementToBeClickable(editProfileClick));
		editProfileClick.click();
	}
	
	@FindBy(id="editProfileNameInputId")
	private WebElement inputText;
	
	public void profileNameInput() {
		wait.until(ExpectedConditions.visibilityOf(inputText));
		inputText.clear();
		wait.until(ExpectedConditions.visibilityOf(inputText));
		inputText.sendKeys("Bhavani G R"+Keys.ENTER);
	}
}
