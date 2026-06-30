package UsingWebDriverMethods;

import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtilitites {
	
	public WebDriver driver = null;
	
	/*
	//Launch the browser
	public void launchTheBrowser() {
		driver = new EdgeDriver();
	}
	*/
	
	   // Accept the browser name dynamically from your properties file
    public void launchTheBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver(); // This will launch Microsoft Edge
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Invalid browser name specified in properties file! Defaulting to Chrome.");
            driver = new ChromeDriver();
        }
    }
	
	//Maximize the window
	public void maxTheWin() {
		driver.manage().window().maximize();
	}
	
	//Navigate to the application
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	//Get title mehtods
	public String fetchTitle() {
		return driver.getTitle();
	}
	
	//get current URL method
	public String fetchCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	//Fetch the HTML source code of the webpage
	public String fetchSrc() {
		return driver.getPageSource();
	}
	
	//minimize the window
	public void minWin() {
		driver.manage().window().minimize();
	}
	
	//Refresh the window
	public void refreshWin() {
		driver.navigate().refresh();
	}
	
	//Enable the fullScreen window
	public void fullScreenWin() {
		driver.manage().window().fullscreen();
	}
	
	//Fetch the window size
	public Dimension getWinSize() {
		return driver.manage().window().getSize();
	}
	
	//Set the window size
	public void setWinSize(int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}
	
	//Fetch the window position
	public Point getWinPosition() {
		return driver.manage().window().getPosition();
	}
	
	//Set the window position
	public void setWinPosition(int x, int y) {
		driver.manage().window().setPosition(new Point(x, y));
	}
	
	//Navigate the an application
	public void navigateToApp(String url) {
		driver.navigate().to(url);
	}
	
	//Navigate to an app/URL
	public void navigateToAppUrl(String url) {
		driver.navigate().to(url);
	}
	
	//Go to the next page
	public void navigateForward() {
		driver.navigate().forward();
	}
	
	//Go to the back page
	public void navigateBack() {
		driver.navigate().back();
	}
	
	//Move the driver controller
	public void moveController(String ID) {
		driver.switchTo().window(ID);
	}
	
	//Get the single window ID
	public String getWinID() {
		return driver.getWindowHandle();
	}
	
	//Get alll the window Ids
	public Set<String> getAllWinIDs() {
		return driver.getWindowHandles();
	}
	
	//close the browser
	public void closeWin() {
		driver.close();
	}
	
	//Quit the browser
	public void quitWin() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	

}
