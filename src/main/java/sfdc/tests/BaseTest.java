package sfdc.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.listeners.ListenersDemo;

@Listeners(ListenersDemo.class)

public class BaseTest {
	public static ExtentReports ext;
	public static ExtentTest test;
	public WebDriver driver;

	@BeforeSuite
	public void setup()
	{
		WebDriverManager.chromedriver().setup();

	}
	
    @BeforeSuite
	public void extentreport() {
		// TODO Auto-generated method stub
    	String dt= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String reportPath = System.getProperty("user.dir")+"/src/main/resources/reports/"+ dt +"extentreport.html";
		ext = new ExtentReports();
		ExtentHtmlReporter html = new ExtentHtmlReporter(reportPath);
		ext.attachReporter(html);
		
	}
    
    @AfterTest
    public void flush()
    {
    ext.flush();
    }
    
	public static String CaptureScreenshot(WebDriver driver) throws IOException
	{
		
		String dt = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String path = System.getProperty("user.dir")+("/src/main/resources/screenshots/"+dt+"screenshot.png");
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File DestinationFile = new File(path);
		FileUtils.copyFile(sourcefile,DestinationFile);
		System.out.print("Screenshot captured");
		return path;
		
		
		
	}
    


}
