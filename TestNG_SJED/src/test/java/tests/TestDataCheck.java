package tests;

import org.testng.annotations.Test;

import data.DataProviderExcel;

public class TestDataCheck {
  @Test(dataProvider = "loginData", dataProviderClass = DataProviderExcel.class)
  public void f(String testcaseName, String userId, String password, String captcha) {
	  
	  if(testcaseName.contains("Blank User ID"))
	  {
	
	  System.out.print(testcaseName+"  "+userId+"  "+password+"  "+captcha);	  
	  System.out.println();
	  }
  }
}
