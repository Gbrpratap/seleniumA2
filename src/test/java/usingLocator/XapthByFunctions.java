package usingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class XapthByFunctions {

	public static void main(String[] args) throws InterruptedException {
		
		/*In normal browser the login popup of flipkart does not appear but in automated browser it appears
		 * and if I open incognito browser the pop up appears so from this we can derive a best pratice
		 * like if we want to test the web application we should open in incognito window
		 */
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the application
		driver.get("https://www.flipkart.com/");
		
		Thread.sleep(3000);
		
		//close the popup
		driver.findElement(By.xpath("//span[@role='button']")).click();
		
		//find the search bar and input sample product name
		driver.findElement(By.xpath("//input[contains(@title, 'Search for Products') and @type='text']")).sendKeys("shoes");
		
		//find the search icon svg and click on it
		driver.findElement(By.xpath("//*[name() = 'svg'][@width='24' and @fill='none']")).click();	
		
		//close the browser
		driver.quit();
	}

}
