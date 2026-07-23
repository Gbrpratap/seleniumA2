package testNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testNG.ListenersUtil.class)
public class ListenersHandle extends TestNGBaseAnnotations {
	
	@Test(dependsOnMethods = "listenMethod2")
	public void listenMethod1() {
		Reporter.log("method 1", true);
	}
	
	@Test(retryAnalyzer = testNG.RetryAnalyserUtil.class)
	public void listenMethod2() {
		Reporter.log("method 2", true);
//		Assert.fail();
	}

}
