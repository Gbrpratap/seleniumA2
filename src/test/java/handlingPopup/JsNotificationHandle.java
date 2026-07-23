package handlingPopup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class JsNotificationHandle {
	
	@Test
	public void jsNotifyHandle() {
		
		EdgeOptions opt = new EdgeOptions();
		opt.addArguments("--disable-notifications");
//		opt.addArguments("--disable-geolocation");
		
		//launch the browser
		WebDriver driver = new EdgeDriver(opt);
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//navigate to an application
		driver.get("https://demoapps.qspiders.com/ui/browserNot?sublist=0");
		
		//idenify the notification button and click on it
		driver.findElement(By.id("browNotButton")).click();
		
		//close the browser
		driver.quit();
	}

}
