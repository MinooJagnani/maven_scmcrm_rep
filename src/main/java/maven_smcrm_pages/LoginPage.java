package maven_smcrm_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_smcrm_utils.BasePage;

public class LoginPage extends BasePage{

	//declaration of webelements
	
	@FindBy(xpath="//input[@name='j_username']")
	private WebElement loginName;

	@FindBy(xpath="//input[@name='j_password']")
	private WebElement password;

	@FindBy(xpath="//input[@type='image']")
	private WebElement loginButton;
	
	//  initialize weblements
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterLoginName(String strLoginName)
	{
		loginName.sendKeys(strLoginName);
	}
	public void enterLoginPassword(String strPwd)
	{
		password.sendKeys(strPwd);
	}
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
}
