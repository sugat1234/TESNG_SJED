package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestManager {
	
	  static ExtentReports report;
	  static ExtentSparkReporter reporter;
	  static ExtentTest test;
	  
	  public ExtentTestManager()
	  {
		  report=new ExtentReports();
		  ExtentSparkReporter reporter=new ExtentSparkReporter("C:\\Users\\sugat\\git\\TESNG_SJED\\TestNG_SJED\\extent-report\\index2.html");
		  reporter.config().setReportName("Sample Report");			
		  report.attachReporter(reporter); 
	  }
	  
	 public void createTest(String testName)
	 {
		 test=report.createTest(testName);
	 }
	 
	 public void logPass(String msg)
	 {
		 test.log(Status.PASS, msg);
	 }

	 public void logInfo(String msg)
	 {
		 test.log(Status.INFO, msg);
	 }
	 
	 public void logFail(String msg)
	 {
		 test.log(Status.FAIL, msg);
	 }
	 
	 public void publishReport()
	 {
		 report.flush();
	 }

}
