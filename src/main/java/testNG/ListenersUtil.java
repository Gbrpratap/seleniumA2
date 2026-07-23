package testNG;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersUtil implements ITestListener, ISuiteListener{
	
	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Configure the report", true);
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Finish report", true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Reporter.log(testName + " : execution started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Reporter.log(testName + " : execution passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Reporter.log(testName + " : execution failed", true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Reporter.log(testName + " : execution finished", true);
	}
	

}
