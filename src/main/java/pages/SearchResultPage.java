package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	WebDriver driver;
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//initialize
		public SearchResultPage (WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
	//Clicking on first product from list
	@FindBy(xpath="//a[@class='a-link-normal s-no-outline']")
	private List<WebElement> allProducts;
	
	public void click1stProduct_MovingControl(WebDriver driver) {
		//wait.until(ExpectedConditions.visibilityOfAllElements(allProducts));
		
		allProducts.get(0).click();
		Set<String> browserIds=driver.getWindowHandles();
		Iterator<String> ids=browserIds.iterator();
		String parentId=ids.next();
		
		String childId=ids.next();
		driver.switchTo().window(childId);
	}
	//add to cart button
	@FindBy(css="#add-to-cart-button")
	private WebElement addToCartVerification;
	
	public boolean verifyAddToCart() {
		return addToCartVerification.isDisplayed();
	}
	//Filtering brands
	@FindBy(xpath="//div[@id='brandsRefinements']//ul/child::span[@class='a-declarative']//a//i[@class='a-icon a-icon-checkbox']")
	private List<WebElement> filterBrands;
	
	public void filterWithBrand() {
		//wait.until(ExpectedConditions.visibilityOfAllElements(filterBrands));
		filterBrands.get(2).click();
	}
	//Assertion methods for checking brand name
	@FindBy(xpath="//span[contains(@class, 'a-size-base-plus')]")
	private List<WebElement> assertBrandName;
	
	public List<String> brandNameCheck() {
		wait.until(ExpectedConditions.visibilityOfAllElements(assertBrandName));
		
	    List<String> names = new ArrayList<>();

	    for (WebElement product : assertBrandName) {
	        names.add(product.getText().toLowerCase());
	    }

	    return names;
		
	}
	//Filtering by gender
		@FindBy(xpath="//div[@id='gender']//span[@class='a-declarative']//span//li[@class='a-spacing-micro']//i")
		private List<WebElement> filterbyGender;
		
		public void genderFilter() {
			filterbyGender.get(1).click();
		}
		
		@FindBy(xpath="//span[text()='Women']/preceding::input[1]")
		private WebElement checkboxForWomen;
		
		public boolean verifyWomenCheckbox() {
		
			
			return checkboxForWomen.isSelected();
		}
		
		
		
		
}
