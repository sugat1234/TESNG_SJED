package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NewUserRegistration;
import utilities.BrowserFactory;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class Test_Registration {

	String url = "https://esamajkalyan.gujarat.gov.in/index.aspx";

	WebDriver driver;
	LoginPage loginPage;
	NewUserRegistration newUserRegistration;

	@BeforeMethod
	public void beforeMethod() {
		
		driver=BrowserFactory.initialize("chrome", url);
		
		loginPage=new LoginPage(driver);
		
		newUserRegistration=new NewUserRegistration(driver);
	}

	@Test
	public void test1() {
		loginPage.clickNewUserRegistration();

		newUserRegistration.enterFullName("Sugat Shivsharan");

		newUserRegistration.selectGender("Male");
		
		newUserRegistration.selectBirthDate("16/04/1987");
		
		newUserRegistration.enterAadharCardNumber("1000121214152323");
		
		newUserRegistration.enterEmailId("suga123@gmail.com");
		
		newUserRegistration.selectCaste("SC");
		
		newUserRegistration.enterMobileNumber("9819990130");
		
		newUserRegistration.enterPassword("sugat123");
		
		newUserRegistration.enterConfirmPassword("sugat123");
		
		newUserRegistration.enterCaptchaCode("YCJC1A");
		
	}

	@AfterMethod
	public void afterMethod() {
	}

}
