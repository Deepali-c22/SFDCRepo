package sfdc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LeadsPage {

	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@title=\"Leads Tab\"]")
	public WebElement Leadstab;
	
	@FindBy(id="fcf")
	public WebElement viewdd;
	
	
	@FindBy(name="go")
	public WebElement go;
	
	@FindBy(name="new")
	public WebElement newtab;
	
	@FindBy(name="name_lastlea2")
	public WebElement lastname;
	
	@FindBy(name="lea3")
	public WebElement company;
	
	
	@FindBy(name="save")
	public WebElement save;
	
	
	
	
	
	public Boolean verifyViewDropdown()
	{
		
		Boolean val= false;
		String[] Expected= {"All Open Leads",
				"My Unread Leads",
				"Recently Viewed Leads",
				"Today's Leads",
				"View - Custom 1",
				"View - Custom 2"};
		
		Select dd = new Select(viewdd);
		List<WebElement> ddvalues=dd.getOptions();
		
		
		
		for(int i=0;i<=ddvalues.size()-1;i++)
		{
			System.out.println(ddvalues.get(i).getText());
			String Actual=ddvalues.get(i).getText();
			if(Actual.equals(Expected[i]))
			{
				val=true;
			}
		}
		return val;
	}
	String val1=null;

	
	public Boolean SelectData()
	{
		Boolean val= false;
		String[] Expected= {"All Open Leads",
				"My Unread Leads",
				"Recently Viewed Leads",
				"Today's Leads",
				"View - Custom 1",
				"View - Custom 2"};
		
		Select dd = new Select(viewdd);
		List<WebElement> ddvalues=dd.getOptions();
		
		
		
		for(int i=0;i<=ddvalues.size()-1;i++)
		{
			System.out.println(ddvalues.get(i).getText());
			String Actual=ddvalues.get(i).getText();
			if(Actual.equals(Expected[4]))
			{
				ddvalues.get(i).click();
				val1=ddvalues.get(i).getText();
				val=true;
				break;
			}
		}
		return val;
	}
	
	public Boolean verifyviewddselection()
	{
		Boolean val=false;
		Select selectoption= new Select(viewdd);
		WebElement option=selectoption.getFirstSelectedOption();
		String s=option.getText();
		
		
		if(s.equals(val1))
		{
			val=true;
		}
		return val;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void verifyTodaydd(String str)
	{
		Select selectoption= new Select(viewdd);
		List<WebElement> s =selectoption.getOptions();
		
		for(int i=0;i<=s.size();i++)
		{
			String s1=s.get(i).getText();
			if(s1.equals(str))
			{
				s.get(i).click();
				break;
			}
		}
	}
	
	
}
