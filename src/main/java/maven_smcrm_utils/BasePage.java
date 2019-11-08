package maven_smcrm_utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{
	WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verifyTitle(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
		wait.until(ExpectedConditions.titleIs(title));
		Reporter.log("Title is matching "+title,true);
		}
		catch (Exception e) 
		{
			Reporter.log("Title is not matching "+driver.getTitle(),true);
			Assert.fail();
		}
	}
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present...........",true);
		}
		catch (Exception e) 
		{
			Reporter.log("Elemnt is not present..........",true);
			Assert.fail();
		}
	}
}
