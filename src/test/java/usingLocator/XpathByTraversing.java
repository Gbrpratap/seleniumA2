package usingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class XpathByTraversing {

	public static void main(String[] args) throws InterruptedException {
		/*
		Finding price of https://www.amazon.in/dp/B0CBVN2SCS?th=1&psc=1
		using xpath by traversing (independent and dependent xpath)

		//span[@id='productTitle']/../../../../../../div[@id='apex_desktop']/div/div/div[@id='corePriceDisplay_desktop_feature_div']/div/span/span/span[@class='a-price-whole']

		//span[text()='Skechers Women Summits Sneakers']/../../../../div[contains(@class,'a-section a-spacing-none a-spacing-top-small s-pr')]/div[@class='a-row a-size-base a-color-base']/div/a/span[@class='a-price']/span

		*/
		
		//Launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to an application
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(3000);
						
		//locate the search bar and enter ASIN
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("B0CBVN2SCS");
		
		//click on search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(3000);
		
		//find price and store it
		WebElement priceAddress = driver.findElement(By.xpath("//span[contains(text(),'Skechers Women Summits')]//ancestor::div[@data-component-type='s-search-result']//span[@class='a-price-whole']"));
						
		//print the price
		System.out.println(priceAddress.getText());
		
		//quit the browser
		driver.quit();
		


	}

}
