package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseAndKey {

	@Test
	public void testActions() throws InterruptedException {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//navigate to the application
		driver.get("https://demoapps.qspiders.com/");
		
		//scroll the page using X and Y coordinates
		Actions act = new Actions(driver);
		act.scrollByAmount(100, 700).perform();
		Thread.sleep(3000);
		
		//scroll the webpage until the element is visible
		WebElement DBtest = driver.findElement(By.xpath("//p[contains(text(), 'Explore Web UI Testing')]"));
		act.scrollToElement(DBtest).perform();
		
		//close the browser
		driver.quit();

	}
	
	@Test
	public void testDemoApps() throws InterruptedException {
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//navigate to the application
		driver.get("https://demoapps.qspiders.com/ui/dragDrop?sublist=0");
		
		Thread.sleep(2000);
		
		//perform drag and drop action
		Actions act = new Actions(driver);
		WebElement dragBtn = driver.findElement(By.xpath("//div[text()='Drag Me']"));
		act.dragAndDropBy(dragBtn, 50, 50).perform();
		
		Thread.sleep(3000);
		//close the browser
		driver.quit();

		
		
	}
}
