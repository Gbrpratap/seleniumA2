package usingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DemoAppQspLogin {

	public static void main(String[] args) throws InterruptedException {
				//Launch the browser
				WebDriver driver = new EdgeDriver();
				
				//maximize the window
				driver.manage().window().maximize();
				
				//navigate to the application
				driver.get("https://demoapps.qspiders.com/ui/login");
				
				Thread.sleep(10000);
				
				//locate the email text field and enter email
				driver.findElement(By.id("email")).sendKeys("selenium@gmail.com");

				//locate the password text field and enter password
				driver.findElement(By.id("password")).sendKeys("sel@123");
				
				//locate the Register button and click on it
//				driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/section/main/section/article[1]/aside/article/aside[2]/div/div/form/div[4]/button']")).click();
				driver.findElement(By.xpath("//button")).click();


	}

}
