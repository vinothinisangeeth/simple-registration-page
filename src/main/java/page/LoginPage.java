package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	  WebDriver driver;

	//    Constructor
    public LoginPage(WebDriver driver) {
  	  this.driver=driver;
    }
    
  //locators
    By username=By.id("username");
    By password=By.id("password");
    By loginButton=By.xpath("//button[@type='submit']");
    
  //Action
  	public void enterUserName(String username)
  	{
  		driver.findElement(By.id("username")).sendKeys(username);	
  	}
  	public void enterPassword(String password)
  	{
  		driver.findElement(By.id("password")).sendKeys(password);
  	}
  	public void clicklogin(){
  		By loginbtn=By.xpath("//button[@type='submit']");
  		WebElement btnele=driver.findElement(loginbtn);
  		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", btnele);
	    try {
	    	Thread.sleep(500);;
	    }catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    btnele.click();
  }
  	
  	public void login(String username,String pass)
  	{
  		enterUserName(username);
  		enterPassword(pass);
  		clicklogin();
  	}
}


