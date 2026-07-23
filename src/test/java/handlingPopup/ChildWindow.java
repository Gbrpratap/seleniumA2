package handlingPopup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ChildWindow {
	
	@Test
	public void childWindow() {
		
		//launch the window
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to an application
		driver.get("https://www.flipkart.com/");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//close the login Modal Dialog (or a Modal Overlay)
		driver.findElement(By.xpath("//span[@class='b3wTlE']")).click();
		
		driver.findElement(By.xpath("//input[contains(@placeholder, 'Search for Products, Brands and More')]")).sendKeys("mobile");
		
		driver.findElement(By.xpath("//div[text()='Ai+ Pulse 2 (Purple, 64 GB)']")).click();
		
		
		
	}

}
