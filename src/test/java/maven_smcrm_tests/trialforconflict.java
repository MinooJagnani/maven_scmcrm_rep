package maven_smcrm_tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class trialforconflict {
	@Test
	public void oneMethod()
	{
		Reporter.log("hello minoo",true);
		
		Reporter.log("hello minoo again",true);
		
		Reporter.log("hello minoo again2",true);
		Reporter.log("hello minoo again",true);


	}

}
