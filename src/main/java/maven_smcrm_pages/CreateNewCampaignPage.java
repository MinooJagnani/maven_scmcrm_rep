package maven_smcrm_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_smcrm_utils.BasePage;

public class CreateNewCampaignPage extends BasePage{


	public CreateNewCampaignPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(name="property(Campaign Name)")
	private WebElement CampaignName;
	
	@FindBy(xpath="//td[@class='mainLayer']//td[2]//div[1]//img[1]")
	private WebElement startDate;
	

	
	@FindBy(xpath="(//input[@value='Save'])[2]")
	private WebElement save;
	
	
	public void enterNewCampaignData(String name)
	{
		CampaignName.sendKeys(name);
		
	}
	public void enterStartDate()
	{
		startDate.click();
		
		//startDate.sendKeys(strStartDate);
	}
	public void clickSave()
	{
		//save.click();
		save.submit();
	}
	
}