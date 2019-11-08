package maven_smcrm_tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import maven_smcrm_utils.BaseTest;
import maven_smcrm_utils.ExcelData;
//import maven_smcrm_pages.actiTIMELoginPage;
public class InvalidLoginTest extends BaseTest
{
	/*
	@Test(priority = 2)
	public void InvalidLogin() throws InterruptedException
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		
		  actiTIMELoginPage lp =new actiTIMELoginPage(driver);
		 
		//verify login page title
		lp.verifyTitle(title);
		int rc = ExcelData.getRowCount(file_path, "TC02");
		for(int i=1; i<=rc; i++)
		{
			String un = ExcelData.getData(file_path, "TC02", i, 0);
			String pw = ExcelData.getData(file_path, "TC02", i, 1);
			//entering user name
			Reporter.log("User name "+un,true);
			lp.EnterUserName(un);
			//entering password
			Reporter.log("password "+pw,true);
			lp.EnterPassword(pw);
			//click on login button
			lp.ClickOnLogin();
			String aerrormsg = lp.verifyErrorMsg();
			String eerrormsg = ExcelData.getData(file_path, "TC02", 1, 2);
			// verifying error msg
			Assert.assertEquals(aerrormsg, eerrormsg);
			Reporter.log("==========================================",true);
			Thread.sleep(2000);
		}
		
	}
*/
}
