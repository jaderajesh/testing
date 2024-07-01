package com.saudia.qa.listeners;



import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.model.Report;
import com.saudia.qa.base.TestBase;
import com.saudia.qa.util.Utilities;

public class TestListener extends TestBase implements ITestListener , IExecutionListener{

	@Override
	public void onExecutionStart() {
		long jobStartTime = System.currentTimeMillis();
		Reporter.log("Job Strat time is ....."+jobStartTime,true);
		
	}

	@Override
	public void onExecutionFinish() {
		long jobEndTime = System.currentTimeMillis();
		Reporter.log("Job Strat time is ....."+jobEndTime,true);
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Utilities.captureScreenshot(driver, result.getName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub	
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
