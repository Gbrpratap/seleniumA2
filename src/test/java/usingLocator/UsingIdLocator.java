package usingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UsingIdLocator {

	public static void main(String[] args) {
		//If Id attribute value is in alpha numerical then it means it is dynamic ID and is discouraged to use

		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the application
		driver.get("https://www.facebook.com/");
		
		//locate the username and enter username
		driver.findElement(By.id("_R_1h6kqsqppb6amH1_")).sendKeys("selenium");
		
		//locate the password and enter the password
		driver.findElement(By.id("_R_1hmkqsqppb6amH1_")).sendKeys("sel@123");
		
		//locate login button and click on login
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		
		//close the browser
		driver.quit();
		
		
		
		
		
		
	}

}
