package testNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsingHardAssert {
	
	@Test
	public void hardAssert() {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to myntra
		driver.get("https://www.myntra.com/");
		
		//validate the title
		
		String actualTitle = driver.getTitle();
		
//		String expectedTitle = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
		String expectedTitle = "ORandom";
		/*
		if(actualTitle.contains(expectedTitle))
				System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
			
		*/
		
		//use hard assert
//		Assert.assertEquals(actualTitle, expectedTitle, "validating myntra home page title");
		Assert.assertNotEquals(actualTitle, expectedTitle);
		
		//close the browser
		driver.quit();
		
		
	}

}
