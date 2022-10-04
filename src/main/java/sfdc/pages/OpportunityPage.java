package sfdc.pages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import sfdc.tests.Account;

public class OpportunityPage {
	//boolean val = false;
	private static Logger logger = LogManager.getLogger(Account.class.getName());

	public OpportunityPage(WebDriver driver)
	{
		  PageFactory.initElements(driver,this);

	}
	@FindBy(xpath="//a[@title='Opportunities Tab']")
	public WebElement Opportunity_tab;
	
	@FindBy(xpath="//*[@id='bodyCell']//div[1]//div[1]//div[1]//h1")
	public WebElement Opportunity_home_title;
	
	@FindBy(id="fcf")
	public WebElement Opportunity_dropdown;
	
	@FindBy(xpath="//input[@name='new']")
	public WebElement NewOpp;
	
	@FindBy(id="opp3")
	public WebElement Opportunity_name;
	
	
	@FindBy(id="opp4")
	public WebElement Account;
	
	
	@FindBy(id="opp9")
	public WebElement Calender;
	
	@FindBy(xpath="//*[@id=\"calRow3\"]/td[5]")
	public WebElement SelectDate;
	
	@FindBy(id="opp11")
	public WebElement Stage;
	
	@FindBy(id="opp12")
	public WebElement Probability;
	

	@FindBy(id="opp6")
	public WebElement LeadSource;
	
	@FindBy(id="opp17")
	public WebElement Primary_Campaign_Source;
	
	
	@FindBy(name="save")
	public WebElement save;
	
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement verifynewopp;
	
	@FindBy(id="opp3_ilecell")
	public WebElement verifyoppelement;
	
	@FindBy(linkText="Opportunity Pipeline")
	public WebElement oppoPipeLine;
	
	@FindBy(xpath="//table[@class='reportTable tabularReportTable']//tr/td[5]")
	public List<WebElement> verifyoppinreportpage;
	
	@FindBy(linkText="Stuck Opportunities")
	public WebElement stuckopportunities;
	
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
	public WebElement stuckoppoverify;

	@FindBy(id="quarter_q")
	public WebElement quarter_q;
	
	@FindBy(xpath="//*[@id=\"quarter_q\"]")
	public WebElement quateroption;
	
	@FindBy(id="open")
	public WebElement Includeoption;
	
	@FindBy(xpath="//input[@value='Run Report']")
	public WebElement runreport;
	
	@FindBy(xpath="//table[@class='reportTable tabularReportTable']//td[5]")
	public List<WebElement> Opp_report;
	
	//table[@class='reportTable tabularReportTable']//th[4]
	
	//*[@id="quarter_q"]/option[5]
	
	

	public void clickOpportunity()
	{
		Opportunity_tab.click();
	}
	
	public boolean verifyOppPage()
	{
		if(Opportunity_home_title.getText().equals("Opportunities"))
		{
			return true;
		}
		else 
		{
		return false;
		}
		}
	
	public boolean verifyoppddpresent()
	{
		if(Opportunity_dropdown.isDisplayed())
		{
			//System.out.print("returning true");
			return true;
		}
		{
			return false;
			}
	}
	public boolean verifyoppddoptions()
	{

		Opportunity_dropdown.click();
		//Select select = new Select(select_drop_down);

		@SuppressWarnings("unchecked")
        Select dropdown = new Select(Opportunity_dropdown);		
		List<WebElement> opp_dd=dropdown.getOptions();
		
	   String[] Expected={"All Opportunities","Closing Next Month","Closing This Month","My Opportunities","New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won"};
		boolean val = false;

	   for(int i=0;i<=opp_dd.size()-1;i++)
	   {
		  
		   String Actual = opp_dd.get(i).getText();
		  String SingleExpected = Expected[i];
		  if(Actual.equals(SingleExpected))
         {
		      System.out.println("value matched"+ " " +SingleExpected);
		      if(i==10)
				{
					val=true;
				}

         }

		
	}
		return val;

	   

	}
	
	public void createopportunity()
	{
		//Opportunity_tab.click();
		NewOpp.click();
		Opportunity_name.sendKeys("Sep_Opp4_2022");
		Calender.click();
		SelectDate.click();
		Select dd = new Select(Stage);
		dd.selectByIndex(2);
		Probability.clear();
		Probability.sendKeys("20");
		LeadSource.click();
		Select dd1 = new Select(LeadSource);
		
		//List<WebElement> dropdown=dd1.getOptions();
		//List<String> ddlist=new ArrayList<String>();
		//ddlist.add(null)
		
		//for(int i=0;i<dropdown.size();i++)
		//{
		//	System.out.println(dropdown.get(i).getText());
		//}
		
		dd1.selectByIndex(3);
		Primary_Campaign_Source.sendKeys("Sep_2022_Camp1");
		save.click();
		
		
	}
	
	public boolean verifynewopp()
	{
		if(verifynewopp.getText().equals(verifyoppelement.getText()))
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public void oppPipeLine()
	{
		oppoPipeLine.click();
	}
	
	public void verifyoppinreportpage(List<WebElement> Ele)
	{
		for(int i=0;i<=Ele.size()-1;i++)
		{
			System.out.println(Ele.get(i).getText());	
			logger.debug(Ele.get(i).getText());
			if(Ele.get(i).getText().equals("Closed") || Ele.get(i).getText().equals("Closed Won"))
			{
				System.out.print("Not showing the result as per expectations");
				break;
				
			}
			
		}
		
		
	}
	public boolean verifyoppinreportpage1(List<WebElement> Ele)
	{

		boolean var = false;
		for(int i=0;i<=Ele.size()-1;i++)
		{
			System.out.println(Ele.get(i).getText());	
			logger.debug(Ele.get(i).getText());
			if(Ele.get(i).getText().equals("Closed") || Ele.get(i).getText().equals("Closed Won"))
			{
				System.out.print("Not showing the result as per expectations");
				var= false;
				
			}
			else
			{
				var= true;
			}
			
		}
		return var;
		
		
	}
	
	
	public void stuckopportunities() {
		stuckopportunities.click();
	}
	
	public void selectvalues(WebElement element,String text)
	{
		Select val = new Select(element);
		//val.selectByVisibleText(text);
		List<WebElement> oplist =val.getOptions();
		
		 for(int i =0;i<=oplist.size()-1;i++) {
			 
		  if(oplist.get(i).getText().equals(text))
			  {
			  try
			  {
			  oplist.get(i).click();
			  oplist.get(i).sendKeys(Keys.ENTER);
			  }
			  catch(Exception e)
			  {
				  System.out.println("Ran in to exception");
			  }
			  
			  }
			  }
		 
		 
	
		//val.selectByValue(value);
		//element.click();
	}
	
	
}



