package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestExtentReport {
	ExtentReports report;
	ExtentTest test;
	
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

	@Test
	public void test1() {
		test=report.createTest("Test1");
		
		test.log(Status.PASS, "Test Pass");
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
