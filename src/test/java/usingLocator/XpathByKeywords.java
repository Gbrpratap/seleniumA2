package usingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class XpathByKeywords {

	public static void main(String[] args) throws InterruptedException {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the application
		driver.get("https://demoapps.qspiders.com/");
		
		//find the UI testing link and click on it
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		Thread.sleep(4000);
		
		//find the name, email, password field and enter sample value and click on submit
		
		driver.findElement(By.xpath("//input[contains(@class, 'bg-gray-50') and @id='name']")).sendKeys("selenium");
		
		driver.findElement(By.xpath("//input[@type='email' and @id='email']")).sendKeys("sel123@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='password' and @type='password']")).sendKeys("123456");
		
		driver.findElement(By.xpath("//button[@type='submit' and text()='Register']")).click();
		
		//close the browser
		driver.quit();
		

	}

}
