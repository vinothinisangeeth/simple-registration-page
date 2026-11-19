package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
  private WebDriver driver;
  
  //Locators
  private By username=By.id("username");
  private By password=By.id("password");
  private By Confirmpassword=By.id("confirmPassword");
  private By Register=By.xpath("//button[text()='Register']");
  private By successAlertMessage=By.id("flash");
  
  
 //Constructor
  public RegisterPage(WebDriver driver) {
	  this.driver=driver;
  }
  
  //Action
  public void userName(String user) {
	  driver.findElement(username).sendKeys(user);
  }
  public void enterPassword(String pass)
  {
  	driver.findElement(password).sendKeys(pass);
  }
  public void enterConPassword(String pass)
  {
  	driver.findElement(Confirmpassword).sendKeys(pass);
  }
  public void clickRegister() {
	  WebElement registerbtn=driver.findElement(Register);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", registerbtn);
	    try {
	    	Thread.sleep(500);;
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    registerbtn .click();
  }
  
  public void registerUser(String user,String pass,String Confirmpassword) {
	  userName(user);
  	enterPassword(pass);
  	enterConPassword(Confirmpassword);
  	clickRegister();
  }
  public String getSuccessmsg() {
  	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
  	wait.until(ExpectedConditions.visibilityOfElementLocated(successAlertMessage));
		 String register= driver.findElement(successAlertMessage).getText();
		System.out.println("Message:"+register);
		return register;
  	
  }
}
