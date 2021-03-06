package maven_smcrm_tests;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.mail.MessagingException;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import maven_smcrm_pages.CalendarPage;
import maven_smcrm_pages.CreateNewCampaignPage;
import maven_smcrm_pages.EditCampaignPage;
import maven_smcrm_pages.FeedBackPage;
import maven_smcrm_pages.HomePage;
import maven_smcrm_pages.LoginPage;
import maven_smcrm_pages.NewEventPage;
import maven_smcrm_pages.NewTaskPage;
import maven_smcrm_utils.BaseTest;
import maven_smcrm_utils.ExcelData;
import maven_smcrm_utils.GenericUtils;

@Listeners(maven_smcrm_utils.MyListener.class)

public class ValidLoginCrmTest extends BaseTest{
	
	private static final Logger logg = Logger.getLogger(Logger4j.class);
	
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
		logg.info("Check user id n " + strLoginId + "password  " + strLoginPwd);
		lp.clickOnLoginButton();
		
		HomePage hp= new HomePage(driver);
		Reporter.log("titlttltltlteee ---" + strHomeTitle, true);
	    hp.verifyTitle(strHomeTitle);
		
	}

	
	@Test(priority=2)
	public void verifyCampaign() throws InterruptedException, FileNotFoundException, IOException, MessagingException
	{
		HomePage hp = new HomePage(driver);
		// click on Feedback link
		//send email
		Reporter.log("before click feedback", true);

		hp.clickFeedbackLink();
		Reporter.log("afteer click feedback", true);
		
		FeedBackPage fdb = new FeedBackPage(driver);
		
		String parenthandle1 = driver.getWindowHandle();
		Set<String> shandle1 = driver.getWindowHandles();
		Reporter.log("parenthandle1 ---" + parenthandle1, true);
		Reporter.log("shandle1 size ---" + shandle1.size(), true);
 		for(String win11:shandle1)
		{
 			Reporter.log("win11 ---" + win11, true);
			if(!parenthandle1.equals(win11))
			{
				driver.switchTo().window(win11);
				Thread.sleep(2000);

				break;
			}
		}	
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		fdb.enterEmailSubject("TEST EMAIL");
		fdb.enterEmailMessage("TRYING TO tes/SEND FROM CRM APPLICAITON");
		//fdb.clickSendEmail();
		fdb.clickcancel();
		
		Reporter.log("AFTER EMAIL", true);
		driver.switchTo().window(parenthandle1);

		
		Reporter.log("ON PARENT WINDOWN AFTER EMAIL ---", true);
			
		
		//click campaign
		hp.clickNewCampaignLink();
		String strCampaignTitle = ExcelData.getData(file_path, "TC03", 1, 0);
		Reporter.log("strCampaignTitle ---" + strCampaignTitle, true);
		hp.verifyTitle(strCampaignTitle);
	}
	
	
	@Test(priority=3)
	public void verifyCampaignData() throws InterruptedException, IOException, AWTException
	{

		CreateNewCampaignPage cp = new CreateNewCampaignPage(driver);	
		String campaignName=ExcelData.getData(file_path,"TC04", 1, 0);
		String strCampaignTitle1=ExcelData.getData(file_path,"TC04", 1, 1);
		  
		Reporter.log("name ---" + campaignName, true);
		Reporter.log("strCampaignTitle1 ---" + strCampaignTitle1, true);
		
		cp.enterNewCampaignData(campaignName);
	    cp.enterStartDate();
	    GenericUtils.calendarPopUp(driver);
	    
	    Thread.sleep(3000);
	    cp.clickExpectedRevenue();
	    String   parenthandle = driver.getWindowHandle();
		 Set<String> shandle = driver.getWindowHandles();
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
			cp.enterExpectedRevenue1();
			 
			cp.enterExpectedRevenue2();
			
			cp.enterExpectedRevenue3();
			Thread.sleep(3000);
			cp.enterExpectedRevenue4();
			 
			
			driver.close();
			driver.switchTo().window(parenthandle);	 
			
	   // GenericUtils.calculatorPopUp(driver);
	 
	    Thread.sleep(3000);
	   
	    
		cp.clickSave();	
		cp.verifyTitle(strCampaignTitle1);
		
		Thread.sleep(3000);
		// check for print preview
		
		EditCampaignPage edp = new EditCampaignPage(driver);
		
		
		edp.clickPrintPrreviewBtn();
		Thread.sleep(3000);
		Reporter.log("BEFORE PRINT ---"  , true);
		String parenthandle11 = driver.getWindowHandle();
		Set<String> shandle11 = driver.getWindowHandles();
		Reporter.log("parenthandle11 ---" + parenthandle11, true);
		Reporter.log("shandle11 size ---" + shandle11.size(), true);
 		for(String win11:shandle11)
		{
 			Reporter.log("win11 ---" + win11, true);
			if(!parenthandle11.equals(win11))
			{
				driver.switchTo().window(win11);
				Thread.sleep(2000);

				break;
			}
		}	
		Thread.sleep(2000);
		//driver.manage().window().maximize();
		edp.clickPrinterLink(driver);
		Thread.sleep(3000);
		Reporter.log("AFTER PRINT", true);
		driver.switchTo().window(parenthandle11);
		
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
 
	
	edp.clickHomelink();
	String strHomeTitle = ExcelData.getData(file_path, "TC01", 1, 3);
	edp.verifyTitle(strHomeTitle);
	
	Reporter.log("AFTER edit campaign ---" , true);
 
	 
	edp.clickTasklink();
	String strTaskTitle = ExcelData.getData(file_path, "TC04", 1, 4);
	edp.verifyTitle(strTaskTitle);
	 
	NewTaskPage tp= new NewTaskPage(driver);
	
	String strSubject = ExcelData.getData(file_path, "TC04", 1, 5);	
	tp.enterSubject(strSubject);
 
	
	//tp.clickSubjectPopup();
	//GenericUtils.subjectNameLookUpPopUp(driver);
 
	
	String StrValue = ExcelData.getData(file_path, "TC04", 1, 6);
	tp.clickPriority(StrValue);
 
	Reporter.log("Selected value ---"+StrValue , true);
	
	String StrLeadValue = ExcelData.getData(file_path, "TC04", 1, 7);	 
	tp.clickLeadDropDown(StrLeadValue);
	Reporter.log("StrLeadValue ---"+StrLeadValue , true);
	
	//tp.clickLeadPopUp();	
		
	//GenericUtils.contactLeadNameLookUpPopUp(driver);
		tp.clickSave();
		hp.verifyTitle(ExcelData.getData(file_path, "TC01", 1, 3));
		
		edp.clickEventlink();
		
		String strEventTitle = ExcelData.getData(file_path, "TC04", 1, 9);
		edp.verifyTitle(strEventTitle);
	 	 
		NewEventPage ep= new NewEventPage(driver);		
		String strEventSubject = ExcelData.getData(file_path, "TC04", 1, 10);	
		ep.enterSubject(strEventSubject);
		ep.clickCalendar();
		 
		GenericUtils.calendarPopUp(driver);

		
		String strTime = ExcelData.getNumberDataFromCell(file_path, "TC04", 1, 11);	
		ep.enterTime(strTime);
		
		
		//testing select drop down
		String strSelectProducts = ExcelData.getData(file_path, "TC04", 1, 12);
		ep.selectProductsDropDown(strSelectProducts);
		
		ep.clickImgPopupLink();
		GenericUtils.parentAccountLookUpPopUp(driver);
		
		/*
		String parenthandle = driver.getWindowHandle();
		Set<String> shandle2 = driver.getWindowHandles();
 		for(String win2:shandle2)
		{
	
			if(!parenthandle.equals(win2))
			{
				driver.switchTo().window(win2);
				break;
			}
		}	
		Thread.sleep(2000);
		ep.clickProductsName();
		driver.switchTo().window(parenthandle);
		*/
		
		ep.clickSave();
		hp.verifyTitle(ExcelData.getData(file_path, "TC01", 1, 3));
		
		
		
	}
 



}
