package experienceSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumExceptionDemo {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void triggerNoSuchElementException() {
		System.out.println("--- Scenario 1: Triggering NoSuchElementException ---");
		driver.get("https://www.w3schools.com");
		
		try {
			//intentionally using an ID that does not exist
			WebElement fakeElement = driver.findElement(By.id("this-id-does-not-exist"));
			fakeElement.click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void triggerElementNotInteractableException() {
		System.out.println("--- Scenario 2: triggering ElementNotInteractableException,\n the ElementNotVisibleException is depricated and not present in selenium 4 version");
		
		//navigating to a demo page
		driver.get("https://www.w3schools.com");
		
		//using findElement method to locate hidden webElements, below find the first hidden paragraph as there can be multiple hidden elements
		WebElement hiddenUpArrow  = driver.findElement(By.xpath("//a[@id='navbtn_tutorials']/i[contains(@class,'fa-caret-up')]"));
		
		System.out.println("Visibility check: Is the element visible to user on screen? " + hiddenUpArrow.isDisplayed());
		
		try {
			//Even if the hidden element is not visible we will try to interact with it
			hiddenUpArrow.click();	
		}catch(ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyDOMPresenceForHiddenElement() {
		driver.get("https://www.w3schools.com");
		
		//1. finding the hidden button 
		WebElement tutoiralsBtn = driver.findElement(By.id("navbtn_tutorials"));
		
		//2. Locate the hidden up-arrow icon inside it
		WebElement hiddenUpArrow = driver.findElement(By.xpath("//a[@id='navbtn_tutorials']/i[contains(@class,'fa-caret-up')]"));
		System.out.println("Before action - visibility check: " + hiddenUpArrow.isDisplayed());
		
		//3. Create an explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//4. Click the tutorials button to open the menu
		tutoiralsBtn.click();
		
		//5. condition to check the hidden up arrow icon element
		wait.until(ExpectedConditions.visibilityOf(hiddenUpArrow));
		
		System.out.println("");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		if(driver != null)
			driver.quit();
	}
	
}
