package com.saudia.qa.pages;
 
import java.awt.Robot;

import java.awt.event.KeyEvent;

import java.util.List;
 
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import org.testng.AssertJUnit;
 
import com.aventstack.extentreports.model.ReportStats;

import com.saudia.qa.base.TestBase;

import com.saudia.qa.config.Constants;

import com.saudia.qa.util.Log;

import com.saudia.qa.util.ReportLog;

import com.saudia.qa.util.Utilities;
 
public class HomePage extends TestBase{

	private static Logger Log= Logger.getLogger(HomePage.class);

	private ReportLog reportLog;

	@FindBy(xpath = "//input[@placeholder='Search country/territory'][1]")

	public WebElement searchCountryTXT;
 
	@CacheLookup

	@FindBy(xpath = "(//h5[text()= ' Saudi Arabia'])[1]")

	public WebElement saudiOPT;
 
	@FindBy(xpath = "//span[text()= 'English']")

	public WebElement englishOPT;
 
	@FindBy(xpath = "//img[@aria-label='Click to change Country/Territory & Language']")

	public WebElement chooseCounrtBTN;
 
	@FindBy(xpath = "//input[@placeholder='From']")

	public WebElement fromTXT;
 
	@FindBy(xpath = "//span[text()=' cancel ']")

	public WebElement fromCancelBTN;

	@CacheLookup

	@FindBy(xpath = "//span[contains( text(),'Yes' )]")

	public WebElement acceptCookiesBTN;

	@CacheLookup

	@FindBy(xpath = "//input[@aria-label='From']")

	public WebElement originTXT;


	@FindBy(xpath = "//*[text()=' flight_takeoff ']")

	public WebElement flightTakeOffImg;

	@FindBy(xpath = "//div[@aria-label='Click here to clear flying from Destinations value ']//span")

	public WebElement originCancelBTN;

	@FindBy(xpath = "//*[contains(@class,'light__landing is-focused')]//input")

	public WebElement destinationTXT;

	@FindBy(xpath = "//span[text()='Don’t change']//parent::div")

	public WebElement dontChangeBTN;

	@FindBy(xpath = "(//span[@aria-label = 'Click here to open the calendar dropdown '])[1]")

	public WebElement calendarDDBTN;

	@FindBy(xpath = "(//th[@class='month drp-animate'])[2]/div")

	public WebElement currentMonth;

	@FindBy(xpath = "(//th[@class='next available ng-star-inserted'])[2]")

	public WebElement nxtMonthBTN;

	@FindBy(xpath = "(//td[@class='weekend ng-star-inserted available'])[1]")

	public WebElement departDate;

	@FindBy(xpath = "(//td[@class='weekend ng-star-inserted available'])[2]")

	public WebElement returnDate;

	@FindBy(xpath = "(//button[text()='Continue'])[2]")

	public WebElement continueBTN;

	@FindBy(xpath = "//span[text()= 'Search Flights']")

	public WebElement searchFlightsBTN;

	@FindBy(xpath = "(//*[@class='mat-focus-indicator flexcard mat-card guest_card flight-card']//div[@role='button'])[3]")

	public WebElement selectGuestCard;

	@FindBy(xpath = "//*[@aria-label='Select Guest Basic Flight']")

	public WebElement selectBasicFlightBTN;

	@FindBy(xpath = "//*[@aria-label='Select Guest Flex Flight']")

	public WebElement selectFlexFlightBTN;

	@FindBy(xpath = "//*[@aria-labelledby='Continue to Passenger']")

	public WebElement contToPssngrBTN;

	@FindBy(xpath = "//*[@class='passenger-information']")

	public WebElement pssngrInfoTitle;

	@FindBy(xpath = "//*[@class='control-wrapper passenger-title-input']//span[text()=' expand_more ']")

	public WebElement titleExpandArraw;

	@FindBy(xpath = "//button[text()='Edit search ']")

	public WebElement editSearchBTN;

	@FindBy(xpath = "//*[text()='First name']")

	public WebElement firstNameInput;


	@FindBy(xpath = "//*[text()='Last name']")

	public WebElement lastNameInput;

	@FindBy(xpath = "//button[text()='Edit search ']")

	public WebElement editSearchBTN1;

	@FindBy(xpath = "//*[@class='passanger-arrow']")

	public WebElement passengerArrowBTN;

	@FindBy(xpath = "//*[@aria-label='Add a seat for  Adults']")

