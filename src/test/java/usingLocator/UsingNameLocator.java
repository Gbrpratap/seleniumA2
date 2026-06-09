package usingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UsingNameLocator {

	public static void main(String[] args) {
		
		//Launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the application
		driver.get("https://www.facebook.com/");
		
		//locate the user name using name locator and enter username
		driver.findElement(By.name("email")).sendKeys("selenium");
		
		//locate the password using name locator and enter password
		driver.findElement(By.name("pass")).sendKeys("sel@123");
		
		//locate the login button and click on it
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		

	}

}
