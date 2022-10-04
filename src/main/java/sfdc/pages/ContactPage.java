package sfdc.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
	
	public ContactPage(WebDriver driver){
		
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="Contact_Tab")
	public WebElement Contact_Tab;
	
	
	@FindBy(name="new")
	public WebElement newtab;
	
	@FindBy(id="name_lastcon2")
	public WebElement lastname;
	
	
	@FindBy(id="con4")
	public WebElement Accountname;
	
	
	@FindBy(name="save")
	public WebElement save;
	
	@FindBy(xpath="//div[@class='bPageBlock brandSecondaryBrd secondaryPalette']//a[1]")
	public WebElement tablepath;
	
	@FindBy(id="fname")
	public WebElement viewname;
		
	@FindBy(id="devname")
	public WebElement viewUniqueName;
	
	@FindBy(name="fcf")
	public WebElement viewdd;
	
	@FindBy(linkText="Create New View")
	public WebElement CreateView;
	
	@FindBy(id="hotlist_mode")
	public WebElement recentdd;
	
	@FindBy(xpath="//div[@class='bPageBlock brandSecondaryBrd secondaryPalette']//a")
	public WebElement contactname;
	
	@FindBy(xpath="//div[@class='errorMsg'][1]")
	public WebElement errormsg;
	
	@FindBy(name="cancel")
	public WebElement cancel;
	
	
	String colval;
	public void verifyContactCreated()
	{
		 colval=tablepath.getText();
		System.out.println(colval);
	}
	
	public Boolean verifyViewVal(String str)
	{
	Boolean val=false;
	Select dd = new Select(viewdd);
	List<WebElement> w=dd.getOptions();
	
	for(int i=0;i<w.size();i++)
	{
		if(w.get(i).getText().equals(str))
		{
			System.out.print("New view is created with name " + (w.get(i).getText()));
			val=true;
			break;
		}
	}
	return val;
	}
	
	public Boolean verifyddvalue(String str,WebElement wb) throws InterruptedException
	{
	Boolean val=false;
	wb.click();
	Select dd = new Select(wb);
	List<WebElement> w=dd.getOptions();
	
	for(int i=0;i<w.size();i++)
	{
		if(w.get(i).getText().equals(str))
		{
			System.out.print("view = " + (w.get(i).getText()));
			w.get(i).click();
//			w.get(i).sendKeys(Keys.ENTER);
			val=true;
			break;
		}
	}
	return val;
	}
	
	public Boolean errormsg(String str)
	{
		Boolean val=false;
		if(errormsg.getText().equals(str))
		{ 
			System.out.print(errormsg.getText());
		val=true;
		}
		return val;
	}
	
	
	
	
	
	
}
