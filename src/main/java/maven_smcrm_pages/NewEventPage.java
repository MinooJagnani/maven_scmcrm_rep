package maven_smcrm_pages;
 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import maven_smcrm_utils.BasePage;
import maven_smcrm_utils.GenericUtils;

public class NewEventPage extends BasePage{
	
	@FindBy(xpath="//input[@id='subject']")
	private WebElement subject;
	
	@FindBy(xpath="//img[@title='Calendar']")
	private WebElement calendar;
	
	@FindBy(xpath="//input[@id='time']")
	private WebElement time;
		
	@FindBy(xpath="//input[@value='Save']")
	private WebElement saveBtn;
	
	

	public NewEventPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	

	public void enterSubject(String strSubject)
	{
		subject.sendKeys(strSubject);
	}

	public void clickCalendar()
	{
		calendar.click();
	}
	public void enterTime(String strTime)
	{
		time.sendKeys(strTime);
	}
	
	
	
	public void clickSave()
	{
		saveBtn.click();
	}
	
	
	

}
