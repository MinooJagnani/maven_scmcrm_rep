package maven_smcrm_pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		
	@FindBy(xpath="(//input[@value='Print Preview '])[2]")	 
	private WebElement clickPrintPreview;
	
	@FindBy(xpath="((//input[@value='Print Page'])[1]")
	private WebElement clickPrinterLink1;

	@FindBy(xpath="((//input[@type='button'])[1])[position()=1]")
	private WebElement clickPrinterLinkObj;
	
	
	
	public EditCampaignPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	
	 
	}
	
	public void clickHomelink()
	{
		 
		homeLink.click();
		 
	}

	public void clickTasklink()
	{
	 
		taskLink.click();
		 
	}

	public void clickEdit()
	{
		edit.click();
		//edit.submit();
	}
	public void clickEventlink()
	{
		  
		eventLink.click();
		 
	}
	public void clickPrintPrreviewBtn()
	{
		clickPrintPreview.click();
		 
	}
	public void clickPrinterLink(WebDriver driver) throws AWTException, IOException, InterruptedException
	{
		  
//		clickPrinterLinkObj.click();
		//new Actions(driver).click(clickPrinterLink).perform();
		System.out.println("INSIDE PRINT FUNCTION");
		Robot r = new Robot();
		int c = KeyEvent.VK_CONTROL;
		int p = KeyEvent.VK_P;
		r.keyPress(c);
		r.keyPress(p);
		Thread.sleep(2000);;

		r.keyRelease(p);
		r.keyRelease(c);
		Thread.sleep(2000);;
		Runtime.getRuntime().exec("C:\\minoo\\sample_autoit\\print1.exe");
		System.out.println("FINISHED PRINT FUNCTION");
	}
	
}
