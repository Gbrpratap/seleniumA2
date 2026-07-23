package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class IncovactionMethod {
	
	@Test
	public void manual() {
		Reporter.log("manual", true);
	}
	
	@Test(invocationCount = 2)
	public void selenium() {
		Reporter.log("selenium", true);
	}

}
