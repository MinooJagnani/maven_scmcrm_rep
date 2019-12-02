package maven_smcrm_tests;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(maven_smcrm_utils.MyListener.class)

public class demoListenerTest {
	
	@Test(enabled=false)
	public void beforeMethod()
	{
		Reporter.log("I am in Before Method ", true);
		
	}

	
	@Test(enabled=false)
	public void afterMethod()
	{
		Reporter.log("i am in After Method", true);
		Assert.fail();
		
		
	}
}
