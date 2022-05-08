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
import utilities.ExtentTestManager;
import utilities.Log;
import utilities.TestListener;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

@Listeners(TestListener.class)
public class Test_Login {

	String url = "https://esamajkalyan.gujarat.gov.in/index.aspx";

	WebDriver driver;
	LoginPage loginPage;
	SoftAssert softAssert;

	@Parameters("browser")
	@BeforeMethod(groups = { "validation", "pagedetails" })
	public void beforeMethod(@Optional("firefox") String browser) {

		driver = BrowserFactory.initialize(browser, url);
		
		loginPage = new LoginPage(driver);

		softAssert = new SoftAssert();

		Assert.assertNotNull(softAssert);

		Assert.assertNotNull(driver);
		
		Log.info("Open Application in "+browser+" browser");

	}

	@Test(priority = 0, groups = { "pagedetails" })
	public void test_pageDetails() {
		Log.info("Test Case : Check Page Details");
		
		softAssert.assertEquals(loginPage.getPageTitle(), "SJED");

		Log.info("Check the Page Title");
		
		softAssert.assertEquals(loginPage.getURL(), "https://esamajkalyan.gujarat.gov.in/index.aspx");

		Log.info("Check the URL");
		
		softAssert.assertAll("Both values asserted");

	}

	@Test(priority = 1, groups = {
			"validation" }, dataProvider = "blankUserId", dataProviderClass = data.DataProviderOne.class)
	public void test_blankUserId(String userId, String password, String captcha) {
		Log.info("Test Case : Check when User ID is blank");
		
		loginPage.enterUserId(userId);

		loginPage.enterPassword(password);

		loginPage.enterCaptcha(captcha);

		loginPage.clickLogin();

		Assert.assertEquals(loginPage.getErrorMessageBlankUserId(), "Please Enter Registration Number");

	}

	@Test(priority = 2, groups = {
			"validation" }, dataProvider = "blankPassword", dataProviderClass = DataProviderOne.class)
	public void test_blankPassword(String userId, String password, String captcha) {

		Log.info("Test Case : Check Page Details");
		
		loginPage.enterUserId(userId);

		loginPage.enterPassword(password);

		loginPage.enterCaptcha(captcha);

		loginPage.clickLogin();

		Assert.assertEquals(loginPage.getErrorMessageBlankPassword(), "Please Enter Password");

	}

	@Test(priority = 3, groups = {
			"validation" }, dataProvider = "blankCaptcha", dataProviderClass = DataProviderOne.class)
	public void test_blankCaptcha(String userId, String password, String captcha) {

		loginPage.enterUserId(userId);

		loginPage.enterPassword(password);

		loginPage.enterCaptcha(captcha);

		loginPage.clickLogin();

		Assert.assertEquals(loginPage.getErrorMessageBlankCaptcha(), "Please Enter Captcha Code");

	}

	@Test(priority = 4, groups = {
			"validation" }, dataProvider = "invalidCaptcha", dataProviderClass = DataProviderOne.class)
	public void test_invalidCaptcha(String userId, String password, String captcha) {

		loginPage.enterUserId(userId);

		loginPage.enterPassword(password);

		loginPage.enterCaptcha(captcha);

		loginPage.clickLogin();

		Assert.assertEquals(loginPage.getErrorMessageInvalidCaptcha(), "Allows Only Alpha-numeric 6 Characters.");

	}

	@Test(priority = 5, groups = "validation", dataProvider = "invalidCaptchaCode", dataProviderClass = DataProviderOne.class)
	public void test_invalidCaptchaCode(String userId, String password, String captcha) {

		loginPage.enterUserId(userId);

		loginPage.enterPassword(password);

		loginPage.enterCaptcha(captcha);

		loginPage.clickLogin();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(loginPage.getErrorMessageInvalidCaptchaCode(),
				"Invalid Captcha Code. Please Enter code again!");

		loginPage.clickOk();

	}

	@Test(enabled = false)
	public void test_equalArray() {
		Object[] arr1 = { 1, 2, 3, 4 };

		Object[] arr2 = { 4, 3, 2, 1 };

		Assert.assertEqualsNoOrder(arr1, arr2);

	}

	@AfterMethod(groups = { "validation", "pagedetails" })
	public void afterMethod() {

		BrowserFactory.closeAll();

	}

}
