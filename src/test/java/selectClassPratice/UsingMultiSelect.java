package selectClassPratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class UsingMultiSelect {

public static void main(String[] args) {
		
		//launch the browser
		WebDriver driver = new EdgeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait for the emelemts to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//navigate to the application
		driver.get("https://demoapps.qspiders.com/ui/dropdown/multiSelect?sublist=1");
		
		//identify the dropdown 
		WebElement dropdown = driver.findElement(By.id("select-multiple-native"));
		
		//select the options
		Select sel = new Select(dropdown);
		
		sel.selectByIndex(3);
		sel.selectByVisibleText("SanDisk SSD PLUS 1TB...");
		sel.selectByValue("White Gold Plated Princess");
		
		//fecth all the options
		List<WebElement> listOfOptions = sel.getOptions();
		
//		print all the options
//		for(WebElement ele : listOfOptions) {
//			System.out.println(ele.getText());
//		}
		
		//check if option is single or multi select
//		if(sel.isMultiple()){
//			System.out.println("Multi select");
//		}else {
//			System.out.println("Single select");
//		}
		
		//fetch first select option.
//		WebElement first = sel.getFirstSelectedOption();
		
//		System.out.println(first.getText());
		
		//fetch all the selected options
//		List<WebElement> selectedOption = sel.getAllSelectedOptions();
//		
//		for(WebElement ele : selectedOption) {
//			System.out.println(ele.getText());
//		}
		
		//What will happens if we try to use deselect method with single select option in Amazon dropdown list beside search bar
		sel.deselectAll();
		
		//close the browser
		driver.quit();
		

	}

}
