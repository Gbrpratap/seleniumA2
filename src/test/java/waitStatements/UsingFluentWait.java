package waitStatements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class UsingFluentWait {
	
	@Test
	public void fluentWait() {
		
		//lanuch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to an application
		driver.get("https://shoppersstack.com/");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//fluent wait
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		
		wait.withTimeout(Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.ignoring(Exception.class);
		
		wait.until(ExpectedConditions.titleContains("ShoppersStack"));
		
		//find the login button
		WebElement loginBtn = driver.findElement(By.id("loginBtn"));
		
		loginBtn.click();
		
		//close the browser
		driver.quit();
		
	}

}
