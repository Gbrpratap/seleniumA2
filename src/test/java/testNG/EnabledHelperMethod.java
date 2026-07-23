package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class EnabledHelperMethod {
	
	@Test
	public void login() {
		Reporter.log("Login", true);
	}
	
	@Test(enabled = false)
	public void register() {
		Reporter.log("Register", true);
	}
	
	@Test
	public void createProduct() {
		Reporter.log("Create", true);
	}
	

}
