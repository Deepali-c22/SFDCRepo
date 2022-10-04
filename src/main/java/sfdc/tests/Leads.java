package sfdc.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.pages.AccountPage;
import sfdc.pages.HomePage;
import sfdc.pages.LeadsPage;
import sfdc.pages.LoginPage;
import sfdc.utils.Utilities;

public class Leads extends BaseTest{

	//@Test
	public void TC20() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);

	lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	Thread.sleep(3000);
	lp1.click(lp.Leadstab);
	Thread.sleep(3000);

	lp1.click(hp.username);
	Thread.sleep(3000);
    Assert.assertTrue(Utilities.verifyusermenuitems(driver));
    driver.quit();	
	}
	
	//@Test
	public void TC21() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);

	lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	Thread.sleep(3000);
	lp1.click(lp.Leadstab);
	Thread.sleep(3000);
	lp1.click(lp.viewdd);
	Assert.assertTrue(lp.verifyViewDropdown());
	
	}
	
	@SuppressWarnings("static-access")
	//@Test
	public void TC22() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);

	lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	Thread.sleep(3000);
	lp1.click(lp.Leadstab);
	Thread.sleep(3000);
	lp1.click(lp.viewdd);
	lp.SelectData();
	lp1.click(hp.username);
	lp1.click(hp.logout);
	Thread.sleep(3000);
	lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	lp1.click(lp.Leadstab);
	Assert.assertTrue(lp.verifyviewddselection());
	lp1.click(lp.go);

	}
	
	//@Test
	public void TC23() throws IOException, InterruptedException
	{
	WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);

	lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	Thread.sleep(3000);
	lp1.click(lp.Leadstab);
	lp1.click(lp.viewdd);
	lp.verifyTodaydd("Today's Leads");
	
	}
	
	@Test
	public void TC24() throws IOException, InterruptedException
	{
	WebDriverManager.chromedriver().setup();

	WebDriver driver=new ChromeDriver();
	LeadsPage lp = new LeadsPage(driver);
	LoginPage lp1= new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	//lp1.enterText(Utilities.loginCreds(lp1.username,"file");
	Utilities.launchApp(driver);
    lp1.enterText(lp1.username,Utilities.loginCreds("username","file"));
	lp1.enterText(lp1.password,Utilities.loginCreds("password","file"));
	lp1.click(lp1.loginButton);
	Thread.sleep(3000);
	lp1.click(lp.Leadstab);
	Thread.sleep(3000);
    lp1.click(lp.newtab);
	Thread.sleep(3000);

	Utilities.enterText(lp.lastname, "Jackson");
	Utilities.enterText(lp.company, "Adb");
	lp1.click(lp.save);
	
	WebElement w = driver.findElement(By.xpath("//table[@class='list']//a"));

	
	}
	
}
