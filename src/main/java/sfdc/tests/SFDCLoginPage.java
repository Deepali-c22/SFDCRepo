package sfdc.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.dockerjava.api.model.LogConfig.LoggingType;

import io.github.bonigarcia.wdm.WebDriverManager;
//import sfdc.com.pages.LoginPage;
import sfdc.utils.Utilities;

public class SFDCLoginPage {
	

	public WebDriver driver; 
	Logger logger = LogManager.getLogger(SFDCLoginPage.class);

	public ExtentReports extRpt;
	public ExtentTest test;
	private sfdc.pages.LoginPage lp = null;

	
	@BeforeSuite
	public void initialization()
	{
		
	}
	
	@BeforeTest
	public void initializeReports()
	{
		String dateformat= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String ReportPath = System.getProperty("user.dir")+"/src/main/resources/reports/ "+dateformat+"demoreport.html";
		extRpt = new ExtentReports();
		ExtentHtmlReporter extrpt1 = new ExtentHtmlReporter(ReportPath);
		extRpt.attachReporter(extrpt1);
	}
	

@BeforeSuite
public void Setup()
{
	WebDriverManager.chromedriver().setup();
	logger.debug("webdriver manager has started");
	 driver = new  ChromeDriver();	
	 //driver.get("https://login.salesforce.com");
}

/*@BeforeMethod
public void appLaunch()
{
	Utilities.loginCreds(driver); 
}*/

@BeforeClass
public void launchApp()
{
    Utilities.launchApp(driver);

}

@Test
	public void TC1() throws InterruptedException, IOException
	{
	//driver.get("https://login.salesforce.com");
	//driver.manage().window().maximize();		
		  
	    //SoftAssert as = new SoftAssert();
		 
		test = extRpt.createTest("TC1");
		String Expectedtitle = "Login | Salesforce";
		String ActualTitle= driver.getTitle();
		Assert.assertEquals(ActualTitle,Expectedtitle,"title match the text");
		
	      // System.out.println("TC1 Executed title  verification");
        logger.info("TC1 executed title verification");
        
        
        Utilities.launchApp(driver);
	    
	    WebElement textbx =driver.findElement(By.id("username"));
		textbx.sendKeys("deepali.c@adb.com");
		String Expectedtext = "deepali.c@adb.com";
		String Actualtext = textbx.getAttribute("value");
		Assert.assertEquals(Actualtext,Expectedtext,"should match the text");
		
	       System.out.println("TC1 Executed textbox value verification");

		WebElement texbx1=driver.findElement(By.id("password"));
        texbx1.clear();
        
        String Expectedpwd ="";
        String Actualpwd = texbx1.getAttribute("value");
        
        Assert.assertEquals(Expectedpwd, Actualpwd,"pwd values should match");
        
        System.out.println("TC1 Executed pwd verification");

       // WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        //Replaced above line with below line  to make use of utilities
        
        //WebElement submit =Utilities.findElement("//input[@type='submit']","xpath");
        
         driver.findElement(By.xpath("//input[@type='submit']")).click();
        
       //Utilities.click(submit);
       
       String Expected = "Please enter your password.";
       Thread.sleep(5000); 
       String Actual = driver.findElement(By.xpath("//div[@id='error']")).getText();
       
       
       
       //HARD ASSERT : once the assert fails it will stop the execution of the program
        Assert.assertEquals(Actual, Expected,"should match");
       
       //SOFT ASSERT : even if the assert fails it will continue the execution of the remaining part of the program/method
       // to make its further execution stop, should put Assert.All();
        
       //as.assertEquals(Actual, Expected,"values should match");
       System.out.println("TC1 Executed error message verification");
       Utilities.CaptureScreenshot(driver);
        
        
		/*WebElement textbx =driver.findElement(By.id("username"));
		WebElement texbx1=Utilities.findPwd("password");


		/*WebElement textbx=driver.findElement(By.name("username"));
		WebElement texbx1= driver.findElement(By.id("password")); 
		WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));*/
	    
	   /* WebElement usernameElement = driver.findElement(By.name("username"));
		usernameElement.sendKeys(username);
		test.log(Status.INFO, "Username is entered");
		String actualUsername = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUsername, username, "username displayed should be equal");*/
		
		
		/*Assert.assertEquals("deepali.c@adb.com",textbx,"value should match");
		System.out.print("TC completed");
		WebElement texbx1=Utilities.findPwd("password");
		WebElement submitBtn=Utilities.submit();
		Assert.assertTrue(Utilities.loginDetails(textbx, texbx1, submitBtn)); */
		
		
		
	}
	
	
	public void TC2() throws IOException, InterruptedException
	{
		test = extRpt.createTest("TC2");

		lp = new sfdc.pages.LoginPage(driver);

		Utilities.launchApp(driver);
		Utilities.loginCreds("username","file");
		lp.enterText(lp.username,"Hello");
		test.log(Status.DEBUG,"user name entered");
		lp.enterText(lp.password,"abc");
		test.log(Status.DEBUG,"user password");

	    lp.click(lp.loginButton);
		test.log(Status.DEBUG,"clicked on login button");

		String ac = lp.loginError.getText();
		String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
				
		Thread.sleep(5000);
		//SoftAssert asrt = new softAssert();
        Assert.assertEquals(ac,expected,"error message is not same as expected");
        test.log(Status.PASS,"test passed");
	

		/*WebElement tb =driver.findElement(By.name("username"));
		WebElement tb1 = driver.findElement(By.id("password"));
		WebElement btn = driver.findElement(By.xpath("//input[@type='submit']"));
		Utilities.loginAccepted(tb, tb1, btn);*/
		Utilities.CaptureScreenshot(driver);
		
		
		
	}
	
	public void TC3() throws InterruptedException
	{
	   //  Utilities.loginCreds(driver);  

		WebElement e = driver.findElement(By.name("username"));
		 e.sendKeys("deepali.c@adb.com");
		 
		String s = e.getText(); // Not able to catch send keys text in a string
		
		
		driver.findElement(By.id("password")).sendKeys("SFDC@2022"); 
		driver.findElement(By.id("rememberUn")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@title='Logout']")).click();
		//WebElement e1=	driver.findElement(By.xpath("//span[@id='idcard-identity']"));
		Thread.sleep(3000);

		WebElement e1 = driver.findElement(By.cssSelector("#idcard-identity")); 
		String s2=e1.getText();
		
		//if(s.equals(s2))
				//{
			//System.out.print("User name is correct");
			//	}
		
		


	}
				
				public void TC4A() throws InterruptedException
				{
				    //Utilities.loginCreds(driver);  

					driver.findElement(By.xpath("//a[@href='/secur/forgotpassword.jsp?locale=us']")).click();
					driver.findElement(By.xpath("//input[@id='un']")).sendKeys("deepali.c@adb.com");
					driver.findElement(By.xpath("//input[@type='submit'][1]")).click();

				}
				
				public void TC4B() throws InterruptedException
				{
				   // Utilities.loginCreds(driver);  

					driver.findElement(By.name("username")).sendKeys("a.c@adb.com");
					driver.findElement(By.id("password")).sendKeys("a@2022"); 

					driver.findElement(By.xpath("//input[@type='submit']")).click();
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
					
					js.executeScript("alert('leave this site')" );

				}
	
	
	
	/*public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
    	SFDCLoginPage sfdclogin = new SFDCLoginPage();
		sfdclogin.TC1();


		//WebDriver driver = new FirefoxDriver();
		//sfdclogin.TC2();
		//sfdclogin.TC3();
		//sfdclogin.TC4A();
		//sfdclogin.TC4B();
 
	}*/

}

