package testNGAnnotations;

import org.testng.Reporter;
import org.testng.annotations.Test;

import testNG.TestNGBaseAnnotations;

public class HandlleBaseAnnotations extends TestNGBaseAnnotations{

	@Test
	public void runAnnotationFlow() {
		Reporter.log("Test-1", true);
	}
	
	
	@Test
	public void runAnnotationFlow2() {
		Reporter.log("Test-2", true);
	}
	
}
