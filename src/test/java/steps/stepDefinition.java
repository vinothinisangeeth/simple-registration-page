package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseClass;
import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.RegisterPage;

public class stepDefinition extends BaseClass {
	
	private RegisterPage registerPage;

@Given("User navigate to the portal")
public void user_navigate_to_the_portal() {
	driver=setUpFramework();
	By registration=By.xpath("(//a[text()='Try it out'])[3]");
	WebElement tryItOutBtn=explicitWaitVisible(registration);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500);");
	try {
		Thread.sleep(500);
	}catch(InterruptedException e){
		e.printStackTrace();
		
		
	}
	WebElement btn=driver.findElement(registration);
	JavascriptExecutor jsClick=(JavascriptExecutor) driver;
	jsClick.executeScript("arguments[0].click();",btn);
//	btn.click();
	registerPage=new RegisterPage(driver);
}

@Given("User enters the username as {string}")
public void user_enters_the_username_as(String string) {
	String uniqueUsername=string+(System.currentTimeMillis()% 100000);
	registerPage.userName(uniqueUsername);
    
}

@Given("User enters the password as {string}")
public void user_enters_the_password_as(String string) {
	registerPage.enterPassword(string);
    
}

@Given("User enters the confirmpassword as {string}")
public void user_enters_the_confirmpassword_as(String string) {
   
	registerPage.enterConPassword(string);
}

@When("User clik on the Registration button")
public void user_clik_on_the_registration_button() {
	registerPage.clickRegister();
    
}

@Then("Registration should be successful")
public void registration_should_be_successful() {
	String actualMsg=registerPage.getSuccessmsg();
	String expectedMsg="Successfully registered, you can log in now.";
	Assert.assertTrue(actualMsg.contains(expectedMsg));
    
}
@After
public void tearDown() {
	DriverFactory.quitDriver();
	}
}


	    
	




