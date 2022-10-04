package sfdc.tests;

import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.utils.Utilities;

public class UserMenuDropDown {

	WebDriver driver= new ChromeDriver();
    
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
		 UserMenuDropDown dr = new UserMenuDropDown();
		// dr.TC5();
		 dr.TC6();
		// dr.TC7();
        //dr.TC8();
		// dr.TC9();


	}
	
	
	
	public void TC5() throws InterruptedException
	{
		 //WebDriverManager.firefoxdriver().setup();

		//driver.get("https:amazon.com");
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.name("username")).sendKeys("deepali.c@adb.com");
		driver.findElement(By.id("password")).sendKeys("SFDC@2022"); 

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		
		driver.findElement(By.id("userNavLabel")).click();
		
         Assert.assertTrue(Utilities.usermenudropdown(driver));
		/*String[] expectedValues = {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};

		

		for(int i = 0;i<expectedValues.length;i++)
		{
			String Actual = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a"+"["+ (i+1) +"]")).getText();
			
			if(Actual.equals(expectedValues[i]))
			{
				System.out.println(expectedValues[i] + " verified successfully");
			}
		}*/
		
		//Replaced above block of code with utilities  one line of code
		
            
		
	}
	
	public void TC6() throws InterruptedException
	{
		 //WebDriverManager.firefoxdriver().setup();

		//driver.get("https:amazon.com");
		//WebDriver driver = new FirefoxDriver();
		Utilities.launchApp(driver);
		Thread.sleep(2000);
		
		//Utilities.loginCreds(driver);
		
		
		
		/*String[] expectedValues = {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};

		

		for(int i = 0;i<expectedValues.length;i++)
		{
			String Actual = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a"+"["+ (i+1) +"]")).getText();
			
			if(Actual.equals(expectedValues[i]))
			{
				System.out.println(expectedValues[i] + " verified successfully");
			}
		}*/
		
		//Replaced above code with below one line code of utilities class
		
		 Assert.assertTrue(Utilities.usermenudropdown(driver));
		 
		 //driver.findElement((By.xpath("//div[@id='userNav-menuItems']/a[1]"))).click();
		 
		// Replaced above code with Utilities class one line code

		 Assert.assertTrue(Utilities.selectUserMenuOption("My Profile",driver));
		 
		 
		 
		 Thread.sleep(5000);
		 
		 driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']")).click();
		
		 driver.switchTo().frame("contactInfoContentId");
		 
		 WebElement abouttab = driver.findElement(By.xpath("//li[@id='aboutTab']/a"));		  
		 WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		 lastname.sendKeys("k");
		 WebElement saveall = driver.findElement(By.xpath("//input[@value='Save All']"));
		 
		 Assert.assertTrue(Utilities.editProfile(abouttab, lastname, lastname.getText(), saveall));
		 
		 driver.switchTo().defaultContent();
		 
		 
		 WebElement post = Utilities.findElement("#publisherAttachTextPost>span.publisherattachtext", "css");
		 WebElement entertext =Utilities.findElement("/html/body", "xpath");
		 entertext.sendKeys("My first comment through automation");
		 WebElement btn = Utilities.findElement("//input[@id='publishersharebutton']","xpath");
		 Utilities.createPost(post, entertext.getText(), btn);

		 
		 Thread.sleep(5000);
		 //Click on the  file link and click on "upload a file from computer" button.
		 //Click on choose file button and select a file to be uploaded and click open button.
		 //Selected file should be posted
		 
		 WebElement file=driver.findElement(By.xpath("//a[@title='File']"));
		 
		 WebElement fileupload=driver.findElement(By.id("chatterUploadFileAction"));
		 
		 ////input[@id='chatterFile']
		 Thread.sleep(5000);

		 WebElement choosefile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		 choosefile.sendKeys("/Users/alokkhare/Desktop/Profile pic.png");
		 
		 WebElement sharebutton = driver.findElement(By.id("publishersharebutton"));
		 
		 Assert.assertTrue(Utilities.uploadaFile(file, fileupload, choosefile, choosefile.getText(), sharebutton));
		 
		 Thread.sleep(5000);

		 //driver.findElement(By.id("photoSection")).click();
		WebElement displaybadge =  driver.findElement(By.id("displayBadge"));
		 
		 
		 WebElement uploadinputfile = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		 uploadinputfile.sendKeys("/Users/alokkhare/Desktop/Profile pic.png");


		// driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:save']")).click();
		 WebElement uploadbbutton = driver.findElement(By.name("j_id0:uploadFileForm:uploadBtn"));
		 
		 Assert.assertTrue(Utilities.addPhoto(displaybadge, uploadinputfile, uploadinputfile.getText(), uploadbbutton));
		 Thread.sleep(5000);
		 
		 driver.findElement(By.name("j_id0:j_id7:save")).click();

		
	}
	
	public void TC7() throws InterruptedException
	{
		 //WebDriverManager.firefoxdriver().setup();

		//driver.get("https:amazon.com");
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("deepali.c@adb.com");
		driver.findElement(By.id("password")).sendKeys("SFDC@2022"); 

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		
		driver.findElement(By.id("userNavLabel")).click();
		String[] expectedValues = {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};

		

		for(int i = 0;i<expectedValues.length;i++)
		{
			String Actual = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a"+"["+ (i+1) +"]")).getText();
			
			if(Actual.equals(expectedValues[i]))
			{
				System.out.println(expectedValues[i] + " verified successfully");
			}
		}
		 driver.findElement((By.xpath("//div[@id='userNav-menuItems']/a[2]"))).click();
		 
		 Thread.sleep(5000);
		 
		 driver.findElement(By.id("PersonalInfo_font")).click();
		 driver.findElement(By.xpath("//a[@id='LoginHistory_font']")).click();
		 
		 driver.findElement(By.id("DisplayAndLayout_font")).click();
		 driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']")).click();
		
		 
			Select SC = new Select(driver.findElement(By.name("p4")));

			SC.selectByVisibleText("Salesforce Chatter");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollBy(0,1000)");
			
             Select objSelect =new Select(driver.findElement(By.xpath("//select[@id='duel_select_0']")));
					 objSelect.selectByVisibleText("Reports");
					 
					 driver.findElement(By.className("rightArrowIcon")).click();
					 
					 driver.findElement(By.xpath("//a[@class='header setupFolder']/span[text()='Email']")).click();
					 driver.findElement(By.id("EmailSettings_font")).click();
					 driver.findElement(By.id("sender_name")).clear();
					 driver.findElement(By.id("sender_name")).sendKeys("Deepali");
					 
					 driver.findElement(By.id("sender_email")).clear();
					 driver.findElement(By.id("sender_email")).sendKeys("Deepali.chakradhar@gmail.com");

    WebElement radio1 = driver.findElement(By.id("auto_bcc1"));	
				        
				        if(!radio1.isSelected())
				        {
				        	radio1.click();
				        }
				        else {
				        	System.out.print("radibutton is already selected");
				        }
				        
				        driver.findElement(By.name("save")).click();
				        
				        driver.findElement(By.id("CalendarAndReminders_font")).click();
				   	 driver.findElement(By.xpath("//a[@id='Reminders_font']")).click();
				   	 driver.findElement(By.xpath("//input[@value='Open a Test Reminder']")).click();
				   	
				        
				       
				        }
	
	public void TC8() throws InterruptedException
	{
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("deepali.c@adb.com");
		driver.findElement(By.id("password")).sendKeys("SFDC@2022"); 

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		
		driver.findElement(By.id("userNavLabel")).click();
		String[] expectedValues = {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};

		

		for(int i = 0;i<expectedValues.length;i++)
		{
			String Actual = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a"+"["+ (i+1) +"]")).getText();
			
			if(Actual.equals(expectedValues[i]))
			{
				System.out.println(expectedValues[i] + " verified successfully");
			}
		}
		 driver.findElement((By.xpath("//div[@id='userNav-menuItems']/a[3]"))).click();
		 
		 Thread.sleep(5000);
		 
		 // TC says "Click on close button the developer console browser" but i did not see any close button on the window other then the red cross mark on the top left
		 //so used quit method to close the window
		 driver.quit();
		 //driver.getWindowHandle();
		 
		 
	}

				    
	public void TC9() throws InterruptedException
	{
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("deepali.c@adb.com");
		driver.findElement(By.id("password")).sendKeys("SFDC@2022"); 

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		
		driver.findElement(By.id("userNavLabel")).click();
		String[] expectedValues = {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};

		

		for(int i = 0;i<expectedValues.length;i++)
		{
			String Actual = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a"+"["+ (i+1) +"]")).getText();
			
			if(Actual.equals(expectedValues[i]))
			{
				System.out.println(expectedValues[i] + " verified successfully");
			}
		}
		 driver.findElement((By.xpath("//div[@id='userNav-menuItems']/a[5]"))).click();
		 
		 //driver.findElement(By.xpath("//a[@title='Logout']")).click();
		
		 
		 
	}
	
	
	
	        
	            



				

					}

	
	
	
	

	



