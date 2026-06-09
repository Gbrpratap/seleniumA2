package usingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UsingDirectLocator {

	public static void main(String[] args) throws InterruptedException {
		//Direct locator are id(), classname(), name(), linkText(), partialLinkText(), and tagname() these are direct locator as we are passing value directly not expression

		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to Amazon.in application
		driver.get("https://amazon.in/");
		
		//Stopping the execution for 3 seconds to see the execution
		Thread.sleep(3000);
		
		//click on Today's Deal link using full link and partial link
		driver.findElement(By.partialLinkText("Today's Deals")).click();
		
		Thread.sleep(3000);
		
		//close the browser using quit method
		driver.quit();
		
	}

}
