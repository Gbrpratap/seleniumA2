package handlingPopup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JsAlertHandle {
	
	@Test
	public void jsAlter() {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the application
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//identify the alert button and click on it
		driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]")).click(); //if we don't click on this to trigger the popup and try to handle it we get NoAlertPresentException
	
		
		//handle the alert popup
		Alert al = driver.switchTo().alert();
		
		//click on ok button
		al.accept(); //if we don't handle popup we get UnhandledAlertException
		//or
		//al.dismiss();
		
		//identify result and print it
		String result = driver.findElement(By.id("result")).getText();
		System.out.println(result);
		
		//close the browser
		driver.quit();
		
	}

	
	@Test
	public void jsConfirm() {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the application
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//identify the alert button and click on it
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click(); //if we don't click on this to trigger the popup and try to handle it we get NoAlertPresentException
	
		
		//handle the alert popup
		Alert al = driver.switchTo().alert();
		
		//click on ok button
		//if we don't handle popup we get UnhandledAlertException
//		al.accept();
		//or
		al.dismiss();
		
		//identify result and print it
		String result = driver.findElement(By.id("result")).getText();
		System.out.println(result);
		
		//close the browser
		driver.quit();

	}
	
	@Test
	public void jsPrompt() {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the application
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//identify the alert button and click on it
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click(); //if we don't click on this to trigger the popup and try to handle it we get NoAlertPresentException
	
		
		//handle the alert popup
		Alert al = driver.switchTo().alert();
		
		//click on ok button
		//if we don't handle popup we get UnhandledAlertException
		//or
//		al.dismiss();
		
		//to input
		al.sendKeys("123456789");
		al.accept();
		
		//identify result and print it
		String result = driver.findElement(By.id("result")).getText();
		System.out.println(result);
		
		//close the browser
		driver.quit();
		
	}
	

}
