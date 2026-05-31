package learningHtml;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import UsingWebDriverMethods.WebDriverUtilitites;

public class UsingAbsolutePathForFlipkart {

	public static void main(String[] args) throws InterruptedException {
		//Task: find the flipkart search bar element and input product name text and search that product and don't quit

		/*
		 * Research comment:
		 * search bar input tag class name "nw1UBF v1zwn25"
		 * Search button class name "XFwMiH"
		 * 
		 * 
		 * Login popup close button xpath: "html/body/div[5]/div/span"
		 * xpath for search bar: "html/body/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/header/div/div/form/div/div/input"
		 * xpath for search button: html/body/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/header/div/div/form/div/button
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		WebDriverUtilitites winUtil = new WebDriverUtilitites();
		
		//Launch the browser
		winUtil.launchTheBrowser();
		
		//Maximize the window
		winUtil.maxTheWin();
		
		//navigate to the filpkart application
		winUtil.navigateTo("https://www.flipkart.com/");
		
		//Sleep thread for the popup to appear
		Thread.sleep(3000);
		
		//locate the login popup close button and click on it
		WebElement loginPopupClose = winUtil.driver.findElement(By.xpath("html/body/div[5]/div/span"));
		loginPopupClose.click();
		
		//locate the search input element and store it in a variable and input a sample product name
		WebElement searchBar = winUtil.driver.findElement(By.xpath("html/body/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/header/div/div/form/div/div/input"));
		searchBar.sendKeys("Puma Shoes black");
		
		//Locate the search button and click on it to search the product
		WebElement searchBtn = winUtil.driver.findElement(By.xpath("html/body/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/header/div/div/form/div/button"));
		searchBtn.click();
		
		//Sleep to see the result page
		Thread.sleep(3000);
		
		//Close the browser
		winUtil.quitWin();
		
		
		
		
	}

}
