package dataDrivernTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import UsingWebDriverMethods.WebDriverUtilitites;
import pomUtility.POMDAReg; // Added import for your POM class

public class DemoAppsRegistration {

	public static void main(String[] args) throws IOException, InterruptedException {

		// step-01: convert physical file to java object
		FileInputStream fis = new FileInputStream("./src/test/resources/DemoApps.properties");

		// step-02: Create an empty property file
		Properties p = new Properties();

		// step-03: Load data from java object to property object
		p.load(fis);

		// step-04: Fetch the value using key from property object
		String browserName = p.getProperty("browser");
		String url = p.getProperty("url");
		String name = p.getProperty("name");
		String email = p.getProperty("email");
		String password = p.getProperty("password");
		
		// Note: Ensure this utility class exists in your project and controls a public 'driver' variable
		WebDriverUtilitites wdu = new WebDriverUtilitites();

		wdu.launchTheBrowser(browserName);
		wdu.maxTheWin();
		wdu.navigateTo(url);
		Thread.sleep(4000);
		
		// Validate the web page using POM
		POMDAReg demo = new POMDAReg(wdu.driver);
		if(demo.getHeader().equals("Register")) {
			System.out.println("Navigated to demo reg page");
		} else {
			System.out.println("Test fail");
		}
		
		// Optimized step: You can replace the individual steps below with your POM business logic method:
		// demo.Register(name, email, password);
		
		demo.getNameTF(name);
//		Thread.sleep(2000);

		demo.getEmailTF(email);
//		Thread.sleep(2000);

		demo.getPasswordTF(password);
//		Thread.sleep(2000);

		demo.getRegisterBtn();
		Thread.sleep(4000);
		
		wdu.quitWin();		 	
	}
}
