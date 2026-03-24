package pages;

import java.time.Duration;
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
	
	//Clicking on first product from list
	@FindBy(xpath="//a[@class='a-link-normal s-no-outline']")
	private List<WebElement> allProducts;
	
	public void click1stProduct_MovingControl(WebDriver driver) throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOfAllElements(allProducts));
		Thread.sleep(2000);
		allProducts.get(0).click();
		Set<String> browserIds=driver.getWindowHandles();
		Iterator<String> ids=browserIds.iterator();
		String parentId=ids.next();
		
		String childId=ids.next();
		driver.switchTo().window(childId);
	}
	
	//initialize
	public SearchResultPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
