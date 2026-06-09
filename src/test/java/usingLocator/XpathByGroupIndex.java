package usingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class XpathByGroupIndex {

	public static void main(String[] args) throws InterruptedException {
		//In this program I am registering and login into a demo application using Xpath by group indexing
		
			//Launch the browser
			WebDriver driver = new EdgeDriver();
			
			//maximize the window
			driver.manage().window().maximize();
			
			//navigate to an application
			driver.get("https://demoapps.qspiders.com/ui?scenario=1");
			
			Thread.sleep(10000);
			
			//locate name, email and password text field and enter sample text
			
			driver.findElement(By.xpath("(//input)[1]")).sendKeys("Selenium");

			driver.findElement(By.xpath("(//input)[2]")).sendKeys("sele@gmail.com");
			
			driver.findElement(By.xpath("(//input)[3]")).sendKeys("sel@123");
			
			driver.findElement(By.xpath("(//button)[1]")).click();
			
			//after clicking on register use the same credential to login
			Thread.sleep(3000);
			
//				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sele@gmail.com");
			driver.findElement(By.xpath("(//input)[1]")).sendKeys("sele@gmail.com");
			
//				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("sele@123");
			driver.findElement(By.xpath("(//input)[2]")).sendKeys("sele@123");
			
//				driver.findElement(By.xpath(("//button[text() = 'Login']"))).click();
			driver.findElement(By.xpath(("(//button)[1]"))).click();
			
			Thread.sleep(3000);
			
			//quit the browser
			driver.quit();

	}

}
