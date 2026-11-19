package tests;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import driverFactory.DriverFactory;
import page.RegisterPage;

public class RegisterPageTest extends BaseClass{
	private RegisterPage registerPage;
	
	@BeforeMethod
	public void setUP() {
		driver=setUpFramework();
		registerPage=new RegisterPage(driver);
		
	}
	
	@Test
	public void successfulRegistration() {
		registerPage.registerUser("vinothini", "Password12", "Password12");
		String actualMsg=registerPage.getSuccessmsg();
		String expectedMsg="Successfully registered, you can log in now.";
		Assert.assertTrue("Assertion failed!Actual text:"+actualMsg,actualMsg.contains(expectedMsg));
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
