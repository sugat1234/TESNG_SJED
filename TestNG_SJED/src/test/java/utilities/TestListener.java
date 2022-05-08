package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {
	


	public void onStart(ITestContext context) {
		Log.info("Tests are starting");
	}

	
	public void onTestStart(ITestResult result) {
		Log.info("Test Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		Log.info("Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		Log.error("Test Failed");
		
	}

	public void onTestSkipped(ITestResult result) {

		Log.warn("Test Skipped");
		

	}

	public void onTestFailedWithTimeout(ITestResult result) {

		Log.error("Test Failed with Timeout");
	}


	public void onFinish(ITestContext context) {
		Log.info("Tests are ending");
	}

}
