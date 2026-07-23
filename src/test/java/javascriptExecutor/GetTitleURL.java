package javascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class GetTitleURL {
	
	@Test
	public void getTitleAndUrl() {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the url using js executor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.location='https://in.bookmyshow.com/explore/home/hyderabad';");
		
		//get browser title and url
		System.out.println(js.executeScript("return document.title"));
		
		System.out.println(js.executeScript("return document.URL"));
		
	}

}
