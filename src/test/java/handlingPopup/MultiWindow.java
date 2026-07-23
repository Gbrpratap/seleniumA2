package handlingPopup;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class MultiWindow {
	
	//scenario: go to shoppersstack mobile webpage, click on compare and go to ebay webpage and search for mobile after that come to main webpage and click on buy now
	
	@Test
	public void shoperStackPopup() {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the application
		driver.get("https://shoppersstack.com/products_page/51");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//get parent window id
		String parentWinID = driver.getWindowHandle();
		
		//click on compare button
		driver.findElement(By.id("compare")).click();
		
		//store the windows id
		Set<String> st = driver.getWindowHandles();
		
		//iterate the window ids and validate it
		for(String s : st) {
			driver.switchTo().window(s);
			if(driver.getCurrentUrl().contains("ebay")) {
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//input[@placeholder=\"Search for anything\"]")).sendKeys("mobile" + Keys.ENTER);
			}
		}
		
		//switch to the parent window
		driver.switchTo().window(parentWinID);
		
		//click on buy now button
		driver.findElement(By.id("Buy Now")).click();
		
		//close the browser
		driver.quit();
		
		
	}

}
