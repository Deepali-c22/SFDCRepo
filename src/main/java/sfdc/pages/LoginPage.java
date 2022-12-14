package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage  {
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "username")
	public static WebElement username;

	@FindBy(name = "pw")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;

	@FindBy(partialLinkText = "Forgot Your")
	public WebElement forgotYourPassword;

	@FindBy(xpath = "/html/body/div[2]/div/div[6]/div[1]/div/div[8]/div/div/div/a/span")
	public WebElement startFreeTrial;

	@FindBy(css = "#error")
	public WebElement loginError;
	
	
	public static void click(WebElement element) {
		element.click();
	}
	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
}

	
	



