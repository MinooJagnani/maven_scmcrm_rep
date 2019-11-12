package maven_smcrm_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import maven_smcrm_utils.BasePage;

public class EditCampaignPage extends BasePage{
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement homeLink;

	public EditCampaignPage(WebDriver driver) {
		super(driver);
	 
	}
	
	public void clickHomelink()
	{
		homeLink.click();
	}

}
