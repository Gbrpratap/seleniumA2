package UsingWebDriverUtilities;

import UsingWebDriverMethods.WebDriverUtilitites;

public class UsingDriverUtilities {

	public static void main(String[] args) {
		
		WebDriverUtilitites winUtil = new WebDriverUtilitites();
		
		//Lanuch the browser
		winUtil.launchTheBrowser();
		
		//Maximize the window
		winUtil.maxTheWin();
		
		//navigate to application
		winUtil.navigateToApp("https://google.com/");
		
		//get the title
		winUtil.fetchTitle();
		
		//Validate the title
		String actualTitle = winUtil.fetchTitle();
		
		if(actualTitle.contains("Google")) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		//Close the browser
		winUtil.quitWin();
		

	}

}
