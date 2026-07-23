package handlingPopup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JsAuthHandle {
	
	@Test
	public void JsAuthScript() {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the url
		driver.manage().window().maximize();
		
		//navigate to an application
		driver.get("https://admin:admin@basic-auth-git-main-shashis-projects-4fa03ca5.vercel.app/");
		
		//close the browser
		driver.quit();
		
	}

}
