package com.AdvanceSelenium.Pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AdvanceSelenium.Utils.PropKey;
import com.AdvanceSelenium.Utils.PropertyReader;

public class BasePage1 extends HTMLPageObject {

	private WebDriver driver;

	public BasePage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static final String YOU_AMAZON_ID = "nav-your-amazon";
	public static final String MAIN_SEARCH_BOX_ID = "twotabsearchtextbox";
	public static final String MAIN_SEARCH_BUTTON_ID = "nav-search-submit-button";
	public static final String SIGNIN_BUTTON_ID = "nav-link-accountList";
	public static final String SIGNIN_HEADER_TEXT_XPATH = "//*[@class='a-row a-spacing-base']/h1";
	public static final String SIGNIN_HEADER_TEXT = "Your Account";
	public static final String MAIN_LOGO_ID = "nav-logo-sprites";
	public static final String SEARCH_KEY_TEXT = "RAZER";
	public static final String SEARCH_MENU_OPTION_TEXT_1 = "RAZER";
	public static final String SEARCH_MENU_OPTION_TEXT_2 = "RAZER";
	public static final String SEARCH_MENU_OPTION_TEXT_3 = "RAZER";

	@FindBy(id = MAIN_LOGO_ID)
	private WebElement mainLogo;

	@FindBy(id = SIGNIN_BUTTON_ID)
	private WebElement signInButton;

	public void navigateToApp() {
		try {
			driver.navigate().to(new URL(PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal())));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public LoginPage navigateToLoginPage() {

		clickAction(signInButton);
		return new LoginPage(driver);
	}

}
