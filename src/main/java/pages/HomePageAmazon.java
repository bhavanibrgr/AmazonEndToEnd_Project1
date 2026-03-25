package pages;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageAmazon {
    WebDriver driver;
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    //initialize constructor
    public HomePageAmazon(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    //hover over
	@FindBy(xpath="//div[@id='nav-link-accountList']")
	private WebElement accountAndList;
	
	public void hoverOverOnAccountAndList(WebDriver driver) {
		wait.until(ExpectedConditions.visibilityOf(accountAndList));
		Actions action=new Actions(driver);
		action.moveToElement(accountAndList).perform();
	}
	
	//signIn
	@FindBy(xpath="//a[@class='nav-action-signin-button']")
	private WebElement signIn;
	
	public void signInClick() {
		wait.until(ExpectedConditions.elementToBeClickable(signIn));
		signIn.click();
	}
	
	//SearchProduct
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchingProduct;
	
	public void searchingProduct() {
		wait.until(ExpectedConditions.visibilityOf(searchingProduct));
		searchingProduct.sendKeys("shoe"+Keys.ENTER);
	}
	
	//Click on Manage profiles under account and list
	@FindBy(xpath="//span[@id='selectProfileModalId']/descendant::button")
	private WebElement manageProfilesClick;
	
	public void manageProfilesClick() {
		wait.until(ExpectedConditions.visibilityOf(manageProfilesClick));
		manageProfilesClick.click();
	
	}
	//Click on account holder name
	@FindBy(xpath="//div[text()='Bhavani G R']")
	private WebElement ClickOnAccountHolderName;
	
	public void accoundHolderNameClick() {
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnAccountHolderName));
		ClickOnAccountHolderName.click();

	}
	//click on profile
	@FindBy(xpath="//span[@id='selectProfileModalId']//div[@role='button']")
	private WebElement clickOnProfile;
	
	public void clickingOnProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(clickOnProfile));
		clickOnProfile.click();
	}
	//click on view button
	@FindBy(xpath="//a[text()='View']")
	private WebElement viewLinkClick;
	
	public void viewLinkClick() {
		wait.until(ExpectedConditions.visibilityOf(viewLinkClick));
		viewLinkClick.click();
	}
}
