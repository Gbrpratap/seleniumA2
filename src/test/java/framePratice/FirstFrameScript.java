package framePratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class FirstFrameScript {
	
	@Test
	public void handleFrame() throws InterruptedException {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to the webpage
		driver.get("https://www.zomato.com/india");
		
		//identify the login-in button and click on it
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		
		//switch the driver controller to login frame by using ID
//		driver.switchTo().frame("auth-login-ui");
		
		//switch using web element
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@id='auth-login-ui']"));
		driver.switchTo().frame(frameEle);
		
		//identify the phone number text field
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1234567890");

		Thread.sleep(2000);
		
		//click on close frame 
		driver.findElement(By.xpath("//i[@aria-label='close Modal']")).click();
		
		//switch back to main page directly
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		//find the add restaurant link and click on it
		driver.findElement(By.xpath("//a[contains(text(), \"Add restaurant\")]")).click();
		
		Thread.sleep(2000);
		
		//close the browser
		driver.quit();
		
	}

}
