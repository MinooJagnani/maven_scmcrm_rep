package maven_smcrm_pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import maven_smcrm_utils.BasePage;
import maven_smcrm_utils.EmailUtility;

public class FeedBackPage extends BasePage{
	@FindBy(xpath ="//input[@name='subject']")
	private WebElement emailSubject;

	@FindBy(xpath ="//textarea[@name='message']")
	private WebElement emailMessage;


	@FindBy(xpath ="//input[@value='Send']")
	private WebElement sendButton;
	
	@FindBy(xpath ="//input[@name='cancel']")
	private WebElement cancelBtn;
	 

	public FeedBackPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterEmailSubject(String subject)
	{
		emailSubject.sendKeys(subject);
	}
	
	public void enterEmailMessage(String message)
	{
		emailMessage.sendKeys(message);
	}
	public void clickSendEmail() throws FileNotFoundException, IOException, MessagingException
	{
		Reporter.log("calling EMAIL", true);

		sendButton.click();
		//EmailUtility.sendEmailText();
	}
	public void clickcancel() throws FileNotFoundException, IOException, MessagingException
	{
		Reporter.log("calling CANCEL", true);

		cancelBtn.click();
 	}
	
	
}
