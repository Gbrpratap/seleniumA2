package pomUtilization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import pomUtility.DemoRegister;

public class DemoRegisterPage {

	public static void main(String[] args) throws InterruptedException {
		//Launch the browser
		WebDriver driver = new EdgeDriver();
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Navigate to the web application
		driver.get("https://demoapps.qspiders.com/ui");
		
		Thread.sleep(3000);
		
		DemoRegister RegisterDemo = new DemoRegister(driver);
		/*
		//Identify all the text field and enter sample text
		
		RegisterDemo.getName("Selenium");
		RegisterDemo.getEmail("sel123@gmail.com");
		RegisterDemo.getPassword("123456789");
		RegisterDemo.getButton();
		*/
		
		RegisterDemo.registerTest("Selenium", "sel123@gmail.com", "123456789");
		
		
		Thread.sleep(3000);
		
		//close the browser
		driver.quit();
		
		
		

	}

}
