package maven_smcrm_tests;

import java.io.IOException;
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
import maven_smcrm_pages.NewEventPage;
import maven_smcrm_pages.NewTaskPage;
import maven_smcrm_utils.BaseTest;
import maven_smcrm_utils.ExcelData;
import maven_smcrm_utils.GenericUtils;

public class ValidLoginCrmTest extends BaseTest{
	@Test(priority = 1)
	public void verifyLogin() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		String strLoginId = ExcelData.getData(file_path, "TC01", 1, 0);
		String strLoginPwd = ExcelData.getData(file_path, "TC01", 1, 1);
		
		
		/*
		String strLoginId = GenericUtils.getdataFromProperties("un");
		String strLoginPwd = GenericUtils.getdataFromProperties("pw");
		*/
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
		hp.clickNewCampaignLink();
		String strCampaignTitle = ExcelData.getData(file_path, "TC03", 1, 0);
		Reporter.log("strCampaignTitle ---" + strCampaignTitle, true);
		hp.verifyTitle(strCampaignTitle);
	}
	
	
	@Test(priority=3)
	public void verifyCampaignData() throws InterruptedException
	{

		CreateNewCampaignPage cp = new CreateNewCampaignPage(driver);	
		String campaignName=ExcelData.getData(file_path,"TC04", 1, 0);
		String strCampaignTitle1=ExcelData.getData(file_path,"TC04", 1, 1);
		  
		Reporter.log("name ---" + campaignName, true);
		Reporter.log("strCampaignTitle1 ---" + strCampaignTitle1, true);
		
		cp.enterNewCampaignData(campaignName);
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
		
				   break;
			}
		}
		/*
	    String strStartDateTitle=ExcelData.getData(file_path,"TC04", 1, 3);
	    GenericUtils.switchChildWindow(driver, strStartDateTitle);
	    */
		
		CalendarPage calObj = new CalendarPage(driver);
		calObj.selectDate();
		  Thread.sleep(4000);
		driver.switchTo().window(parenthandle);
	
		
		/*
		
		   Date d = new Date();
		    SimpleDateFormat s1 = new SimpleDateFormat("d");
		    String day = s1.format(d);
		    calObj.clickDay(day);
		    
		    SimpleDateFormat s2 = new SimpleDateFormat("MMMM");
		    String month = s1.format(d);
		    calObj.clickMonth(month);
	
		driver.switchTo().window(parenthandle);
		Reporter.log("OUT OF FOR LOOP " , true);
		
		*/
		
		cp.clickSave();	
		cp.verifyTitle(strCampaignTitle1);
		
		
	}

	@Test(priority=4)
	public void verifyInvalidCampaignData() throws InterruptedException
	{

	HomePage hp = new HomePage(driver);	
	hp.clickNewCampaignLink();	
	Thread.sleep(2000);

	String strCampaignTitle2=ExcelData.getData(file_path,"TC03", 1, 0);
	Reporter.log("strCampaignTitle2 ---" + strCampaignTitle2, true);
	hp.verifyTitle(strCampaignTitle2);

	CreateNewCampaignPage cp = new CreateNewCampaignPage(driver);	
	cp.clickSave();
	Alert al = driver.switchTo().alert();
	Reporter.log("message ---" + al.getText(), true);

	al.accept();
	String validname=ExcelData.getData(file_path,"TC04", 1, 0);
	String strCampaignTitle3=ExcelData.getData(file_path,"TC04", 1, 1);
	cp.enterNewCampaignData(validname);	
	cp.clickSave();	
	Thread.sleep(2000);
	cp.verifyTitle(strCampaignTitle3);
	
	Thread.sleep(2000);
	
	EditCampaignPage edp = new EditCampaignPage(driver);
	Reporter.log("BEFORE edit campaign ---" , true);
	Thread.sleep(2000);
	
	edp.clickHomelink();
	String strHomeTitle = ExcelData.getData(file_path, "TC01", 1, 3);
	edp.verifyTitle(strHomeTitle);
	
	Reporter.log("AFTER edit campaign ---" , true);
	Thread.sleep(2000);
	 
	edp.clickTasklink();
	String strTaskTitle = ExcelData.getData(file_path, "TC04", 1, 4);
	edp.verifyTitle(strTaskTitle);
	 
	NewTaskPage tp= new NewTaskPage(driver);
	
	String strSubject = ExcelData.getData(file_path, "TC04", 1, 5);	
	tp.enterSubject(strSubject);
	Thread.sleep(4000);
	Reporter.log("Subject name ---"+strSubject , true);
	
	String StrValue = ExcelData.getData(file_path, "TC04", 1, 6);
	tp.clickPriority(StrValue);
	Thread.sleep(4000);
	Reporter.log("Selected value ---"+StrValue , true);
	
	String StrLeadValue = ExcelData.getData(file_path, "TC04", 1, 7);	 
	tp.clickLeadDropDown(StrLeadValue);
	Reporter.log("StrLeadValue ---"+StrLeadValue , true);
	
	tp.clickLeadPopUp();	
	
	/*
	String childWinTitle = ExcelData.getData(file_path, "TC04", 1, 8);
	Reporter.log("childWinTitle ---"+childWinTitle , true);
	*/
	
	Thread.sleep(3000);
	
	 String   parenthandle = driver.getWindowHandle();
	 Set<String> shandle = driver.getWindowHandles();
		  Thread.sleep(2000);

		  
		for(String win:shandle)
		{
			
			Reporter.log("win " + win, true);
			if(!parenthandle.equals(win))
			{
				driver.switchTo().window(win);
				break;
			}
		}	
		Thread.sleep(3000);
		tp.clickLeadName();
		
		driver.switchTo().window(parenthandle);
		tp.clickSave();
		hp.verifyTitle(ExcelData.getData(file_path, "TC01", 1, 3));
		
		edp.clickEventlink();
		
		String strEventTitle = ExcelData.getData(file_path, "TC04", 1, 9);
		edp.verifyTitle(strEventTitle);
	 	 
		NewEventPage ep= new NewEventPage(driver);		
		String strEventSubject = ExcelData.getData(file_path, "TC04", 1, 10);	
		ep.enterSubject(strSubject);
		ep.clickCalendar();
		 
		String   parenthandle1 = driver.getWindowHandle();
		Set<String> shandle1 = driver.getWindowHandles();
		Thread.sleep(2000);
  
		for(String win:shandle1)
		{
			
			Reporter.log("win " + win, true);
			if(!parenthandle1.equals(win))
			{
				driver.switchTo().window(win);
		
				   break;
			}
		}
		
		CalendarPage calObj = new CalendarPage(driver);
		calObj.selectDate();
		  Thread.sleep(4000);
		driver.switchTo().window(parenthandle);
		String strTime = ExcelData.getNumberDataFromCell(file_path, "TC04", 1, 11);	
		String strTime1 = ExcelData.getData(file_path, "TC04", 1, 11);	
		Reporter.log("strTime " + strTime, true);
		Reporter.log("strTime1 " + strTime1, true);
		ep.enterTime(strTime);
		ep.clickSave();
		hp.verifyTitle(ExcelData.getData(file_path, "TC01", 1, 3));
		
	}
 



}
