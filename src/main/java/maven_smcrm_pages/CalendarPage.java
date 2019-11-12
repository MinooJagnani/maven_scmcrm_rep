package maven_smcrm_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_smcrm_utils.BasePage;

public class CalendarPage extends BasePage{
	
	@FindBy(xpath="//a[@class='calCurrDay']")
	private WebElement calendarDay;
	
	@FindBy(xpath="//td[3]//span[1]//a[1]")
	private WebElement calendarMonth ;
	
	@FindBy(xpath="//a[contains(text(),'»')]")
	private WebElement calendarYear;
	
	
	public CalendarPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickDay(String StrDay)
	{
		calendarDay.click();
	}

	
	public void clickMonth(String StrDay)
	{
		calendarMonth.click();
	}
	
	public void clickYear(String StrDay)
	{
		calendarYear.click();
	}

}
