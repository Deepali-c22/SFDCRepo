package sfdc.tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.pages.AccountPage;
import sfdc.pages.LoginPage;
import sfdc.utils.Utilities;

public class Account extends BaseTest{

	//private static Logger logger = LogManager.getLogger(Account.class.getName());

	//@Test
	public void TC10() throws InterruptedException

	{
		WebDriver driver = new ChromeDriver();

		Utilities.launchApp(driver);
//Utilities.loginCreds(driver);
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("deepali.c@adb.com");
		driver.findElement(By.id("password")).sendKeys("SFDC@2022");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.id("Account_Tab")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value=' New ']")).click();
		driver.findElement(By.xpath("//*[@id='acc2']")).sendKeys("Account_1");
		driver.findElement(By.name("save")).click();

	}

	////@Test
	public void TC11() throws InterruptedException

	{
		WebDriver driver = new ChromeDriver();

		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("deepali.c@adb.com");
		driver.findElement(By.id("password")).sendKeys("SFDC@2022");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.id("Account_Tab")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@href='/ui/list/FilterEditPage?ftype=a&retURL=%2F001&cancelURL=%2F001%2Fo']"))
				.click();
		driver.findElement(By.id("fname")).sendKeys("Account_2_view");
		driver.findElement(By.id("devname")).sendKeys("Account_2_view_unique");
		driver.findElement(By.name("save")).click();

	}
	
	///@Test
    public void TC12() throws InterruptedException

	{		WebDriver driver = new ChromeDriver();


		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Utilities.loginCreds(driver);

		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("deepali.c@adb.com");
		driver.findElement(By.id("password")).sendKeys("SFDC@2022");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.id("Account_Tab")).click();
//Thread.sleep(2000);

//PUT TRY CATCH TO RESOLVE "Element is not attached to DOM", PREVIOUSLY I GOT THAT ERROR SO WRITTEN BELOW CODE,

//try{

//WebElement dropdown = driver.findElement(By.xpath("//select[@id='fcf']"));
//dropdown.click();
//Select dd = new Select(dropdown);
//dd.selectByVisibleText("Account_1_view");
//}
//catch(Exception e)
//{
//	WebElement dropdown = driver.findElement(By.xpath("//select[@id='fcf']"));
//dropdown.click();
//Select dd = new Select(dropdown);
//dd.selectByVisibleText("Account_1_view");
//}

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='fcf']"));
		dropdown.click();

		Select dd = new Select(dropdown);
		dd.selectByVisibleText("New_Account_2_view");

//Thread.sleep(2000);

		driver.findElement(
				By.xpath("//a[@href='/ui/list/FilterEditPage?id=00B8V00000CVte3&retURL=%2F001&cancelURL=%2F001%2Fo']"))
				.click();
		driver.findElement(By.id("fname")).sendKeys("New_Account_3_view");

		WebElement dropdown1 = driver.findElement(By.id("fcol1"));
		dropdown1.click();

		Select dd1 = new Select(dropdown1);
		dd1.selectByVisibleText("Account Name");

		WebElement dropdown2 = driver.findElement(By.id("fop1"));
		dropdown2.click();

		Select dd2 = new Select(dropdown2);
		dd2.selectByVisibleText("contains");

		driver.findElement(By.id("fval1")).sendKeys("a");

		WebElement dropdown3 = driver.findElement(By.id("colselector_select_0"));
		Select dd3 = new Select(dropdown3);

		dd3.selectByVisibleText("Last Activity");

		driver.findElement(By.id("colselector_select_0_right")).click();

		driver.findElement(By.name("save")).click();

	}

	//@Test

	public void TC13() throws InterruptedException

	{		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Utilities.launchApp(driver);

		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("deepali.c@adb.com");
		driver.findElement(By.id("password")).sendKeys("sfdc@2022");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.id("Account_Tab")).click();
//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[ text() ='Merge Accounts']")).click();
		driver.findElement(By.id("srch")).sendKeys("Apple");
//Thread.sleep(5000);
		driver.findElement(By.name("srchbutton")).click();

		List<WebElement> checkbox = driver.findElements(By.className("cb1-element"));

		int Size = checkbox.size(); // Finding the number of check boxes

		for (int i = 0; i < Size; i++) // Starts the loop from first check box to the last one
		{
			String val = checkbox.get(i).getAttribute("Value");
//check box name stored to the string variable, using ‘Value' attribute

			if (val.equalsIgnoreCase("cb1-element "))
//equalsIgnoreCase is ignore case (upper/ lower)   
			{
				// Selecting the check box if its value is same as that we are looking for
				checkbox.get(i).click();
				break;
			}
		}
		WebElement val1 = driver.findElement(By.xpath("//input[@value='0018V00002Nn7z8']"));

		WebElement val2 = driver.findElement(By.xpath("//input[@value='0018V00002RMcU2']"));
		if (!val1.isSelected()) {
			driver.findElement(By.xpath("//input[@value='0018V00002Nn7z8']")).click();
		}
		if (val2.isDisplayed() && !val2.isSelected()) {
			driver.findElement(By.xpath("//input[@value='0018V00002RMcU2']")).click();
		}
		driver.findElement(By.xpath("//input[@value=' Next ']")).click();
		driver.findElement(By.xpath("//input[@value=' Merge ']")).click();

//Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();
		alert.accept();

//driver.switchTo().activeElement().submit();
	}

	@Test
	public void TC14() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();

		Utilities.launchApp(driver);
		LoginPage lp = new LoginPage(driver);
		AccountPage ap = new AccountPage(driver);
		lp.enterText(lp.username, Utilities.loginCreds("username", "file"));
		lp.enterText(lp.password, Utilities.loginCreds("password", "file"));
		lp.click(lp.loginButton);
		String Actual = "Deepali K";
		String Expected = ap.HomeUserName.getText();
		Assert.assertEquals(Actual, Expected, "Name did not match");
//System.out.println("Username is correct");
//ap.click(ap.AccountTab);
		ap.AccountTabclick();
		Assert.assertEquals(Actual, Expected, "Name did not match");
//ap.click(ap.LastActivity);
		ap.LastActivityclick();
		Assert.assertEquals(ap.UnsavedReport.getText(), "Unsaved Report");
//System.out.println("I am in Unsaved Report page sysout");
		ap.Datefield();
		ap.FromDate();
		ap.ToDate();
		Thread.sleep(5000);
		ap.LastDateCreated();
		ap.QualifiedAccounts();
		ap.savereport.click();
		ap.reportname("Sep_Report7");
		ap.developername("DeepaliC");
		Thread.sleep(5000);
		ap.saveandrun();
		Thread.sleep(5000);
//ap.verifyreportname();
		Assert.assertEquals(ap.verifyreport.getText(), ap.repName);
		//logger.info("logger print");
//System.out.print("report name is showing up correctly");

	}

}
