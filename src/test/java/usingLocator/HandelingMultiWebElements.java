package usingLocator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandelingMultiWebElements {

	public static void main(String[] args) throws InterruptedException {

		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to Amazon.in application
		driver.get("https://amazon.in/");
		
		//Stopping the execution for 3 seconds to see the execution
		Thread.sleep(3000);
		
		//click on Today's Deal link using full link and partial link
		List<WebElement> ele = driver.findElements(By.tagName("a"));

		for(WebElement link : ele) {
			if(link.getText().contains("Returns")) {
				link.click();
				break; //if we don't break it will iterate all remaining element which are not present after click and so we will get StaleElementReferenceException at runtime 
			}
		}
		
		//close the browser using quit method
		driver.quit();
		
	}

}
