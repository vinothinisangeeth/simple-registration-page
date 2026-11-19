package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;

public class loginstepdefinition extends BaseClass{
	private LoginPage loginPage;
	

@Given("User navigate to the login portal")
public void user_navigate_to_the_login_portal() {
	driver=setUpFramework();
	By loginCard=By.xpath("(//a[text()='Try it out'])[2]");
	WebElement tryItOutBtn=explicitWaitVisible(loginCard);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500);");
	
	try {
		Thread.sleep(500);
	}catch(InterruptedException e){
		e.printStackTrace();
		
	}
	WebElement btn=driver.findElement(loginCard);
	JavascriptExecutor jsClick=(JavascriptExecutor) driver;
	jsClick.executeScript("arguments[0].click();",btn);
	loginPage=new LoginPage(driver);

}	   


@When("User enters the username and password from excel {int}")
public void user_enters_the_username_and_password_from_excel(Integer rowNumber) throws Exception {
   String excelPath="src/test/resources/Login-data.xlsx";
   String sheetName="Sheet1";
   String username=getExcelData(excelPath,sheetName,rowNumber,0);
   String password=getExcelData(excelPath,sheetName,rowNumber,1);
   loginPage.login(username, password);
}

@Then("User should be successfully logged in")
public void user_should_be_successfully_logged_in() {
	explicitWaitUrlcontains("/secure");
	String actualUrl=driver.getCurrentUrl();	
	System.out.println("The current url is:"+actualUrl);
	String expectedUrl="https://practice.expandtesting.com/secure";
	Assert.assertEquals(actualUrl,expectedUrl,"Login failed with these  redential");

}

}
