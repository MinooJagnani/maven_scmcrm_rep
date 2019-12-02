package maven_smcrm_utils;

import java.beans.DesignMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;



public abstract class BaseTest implements Autoconstant
{
	
	static
	{
		Reporter.log("HELLO", true);
		System.setProperty(chrome_key, chrome_value);
		//WebDriverManager.firefoxdriver().setup();
	
		System.setProperty(firefox_key, firefox_value);
		System.setProperty(ie_key, ie_value);
	}
	
	public WebDriver driver;
	

	
	
	
	@Parameters({"huburl","browser","appurl"})
	@BeforeClass
	public void precondition(String huburl, String browser, String appurl) throws MalformedURLException
	{
		URL url = new URL(huburl);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		
		Reporter.log("huburl  name    " + huburl , true);;
		Reporter.log("browser  name    " + browser , true);;
		driver = new RemoteWebDriver(url, dc);
		//driver = new ChromeDriver();
		//driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(appurl);
	}
	@AfterMethod
	public void postcondition(ITestResult res) 
	{
		
		int status = res.getStatus();
		if(status==2)
		{
			String name = res.getMethod().getMethodName();
			GenericUtils.getScreenShot(driver, name);
		}
		//driver.close();

	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
}