	public WebElement adultAddBTN;

	@FindBy(xpath = "//*[@aria-label='Add a seat for  Children']")

	public WebElement childrenAddBTN;

	@FindBy(xpath = "//*[@aria-label='Add a seat for  Infants']")

	public WebElement infantsAddBTN;

	@FindBy(xpath = "//*[@aria-label='Add a seat for  Infant on seat']")

	public WebElement infantOnSeatAddBTN;

	@FindBy(xpath = "//*[@value='Guest']")

	public WebElement guestRadioBTN;

	@FindBy(xpath = "//*[@value='Business']")

	public WebElement guestBusinessBTN;

	@FindBy(xpath = "//*[@value='First']")

	public WebElement guestFirstBTN;

	@FindBy(xpath = "//*[@class='passenfer-confirm-wrapper']//button")

	public WebElement passengerConfirmBTN;


//	https://www.saudia.com/en-SA/booking/passengerDetails

	public HomePage(ReportLog reportLog) {

		PropertyConfigurator.configure(Constants.LOG4J_DIR);

		this.reportLog = reportLog;

		PageFactory.initElements(driver, this);

		Log.info("Intialize the Webelements in the driver");

	}

	public void acceptPrivacyCookies() {


		  try {

			  Utilities.moveToElementAndClick(acceptCookiesBTN);

			   }

		catch (Exception e) {

			e.printStackTrace();

		}

	}


		  public void changeCountryIndiaToSaudiArabia() throws Throwable {

			  try {

			  Utilities.moveToElementAndClick(chooseCounrtBTN);

			  Utilities.moveToElementAndClick(searchCountryTXT);

			  Utilities.setText(searchCountryTXT, "SAUDI");		 

			  Utilities.moveToElementAndClick(saudiOPT);

			  Utilities.moveToElementAndClick(englishOPT);

			  reportLog.logPass("Saudia Arabia-English ", "Option is slected");

		  } catch (Exception e) { 

			  reportLog.logFail("Saudia Arabia-English ", "Option is not slected");

			  throw new Exception("Error while Changing Country to Saudia"); } }


		  public void enterOriginDestination(String origin, String destination) throws

