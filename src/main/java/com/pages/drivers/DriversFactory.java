package com.pages.drivers;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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

	public WebDriver init_driver(String browser, Properties properties) {

		logger.debug("Initialize Driver Browser Configuration");

		logger.debug(" Driver Browser : " + browser + "");
		String getVersion = properties.getProperty(browser + "Version");
		
		switch (browser) {
		case "chrome":
//			System.setProperty("webdriver.chrome.driver", properties.getProperty("chromepath")); 
//			WebDriverManager.chromedriver().driverVersion(properties.getProperty("chromeVersion")).setup();
			WebDriverManager.chromedriver()
            .browserVersion(getVersion)
            .driverVersion(getVersion)
//            .arch32()
//            .proxy("proxyhostname:80")
//            .proxyUser("username")
//            .proxyPass("password")
			.setup();
			
			ChromeOptions chromeOptions = new ChromeOptions();			
//			chromeOptions
//			.addArguments("--window-position=0,0")
//			.addArguments("--window-size=1840,1080")
//			.addArguments("--no-sandbox")
//			.addArguments("--disable-gpu")
//			.addArguments("--headless");
			
			tlDriver.set(new ChromeDriver(chromeOptions));
			
			break;

		case "firefox":
			WebDriverManager.firefoxdriver()
			.browserVersion(getVersion)
            .driverVersion(getVersion)
            .setup();
			
			FirefoxOptions firefoxOptions = new FirefoxOptions();	
//			firefoxOptions
//			.addArguments("--window-position=0,0")
//			.addArguments("--window-size=1840,1080")
//			.addArguments("--no-sandbox")
//			.addArguments("--disable-gpu")
//			.addArguments("--headless");
//				
			tlDriver.set(new FirefoxDriver(firefoxOptions));
			break;
		
		case "edge":
			WebDriverManager.edgedriver()
			.browserVersion(getVersion)
            .driverVersion(getVersion)
            .setup();
			
			tlDriver.set(new EdgeDriver());
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
	 * Get The Current WebDriver
	 * 
	 * @return WebDriver
	 */

	public static synchronized WebDriver getWebDriver() {
		return tlDriver.get();
	}
}
