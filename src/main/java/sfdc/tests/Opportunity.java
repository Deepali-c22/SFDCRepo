package sfdc.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.pages.AccountPage;
import sfdc.pages.LoginPage;
import sfdc.pages.OpportunityPage;
import sfdc.utils.Utilities;


public class Opportunity {

	//@Test
    public void TC15() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		LoginPage lp = new LoginPage(driver);
	    AccountPage ap = new AccountPage(driver);
	    OpportunityPage op = new OpportunityPage(driver);
		Utilities.launchApp(driver);
		lp.enterText(lp.username,Utilities.loginCreds("username","file"));
		lp.enterText(lp.password,Utilities.loginCreds("password","file"));
		lp.click(lp.loginButton);
		String  Actual = "Deepali K";
		String Expected = ap.HomeUserName.getText();
		Assert.assertEquals(Actual,Expected,"Name did not match");
		op.clickOpportunity();
		Thread.sleep(3000);
        Assert.assertEquals(true,op.verifyOppPage());
        
		//System.out.println("I am in opportunity page");
        Assert.assertEquals(true,op.verifyoppddpresent()); // verifying opportunity drop down is present
        Assert.assertTrue(op.verifyoppddoptions());
        
	}
	
	//@Test
    public void TC16() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		LoginPage lp = new LoginPage(driver);
	    AccountPage ap = new AccountPage(driver);
	    OpportunityPage op = new OpportunityPage(driver);
		Utilities.launchApp(driver);
		lp.enterText(lp.username,Utilities.loginCreds("username","file"));
		lp.enterText(lp.password,Utilities.loginCreds("password","file"));
		lp.click(lp.loginButton);
		String  Actual = "Deepali K";
		String Expected = ap.HomeUserName.getText();
		Assert.assertEquals(Actual,Expected,"Name did not match");
		op.clickOpportunity();
		Thread.sleep(3000);
        Assert.assertTrue(op.verifyOppPage());
		Thread.sleep(3000);
        op.createopportunity();
        Assert.assertTrue(op.verifynewopp(),"Opportunity name is different than the newly created opportunity");
        
	
	}
	//@Test
    public void TC17() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		LoginPage lp = new LoginPage(driver);
	    AccountPage ap = new AccountPage(driver);
	    OpportunityPage op = new OpportunityPage(driver);
		Utilities.launchApp(driver);
		lp.enterText(lp.username,Utilities.loginCreds("username","file"));
		lp.enterText(lp.password,Utilities.loginCreds("password","file"));
		lp.click(lp.loginButton);
		String  Actual = "Deepali K";
		String Expected = ap.HomeUserName.getText();
		Assert.assertEquals(Actual,Expected,"Name did not match");
		op.clickOpportunity();
		Thread.sleep(3000);
        Assert.assertTrue(op.verifyOppPage());
        op.oppPipeLine();
		Thread.sleep(3000);

        op.verifyoppinreportpage(op.verifyoppinreportpage);
        //Assertion pending of the pipelined opportunities,will try to download the pipelined opportunity data in a excel
        //or save in logs
        
        
	}
	//@Test
	 public void TC18() throws IOException, InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();

			LoginPage lp = new LoginPage(driver);
		    AccountPage ap = new AccountPage(driver);
		    OpportunityPage op = new OpportunityPage(driver);
			Utilities.launchApp(driver);
			lp.enterText(lp.username,Utilities.loginCreds("username","file"));
			lp.enterText(lp.password,Utilities.loginCreds("password","file"));
			lp.click(lp.loginButton);
			String  Actual = "Deepali K";
			String Expected = ap.HomeUserName.getText();
			Assert.assertEquals(Actual,Expected,"Name did not match");
			op.clickOpportunity();
			Thread.sleep(3000);
	        Assert.assertTrue(op.verifyOppPage());
			op.stuckopportunities();
			Assert.assertEquals(op.stuckoppoverify.getText(),"Stuck Opportunities");
			//System.out.print("i am in stuck opportunity page");
			
		}
	
	@Test
	 public void TC19() throws IOException, InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();

			LoginPage lp = new LoginPage(driver);
		    AccountPage ap = new AccountPage(driver);
		    OpportunityPage op = new OpportunityPage(driver);
			Utilities.launchApp(driver);
			lp.enterText(lp.username,Utilities.loginCreds("username","file"));
			lp.enterText(lp.password,Utilities.loginCreds("password","file"));
			lp.click(lp.loginButton);
			String  Actual = "Deepali K";
			String Expected = ap.HomeUserName.getText();
			Assert.assertEquals(Actual,Expected,"Name did not match");
			op.clickOpportunity();
			Thread.sleep(3000);
	        Assert.assertTrue(op.verifyOppPage());
	        Utilities.click(op.quarter_q);
	        op.selectvalues(op.quateroption,"Current and Next FQ");
	        op.selectvalues(op.Includeoption,"Open Opportunities");
	        Utilities.click(op.runreport);
	        Assert.assertTrue(op.verifyoppinreportpage1(op.Opp_report));
	        //System.out.print("Assertion passed");
	        
	        
		}
}

