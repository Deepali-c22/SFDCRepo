package sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserMenuDropDown {


	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement username;
	
	@FindBy(partialLinkText ="My Profile")
	public WebElement profile;
	
	
	@FindBy( xpath="//a[@title='My Settings']")
	public WebElement settings;
	

	@FindBy( xpath="//a[@title='Developer Console (New Window)']")
	public WebElement devconsole;
	

	@FindBy( xpath="//a[@title='Switch to Lightning Experience']")
	public WebElement lighteningexp;
	
	
	@FindBy( xpath="//a[@title='Logout']")
	public WebElement logout;


	
}

