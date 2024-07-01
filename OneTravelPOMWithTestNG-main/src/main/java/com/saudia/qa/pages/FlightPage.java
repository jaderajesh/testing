package com.saudia.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.util.Log;

public class FlightPage extends TestBase {

	@CacheLookup
	@FindBy(id="onewayTrip")
	public WebElement oneWayTrip;
	
	@CacheLookup
	@FindBy(id="roundTrip")
	public WebElement roundTrip;
	
	@CacheLookup
	@FindBy(id="multiTrip")
	public WebElement multicityTrip;
	
	
	@CacheLookup
	@FindBy(css ="div.widget__input.is-active>a>svg")
	public WebElement suggestionbox__clear_icon;
	
	@CacheLookup
	@FindBy(id="from0")
	public WebElement FromWhere;
	
	@CacheLookup
	@FindBy(id="to0")
	public WebElement ToWhere;
	
	@CacheLookup
	@FindBy(id="cal0")
	public WebElement DepatureDate;
	
	
	@CacheLookup
	@FindBy(id="searchNow")
	public WebElement SerachFlight;
	
	@CacheLookup
	@FindBy(xpath="//label[text()='One Way']")
	public WebElement verifyTriplabel;
	
	public FlightPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyoneTripLabel() {
		return verifyTriplabel.isDisplayed();

	}
	public void SelectonewayTripOprtion() {
		oneWayTrip.click();
		

	}
	public void enterDepatureCity() {
		try {
			suggestionbox__clear_icon.click();
			FromWhere.sendKeys(prop.getProperty("From", "NONE"),Keys.ENTER);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

	}
	
}
