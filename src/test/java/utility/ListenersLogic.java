package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersLogic implements ITestListener{
	  public static WebDriver driver;
	  
//	  common method to take screenshot
	  static String pathOfScreenshot(String status) {

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		String path = System.getProperty("user.dir") 
				+ "/screenshots/" + status + "/"+ timestamp+"_";
		return path;
	}

	  @Override
		public void onTestSuccess(ITestResult result) {
			
			TakesScreenshot ts= (TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			String path1=pathOfScreenshot("Pass");
			File destination=new File(path1+result.getName()+".png");
			
			try {
				FileHandler.copy(source, destination);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			ITestListener.super.onTestSuccess(result);
		}

		@Override
		public void onTestFailure(ITestResult result) {
			
			TakesScreenshot ts= (TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			String path1=pathOfScreenshot("Fail");
			File destination=new File(path1+result.getName()+".png");
			try {
				FileHandler.copy(source, destination);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			ITestListener.super.onTestFailure(result);
		}

}





