package com.pages.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriversFactory {

	public static Logger logger = LoggerFactory.getLogger(DriversFactory.class);

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * Initialize Driver Browser Configuration
	 * 
	 * @return WebDriver
	 */

	public WebDriver init_driver(String browser) {

		logger.debug("Initialize Driver Browser Configuration");

		logger.debug(" Driver Browser : " + browser + "");

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			
			tlDriver.set(new ChromeDriver());
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			break;

		case "safari":
			tlDriver.set(new SafariDriver());
			break;

		default:
			logger.debug(" Driver Browser : No Selected Browser ");
			System.out.println("Configure Correct Driver Browser");
			break;
		}

		getWebDriver().manage().deleteAllCookies();
		getWebDriver().manage().window().maximize();
		
		return getWebDriver();
	}

	/**
	 * Get The Currnt WebDriver
	 * 
	 * @return WebDriver
	 */

	public static synchronized WebDriver getWebDriver() {
		return tlDriver.get();
	}
}
