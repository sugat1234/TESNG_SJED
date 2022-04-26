package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;	
	public static WebDriver initialize( String browser, String url) {

		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sugat\\eclipse-workspace\\POMFrameworkOne\\driver\\chromedriver.exe");
			
			driver=new ChromeDriver();
			
		
		}
		
		if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sugat\\eclipse-workspace\\POMFrameworkOne\\driver\\geckodriver.exe");
			
			driver=new FirefoxDriver();
			
		}
		
		driver.get(url);	
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		return driver;
	
	}
	
	public static void closeAll()
	{
		driver.quit();
	}

}
