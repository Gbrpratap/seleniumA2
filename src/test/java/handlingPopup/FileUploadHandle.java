package handlingPopup;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FileUploadHandle {

	//using sendKeys method
	@Test
	public void handleFileUpload() throws InterruptedException {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to the application
		driver.get("https://the-internet.herokuapp.com/upload");
		
		//upload file
		driver.findElement(By.id("file-upload")).sendKeys("C:\\GBR_drive E\\Download\\js test script.jpeg");
		
		Thread.sleep(2000);
		
		//identify the upload button and click on it
		driver.findElement(By.id("file-submit")).submit();
		
		Thread.sleep(2000);
		
		//close the browser
		driver.quit();
	}
	
	@Test
	public void usingRobot() throws InterruptedException, AWTException {
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to the application
		driver.get("https://the-internet.herokuapp.com/upload");
		
		//copy the path temporarily to the clip board
		StringSelection str = new StringSelection("C:\\GBR_drive E\\Download\\js test script.jpeg");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		Thread.sleep(2000);
		
		//identify choose file button
		WebElement btn = driver.findElement(By.id("file-upload"));
		Actions act = new Actions(driver);
		act.click(btn).perform();
		
		Thread.sleep(2000);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		//click on upload button
		driver.findElement(By.id("file-submit")).click();
		
		//close the browser
		driver.quit();
	}
	
}
