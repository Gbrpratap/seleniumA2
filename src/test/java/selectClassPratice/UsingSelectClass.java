package selectClassPratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class UsingSelectClass {

	public static void main(String[] args) {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait for the emelemts to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //works only for findelement method
		
		//navigate to the application
		driver.get("https://www.amazon.in/");
		
		//identify the dropdown search webelement beside amazon search bar
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		
		//select the options
		Select sel = new Select(dropdown);
		
		sel.selectByIndex(3);
		sel.selectByVisibleText("Amazon Devices");
		sel.selectByValue("search-alias=alexa-skills");
		
		//fecth all the options
//		List<WebElement> listOfOptions = sel.getOptions();
		
//		print all the options
//		for(WebElement ele : listOfOptions) {
//			System.out.println(ele.getText());
//		}
		
		//check if option is single or multi select
		/*
		if(sel.isMultiple()){
			System.out.println("Multi select");
		}else {
			System.out.println("Single select");
		}
		*/
		
		//fetch first select option. In single select it will be the last selected option. From this we can say that this method is used for multi select option
//		WebElement first = sel.getFirstSelectedOption();
		
//		System.out.println(first.getText());
		
		//fetch all the selected options
		List<WebElement> selectedOption = sel.getAllSelectedOptions();
		
		for(WebElement ele : selectedOption) {
			System.out.println(ele.getText());
		}
		
		//What will happens if we try to use deselect method with single select option in Amazon dropdown list beside search bar
//		sel.deselectByValue("search-alias=alexa-skills");
		
		//close the browser
		driver.quit();
		

	}

}
