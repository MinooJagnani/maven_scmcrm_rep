package maven_smcrm_tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class trialforconflict {
	@Test
	public void oneMethod()
	{
		Reporter.log("hello minoo",true);
		Reporter.log("Hello Trial for conflict");
		Reporter.log("hello trial again",true);

	
	}

}
