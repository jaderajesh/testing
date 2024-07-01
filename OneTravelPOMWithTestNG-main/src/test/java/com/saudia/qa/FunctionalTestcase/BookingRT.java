package com.saudia.qa.FunctionalTestcase;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.SignInPage;
import com.saudia.qa.util.ExcelUtill;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;





public class BookingRT extends TestBase {
	protected Utilities utils;
//	public ReportLog reports;
	protected ExcelUtill excel;
	ArrayList<String> values = new ArrayList<>();
	protected String pnr = null; 

	public BookingRT() {
		super();
	}


	
	@BeforeMethod
	public void setup(Method m) {
		// initliazing the classes
		String filePath ="";
		signInPage = new SignInPage(reports);
		excel = new ExcelUtill(filePath, 1);
		reports.startTest(m.getName(), "BanumathiS", "Booking RoundTrip");
	}


	@Test(priority= 1 , description = "Validate the PNR creation")
	public void pnrCreation() throws Throwable {
		
		
		try {
			String origin1 ="RUH";
			String destination1 ="JED";
			
		HomePage homePage = new HomePage(reports);
			homePage.acceptPrivacyCookies();
			homePage.changeCountryIndiaToSaudiArabia();
			homePage.enterOriginDestination(origin1, destination1);
			homePage.selectjourneydates();
			homePage.dontChangeBTNMethod();
			homePage.selectFlightDepartReturn();
			homePage.clickContToPassenger();
			//homePage.addPassengerDetails();
			System.out.println("ddd");
			 
		} catch (Exception e) {
			reports.logPass("Booking", "Error while doing Booking");
			reports.logFail(e.getMessage(), "Unable to do Booking...");
		}
	}
		
	
		@AfterMethod
	public void tearDown() {
			reports.endTest();

	}

		

	

}
