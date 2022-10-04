package sfdc.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.listeners.ListenersDemo;
import sfdc.pages.ContactPage;
import sfdc.pages.HomePage;
import sfdc.pages.LeadsPage;
import sfdc.pages.LoginPage;
import sfdc.utils.Utilities;

@Listeners(ListenersDemo.class)
public class Contacts extends BaseTest{
	
	Logger logger = LogManager.getLogger(Contacts.class);

	//@Test
	public void TC25() throws IOException, InterruptedException
	{
	WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	ContactPage cp=new ContactPage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);
    lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	Thread.sleep(3000);
	lp1.click(cp.Contact_Tab);
	Thread.sleep(3000);
    lp1.click(cp.newtab);
    Utilities.enterText(cp.lastname, "Robin");
    Utilities.enterText(cp.Accountname, "sep_15");
	Thread.sleep(3000);
    lp1.click(cp.save);
	lp1.click(cp.Contact_Tab);
	Thread.sleep(3000);
    cp.verifyContactCreated();
	
	}
	
	//@Test
	public void TC26() throws IOException, InterruptedException
	{
	WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	ContactPage cp=new ContactPage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);
    lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	Thread.sleep(3000);
	lp1.click(cp.Contact_Tab);
	Thread.sleep(3000);
	lp1.click(cp.CreateView);
	Utilities.enterText(cp.viewname,"eeeee");
	String str= cp.viewname.getAttribute("value");
	Utilities.enterText(cp.viewUniqueName, "ee");
	lp1.click(cp.save);
	Assert.assertTrue(cp.verifyViewVal(str));
	
	}
	
	
//	@Test
	public void TC27() throws IOException, InterruptedException
	{
	WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	ContactPage cp=new ContactPage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);
    lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	Thread.sleep(3000);
	lp1.click(cp.Contact_Tab);
	Thread.sleep(3000);
	Assert.assertTrue(cp.verifyddvalue("Recently Created",cp.recentdd));
	
	}
	
	//@Test
	public void TC28() throws IOException, InterruptedException
	{
	WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	ContactPage cp=new ContactPage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);
    lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	Thread.sleep(3000);
	lp1.click(cp.Contact_Tab);
	Thread.sleep(3000);
	Assert.assertTrue(cp.verifyddvalue("My Contacts",cp.viewdd));

	
	}
	
	//@Test
	public void TC29() throws IOException, InterruptedException
	{
	WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	ContactPage cp=new ContactPage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);
    lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	Thread.sleep(3000);
	lp1.click(cp.Contact_Tab);
	Thread.sleep(3000);
	lp1.click(cp.contactname);
	
	}

	//@Test
	public void TC30() throws IOException, InterruptedException
	{
	WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	ContactPage cp=new ContactPage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);
    lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	Thread.sleep(3000);
	lp1.click(cp.Contact_Tab);
	Thread.sleep(3000);
	lp1.click(cp.CreateView);
	//Utilities.enterText(cp.viewname,"eeeee");
	//String str= cp.viewname.getAttribute("value");
	Utilities.enterText(cp.viewUniqueName, "EFGH");
	lp1.click(cp.save);
	Assert.assertTrue(cp.errormsg("Error: You must enter a value"));
	}
	
	@Test
	public void TC31() throws IOException, InterruptedException
	{
	//WebDriverManager.chromedriver().setup();
    ExtentTest test=ext.createTest("TC01");
	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	ContactPage cp=new ContactPage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);
    lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
    logger.info("Logged in to the application");
	test.log(Status.INFO,"Logged in to the application");
	Thread.sleep(3000);
	lp1.click(cp.Contact_Tab);
	Thread.sleep(3000);
	lp1.click(cp.CreateView);
	Utilities.enterText(cp.viewname,"ABCD");
	String str= cp.viewname.getAttribute("value");
	Utilities.enterText(cp.viewUniqueName, "EFGH");
    lp1.click(cp.cancel);
    logger.debug("Clciked on cancel button");
   // Utilities.CaptureScreenshot(driver);
	//logger.info("logger log4j");
	test.pass("Clicked on cancel button");
	test.addScreenCaptureFromPath(Utilities.CaptureScreenshot(driver));
	}

}

