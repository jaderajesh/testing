package com.saudia.qa.config;

import java.io.File;
import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Constants {
	public static final String WORKING_DIR = System.getProperty("user.dir");
	public static final String REPORT_DIR = WORKING_DIR + File.separator + "Reports" + File.separator;
	public static final String SCREENSHOT_DIR="C:\\Users\\1000050767\\Downloads\\OneTravelPOMWithTestNG-main\\OneTravelPOMWithTestNG-main\\src\\main\\resources\\Screenshots\\";
	public static final String PROJECT_NAME = "Saudia";
	public static final String EXTENT_CONFIG_PATH=WORKING_DIR+"";
	public static final String PROPERITY_FILE_PATH=WORKING_DIR+"src\\main\\java\\com\\saudia\\qa\\config\\config.properties";
	public static final long PAGE_LOAD_TIMEOUT = 20;
	public static final long IMPLICTY_WAIT = 20;
	public static final long SYNC=2000;
	public static final String LOG4J_DIR=WORKING_DIR+File.separator+"\\src\\main\\resources\\LOGS\\log4j.properties";
	public static final int maxTime= 20;
	public static final int poolingTime= 5000;
}