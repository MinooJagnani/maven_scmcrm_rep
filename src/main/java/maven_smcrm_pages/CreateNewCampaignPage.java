package maven_smcrm_pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_smcrm_utils.BasePage;

public class CreateNewCampaignPage extends BasePage{




	@FindBy(name="property(Campaign Name)")
	private WebElement CampaignName;
	
	@FindBy(xpath="//td[@class='mainLayer']//td[2]//div[1]//img[1]")
	private WebElement startDate;
	
	@FindBy(xpath="(//img[@title='Calculator'])[1]")
	private WebElement clickRevenueCalc;
	
	@FindBy(xpath="//input[@name='calc7']")
	private WebElement clickseven;
	
	
	
	@FindBy(xpath="//input[@name='multiply']")
	private WebElement clickmultiply;
	
	@FindBy(xpath="//input[@name='calc5']")
	private WebElement clickfive;
	
	@FindBy(xpath="//input[@name='equal']")
	private WebElement clickequal;
	
	
	
	@FindBy(xpath="(//input[@value='Save'])[2]")
	private WebElement save;
	
	public CreateNewCampaignPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	public void enterNewCampaignData(String name)
	{
		CampaignName.sendKeys(name);
		
	}
	public void enterStartDate()
	{
		startDate.click();
		
		//startDate.sendKeys(strStartDate);
	}
	public void clickExpectedRevenue() throws IOException
	{
		clickRevenueCalc.click();	
		//Runtime.getRuntime().exec("‪C:\minoo\sample_autoit\\calc1.exe");
	 
	}
	public void enterExpectedRevenue1() throws IOException
	{
 
		clickseven.click();
		//clickmultiply.click();
		//clickfive.click();
	}
	public void enterExpectedRevenue2() throws IOException
	{
		clickmultiply.click();
	}
	public void enterExpectedRevenue3() throws IOException
	{
		clickfive.click();
	}
	public void enterExpectedRevenue4() throws IOException
	{
		clickequal.click();
	}
	
	public void clickSave()
	{
		//save.click();
		save.submit();
	}
	
}
