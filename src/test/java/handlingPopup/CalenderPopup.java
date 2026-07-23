package handlingPopup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CalenderPopup {
	
	@Test
	public void calenderPopup() throws InterruptedException {
	    WebDriver driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    
	    // Explicit wait initialization
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    driver.get("https://www.makemytrip.com/flights/");
	    
	    // Close initial modal banner
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='commonModal__close']"))).click();
	    
	    // 1. Handle "From" City
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='From']"))).click();
	    WebElement fromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From']")));
	    fromInput.sendKeys("hyderabad");
	    
	    // Wait for dropdown and select airport
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'Rajiv') or contains(text(), 'HYD')]"))).click();
	    
	    //sometimes make my trip is giving popup this click is to exit that popup
//	    driver.findElement(By.id("root")).click();
	    
	    // 2. Handle "To" City (Fixes the Intercepted Exception)
	    WebElement toField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='toCity']")));
	    toField.click();
	 
	    WebElement toInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='To']")));
	    toInput.sendKeys("bengaluru");
	    
	    // Select the airport from the suggestions list
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'Bengaluru') or contains(text(), 'BLR')]"))).click();
	    
//	    wait.until(ExpectedConditions.elementToBeClickable(By.id("departure"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label=\"Mon Aug 17 2026\"]/..//p[text()='17']"))).click();
	    
	    Thread.sleep(3000);
	    
	    //search the flights
	    driver.findElement(By.xpath("//a[text()='Search']")).click();
	    
	    Thread.sleep(3000);
	    
	    //close the driver
//	    driver.quit();
	    
	}

}
