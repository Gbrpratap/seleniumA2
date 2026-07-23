package screenshotPratice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class WebPageScreenshot {
	
	@Test
	public void takeScreenshotOfWeb() throws IOException {
		
		//taking screenshot of the amazon web page without connecting to the internet
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		try {
			//maximize the window
			driver.manage().window().maximize();
			
			try {
				//navigate to an application
				driver.get("https://amazon.in/");
			}catch(WebDriverException e) {
				System.out.println("Loading the webpage failed");
			}
			//take screenshot of the error you faced
			
			//step 1 downcast the take screenshot interface to webdriver object reference variable
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			//step 2 take the screenshot which will be stored in temporary folder
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			//step 3 create an empty new file
			File dest = new File("./screenshot/amazonError.png");
			
			//step 4 save the file
//			FileUtils.copyFile(src, dest);
			FileHandler.copy(src, dest);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//close the browser
			if(driver != null)
				driver.quit();
		}
		
		
		
		
	}
}
	

