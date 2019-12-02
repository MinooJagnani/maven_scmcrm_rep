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
	
	@FindBy(xpath="//select[@id='modsel']")
	private WebElement selectDropDown2;
	
	@FindBy(xpath="//img[@id='modNameImg']")
	private WebElement imgPopupLink;
	
	@FindBy(xpath="(//tr//tr//tr[2]//a[@href='javascript:;'])[position() mod 2=1])")
	private WebElement productsName1;
	
	@FindBy(xpath="((//table)[3]//tr//a[@href='javascript:;'])[position() mod 2=1]")
	private WebElement productsName;
	
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
	
	public void selectProductsDropDown(String strSelectProducts )
	{
		GenericUtils.selectByValue(selectDropDown2, strSelectProducts);
		
	}
	public void clickImgPopupLink()
	{
		imgPopupLink.click();
	}
	public void clickProductsName()
	{  		
		productsName.click();
		System.out.println("HERE  AFTERE PROFUCT CLICK");
	}
	
	public void clickSave()
	{
		saveBtn.click();
	}
	
	
	

}
