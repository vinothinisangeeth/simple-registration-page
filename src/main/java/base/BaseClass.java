package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import utils.FileReader;

public class BaseClass {
	protected DriverFactory df;
	protected static WebDriver driver;
	protected FileReader reader;
	
	public WebDriver setUpFramework() {
		String browser=FileReader.get("browser");
		
		driver=DriverFactory.getDriver(browser);
		driver.manage().window().maximize();
		driver.get(FileReader.get("url"));
		try {
			Thread.sleep(2000);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("var ads=document.querySelectorAll('[id*=\"google_ads\"],[class*=\"adsbygoogle\",iframe'); "+"for(var i=0;i<ads.length;i++)"
					+ "{ ads[i].style.display='none';}");
		}catch(Exception e) {
			System.out.println("No ads found");
		}
		return driver;
	}
		 //==========GETTING DATA FROM EXCEL SHEET================
	    public static String getExcelData(String filePath, String sheetName, int rowNum, int cellNum)
	            throws IOException {

	        FileInputStream fis = new FileInputStream(filePath);

	        XSSFWorkbook workbook = new XSSFWorkbook(fis);

	        XSSFSheet sheet = workbook.getSheet(sheetName);

	        Row row = sheet.getRow(rowNum);

	        Cell cell = row.getCell(cellNum);

	        DataFormatter formatter = new DataFormatter();

	        String value = formatter.formatCellValue(cell);

	        workbook.close();
	        fis.close();

	        return value;
	    }
	    
	    // ================= Waits =================

	    public static void implicitWait(int seconds) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	    }

	    public static WebElement explicitWaitClickable(WebElement element) {
	        return new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public static WebElement explicitWaitVisible(By registration) {
	        return new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.visibilityOfElementLocated(registration));
	    }
	    public static Boolean explicitWaitUrlcontains(String fractionalUrl) {
	    	return new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.urlContains(fractionalUrl));
	    }
		
	
	
//================= Navigation =================

public static void navigateTo(String url) {
    driver.navigate().to(url);
}

public static void navigateBack() {
    driver.navigate().back();
}

public static void navigateForward() {
    driver.navigate().forward();
}

public static void refresh() {
    driver.navigate().refresh();
}

}




