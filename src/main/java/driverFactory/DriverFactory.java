package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static WebDriver driver;
	
	public static void initializeDriver(String browser)
	{
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else
		{
			throw new RuntimeException("Unsupported browser"+browser);
		}
		

		return;
		
	}
	public static WebDriver getDriver(String browser) {
		if(driver==null) {
			initializeDriver(browser);
		}
		
		return driver;
		
	}
	public static void quitDriver() {
		if(driver!=null)
		{
			driver.quit();
			driver=null;
		}
	}

}
