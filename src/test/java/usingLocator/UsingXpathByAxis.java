package usingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class UsingXpathByAxis {

	public static void main(String[] args) throws InterruptedException {
		//Launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to an application
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(3000);
						
		//locate the search bar and enter mobile and press enter using keys enum
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile" + Keys.ENTER);
		
		Thread.sleep(3000);
		
		//find price and store it by using ancestor and descendant
		WebElement priceAddress = driver.findElement(By.xpath("//span[contains(text(), 'Samsung Galaxy M07')]/ancestor::div[@class='puisg-col-inner']/descendant::span[@class='a-price-whole']"));
		
		//find price and store it by using parent and child
//		WebElement priceAddress = driver.findElement(By.xpath("//span[contains(text(), 'Samsung Galaxy M07')]/parent::h2/parent::a/parent::div/parent::div/child::div[@class='puisg-row puis-desktop-list-row']/child::div/child::div/child::div/child::div/child::div/child::a/child::span/child::span/child::span[@class='a-price-whole']"));
		
		//find price and store it by using forward and backward traversing
//		WebElement priceAddress = driver.findElement(By.xpath("//span[contains(text(), 'Samsung Galaxy M07')]/../../../../div[contains(@class, 'puisg-row puis')]/div/div/div/div/div/a/span/span/span[@class='a-price-whole']"));
		
		//find price and store it by using following and preceding sibling
//		WebElement priceAddress = driver.findElement(By.xpath("//span[contains(text(), 'Samsung Galaxy M07')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/div/following-sibling::div/following-sibling::div/descendant::span[@class='a-price']/span/following-sibling::span/span/following-sibling::span"));
		
		//print the price
		System.out.println(priceAddress.getText());
		
		//quit the browser
		driver.quit();
				
	}

}
