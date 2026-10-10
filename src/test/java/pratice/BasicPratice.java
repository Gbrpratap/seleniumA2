package pratice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicPratice {
	
	@Test
	public void pratice() {
		WebDriver driver = new EdgeDriver();
		driver.get("https://amazon.in/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean isTitlePresent = wait.until(ExpectedConditions.titleContains("Amazon.in"));
		Assert.assertTrue(isTitlePresent, "Title did not contain amazon.in");
		driver.quit();	
	}
	
	@Test
	public void navigateTest() {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com/");
		driver.navigate().to("https://amazon.in/");
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean isTitlePresent = wait.until(ExpectedConditions.titleContains("Google"));
		Assert.assertTrue(isTitlePresent, "Title does not contains Google");
		driver.quit();
	}
	
	@Test
	public void exercise() {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean isTitlePresent = wait.until(ExpectedConditions.titleContains("Google"));
		Assert.assertTrue(isTitlePresent, "The title does not contains Google");
		driver.navigate().refresh();
		driver.quit();	
	}
}
