package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utility.ListenersLogic;

public class BaseClass extends ListenersLogic{
		
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browser)  {
//		ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new"); // headless mode
        
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		if(browser.equals("edge"))
			driver=new EdgeDriver();
		if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
        
		driver.navigate().refresh();
		
		}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
				driver.quit();
	}
	}




