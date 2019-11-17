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
	    GenericUtils.calendarPopUp(driver);
	    
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
	
	tp.clickLeadPopUp();	
		
	GenericUtils.contactLeadNameLookUpPopUp(driver);
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
