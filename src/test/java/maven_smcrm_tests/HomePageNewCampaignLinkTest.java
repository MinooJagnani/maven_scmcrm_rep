package maven_smcrm_tests;

import org.testng.annotations.Test;

import maven_smcrm_pages.HomePage;
import maven_smcrm_pages.LoginPage;
import maven_smcrm_utils.BaseTest;
import maven_smcrm_utils.ExcelData;

public class HomePageNewCampaignLinkTest extends BaseTest{

	@Test(priority=2,enabled=false)	
	public void verifyCampaign1()
	{

	HomePage hp = new HomePage(driver);	
	hp.clickNewCampaignLink();
	String strCampaignTitle = ExcelData.getData(file_path, "TC03", 1, 0);
	System.out.println("strCampaignTitle"+strCampaignTitle);
	hp.verifyTitle(strCampaignTitle);
	}


}
