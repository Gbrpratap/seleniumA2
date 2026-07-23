package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Guru99 {
	
	@Test
	public void testGuruActions() throws InterruptedException {
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//navigate to the url
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		//right click the button
		Actions act = new Actions(driver);
		
		WebElement rightClickBtn =  driver.findElement(By.xpath("//span[contains(text(), 'right click me')]"));
		act.contextClick(rightClickBtn).perform();
		act.click(rightClickBtn);
		
		//double click on the button
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(), 'Double-Click Me')]"));
		act.doubleClick(doubleClickBtn).perform();
		Thread.sleep(3000);
		
		//close the browser
		driver.quit();
		
		
	}
	
	//hovering over i button
	@Test
	public void mouseHover() throws InterruptedException {
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//navigate to the application
		driver.get("https://demoapps.qspiders.com/ui/mouseHover?sublist=0");
		
		//hover over i image
		WebElement img = driver.findElement(By.xpath("//input[@placeholder='Enter Password']/../img[contains(@src, 'hint')]"));
		
		
		Actions act = new Actions(driver);
		act.moveToElement(img).perform();
		Thread.sleep(3000);
		
		//close the browser
		driver.quit();
	}
	
	//Task drang and drop and click and hold in demo apps "https://demoapps.qspiders.com/ui/dragDrop?sublist=0"

}
