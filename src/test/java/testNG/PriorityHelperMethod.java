package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityHelperMethod {
	
	@Test(priority = 2)
	public void login() {
		Reporter.log("Login", true);
	}
	
	@Test(priority = -1)
	public void register() {
		Reporter.log("Register", true);
	}
	
	@Test
	public void createProduct() {
		Reporter.log("Create", true);
	}
	

}
