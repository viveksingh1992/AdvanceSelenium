package com.AdvanceSelenium.Tests;

import org.junit.jupiter.api.Test;

import com.AdvanceSelenium.Driver.DriverManager;
import com.AdvanceSelenium.Pages.BasePage2;

public class NavigationTest extends DriverManager {

	@Test
	void doNavigation() {
		BasePage2 basePage = new BasePage2(getDriver());
		basePage.navigateToApp();
		basePage.navigateToAllCategoriesMenu();
//		basePage.navigateProductPage();
	}
}
