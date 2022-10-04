package sfdc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import sfdc.listeners.ListenersDemo;
import sfdc.pages.HomePage;
import sfdc.tests.BaseTest;


@Listeners(ListenersDemo.class)
public class Utilities{

	static WebDriver driver;

	/**This method is developed to replaced the below mentioned login code 
	 * driver.get("https://login.salesforce.com");
	*driver.manage().window().maximize();
	*Thread.sleep(2000);
	 * @param driver
	 * @return 
	 * @return 
	 * @throws IOException 
	 */
	public static String loginCreds(String username,String filename) throws IOException {
	
		Properties p = new Properties();
		FileReader prop = new FileReader(System.getProperty("user.dir")+ "/src/main/resources/"+filename+".properties");
		///Selenium_Automation_2022/src/main/resources/file.properties
		p.load(prop);
		String value= p.getProperty(username);
		return value;

		/*driver.findElement(By.name("username")).sendKeys("deepali.c@adb.com");
		driver.findElement(By.id("password")).sendKeys("SFDC@2022"); 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.id("userNavLabel")).click();*/
		
		
	}
	
	
	public static void launchApp(WebDriver driver)
	{
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
	}
	
	public static void click(WebElement element) {
		element.click();
	}

	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	

	/*public static WebElement tb(String text, String type) {
		
		WebElement	element = driver.findElement(By.xpath(text));
		return element;
			
		}*/
	
	public static WebElement findName(String name )
	{
		return driver.findElement(By.name(name));

	}
	
	public static WebElement findPwd(String pwd )
	{
		return driver.findElement(By.id(pwd));

	}
	
	public static WebElement submit(WebElement element)
	{
		return driver.findElement(By.xpath("//input[@type='submit']"));

	}
	
	public static WebElement findElement(String text,String locator)
	{
		WebElement element = null;
		switch(locator)
		
		{
		case "xpath" :
			element= driver.findElement(By.xpath(text));
			break;
		case "css" :
			element = driver.findElement(By.cssSelector(text));
			break;

		}
		return element;
		
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static boolean usermenudropdown(WebDriver driver) 
	{
		boolean isVerified = true;
		String[] expectedValues = {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};
		
		List<WebElement> menuitems  = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));

		for(int i = 0;i<menuitems.size();i++)
			
		{
			//String Actual = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a"+"["+ (i+1) +"]")).getText();
			String actual= menuitems.get(i).getText();
			
			if(actual.equals(expectedValues[i]))
			{
				System.out.println(expectedValues[i] + " verified successfully");
				
			}
			else
			{
				System.out.println(expectedValues[i] + " failed ");

				return isVerified=false;
			}
		}
		return isVerified;
	}
	
	
	
	
	public static boolean selectUserMenuOption(String option, WebDriver driver) throws InterruptedException
	{
		boolean isElementDisplayed = true;
		 
		WebElement wb = (WebElement)driver.findElements((By.xpath("//*[contains(text(),"+option+")]")));	
		
		if(wb.isDisplayed())
		{
			wb.click();

		}
		else
		
			
		{
			return isElementDisplayed = false;
		}
		return isElementDisplayed;

	}
	
	/**
	 * This method does edit profile operation,in about tab in the 'My Profile' tab
	 * @param abouttab
	 * @param lastname
	 * @param nametext
	 * @param saveall
	 * @return boolean true or false based on the operation
	 */
	public static boolean editProfile(WebElement abouttab,WebElement lastname ,String nametext, WebElement saveall)
	{
		
		boolean isSaved=false;
		
		if(abouttab.isDisplayed())
		{
			abouttab.click();
			lastname.clear();
			lastname.sendKeys(nametext);
			saveall.click();
			
			isSaved=true;
		}
		return isSaved;
		
	}
	
	public static boolean uploadaFile(WebElement file,WebElement fileupload,WebElement choosefile,String filepath,WebElement share )
	{
		boolean fileuploaded = false;
		if(file.isEnabled())
		{
		file.click();
		fileupload.click();
		choosefile.sendKeys(filepath);
		share.click();
		fileuploaded = true;
		}
		return fileuploaded;
	}
	
	public static boolean addPhoto(WebElement displaybadge,WebElement uploadinputfile, String uploadfilepath,WebElement uploadbbutton )
	{
		boolean addphoto = false;
		if(displaybadge.isEnabled())
		{
			displaybadge.click();
			 driver.switchTo().frame("uploadPhotoContentId");

			uploadinputfile.click();
			uploadinputfile.sendKeys(uploadfilepath);
			uploadbbutton.click();
			addphoto = true;
		}
		return addphoto;
	}
	
	public static boolean createPost(WebElement post, String entertext,WebElement btn)
	{
		 boolean isPostCreated=false;
		 
		if(post.isDisplayed())
		{
			Utilities.switchToIframe(0);
			post.click();
			post.sendKeys(entertext);
			if(btn.isDisplayed())
			{
				btn.click();
				isPostCreated=true;
			}
			 driver.switchTo().defaultContent();
		}
		
		return isPostCreated;
		
		 

	}
	
	public static void switchToIframe(int frameNum)
	{
		driver.switchTo().frame(frameNum);
	}
	
	public boolean WaitforElement(WebDriver driver,WebElement element)
	{
		
	      WebDriverWait wait = new WebDriverWait(driver,3);
		try {
		//wait.until(ExpectedConditions.visibilityOf(element));
		//	wait.until(ExpectedConditions.visibilityOf(element));
		return true;
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		return false;
		}
		
	}

	public static boolean loginDetails(WebElement textBox, WebElement textBox1, WebElement button) {

		boolean isLoggedIn = false;
		if(textBox.isDisplayed()) {
			textBox.sendKeys("deepali.c@adb.com");
			System.out.println("Eneterd text");
			textBox1.clear();
			System.out.println("Cleared the textbox");
			if(button.isDisplayed()) {
				button.click();
				System.out.println("Clicked on the submit button");
				isLoggedIn = true;
			}
		}
		return isLoggedIn;
	}
	
	public static void loginAccepted(WebElement tb, WebElement tb1, WebElement btn) {

		if(tb.isDisplayed()) {
			tb.sendKeys("deepali.c@adb.com");
			System.out.println("Eneterd username");
			tb1.sendKeys("SFDC@2022");
			System.out.println("Entered password");
			if(btn.isDisplayed()) {
				btn.click();
				System.out.println("Clicked on the submit button");
			}
		}
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
	
	public static Boolean verifyusermenuitems(WebDriver driver)
	{
        Boolean returnval=false;
		HomePage hp= new HomePage(driver);
        //hp.usermenu.click();
		String[] expectedValues = {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};

		for(int i = 0;i<expectedValues.length;i++)
		{
			//String Actual = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a"+"["+ (i+1) +"]")).getText();
			String Actual=hp.usermenu.get(i).getText();
			WebElement val= hp.usermenu.get(i);
			
			
			 if(Actual.equals("Logout")) 
			 { 
              val.click();
              returnval=true;
			  	 
			 }
			 
			
			//System.out.print(hp.usermenu.get(i+1).toString());
		}
		return returnval;
	}
	
	

}

