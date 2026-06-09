package usingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UsingExpressionLocator{

	public static void main(String[] args) throws InterruptedException {
				//launch the browser
				WebDriver driver = new EdgeDriver();
				
				//maximize the window
				driver.manage().window().maximize();
				
				//navigate to facebook.ication
				
				driver.get("https://www.facebook.com/");
				
				//Stopping the execution for 3 seconds to see the execution
				Thread.sleep(3000);
				
				//find user name text and enter user name
				driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Selemmium");
				
				//find password and enter password 
				driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Selemmium");
				
				Thread.sleep(3000);
				
				
				
				//close the browser using quit method
				driver.quit();
				

	}

}
