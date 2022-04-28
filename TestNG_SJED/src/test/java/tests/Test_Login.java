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
	  
	  
	  @BeforeClass
	  public void beforeClass()
	  {
		  report=new ExtentReports();
			
		  ExtentSparkReporter reporter=new ExtentSparkReporter("C:\\Users\\sugat\\git\\TESNG_SJED\\TestNG_SJED\\extent-report\\index2.html");
		  reporter.config().setReportName("Sample Report");
			
		  report.attachReporter(reporter); 
		  		  
	  }
	  
	  @Parameters("browser")
	  @BeforeMethod(groups = {"validation","pagedetails"})
	 public void beforeMethod(@Optional("firefox") String browser) {
		 
		  driver=BrowserFactory.initialize(browser, url);
		  
		  loginPage=new LoginPage(driver);
		  
		  softAssert=new SoftAssert();
		  
		  Assert.assertNotNull(softAssert);

		  Assert.assertNotNull(driver);

  }

	  @Test(priority = 0, groups = {"pagedetails"})
	  public void test_pageDetails()
	  {
		  ExtentTest test=report.createTest("Page Details");

		  try {
			  softAssert.assertEquals(loginPage.getPageTitle(), "SJED");
			  
			  softAssert.assertEquals(loginPage.getURL(), "https://esamajkalyan.gujarat.gov.in/index.aspx");
			  
			  softAssert.assertAll("Both values asserted");
			  
			  test.log(Status.PASS, "Test Passed");  
		  }
		  catch(Exception e)
		  {
			  test.log(Status.FAIL, "Test Failed");    
		  }
		  
	  }
	  
	  @Test(priority = 1, groups= {"validation"}, dataProvider = "blankUserId", dataProviderClass = data.DataProviderOne.class )
	  public void test_blankUserId(String userId, String password, String captcha) {
		  ExtentTest test=report.createTest("Blank user id");
		  try
		  {		
			  loginPage.enterUserId(userId);
			  
			  loginPage.enterPassword(password);
			  
			  loginPage.enterCaptcha(captcha);
			  
			  loginPage.clickLogin();
			  
			  Assert.assertEquals(loginPage.getErrorMessageBlankUserId(), "Please Enter Registration Number");
			
			  test.log(Status.PASS, "Test Passed");   
		  }
		  catch(Exception e)
		  {
			  test.log(Status.FAIL, "Test Failed");    
		  }
		   
	  }
	  
	  @Test(priority = 2,groups= {"validation"}, dataProvider = "blankPassword", dataProviderClass = DataProviderOne.class)
	  public void test_blankPassword(String userId, String password, String captcha) {
		  
		  loginPage.enterUserId(userId);
		  
		  loginPage.enterPassword(password);

		  loginPage.enterCaptcha(captcha);
		  
		  loginPage.clickLogin();
		  
		  Assert.assertEquals(loginPage.getErrorMessageBlankPassword(), "Please Enter Password");

	  }
	  
	  @Test(priority = 3, groups= {"validation"}, dataProvider = "blankCaptcha", dataProviderClass = DataProviderOne.class)
	  public void test_blankCaptcha(String userId, String password, String captcha) {
		  
		  loginPage.enterUserId(userId);
		  
		  loginPage.enterPassword(password);

		  loginPage.enterCaptcha(captcha);
		  
		  loginPage.clickLogin();

		  Assert.assertEquals(loginPage.getErrorMessageBlankCaptcha(), "Please Enter Captcha Code");

	  }
	  
	  @Test(priority=4, groups= {"validation"}, dataProvider = "invalidCaptcha", dataProviderClass = DataProviderOne.class)
	  public void test_invalidCaptcha(String userId, String password, String captcha)
	  {
		  
		  loginPage.enterUserId(userId);
		  
		  loginPage.enterPassword(password);		  
		  
		  loginPage.enterCaptcha(captcha);

		  loginPage.clickLogin();
		  
		  Assert.assertEquals(loginPage.getErrorMessageInvalidCaptcha(), "Allows Only Alpha-numeric 6 Characters.");

	  }
	  
	  @Test(priority=5, groups = "validation", dataProvider = "invalidCaptchaCode", dataProviderClass = DataProviderOne.class)
	  public void test_invalidCaptchaCode(String userId, String password, String captcha)
	  {

		  loginPage.enterUserId(userId);

		  loginPage.enterPassword(password);
		  
		  loginPage.enterCaptcha(captcha);

		  loginPage.clickLogin();  
  
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  
		  Assert.assertEquals(loginPage.getErrorMessageInvalidCaptchaCode(), "Invalid Captcha Code. Please Enter code again!");
		  
		  loginPage.clickOk();
		  

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
