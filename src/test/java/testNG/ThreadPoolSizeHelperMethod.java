package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ThreadPoolSizeHelperMethod {

	
	//In this threadPoolSize is Async thread
	@Test(invocationCount = 2, threadPoolSize = 2)
	public void threadMethod() {
		for(int i=0; i<10; i++) {
			System.out.println(i);
		}
	}
	
}
