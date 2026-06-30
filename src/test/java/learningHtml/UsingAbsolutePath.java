package learningHtml;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import UsingWebDriverMethods.WebDriverUtilitites;

public class UsingAbsolutePath {

	public static void main(String[] args) {
		WebDriverUtilitites winUtil = new WebDriverUtilitites();
		
		//Launch the browser
//		winUtil.launchTheBrowser();
		
		//Maximize the window
		winUtil.maxTheWin();
		
		//navigate to the application
		winUtil.navigateTo("file:///C:/GBR_drive%20E/Qspiders/selenium/sampleHtmlPage.html");

		//Locate the user name element and store it in a variable and input a sample username
		WebElement userInput = winUtil.driver.findElement(By.xpath("html/body/input[1]"));
		userInput.sendKeys("Pratap");
		
		//Locate the password element and store it in a variable and input a sample password
		WebElement passwordInput = winUtil.driver.findElement(By.xpath("html/body/input[2]"));
		passwordInput.sendKeys("123@gbr");
		
		//locate the login button and click on it
		WebElement loginBtn = winUtil.driver.findElement(By.xpath("html/body/button[1]"));
		loginBtn.click();
		
		//Locate the cancel button and click on it
		WebElement cancelBtn = winUtil.driver.findElement(By.xpath("html/body/button[2]"));
		cancelBtn.click();
		
		//Locate the forgot? link and click on it
		WebElement forgotLink = winUtil.driver.findElement(By.xpath("html/body/a"));
		forgotLink.click();
		
		//close the browser using quit method
		winUtil.quitWin();
		
		
		
		
	}

}
