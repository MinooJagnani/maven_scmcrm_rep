package maven_smcrm_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_smcrm_utils.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath = "//a[contains(text(),'New Campaign')]")
	private WebElement NewCampaignLink;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickNewCampaignLink() {
		NewCampaignLink.click();

	}

}
