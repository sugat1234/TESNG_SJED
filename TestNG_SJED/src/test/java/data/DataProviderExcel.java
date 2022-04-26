package data;

import org.testng.annotations.DataProvider;

import utilities.TestDataFileReader;

public class DataProviderExcel {

	@DataProvider(name = "loginData")
	public Object[][] dp_excelData()
	{
		return TestDataFileReader.getData();
	}

}
