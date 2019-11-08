package maven_smcrm_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_smcrm_utils.BasePage;

public class NewCampaignPage extends BasePage{

	public NewCampaignPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//td[@class='mainLayer']//td[2]//div[1]//img[1]")
private WebElement startDate;



}
