package com.utils;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

import com.pages.drivers.DriversFactory;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BaseClass {

	public WebDriver driver;
	public WebDriverWait wait;
	public Object pages;
	public Logger logger;
	static ConstantsURL url;
	
	public BaseClass(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,3000);
		this.logger = Logger.getLogger(BaseClass.class);
		
	}

	@SuppressWarnings("static-access")
	public void openApplication() {
		DriversFactory.getWebDriver().get(url.WEB_APP_LOCALHOST.getURL());
	}

	public void verifyPageApplication(String url) {

		String currUrl = driver.getTitle();
		url = url == null ? currUrl : url;
		logger.debug("verifyApplication: '" + url + "' ");

		wait.until(ExpectedConditions.titleContains(currUrl));

		Assert.assertTrue(currUrl.contains(url));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String randomString(int count) {
		String retRandName = RandomStringUtils.randomAlphabetic(count);
		return retRandName;
	}

}
