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

/*
 * Clean code of the previous class FindElementsPracticeTest which contains lots of trial and error or improvements comments
 * I have also removed test scenario and test case comment so you can focus on test code
 * I have only included the best practice code with comment
 */

public class FindElementsProductionTest {
	
    WebDriver driver;
    WebDriverWait wait;
    
    private final String TARGET_BRAND = "samsung";
    private final String EXPECTED_CATEGORY = "Mobiles";
    
    @BeforeMethod
    public void setup() {
    	//Launch Edge browser window
		driver = new EdgeDriver();
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//Explicit wait statement
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
	
	@Test
	public void searchMobile() {
		//Navigate to Amazon.in
		driver.get("https://www.amazon.in/");
		
		//Click on today's deals
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Today's Deals"))).click();
		
		//Filter the mobiles
		String bubbleCategoryXpath = String.format("//button[text()='%s']", EXPECTED_CATEGORY );
		WebElement mobileBubble = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bubbleCategoryXpath)));
		mobileBubble.click();
		
		//Filter the departments
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Electronics']/../../i"))).click();
		
		//Expand the Brands
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-labelledby='see-more-brands-label']//a[text()='See more']"))).click();
		
		//Filter the brand
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Samsung']/ancestor::label"))).click();
		
		// ==========================================
		//           VALIDATION SECTION (ASSERTIONS)
		// ==========================================
		
		// Validation Point 1: Verify the Mobiles filter bubble is active
		String isPressed = mobileBubble.getDomAttribute("aria-pressed");
		Assert.assertEquals(isPressed, "true", "Assertion Failed: The 'Mobiles' filter bubble is not active");
		
		// Validation Point 2: Check that product cards actually loaded (Grid count > 0)
		By productCardLoader = By.cssSelector("div[data-testid='product-card']");
		List<WebElement> productCards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productCardLoader));
		
		Assert.assertTrue(productCards.size()>0, "Assertion Failed: Filter reuslt page grid is completely empty.");
		
		//Validation Point 3: Extract text from inside the real card
		int scanLimit = Math.min(productCards.size(), 5);
		
		for(int i=0; i<scanLimit; i++) {
			String visibleText = productCards.get(i).getText().toLowerCase();
			Assert.assertTrue(visibleText.contains(TARGET_BRAND), "Assertion Failed: Detected a leaked/non-matching item at position " + (i+1)+ " . Text found: " + visibleText);
		}
		
	}
	
	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
            System.out.println("Teardown Completed: Browser closed safely.");
        }
    }

}

