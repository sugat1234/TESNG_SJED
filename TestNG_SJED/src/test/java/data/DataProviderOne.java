package data;

import org.testng.annotations.DataProvider;

public class DataProviderOne {

	@DataProvider(name = "blankUserId")
	public Object[][] dp_login1()
	{
		return new Object[][] {{"","sugat123","XADK01"},{"","","XADK01"},{"","",""}};
	}
	
	@DataProvider(name="blankPassword")
	public Object[][] dp_login2()
	{
		return new Object[][] {{"sugat123","","XADK01"},{"","","XADK01"},{"","",""}};
		
	}
	
	@DataProvider(name="blankCaptcha")
	public Object[][] dp_login3()
	{
		return new Object[][] {{"sugat123","sugat123",""},{"sugat123","",""},{"","",""}};
	}
	
	@DataProvider(name="invalidCaptcha")
	public Object[][] dp_login4()
	{
		return new Object[][] {{"sugat123","sugat123","XD"},{"sugat123","sugat123","XD11"},{"","","DD11"}};
	}
	
	@DataProvider(name="invalidCaptchaCode")
	public Object[][] dp_login5()
	{
		return new Object[][] {{"sugat123","sugat123","XDKD01"},{"sugat123","sugat123","AD11D1"},{"sugat123","sugat123","22KD33"}};
	}
	

}
