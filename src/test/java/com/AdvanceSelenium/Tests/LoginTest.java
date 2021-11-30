package com.AdvanceSelenium.Tests;

import org.junit.jupiter.api.Test;

import com.AdvanceSelenium.Driver.DriverManager;
import com.AdvanceSelenium.Pages.BasePage1;

public class LoginTest extends DriverManager {

	@Test
	void doLogin() {
		BasePage1 basePage = new BasePage1(getDriver());
		basePage.navigateToApp();
		basePage.navigateToLoginPage();
	}
}