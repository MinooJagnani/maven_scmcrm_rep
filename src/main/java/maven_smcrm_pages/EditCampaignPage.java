package maven_smcrm_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_smcrm_utils.BasePage;

public class EditCampaignPage extends BasePage{
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homeLink;
	
	@FindBy(xpath="//a[contains(text(),'New Task')]")
	private WebElement taskLink;
	
	@FindBy(xpath="//a[contains(text(),'New Event')]")
	private WebElement eventLink;
	
	@FindBy(xpath="(//input[@value='Edit'])[2]")
	private WebElement edit;

	public EditCampaignPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	
	 
	}
	
	public void clickHomelink()
	{
		System.out.println(" before Click home link");
		homeLink.click();
		System.out.println(" after Click home link");
	}

	public void clickTasklink()
	{
		System.out.println(" before Click task link");
		//taskLink.sendKeys(Keys.ENTER);
		taskLink.click();
		System.out.println(" after Click task link");
	}

	public void clickEdit()
	{
		edit.click();
		//edit.submit();
	}
	public void clickEventlink()
	{
		System.out.println(" before Click Event link");		 
		eventLink.click();
		System.out.println(" after Click Event link");
	}

}
