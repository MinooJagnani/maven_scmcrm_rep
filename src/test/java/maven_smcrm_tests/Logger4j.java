package maven_smcrm_tests;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class Logger4j 
{
	//private static final Logger logg = Logger.getLogger(Logger4j.class);
	
	@Test
	public void testA()
	{
		logg.debug("THIS IS IS DEBUG MESSAGE");
		logg.info("THIS IS AN INFO MESSage");
		logg.warn("THIS IS IS WRNING MESSAGE");
		logg.fatal("THIS IS AN FATAL MESSage");
		logg.error("THIS IS IS ERROR MESSAGE");
		System.out.println("LOGGER EXECUTED SUCCESSFULY");

	}

}
