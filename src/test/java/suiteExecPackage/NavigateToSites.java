package suiteExecPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NavigateToSites {
	
	//cross browser testing, group and batch execution
	@Parameters("browsers")
	@Test(groups = "reg")
	public void navToAmazon(String browser) throws InterruptedException {
		WebDriver driver = null;
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		
		driver.get("https://amazon.in/");
		
		Thread.sleep(3000);
		
		driver.quit();
		
		Reporter.log("Amazon in " + browser, true);
	}
	
}
