package sfdc.pages;

import java.lang.System.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage {
	static org.apache.logging.log4j.Logger logger = LogManager.getLogger(AccountPage.class.getName());

	public String repName;
	public String UnsavedRep;

	public AccountPage(WebDriver driver) {
		
		  PageFactory.initElements(driver,this);
		
	}

	@FindBy( id="fcf")
	public WebElement view;
	

	@FindBy( xpath="//input[@value=' Go! ']")
	public WebElement Go;
	
	@FindBy(xpath="text()='Edit'")
	public WebElement edit;
	
	@FindBy(xpath="text()='Create New View'")
	public WebElement createNewView;
	
	@FindBy(xpath="text()='//input[@value=' New ']'")
	public WebElement New;
	
	@FindBy(xpath="text()='Merge Accounts'")
	public WebElement mergeaccounts;
	
	@FindBy(xpath="//span[@id='userNavLabel']")
	public  WebElement HomeUserName;
	
	@FindBy(xpath="//a[@title='Accounts Tab']")
	public WebElement AccountTab;
	
	
	@FindBy(xpath="//a[text()='Accounts with last activity > 30 days']")
	public  WebElement LastActivity;
	
     @FindBy(xpath="//h2[text()='Unsaved Report']")
     public WebElement UnsavedReport;
     
     @FindBy(xpath="//input[@name='dateColumn']")
     public WebElement Datefield;
     
     @FindBy(xpath="//div[text()='Created Date']")
     public WebElement CreatedDate;
     
     @FindBy(xpath="//div/a/*[text()='Last Modified Date']")
     public WebElement LastDateModified;
     
     @FindBy(id="ext-gen152")
     public WebElement FromDate;
     
     @FindBy(id="ext-gen154")
      public WebElement ToDate;
     
     
     @FindBy(id="ext-gen281")
     public WebElement fromtoday;
     
     
     @FindBy(id="ext-gen296")
     public WebElement Totoday;
     
     @FindBy(xpath="//div/table/tbody/tr/td[7]")
     public WebElement Datecoloum;

     
     @FindBy(id="ext-comp-1042")
    public WebElement FromTextbox;
     
     @FindBy(id="ext-comp-1045")
     public WebElement ToTextbox;
     
     @FindBy(id="ext-gen49")
     public WebElement savereport;
     
     @FindBy(id="saveReportDlg_reportNameField")
     public WebElement reportname;
     
     @FindBy(id="saveReportDlg_DeveloperName")
     public WebElement developername;
     
     @FindBy(id="ext-gen316")
     public WebElement saveandrun;
     
     @FindBy(xpath="//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1")
     public WebElement verifyreport;
     
  
     
     
     
	public void getHomePageUserName(){
		
	  HomeUserName.click();
	  logger.info("Home page user name clicked");
	 
	}
	
	public void click(WebElement element)
	{
		element.click();
	}
	public void AccountTabclick()
	{
		AccountTab.click();
	}
	public void LastActivityclick() throws InterruptedException
	{
		Thread.sleep(5000);
		LastActivity.click();
	}
	
	/*public boolean Unsavedreport()
	{
		 UnsavedRep=UnsavedReport.getText();
		if(UnsavedRep.equals("Unsaved Report"));
		{
			return true;
		}
		
	}*/
	public void Datefield()
	{
		Datefield.click();
		CreatedDate.click();
	}
	
	public void FromDate() throws InterruptedException
	{
FromDate.click();
fromtoday.click();
//Thread.sleep(5000);


	}
	
	public void ToDate()
	{
		
ToDate.click();
Totoday.click();


	}
	public String createddate;
	public void LastDateCreated()
	{
		 createddate = Datecoloum.getText();
		System.out.println(createddate);

	}
	
	//below method will fetch accounts created date and compare it with entered todays date textbox(to and from)
	@SuppressWarnings("unlikely-arg-type")
	public boolean QualifiedAccounts()
	{
		if(createddate.equals(FromTextbox.getAttribute("value")) && createddate.equals(ToTextbox.getAttribute("value")))
		{
			  logger.info("Qualified accounts showing up log");
			  System.out.println("Qualified accounts showing up sysout");

		}
		return true;
	}
public void reportname(String report)
{
	repName=report;
	reportname.sendKeys(report);
}
	
public void developername(String devname)
{
	developername.sendKeys(devname);
}

public void saveandrun()
{
	saveandrun.click();
}

@SuppressWarnings("unlikely-arg-type")
public void verifyreportname()
{
	if(verifyreport.getText().equals(repName))
	{
		System.out.print("report name is showing up correctly");
	}
}

}
