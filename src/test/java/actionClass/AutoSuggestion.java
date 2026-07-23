package actionClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutoSuggestion {
	
	@Test
	public void testGuruActions() throws InterruptedException {
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//navigate to the url
		driver.get("https://www.google.com/");
		
		//Locate the search box and type "java"
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("java");
		
		Thread.sleep(2000); 
		
		//Explicity wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
		
		//Find all suggestion elements using the common DOM structure
		List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@role='option']"));
		
		
		 //Iterate through the list to find the exact match
		for (WebElement suggestion : suggestions) {
			if(suggestion.getText().contains("compiler")) { 
				suggestion.click();
				break; //if we don't give this break the driver will search for next suggestion and it gives "StaleElementReferenceException" as the page got changed
			}
		}
		Thread.sleep(2000);
		
		//close the browser
		driver.quit();
		
		
	}

}
