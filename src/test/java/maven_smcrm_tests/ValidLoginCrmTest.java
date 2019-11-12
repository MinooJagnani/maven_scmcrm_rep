package maven_smcrm_tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import maven_smcrm_pages.CalendarPage;
import maven_smcrm_pages.CreateNewCampaignPage;
import maven_smcrm_pages.EditCampaignPage;
import maven_smcrm_pages.HomePage;
import maven_smcrm_pages.LoginPage;
import maven_smcrm_utils.BaseTest;
import maven_smcrm_utils.ExcelData;

public class ValidLoginCrmTest extends BaseTest{
	@Test(priority = 1)
	public void verifyLogin()
	{
		LoginPage lp=new LoginPage(driver);
		String strLoginId = ExcelData.getData(file_path, "TC01", 1, 0);
		String strLoginPwd = ExcelData.getData(file_path, "TC01", 1, 1);
		String strloginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String strHomeTitle = ExcelData.getData(file_path, "TC01", 1, 3);
		lp.verifyTitle(strloginTitle);
		lp.enterLoginName(strLoginId);
		lp.enterLoginPassword(strLoginPwd);
		Reporter.log("user id ---" + strLoginId, true);
		Reporter.log("password ---" + strLoginPwd, true);
		lp.clickOnLoginButton();
		
		HomePage hp= new HomePage(driver);
		Reporter.log("titlttltltlteee ---" + strHomeTitle, true);
	    hp.verifyTitle(strHomeTitle);
		
	}
	
	@Test(priority=2)
	public void verifyCampaign()
	{

	HomePage hp = new HomePage(driver);	
	
	hp.verifyNewCampaignLink();
	String strCampaignTitle = ExcelData.getData(file_path, "TC03", 1, 0);
	Reporter.log("strCampaignTitle ---" + strCampaignTitle, true);
	hp.verifyTitle(strCampaignTitle);
	
	}
	@Test(priority=3)
	public void verifyCampaignData() throws InterruptedException
	{

	CreateNewCampaignPage cp = new CreateNewCampaignPage(driver);	
	String name=ExcelData.getData(file_path,"TC04", 1, 0);
    cp.enterNewCampaignData(name);
 
    
	Reporter.log("name ---" + name, true);
	String strCampaignTitle1=ExcelData.getData(file_path,"TC04", 1, 1);
	Reporter.log("strCampaignTitle ---" + strCampaignTitle1, true);


    cp.enterStartDate();

    String   parenthandle = driver.getWindowHandle();
	Set<String> shandle = driver.getWindowHandles();
	  Thread.sleep(2000);

	  
	for(String win:shandle)
	{
		
		Reporter.log("win " + win, true);
		if(!parenthandle.equals(win))
		{
			driver.switchTo().window(win);
			CalendarPage calObj = new CalendarPage(driver);

			  Date d = new Date();
			  			   
			    SimpleDateFormat s1 = new SimpleDateFormat("d");
			    String day = s1.format(d);
			    calObj.clickDay(day);
			    
			    SimpleDateFormat s2 = new SimpleDateFormat("MMMM");
			    String month = s1.format(d);
			    calObj.clickMonth(month);

			    SimpleDateFormat s3 = new SimpleDateFormat("YYYY");
			    String year = s1.format(d);
			   calObj.clickYear(year);
			   break;
		}
		
		Thread.sleep(2000);
	}
	Reporter.log("here " , true);
	Reporter.log("driver.getWindowHandle() " + driver.getWindowHandle(), true);
	driver.switchTo().window(driver.getWindowHandle());
	
	
	
	Reporter.log("OUT OF FOR LOOP " , true);

	cp.clickSave();
	
	cp.verifyTitle(strCampaignTitle1);
	
	
	}

	@Test(priority=4)
	public void verifyInvalidCampaignData()
	{

	CreateNewCampaignPage cp = new CreateNewCampaignPage(driver);
	
	HomePage hp = new HomePage(driver);	
	hp.verifyNewCampaignLink();
	
	
	String strCampaignTitle2=ExcelData.getData(file_path,"TC04", 1, 1);
	Reporter.log("strCampaignTitle ---" + strCampaignTitle2, true);

	cp.clickSave();
	Alert al = driver.switchTo().alert();
	Reporter.log("message ---" + al.getText(), true);

	al.accept();
	String validname=ExcelData.getData(file_path,"TC04", 1, 0);
	cp.enterNewCampaignData(validname);
	
	cp.clickSave();
	
	cp.verifyTitle(strCampaignTitle2);
	
	EditCampaignPage edp = new EditCampaignPage(driver);
	edp.clickHomelink();
	
	
	}
	
	
	@Test(priority=5,enabled=false)
	public void verifyTask()
	{

	HomePage hp = new HomePage(driver);	
	
	hp.verifyNewCampaignLink();
	String strCampaignTitle = ExcelData.getData(file_path, "TC03", 1, 0);
	Reporter.log("strCampaignTitle ---" + strCampaignTitle, true);
	hp.verifyTitle(strCampaignTitle);
	
	} 
	@Test(priority=6,enabled=false)
	public void verifyTaskData() throws InterruptedException
	{

	CreateNewCampaignPage cp = new CreateNewCampaignPage(driver);	
	String name=ExcelData.getData(file_path,"TC04", 1, 0);
    cp.enterNewCampaignData(name);
 
    
	Reporter.log("name ---" + name, true);
	String strCampaignTitle1=ExcelData.getData(file_path,"TC04", 1, 1);
 

	cp.clickSave();
	
	cp.verifyTitle(strCampaignTitle1);
	
	
	}


}
