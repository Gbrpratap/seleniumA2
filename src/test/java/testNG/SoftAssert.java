package testNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class SoftAssert {
	
	@Test
	public void usingSoftAssert() {
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to myntra
		driver.get("https://www.myntra.com/");
		
		//soft assert
		org.testng.asserts.SoftAssert softVal = new org.testng.asserts.SoftAssert();
		
		String actualTitle = driver.getTitle();
		
		String expectedTitle = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
//		String expectedTitle = "ORandom";
		
		softVal.assertEquals(actualTitle, expectedTitle);
		
		//close the browser
		driver.quit();
		
		//mandatory statement to show errors
		softVal.assertAll();
		
		
		
		
	}
}
