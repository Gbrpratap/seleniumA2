package waitStatements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWait {
	
	@Test
	public void explicitWait() throws InterruptedException {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the application
		driver.get("https://shoppersstack.com/");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//find the login button
		WebElement loginBtn = driver.findElement(By.id("loginBtn"));
		
		//explicitly wait for the login button to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		//wait until the title is visible
		wait.until(ExpectedConditions.titleContains("ShoppersStack"));
		
		//condition for the button to be visible
//		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		
		//condition for the element to be enabled
//		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
				
		//click on login button
		loginBtn.click();
		
		Thread.sleep(3000);
		
		//close the browser
		driver.quit();
		
		
		
		
	}

}
