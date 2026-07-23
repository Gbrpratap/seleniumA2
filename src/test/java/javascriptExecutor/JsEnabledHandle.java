package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JsEnabledHandle {

	
	@Test
	public void handleEnabledPage(){
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait for the elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//navigate to the application using javaScript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://demoapps.qspiders.com/ui?scenario=1';");
		
		//find the name text field and enter into the text field
		WebElement nameTF = driver.findElement(By.id("name"));
		js.executeScript("arguments[0].value=arguments[1]", nameTF, "selenium");
		
		//click on submit button
		WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Register']"));
		js.executeScript("arguments[0].click()", submitBtn);
		
		//close the browser
		driver.quit();
		
		
	}
}
