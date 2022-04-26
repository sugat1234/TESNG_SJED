package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	By userId=By.xpath("//input[@id='txtUserName']");
	
	By password=By.xpath("//input[@id='txtPassword']");
	
	By captchaCode=By.xpath("//input[@id='txtCaptcha']");
	
	By login=By.xpath("//input[@id='btnUserLogin']");
	
	By forgotPassword=By.xpath("//a[@id='lnkForgotPass']");
	
	By forgotUserId=By.xpath("//a[@id='lnkForgotUserID']");
	
	By newUserRegistration=By.xpath("//span[@id='lblRegisterHere']");
	
	By newNGORegistration=By.xpath("//span[@id='lblNGORegister']");
	
	By errMsg_blankUserId=By.xpath("//span[@id='rfvtxtUserName']");
	
	By errMsg_blankPassword=By.xpath("//span[@id='rfvtxtPassword']");
	
	By errMsg_blankCaptcha=By.xpath("//span[@id='rfvtxtCaptcha']");
	
	By errMsg_invalidCaptcha=By.xpath("//span[@id='revtxtCaptcha']");
	
	By errMsg_invalidCaptchaCode=By.xpath("//div[starts-with(text(),'Invalid Captcha')]");
	
	By errMsg_Ok=By.xpath("//button[text()='OK']");
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getURL()
	{
		return driver.getCurrentUrl();
	}
	
	
	
	
	public void enterUserId(String userId)
	{
		driver.findElement(this.userId).sendKeys(userId);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(this.password).sendKeys(password);
	}

	public void enterCaptcha(String captcha)
	{
		driver.findElement(this.captchaCode).sendKeys(captcha);
	}
	
	public void clickLogin()
	{
		driver.findElement(this.login).click();
	}
	
	public void clickNewUserRegistration()
	{
		driver.findElement(this.newUserRegistration).click();
	}
	
	public String getErrorMessageBlankUserId()
	{
		return driver.findElement(this.errMsg_blankUserId).getText();
	}

	public String getErrorMessageBlankPassword()
	{
		return driver.findElement(errMsg_blankPassword).getText();
	}
	
	public String getErrorMessageBlankCaptcha()
	{
		return driver.findElement(errMsg_blankCaptcha).getText();
		
	}
	
	public String getErrorMessageInvalidCaptcha()
	{
		return driver.findElement(errMsg_invalidCaptcha).getText();
	}
	
	public String getErrorMessageInvalidCaptchaCode()
	{
		return driver.findElement(errMsg_invalidCaptchaCode).getText();
	}
	
	public void clickOk()
	{
		driver.findElement(errMsg_Ok).click();
	}

}
