package com.saudia.qa.base;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.model.Report;
import com.saudia.qa.config.Constants;
import com.saudia.qa.listeners.WebEventListner;
import com.saudia.qa.pages.SignInPage;
import com.saudia.qa.util.ExcelUtill;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	private static final Logger LOG = Logger.getLogger(TestBase.class);
	public static Properties prop = null;
	public static WebDriver driver = null;
	public static WebDriverWait wd;
	public static ReportLog reports = null;
	protected Utilities utils;
	protected SignInPage signInPage;

	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream fip = new FileInputStream(new File(Constants.WORKING_DIR + File.separator
					+ "src\\main\\java\\com\\saudia\\qa\\config\\config.properties"));

			BufferedInputStream bufferedInputStream = new BufferedInputStream(fip);
			prop.load(bufferedInputStream);
		} catch (IOException e) {
			LOG.error("IOException THROWN WHILE LOADING THE CONFIG FILE" + e.getMessage());

		} catch (Exception e) {
			LOG.error("GENERIC THROWN WHILE LOADING THE CONFIG FILE" + e.getMessage());
		}

	}

	public static void Browsersetup() throws InterruptedException {
		// String browserName="CHROME";
		String browserName = prop.getProperty("browser");
		browserName.toUpperCase().equalsIgnoreCase("CHROME");
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("CHROME")) {
			WebDriverManager.edgedriver().setup();

			
			  
			  ChromeOptions options = new ChromeOptions();
			  
			  options.addArguments("start-maximized"); 
			  //options.addArguments("--incognito");
			  options.addArguments("--disable-extensions");
			  options.addArguments("--remote-allow-origins=*");
			  options.addArguments("ingnore-certificate-errors");
			  options.addArguments("disable-popup-blocking");
			  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			  driver = new ChromeDriver(options);
			 

		

		} else if (browserName.toUpperCase().equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			/*
			 * HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
			 * edgePrefs.put("profile.default_content_settings.popups", 0); EdgeOptions
			 * options = new EdgeOptions(); options.setCapability("prefs", edgePrefs);
			 * options.setCapability("useAutomationExtension", false);
			 */

			driver = new EdgeDriver();
		} else if (browserName.toUpperCase().equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			String downloadFilepath = "C:\\path\\to\\MozillaFirefoxDownload";
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.dir", downloadFilepath);
			FirefoxOptions options = new FirefoxOptions();
			// options.setHeadless(true);
			options.setProfile(profile);
			driver = new FirefoxDriver(options);
		} else {
			LOG.error("RUN TIME EXCEPTION is  OCCURED..........");
			throw new RuntimeException("invalid BrowserName");

		}
		WebDriverListener evenListener = new WebEventListner();
		WebDriver decorder = new EventFiringDecorator<WebDriver>(evenListener).decorate(driver);
		driver = decorder;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICTY_WAIT));
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();
		//driver.get("https://www.amazon.in/");
		driver.get(prop.getProperty("saudiaurl"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wd.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(80));
		Thread.sleep(60000);

		// driver.get(prop.getProperty("saudiaurl"));

		LOG.info("BROWSER SUCESSFULLY LAUNCHED");
	}

	@BeforeSuite
	public void loadConfig() throws InterruptedException {
		Browsersetup();
		long ts = System.currentTimeMillis();
		reports = new ReportLog(driver, String.valueOf(ts), "Automation Reports", "Amadeus", "Banumathi");
		utils = new Utilities(driver);
	}

	@AfterSuite
	public void endTestSuite() {
		if (driver != null) {
			reports.logPass("Test", "Test has been launched Sucessfully");
			driver.quit();
			reports.endSuite();
		}

	}

	/*
	 * @BeforeClass public void signIN() {
	 * 
	 * signInPage = new SignInPage(reports); reports.logPass("Sign IN",
	 * "Sign has been launched Sucessfully"); signInPage.agentModeLogin();
	 * signInPage.personalDataAlert(); }
	 */

}
