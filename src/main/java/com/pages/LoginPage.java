package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import junit.framework.Assert;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage {
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String login_parent_selector = "//div[@id=\"credentials\"]";
	public By user_textBox 				= By.xpath(login_parent_selector + "//div[@class=\"field user\"]//input");
	public By password_textBox			= By.xpath(login_parent_selector + "//div[@class=\"field password\"]//input");
	public By login_button				= By.xpath(login_parent_selector + "//button[contains(@class,\"loginButton\")]");
	public By error_message_label		= By.xpath("//*[@class=\"errorMessage\"]");
	

	public By[] loginPagements =
	{
		user_textBox,
		password_textBox,
		login_button
	};
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static Logger logger = LoggerFactory.getLogger(LoginPage.class);

	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 3000);
	}

	public String getPageTitle() {
		return (String) driver.getTitle();
	}

	public void verifyLoginPageElements() {
		By[] webPageElement = loginPagements;

		for (By elements : webPageElement) {
			logger.debug("verifyPageElements : Current Element = '" + elements + "' ");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(elements));
			
			driver.findElement(elements).isDisplayed();
			driver.findElement(elements).isEnabled();

		}

	}
	

	public void verifyPageApplication(String url) {
		
		String currUrl = getPageTitle();
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
	
	public void verifyErrorMessage(String errMsgLabel, boolean isVisible) {
		
		logger.debug("verifyErrorMessage: '" + errMsgLabel + "' ");
		
		WebElement getErrMessage = null ;

		if (isVisible) {
			getErrMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(error_message_label));
		}
//		String geterrMessage = driver.findElement(error_message_label).getText();	
		Assert.assertTrue(getErrMessage.getText().contains(errMsgLabel));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	public void enterUserCredentails(String username, String password) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.debug("enterUserCredentails: username = '" + username + "' | password = '" + password + "' ");
		driver.findElement(user_textBox).sendKeys(username);
		driver.findElement(password_textBox).sendKeys(password);
		driver.findElement(login_button).click();
	}

}
