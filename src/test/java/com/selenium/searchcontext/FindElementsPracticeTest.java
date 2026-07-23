package com.selenium.searchcontext;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElementsPracticeTest {
	
	/*
	 * Test Scenario ID : TS_AMZ_DEALS_001
	 * Description      : Verify dynamic multi-layered product filtering on the Amazon.in Today's deals engine.
	 * 
	 * Test Case ID     : TC_AMZ_FILTER_01
	 * Title            : Verify dynamic results update when applying sequential Department, Brand, and Category filters.
	 * Prerequisites    : Active network interface, browser driver initialized, viewport maximized.
	 * Test Data        : { Department: "Electronics", Brand: "Samsung", CategoryBubble: "Mobiles" }
	 * 
	 * Test Steps:
	 * 1. Navigate to base URL (https://www.amazon.in/).
	 * 2. Click the "Today's Deals" header navigation anchor link.
	 * 3. Expand the 'Departments' sidebar container, then select the radio option matching [Department].
	 * 4. Expand the 'Brands' sidebar container, then check the option matching [Brand].
	 * 5. Locate the horizontal carousel track and click the filter bubble matching [CategoryBubble].
	 * 
	 * Expected Result:
	 * - Each filter action triggers a partial DOM refresh without breaking page state.
	 * - Selected filters remain visually active (checked/pressed state active).
	 * - The product grid narrows down exclusively to items intersecting all three chosen parameters.
	 * 
	 * Validation Point:
	 * - Assert that the visible item count is greater than zero.
	 * - Assert that product titles harvested from the refreshed grid match the [Brand] text literal.
	 */

	
	// Declare driver globally at the class level so all methods can share it
    WebDriver driver;
    WebDriverWait wait;
    
 // Parameterized test data for easy maintenance
    private final String TARGET_BRAND = "samsung";
    private final String EXPECTED_CATEGORY = "Mobiles";
    
    @BeforeMethod
    public void setup() {
        // Initialization block - Runs before the test method
    	//Launch Edge browser window
		driver = new EdgeDriver();
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//implicit wait statement
//    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Explicit wait statement
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
	
	@Test
	public void searchMobile() {
		//Navigate to Amazon.in
		driver.get("https://www.amazon.in/");
		
		//Click on today's deals
//		driver.findElement(By.linkText("Today's Deals")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Today's Deals"))).click();
		
		//Filter the mobiles
//		driver.findElement(By.xpath("//button[text()='Mobiles']")).click();	
		
//		WebElement mobileBubble = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Mobiles']")));
		String bubbleCategoryXpath = String.format("//button[text()='%s']", EXPECTED_CATEGORY );
		WebElement mobileBubble = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bubbleCategoryXpath)));
		mobileBubble.click();
		
		//Expant the departments
//		driver.findElement(By.xpath("//button[@aria-labelledby='see-more-departments-label']//a[text()='See more']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-labelledby='see-more-departments-label']//a[text()='See more']"))).click();
		
		//Filter the departments
//		driver.findElement(By.xpath("//span[text()='Electronics']/../../i")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Electronics']/../../i"))).click();
		
		//Expand the Brands
//		driver.findElement(By.xpath("//button[@aria-labelledby='see-more-brands-label']//a[text()='See more']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-labelledby='see-more-brands-label']//a[text()='See more']"))).click();
		
		//Filter the brand
//		driver.findElement(By.xpath("//span[text()='Samsung']/../../i]")).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Samsung']/../../i"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Samsung']/ancestor::label"))).click();
		
		// ==========================================
		//           VALIDATION SECTION (ASSERTIONS)
		// ==========================================
		
		// Validation Point 1: Verify the Mobiles filter bubble is active
		// Amazon uses 'aria-pressed' attribute to track whether a bubble selection is active
//		String isPressed = mobileBubble.getAttribute("aria-pressed");
		String isPressed = mobileBubble.getDomAttribute("aria-pressed");
		Assert.assertEquals(isPressed, "true", "Assertion Failed: The 'Mobiles' filter bubble is not active");
		
		// Validation Point 2: Check that product cards actually loaded (Grid count > 0)
		// We use a broader CSS locator to find deal cards inside Amazon's search results container
		By productCardLoader = By.cssSelector("div[data-testid='product-card']");
		List<WebElement> productCards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productCardLoader));
		
		Assert.assertTrue(productCards.size()>0, "Assertion Failed: Filter reuslt page grid is completely empty.");
		
		//Validation Point 3: Extract text from inside the real card
		//checking upto 5 cards to validate becuase amazon uses dynamic scroll the more you scroll down the more product it loads so we are setting a limit
		int scanLimit = Math.min(productCards.size(), 5);
		
		/*
		for(int i=0; i<scanLimit; i++) {
//			 Amazon stores the full text inside an inner span; 
//			 fetching getText() on the card root extracts it automatically
			String cardText = productCards.get(i).getText().toLowerCase();
			
			//using getText() twice in one method is not effecient as getText() has to fecth data from live page again even though we already to that from above step
//			Assert.assertTrue(cardText.contains("samsung"), "Assertion Failed: Detected a leaked/non-matching item at position " + (i+1)+ " . Text found: " + productCards.get(i).getText());
		}
	*/
		
		for(int i=0; i<scanLimit; i++) {
			String visibleText = productCards.get(i).getText().toLowerCase();
			//original positive assert
			Assert.assertTrue(visibleText.contains(TARGET_BRAND), "Assertion Failed: Detected a leaked/non-matching item at position " + (i+1)+ " . Text found: " + visibleText);
			
			//Intentional negative assert
//			Assert.assertTrue(visibleText.contains("vivo"), "Assertion Failed: Detected a leaked/non-matching item at position " + (i+1)+ " . Text found: " + visibleText);
		
		}
		
	}
	
	@AfterMethod
    public void tearDown() {
        // This block is guaranteed to run even if assertions fail or errors occur inside searchMobile()
        if (driver != null) {
            driver.quit(); // Closes the browser window and cleanly kills the background driver process
            System.out.println("Teardown Completed: Browser closed safely.");
        }
    }

}
