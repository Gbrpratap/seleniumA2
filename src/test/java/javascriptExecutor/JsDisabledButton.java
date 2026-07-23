package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JsDisabledButton {
	
	
	@Test
	public void handleDisabledButton(){
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait for the elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//navigate to the application
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		
		//Go the disabled link page
		driver.findElement(By.xpath("//li[text()='Disabled']")).click();
		
		//identify the disabled text field
		WebElement disabledTF = driver.findElement(By.id("name"));
		
		
		//downcast to JavascriptExecutor interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].value=arguments[1]", disabledTF, "selenium");
		
		//navigate to the button utl
		js.executeScript("window.location='https://demoapps.qspiders.com/ui/button?sublist=0';");
		
		//click on disabled button
		driver.findElement(By.xpath("//a[text()='Disabled']")).click();
		
		//find the checkbox and click on it
		
		WebElement disBtn = driver.findElement(By.id("submit"));
		js.executeScript("arguments[0].removeAttribute('disabled')", disBtn);
		
		disBtn.click();
		
		//close the browser
		driver.quit();
				
		
		
		
	}

}
