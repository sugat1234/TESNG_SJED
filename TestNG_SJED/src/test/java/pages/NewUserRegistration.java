package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewUserRegistration {
	
	WebDriver driver;
	
	public NewUserRegistration(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By fullName=By.xpath("//input[@id='txtFullName']");
	
	By male=By.xpath("//input[@id='rblApplicantGender_0']");
	
	By female=By.xpath("//input[@id='rblApplicantGender_1']");
	
	By other=By.xpath("//input[@id='rblApplicantGender_2']");
	
	By date=By.xpath("//input[@id='txtBirthdate']");
	
	By aadharCardNumber=By.xpath("//input[@id='txtAadharCardNo']");
	
	By emailId=By.xpath("//input[@id='txtEmailID']");
	
	By caste=By.xpath("//select[@id='ddlCaste']");
	
	By mobileNumber=By.xpath("//input[@id='txtMobileNo']");
	
	By password=By.xpath("//input[@id='txtPassword']");
	
	By confirmPassword=By.xpath("//input[@id='txtConfirmPassword']");
	
	By captchaCode=By.xpath("//input[@id='txtCaptcha']");
	
	By register=By.xpath("//input[@id='btnRegister']");
	
	
	public void enterFullName(String fullName)
	{
		driver.findElement(this.fullName).sendKeys(fullName);
	}
	
	public void selectGender(String gender)
	{
		if(gender.equalsIgnoreCase("Male"))
			driver.findElement(male).click();
		
		if(gender.equalsIgnoreCase("Female"))
			driver.findElement(female).click();
		
		if(gender.equalsIgnoreCase("Other"))
			driver.findElement(other).click();
	}

	public void selectBirthDate(String dob)
	{
		driver.findElement(this.date).sendKeys(dob);
	}
	
	public void enterAadharCardNumber(String aadharCardNumber)
	{
		driver.findElement(this.aadharCardNumber).sendKeys(aadharCardNumber);
	}
	
	
	public void enterEmailId(String emailId)
	{
		driver.findElement(this.emailId).sendKeys(emailId);
	}
	
	public void selectCaste(String caste)
	{
		new Select(driver.findElement(this.caste)).selectByVisibleText(caste);
	}
	
	public void enterMobileNumber(String mobileNumber)
	{
		driver.findElement(this.mobileNumber).sendKeys(mobileNumber);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(this.password).sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword)
	{
		driver.findElement(this.confirmPassword).sendKeys(confirmPassword);
	}
	
	public void enterCaptchaCode(String captchaCode)
	{
		driver.findElement(this.captchaCode).sendKeys(captchaCode);
	}
	
	public void clickRegister()
	{
		driver.findElement(this.register).click();
	}

}
