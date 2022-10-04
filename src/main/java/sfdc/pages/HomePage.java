package sfdc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@class='brandPrimaryFgr']")
	public WebElement home;
	
	
	@FindBy(xpath = "//a[@title='Chatter Tab']")
	public WebElement chatter;
	
	
	@FindBy(id = "Contact_Tab")
	public WebElement contact;
	
	
	@FindBy(id = "Account_Tab")
	public WebElement account;
	
	
	@FindBy(id = "Lead_Tab")
	public WebElement lead;
	
	@FindBy(id = "Opportunity_Tab")
	public WebElement opportunity;
	
	@FindBy(id = "report_Tab")
	public WebElement reports;
	
	
	@FindBy(id="userNavButton")
	public WebElement username;
	
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a")
	public List<WebElement> usermenu;
	
	

	@FindBy( xpath="//a[@title='Logout']")
	public WebElement logout;
	
	
	

}
