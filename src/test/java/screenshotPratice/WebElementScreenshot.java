package screenshotPratice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebElementScreenshot {
	
	
	@Test
	public void takeScreenshotOfElement() throws IOException {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to an application
		driver.get("https://amazon.in/");
		
		//Step 1 find the element by using locator and store in a reference variable
		// Explicit Wait to ensure the element is loaded completely
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logo-sprites")));
		
		//step 2 take the screenshot which will be stored in temporary folder
		File src = ele.getScreenshotAs(OutputType.FILE);
		
		//step 3 create an empty new file
		File dest = new File("./screenshot/amazonLogo.png");
		
		//step 4 save the file
//		FileUtils.copyFile(src, dest);
		FileHandler.copy(src, dest);
		
		//close the browser
		driver.quit();

		
	}

}
