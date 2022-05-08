package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestExtentReport {
	ExtentReports report;
	ExtentTest test;

	@DataProvider(name = "data_provider1")
	public Object[][] dp1()
	{
		return new Object[][] {{"Set1"},{"Set2"}};
	}
	
	@BeforeClass
	public void beforeClass() {
		report=new ExtentReports();
		
		ExtentSparkReporter reporter=new ExtentSparkReporter("C:\\Users\\sugat\\git\\TESNG_SJED\\TestNG_SJED\\extent-report\\index2.html");
		reporter.config().setReportName("Sample Report");
		
		report.attachReporter(reporter);
		
	}

	@BeforeMethod
	public void beforeMethod() {
		
	}

	@Test(dataProvider ="data_provider1")
	public void test1(String d1) {
		test=report.createTest("Test1");
		
		test.log(Status.PASS, "Test Pass"+d1);
	}
	
	@Test
	public void test2() {

		test=report.createTest("Test2");
		test.log(Status.FAIL, "Test Fail");
	}

	@AfterMethod
	public void afterMethod() {
		test.log(Status.INFO, "Test Completed");
		
	}
	
	@AfterClass
	public void afterClass()
	{
		report.flush();
	}

}