		  Throwable {

			  try {

				  Utilities.scrollDown();

				  Thread.sleep(3000);

				  Utilities.waitForAllElementVisibilty(flightTakeOffImg,Constants.maxTime, Constants.poolingTime);

				  Utilities.jsCLick(flightTakeOffImg);

				  Utilities.waitForAllElementVisibilty(originCancelBTN,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(originCancelBTN);

				  Utilities.moveToElementAndEnter(originTXT, origin);

				  reportLog.logPass("Origin : ",origin+" is selected ");

				  Robot robot = new Robot(); 

				  Thread.sleep(2000);

				  robot.keyPress(KeyEvent.VK_ENTER);

				  Thread.sleep(2000);

				  robot.keyRelease(KeyEvent.VK_ENTER);

				  Utilities.moveToElementAndEnter(destinationTXT, destination);

				  Thread.sleep(2000);

				  robot.keyPress(KeyEvent.VK_ENTER); 
				  Thread.sleep(2000);
			  	  robot.keyRelease(KeyEvent.VK_ENTER); 
			  	 reportLog.logPass("Destination : ",destination+" is selected ");

			} catch (Exception e) {

				 reportLog.logFail("Error", "While selecting the Origin and Destination");

				  throw new Exception("Error While selecting the Origin and Destination");

			}

		  }

 
		  

		  public void addPassenger() throws Throwable {

			  try {

				  Utilities.waitForAllElementVisibilty(passengerArrowBTN,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(passengerArrowBTN);

				  Utilities.moveToElementAndClick(adultAddBTN);

				  Utilities.moveToElementAndClick(childrenAddBTN);

				  Utilities.moveToElementAndClick(infantsAddBTN);

				  Utilities.moveToElementAndClick(infantOnSeatAddBTN);

				  Utilities.moveToElementAndClick(guestRadioBTN);

				  Utilities.moveToElementAndClick(passengerConfirmBTN);


				  reportLog.logPass("Continue to Passenger","has been selected sucessfully");

				 } catch (Exception e) {

				  				e.printStackTrace();

				 reportLog.logFail("Error", "While clicking on Continue to Passengern");

				  throw new Exception("Error While clicking on Continue to Passenger");

			}

	  } 


		  public void selectjourneydates() throws Throwable {

		  try {

			  Utilities.moveToElementAndClick(calendarDDBTN); 

			  String departureMonth = "July 2023";

		  // String departureDate = "8";

			/*

			 * while (true) { Thread.sleep(2000); String currentMonthTXT =

			 * currentMonth.getText(); System.out.println(currentMonthTXT);

			 * if(currentMonthTXT.equalsIgnoreCase(departureMonth.trim())) { break; } else {

			 * System.out.println("clicking on forward arrow on calender page");

			 * nxtMonthBTN.click(); }}

			 */

		  nxtMonthBTN.click();

		  System.out.println("selecting the dates for journey");

		  Thread.sleep(2000);

		  Utilities.scrollDown();

		  Utilities.waitForAllElementVisibilty(departDate,Constants.maxTime, Constants.poolingTime);

		  Utilities.moveToElementAndClick(departDate); 

		  Thread.sleep(2000);

		  Utilities.moveToElementAndClick(returnDate); 

		  Thread.sleep(2000);

		  reportLog.logPass("Select Date : "," From and Return date is selected");

		  Thread.sleep(2000);

		  System.out.println("clicking on Continue button");

		  Utilities.jsCLick(continueBTN);

		  System.out.println("clicking on Search Flights ");

		  Utilities.moveToElementAndClick(searchFlightsBTN);


		} catch (Exception e) {

			e.printStackTrace();

			 reportLog.logFail("Error", "While selecting the dates and search Flights");

			  throw new Exception("Error While selecting the dates and search Flights");

		}

		}

		  public void dontChangeBTNMethod() throws Throwable {

			  try {

				  Utilities.waitForAllElementVisibilty(dontChangeBTN,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(dontChangeBTN);

				  reportLog.logPass("Flight Search"," User has landed on flight search page");

				  			} catch (Exception e) {

				  				e.printStackTrace();

				 reportLog.logFail("Error", "While clicking on Dont change button");

				  throw new Exception("Error While clicking on Dont change button");

			}

		  } 

		  public void selectFareCard() throws Throwable {

			  try {

				  Utilities.waitForAllElementVisibilty(editSearchBTN,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(selectGuestCard);

				  Utilities.waitForAllElementVisibilty(selectBasicFlightBTN,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(selectBasicFlightBTN);

				  reportLog.logPass("Depart Flight Search","has been selected sucessfully");

				  Utilities.waitForAllElementVisibilty(selectGuestCard,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(selectGuestCard);

				  Utilities.waitForAllElementVisibilty(selectBasicFlightBTN,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(selectBasicFlightBTN);

				  reportLog.logPass("Return Flight Search","has been selected sucessfully");


				  			} catch (Exception e) {

				  				e.printStackTrace();

				 reportLog.logFail("Error", "While selecting Return Flight Search");

				  throw new Exception("Error While selecting Return Flight Search");

			}

		  }

		  public void selectFlightDepartReturn() throws Throwable {

			  try {

				  Utilities.waitForAllElementVisibilty(editSearchBTN,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(selectGuestCard);

				  Utilities.waitForAllElementVisibilty(selectBasicFlightBTN,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(selectBasicFlightBTN);

				  reportLog.logPass("Depart Flight Search","has been selected sucessfully");

				  Utilities.waitForAllElementVisibilty(selectGuestCard,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(selectGuestCard);

				  Utilities.waitForAllElementVisibilty(selectBasicFlightBTN,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(selectBasicFlightBTN);

				  reportLog.logPass("Return Flight Search","has been selected sucessfully");


				  			} catch (Exception e) {

				  				e.printStackTrace();

				 reportLog.logFail("Error", "While selecting Return Flight Search");

				  throw new Exception("Error While selecting Return Flight Search");

			}

		  }

		  public void clickContToPassenger() throws Throwable {

			  try {

				  Utilities.waitForAllElementVisibilty(contToPssngrBTN,Constants.maxTime, Constants.poolingTime);

				  Utilities.moveToElementAndClick(contToPssngrBTN);

				  reportLog.logPass("Continue to Passenger","has been selected sucessfully");

				 } catch (Exception e) {

				  				e.printStackTrace();

				 reportLog.logFail("Error", "While clicking on Continue to Passengern");

				  throw new Exception("Error While clicking on Continue to Passenger");

			}

	  } 


}
