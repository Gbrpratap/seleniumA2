package learningHtml;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UsingRelativePath {

	public static void main(String[] args) {
		
		//lauch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the application
		driver.get("file:///C:/GBR_drive%20E/Qspiders/selenium/sampleHtmlPage.html");
		
		//locate the user name text field and enter username
		driver.findElement(By.xpath("//input[1]")).sendKeys("pratap");
		
		//locate the password text field and enter password
		driver.findElement(By.xpath("//input[2]")).sendKeys("12345");
		
		//click on forgot link
		driver.findElement(By.xpath("//a")).click();
		
		//close the window
		driver.quit();

	}

}
