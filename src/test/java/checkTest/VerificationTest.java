package checkTest;
	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerificationTest {
    
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Launching the browser this file is to verify if testNG and selenium are working together
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyGoogleTitle() {
        driver.get("https://google.com");
        String actualTitle = driver.getTitle();
        System.out.println("Page Title is: " + actualTitle);
        
        // TestNG Verification assertion
        Assert.assertEquals(actualTitle, "Google", "Title match failed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
