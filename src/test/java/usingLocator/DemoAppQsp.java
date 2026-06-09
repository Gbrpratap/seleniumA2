package usingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DemoAppQsp {

	public static void main(String[] args) throws InterruptedException {
		//here we automate register process using same credential we will try to login in next class
		
		//Launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the application
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		
		Thread.sleep(10000);
		
		//locate the name text field enter name
		driver.findElement(By.id("name")).sendKeys("selenium");
		
		//locate the email text field and enter email
		driver.findElement(By.id("email")).sendKeys("selenium@gmail.com");

		//locate the password text field and enter password
		driver.findElement(By.id("password")).sendKeys("sel@123");
		
		//locate the Register button and click on it
//		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/section/main/section/article[1]/aside/article/aside[2]/div/div/form/div[4]/button']")).click();
		driver.findElement(By.xpath("//button")).click();

	}

}
