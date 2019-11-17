package maven_smcrm_utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class GenericUtils 
{
	/***
	 * 
	 * @this method use to take screen shot
	 * @param driver
	 * @param name
	 */
	public static void getScreenShot(WebDriver driver,String name)
	{
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
		String dd = s1.format(new Date());
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+dd+" "+name+".png");
		try 
		{
			Files.copy(src, dest);
		}
		catch (IOException e)
		{
		}
	}
	/***
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectByIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/***
	 * 
	 * @param element
	 * @param value
	 */
	public static void selectByValue(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/***
	 * 
	 * @param driver
	 */
	public static void javaScriptClickOnOkButton(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/***
	 * 
	 * @param driver
	 */
	public static void javaScriptClickOnCancelButton(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/***
	 * 
	 * @param driver
	 * @param text
	 */
	public static void javaScriptEnterText(WebDriver driver,String text)
	{
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
		a.accept();
	}
	/***
	 * 
	 * @param driver
	 */
	public static void calendarPopUp(WebDriver driver)
	{
		
	}
	/***
	 * 
	 * @param driver
	 */
	public static void subjectNameLookUpPopUp(WebDriver driver)
	{
		
	}
	public static void contactLeadNameLookUpPopUp(WebDriver driver)
	{
		
	}
	public static void accountNameLookUpPopUp(WebDriver driver)
	{
		
	}
	public static void calculatorPopUp(WebDriver driver)
	{
		
	}
	public static void campaignNameLookUpPopUp(WebDriver driver)
	{
		
	}
	public static void parentAccountLookUpPopUp(WebDriver driver)
	{
		
	}
	/***
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getdataFromProperties(String key) throws IOException
	{
		Properties p = new Properties();
		File f= new File(Autoconstant.file_path_properties);
		FileInputStream file = new FileInputStream(f);
		p.load(file);
		String data = p.getProperty(key);
		return data;
	
	}
	
	/***
	 * 
	 * @param driver
	 * @param eTitle
	 */
	public static void switchChildWindow(WebDriver driver, String eTitle)
	{
		Set<String> strWinHandles = driver.getWindowHandles();
		Iterator<String> itr = strWinHandles.iterator();
		
		while(itr.hasNext())
		{
			System.out.println("HERE IN SWITCH while ");
			String wh=  itr.next();
			System.out.println("wh      " + wh);
			
			if(driver.getTitle().equals(eTitle))
			{
				driver.switchTo().window(wh);
				break;
			}
		}
		
	}
}
