package maven_smcrm_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


import maven_smcrm_utils.BasePage;
import maven_smcrm_utils.GenericUtils;

public class NewTaskPage extends BasePage{
	
	
	@FindBy(xpath="//tr[2]//td[1]]")
	private WebElement subjectNAME;
	
	@FindBy(xpath="//input[@id='subject']")
	private WebElement subject;
	
	
	@FindBy(xpath="//img[@title='Subject Name Lookup']")
	private WebElement subjectLookUpImg;
	
	
	@FindBy(xpath="//select[@name='property(priority)']")
	private WebElement priority;
	
	@FindBy(id="leContModSel")
	private WebElement leaddropdown;
	
	@FindBy(xpath="(//img[@src='/crm/images/lookup.gif'])[1]")
	private WebElement leadLookUpImg;
	
	@FindBy(tagName="//table")
	private WebElement tableLead;
	
	@FindBy(xpath="((//table)[3]//tr//a[@href='javascript:;'])[position() mod 2=1]")
	private WebElement leadName;
	
	@FindBy(xpath="//tr//tr//tr[2]//td[1]")
	private WebElement leadName1;
	
	@FindBy(xpath="//input[@id='leContModName']")
	private WebElement NameTxt;
	
	
	@FindBy(xpath="//input[@value='Save']")
	private WebElement saveBtn;

	public NewTaskPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	

	public void enterSubject(String strSubject)
	{
		subject.sendKeys(strSubject);
	}
	public void clickPriority(String StrValue)
	{
		GenericUtils.selectByValue(priority, StrValue);
	}
	
	public void clickLeadDropDown(String StrValue)
	{
		GenericUtils.selectByValue(leaddropdown, StrValue);
	}
	
	public void clickLeadPopUp()
	{
		leadLookUpImg.click();
	}
	public void clickSubjectPopup()
	{
		subjectLookUpImg.click();
		
	}
	public void clickSubjectNAME()
	{  		
		subjectNAME.click();		 
	}
	
	public void clickLeadName()
	{  		
		leadName.click();		 
	}
	
	public void clickSave()
	{
		saveBtn.click();
	}
	
	

	
	

}
