package sfdc.tests;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
	 Logger logger=LogManager.getLogger(test.class);

	WebDriver driver;
		@Test
		public void ztt() throws IOException
		{
			logger.info("this is info log started");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
		      //implicit wait
		     // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		      //URL launch
				/*
				 * driver.get("https://www.google.com/"); WebElement t
				 * =driver.findElement(By.name("q")); t.sendKeys("Tutorialspoint");
				 * System.out.println("Value is: " + t.getAttribute("value")); driver.quit();
				 */
			
			 driver.get("https://login.salesforce.com/"); 
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("document.getElementById('username').value='Selenium'");
			 
				/*
				 * WebElement s = driver.findElement(By.name("username"));
				 * s.sendKeys("abchhhhhhhhhhhhhhhhhhhhh");
				 */
			 System.out.println(((WebElement) js).getAttribute("value"));
				logger.info("this is info log completed");
				Capturescreenshot(driver);
				

			 
			 
		}

		/*
		 * @Test(groups="abc",priority=1) public void testcase1() {
		 * System.out.println("testcase1 inside"); }
		 * 
		 * @Test(groups="test",priority=3) public void testcase2() {
		 * System.out.println("testcase2 inside"); }
		 * 
		 * @Test(dependsOnGroups="test",priority=2) public void testcase3() {
		 * System.out.println("testcase3");
		 * logger.error("this is a error message inside");
		 * 
		 * }
		 */
		
		 @Test(priority=3)  
		 public void testcase1()  
		 {  
		     System.out.println("testcase1 inside");  
		 } 
		 
		 @Test(priority=1)  
		 public void testcase2()  
		 {  
		     System.out.println("testcase2 inside");  
		 } 
		 
		 @Test(priority=0)  
		 public void testcase3()  
		 {  
		     System.out.println("testcase3 inside");  
		 } 
		 
		 public void Capturescreenshot(WebDriver driver) throws IOException
		 {
			String dateFormat=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			TakesScreenshot screenshot=((TakesScreenshot) driver);
			String path = System.getProperty("user.dir")+"/src/main/resources/screenshots/"+dateFormat+"test.PNG";
			File src= screenshot.getScreenshotAs(OutputType.FILE);
            File destination=new File(path);
			FileUtils.copyFile(src, destination);
			logger.info("screenshot is captured");
			
			
			/*
			 * String dt = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			 * TakesScreenshot screenshot = (TakesScreenshot) driver; String path =
			 * System.getProperty("user.dir")+("/src/main/resources/screenshot"+dt+
			 * "scnshot.png"); File sourcefile =
			 * screenshot.getScreenshotAs(OutputType.FILE); File DestinationFile = new
			 * File(path); FileUtils.copyFile(sourcefile,DestinationFile);
			 */
			 
			 
		 }
		 
		 

	

}
