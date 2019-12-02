package maven_smcrm_utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

 
public class MyListener implements ITestListener{
	
	static ExtentReports reports;
	static ExtentTest test;
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("New Test Started " + result.getName());
	}

	public void onTestSuccess(ITestResult result)
	{
		System.out.println("TEst successfully finisished "  + result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Failed " + result.getName());
	} 
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test Skipped " + result.getName());
	}
	
	
	public void onTestFailedButWiithSuccessPercentage(ITestResult result)
	{
		System.out.println("Test failed but with success [ercentage "+ result.getName());
	}
	
	public void onStart(ITestContext context)
	{
		System.out.println("This is on start context method " + context.getOutputDirectory());
		String strTimeStamp= new SimpleDateFormat("yyyy_mm_hh_mm_ss").format(new Date());
		String respName="test-output"+strTimeStamp+".html";
		
		
		reports = new ExtentReports(System.getProperty("user.dir")+"\\test-output"+ respName);
		test=reports.startTest("TEST METHOD STARTS");
	}
	
	public void onFinish(ITestContext context)
	{
		System.out.println("This is on Finish Method " + context.getPassedTests());
		System.out.println("this is on finish method " + context.getFailedTests());
	}
	
}
