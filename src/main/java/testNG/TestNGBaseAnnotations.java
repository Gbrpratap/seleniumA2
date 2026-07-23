package testNG;

import org.testng.Reporter;
import org.testng.annotations.*;

public class TestNGBaseAnnotations {
	
	@BeforeSuite
	public void bs() {
		Reporter.log("before suite connect to the database", true);
	}
	
	@AfterSuite
	public void as() {
		Reporter.log("after suite disconnect to the database", true);
	}
	
	@BeforeClass
	public void bc() {
		Reporter.log("before class set parallel execution", true);
	}
	
	@AfterClass
	public void ac() {
		Reporter.log("After class remove parallel execution", true);
	}
	
	@BeforeTest
	public void bt() {
		Reporter.log("before test launch the browser", true);
	}
	
	@AfterTest
	public void at() {
		Reporter.log("after test close the browser", true);
	}
	
	@BeforeMethod
	public void bm() {
		Reporter.log("before method run the tests (login)", true);
	}
	
	@AfterMethod
	public void am() {
		Reporter.log("after method runt the tests (logout)", true);
	}

}
