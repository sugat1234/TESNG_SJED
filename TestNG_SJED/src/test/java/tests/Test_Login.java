package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import data.DataProviderOne;
import pages.LoginPage;
import utilities.BrowserFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Test_Login {
	
	String url="https://esamajkalyan.gujarat.gov.in/index.aspx";
	
	  WebDriver driver; 
	  LoginPage loginPage;
	  SoftAssert softAssert;
	
	  ExtentReports report;
	  ExtentTest test;

	  @BeforeClass
	  public void beforeClass()
	  {
			report=new ExtentReports();
			
			ExtentSparkReporter reporter=new ExtentSparkReporter("C:\\Users\\sugat\\git\\TESNG_SJED\\TestNG_SJED\\extent-report");
			reporter.config().setReportName("Sample Report");
			
			report.attachReporter(reporter);
			
	  }
	  
	  
	  @Parameters("browser")
	  @BeforeMethod(groups = {"validation","pagedetails"})
	 public void beforeMethod(@Optional("chrome") String browser) {
		 
		  driver=BrowserFactory.initialize(browser, url);
		  
		  loginPage=new LoginPage(driver);
		  
		  softAssert=new SoftAssert();
		  
		  Assert.assertNotNull(softAssert);

		  Assert.assertNotNull(driver);

  }

	  @Test(priority = 0, groups = {"pagedetails"})
	  public void test_pageDetails()
	  {
		  test=report.createTest("Page details");
  
		  softAssert.assertEquals(loginPage.getPageTitle(), "SJED");

		  test.log(Status.INFO, "Check the title of the page");
		  Reporter.log("Check the title of the page");
		  
		  softAssert.assertEquals(loginPage.getURL(), "https://esamajkalyan.gujarat.gov.in/index.aspx");
		  Reporter.log("Check the url of the page");
		  test.log(Status.INFO, "Check the URL of the page");
		  
		  softAssert.assertAll("Both values asserted");
		  test.log(Status.INFO, "Both values asserted");
		 
	  }
	  
	  @Test(priority = 1, groups= {"validation"}, dataProvider = "blankUserId", dataProviderClass = data.DataProviderOne.class )
	  public void test_blankUserId(String userId, String password, String captcha) {
		  test=report.createTest("Blank user ID");
		  
		  loginPage.enterUserId(userId);
		  test.log(Status.INFO, "Enter User ID");
		  
		  loginPage.enterPassword(password);
		  test.log(Status.INFO, "Enter Password");
		  
		  loginPage.enterCaptcha(captcha);
		  test.log(Status.INFO, "Enter Captcha");
		  
		  loginPage.clickLogin();
		  test.log(Status.INFO, "Click Login");
		  
		  Assert.assertEquals(loginPage.getErrorMessageBlankUserId(), "Please Enter Registration Number");
		
		  test.log(Status.PASS, "Test case passed");

		  
	  }
	  
	  @Test(priority = 2,groups= {"validation"}, dataProvider = "blankPassword", dataProviderClass = DataProviderOne.class)
	  public void test_blankPassword(String userId, String password, String captcha) {
		  test=report.createTest("Blank password");
		  
		  loginPage.enterUserId(userId);
		  test.log(Status.INFO, "Enter User ID");
		  
		  loginPage.enterPassword(password);
		  test.log(Status.INFO, "Enter Password");

		  loginPage.enterCaptcha(captcha);
		  test.log(Status.INFO, "Enter Captcha");
		  
		  loginPage.clickLogin();
		  test.log(Status.INFO, "Click Login");
		  
		  Assert.assertEquals(loginPage.getErrorMessageBlankPassword(), "Please Enter Password");
		  test.log(Status.PASS, "Test case passed");

	  }
	  
	  @Test(priority = 3, groups= {"validation"}, dataProvider = "blankCaptcha", dataProviderClass = DataProviderOne.class)
	  public void test_blankCaptcha(String userId, String password, String captcha) {
		  test=report.createTest("Blank Captcha");
		  
		  loginPage.enterUserId(userId);
		  test.log(Status.INFO, "Enter User ID");
		  
		  loginPage.enterPassword(password);
		  test.log(Status.INFO, "Enter Password");

		  loginPage.enterCaptcha(captcha);
		  test.log(Status.INFO, "Enter Captcha");
		  
		  loginPage.clickLogin();
		  test.log(Status.INFO, "Click Login");

		  Assert.assertEquals(loginPage.getErrorMessageBlankCaptcha(), "Please Enter Captcha Code");
		  test.log(Status.PASS, "Test case passed");

	  }
	  
	  @Test(priority=4, groups= {"validation"}, dataProvider = "invalidCaptcha", dataProviderClass = DataProviderOne.class)
	  public void test_invalidCaptcha(String userId, String password, String captcha)
	  {
		  test=report.createTest("Invalid Captcha");
		  
		  loginPage.enterUserId(userId);
		  test.log(Status.INFO, "Enter User ID");
		  
		  loginPage.enterPassword(password);		  
		  test.log(Status.INFO, "Enter Password");
		  
		  loginPage.enterCaptcha(captcha);
		  test.log(Status.INFO, "Enter Captcha");

		  loginPage.clickLogin();
		  test.log(Status.INFO, "Click Login");
		  
		  Assert.assertEquals(loginPage.getErrorMessageInvalidCaptcha(), "Allows Only Alpha-numeric 6 Characters.");
		  test.log(Status.PASS, "Test case passed");

	  }
	  
	  @Test(priority=5, groups = "validation", dataProvider = "invalidCaptchaCode", dataProviderClass = DataProviderOne.class)
	  public void test_invalidCaptchaCode(String userId, String password, String captcha)
	  {
		  test=report.createTest("Invalid Captcha code");

		  loginPage.enterUserId(userId);
		  test.log(Status.INFO, "Enter User ID");

		  loginPage.enterPassword(password);
		  test.log(Status.INFO, "Enter Password");
		  
		  loginPage.enterCaptcha(captcha);
		  test.log(Status.INFO, "Enter Captcha");

		  loginPage.clickLogin();  
		  test.log(Status.INFO, "Click Login");
  
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  
		  Assert.assertEquals(loginPage.getErrorMessageInvalidCaptchaCode(), "Invalid Captcha Code. Please Enter code again!");
		  
		  loginPage.clickOk();
		  
		  test.log(Status.PASS, "Test case passed");

	  }
	  
	  @Test(enabled = false)
	  public void test_equalArray()
	  {
		  Object[] arr1= {1,2,3,4};
		  
		  Object[] arr2= {4,3,2,1};
		  
		  Assert.assertEqualsNoOrder(arr1, arr2);
		  

	  }
	  	  
	  @AfterMethod(groups = {"validation","pagedetails"})
	  public void afterMethod() {
		  
		  BrowserFactory.closeAll();
		  
	  }
	  
	  @AfterClass
	  public void afterClass()
	  {
		  
		  report.flush();
	  }
	  
	  






}
