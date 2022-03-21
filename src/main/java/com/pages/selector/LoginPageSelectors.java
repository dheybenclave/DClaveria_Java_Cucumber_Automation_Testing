package com.pages.selector;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import org.openqa.selenium.By;

public class LoginPageSelectors {

	public String login_parent_selector = "//div[@id=\"credentials\"]";
	public By user_textBox = By.xpath(login_parent_selector + "//div[@class=\"field user\"]//input");
	public By password_textBox = By.xpath(login_parent_selector + "//div[@class=\"field password\"]//input");
	public By login_button = By.xpath(login_parent_selector + "//button[contains(@class,\"loginButton\")]");

	public By[] loginPagements =
	{
		user_textBox,
		password_textBox,
		login_button
	};

}
