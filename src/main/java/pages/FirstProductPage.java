package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstProductPage {
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//Wishlist
	@FindBy(xpath="//input[@aria-label='Add to Wish List']")
	private WebElement wishList;
//	
//	@FindBy(xpath="//span[text()='Create']")
//	private WebElement createButton;
	
	@FindBy(xpath="//input[@aria-label='Continue shopping']")
	private WebElement continueShoppingButton;
	
	public void wishListAddition() {
		wait.until(ExpectedConditions.elementToBeClickable(wishList));
		wishList.click();
//		createButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
		continueShoppingButton.click();
	}
	
	@FindBy(xpath="//span[@class='a-button a-button-primary attach-button-large attach-primary-cart-button']")
	private WebElement cartbutton;
	
	@FindBy (xpath="//a[contains(text(), 'Go to Cart')]")
	private WebElement goToCartClick;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addToCart;
	
	public void addingToCart(){
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();
		//wait.until(ExpectedConditions.elementToBeClickable(cartbutton));
		//cartbutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(goToCartClick));
		goToCartClick.click();
		
	}
	//Checking cart count
	@FindBy(xpath="//span[@data-a-selector='inner-value']")
	private WebElement productsInCart;
	
	public int cartCount(){
		
		String count=productsInCart.getText();
		int count1=Integer.parseInt(count);
		return count1;
	}
	//Clicking on + to increase count
	@FindBy(xpath="//span[@data-a-selector='increment-icon']")
	private WebElement increaseCartCount;
	
	public boolean quantityCheckInCart() {
		//Initial count
		wait.until(ExpectedConditions.visibilityOf(productsInCart));
		String count1=productsInCart.getText();
		int initialCount=Integer.parseInt(count1);
		//Clicking on + to increase count
		wait.until(ExpectedConditions.elementToBeClickable(increaseCartCount));
		increaseCartCount.click();
		//Updated count
		wait.until(ExpectedConditions.visibilityOf(productsInCart));
		String count2=productsInCart.getText();
		int updatedCount=Integer.parseInt(count2);
		return initialCount<updatedCount;
	}
	
		
	//initialize
	public FirstProductPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
