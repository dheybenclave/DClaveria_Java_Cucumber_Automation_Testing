package com.pages.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.BaseClass;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginPage extends BaseClass {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 3000);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String login_parent_selector = "//div[@id=\"credentials\"]";
	public By user_textBox				= By.xpath(login_parent_selector + "//div[@class=\"field user\"]//input");
	public By password_textBox 			= By.xpath(login_parent_selector + "//div[@class=\"field password\"]//input");
	public By login_button 				= By.xpath(login_parent_selector + "//button[contains(@class,\"loginButton\")]");
	public By error_message_label 		= By.xpath("//*[@class=\"errorMessage\"]");

	public By[] loginPagements = {
		user_textBox,
		password_textBox,
		login_button
	};
		
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void verifyLoginPageElements() {
		By[] webPageElement = loginPagements;

		for (By elements : webPageElement) {
			logger.debug("verifyPageElements : Current Element = '" + elements + "' ");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(elements));
			
			driver.findElement(elements).isDisplayed();
			driver.findElement(elements).isEnabled();
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
