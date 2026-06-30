package waitStatements;

import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ImplicitWait {
	
	@Test
	public void impWait() throws InterruptedException {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//navigate to an application
		driver.get("https://shoppersstack.com/");
		
//		Thread.sleep(10000);
		
		//find the login button and click on it
		driver.findElement(By.id("loginBtn")).click();
		
		Thread.sleep(3000);
		
		//close the browser
		driver.quit();
		
	}

}
