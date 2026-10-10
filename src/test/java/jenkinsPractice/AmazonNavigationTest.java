
package jenkinsPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AmazonNavigationTest {

    WebDriver driver;

    @Test
    public void verifyAmazonPageOpens() {

    	String browser = System.getProperty("browser", "edge");

    	if (browser.equalsIgnoreCase("edge")) {
    	    driver = new EdgeDriver();
    	} else if (browser.equalsIgnoreCase("chrome")) {
    	    driver = new ChromeDriver();
    	} else {
    	    throw new IllegalArgumentException(
    	        "Unsupported browser: " + browser
    	    );
    	}

        driver.get("https://www.amazon.in/");

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(15)
        );

        wait.until(d -> d.getTitle().contains("Amazon.in"));

        String title = driver.getTitle();

        System.out.println("Amazon page title: " + title);

        Assert.assertTrue(
            title.contains("Amazon.in"),
            "Expected Amazon India page title, but got: " + title
        );
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
