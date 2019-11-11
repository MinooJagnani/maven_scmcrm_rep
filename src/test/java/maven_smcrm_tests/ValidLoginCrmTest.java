package maven_smcrm_tests;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import maven_smcrm_pages.CreateNewCampaignPage;
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
	public void verifyCampaignData()
	{

	CreateNewCampaignPage cp = new CreateNewCampaignPage(driver);	
	String name=ExcelData.getData(file_path,"TC04", 1, 0);
    cp.enterNewCampaignData(name);

    
	Reporter.log("name ---" + name, true);
	String strCampaignTitle1=ExcelData.getData(file_path,"TC04", 1, 1);
	Reporter.log("strCampaignTitle ---" + strCampaignTitle1, true);

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
	
	
	}

}
