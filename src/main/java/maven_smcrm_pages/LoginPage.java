package maven_smcrm_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(xpath="//input[name='j_username']")
	private WebElement login;

	@FindBy(xpath="//input[name='j_password']")
	private WebElement login;

	
}
