package com.AdvanceSelenium.Pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AdvanceSelenium.Utils.PropKey;
import com.AdvanceSelenium.Utils.PropertyReader;

public class BasePage2 extends HTMLPageObject {

	private WebDriver driver;

	public BasePage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static final String NAV_HAMBURGER_MANU_ID = "nav-hamburger-menu";
	public static final String NAV_HAMBURGER_MENU_OPTIONS = "//*[@class='hmenu hmenu-visible']/li/a";
	public static final String FIRST_PRODUCT_LINK = "//*[@id='zg_left_col1']/div[1]/div//*[@class='a-carousel-col a-carousel-center']//li[1]//a[2]";

	public static final String MENU_OPTION_TO_SELECT_1 = "Best Sellers";

	@FindBy(id = NAV_HAMBURGER_MANU_ID)
	private WebElement allOptionsMenu;

	@FindBy(id = NAV_HAMBURGER_MENU_OPTIONS)
	private WebElement allOptionsMainMenu;

	@FindBy(xpath = FIRST_PRODUCT_LINK)
	private WebElement firstBestSeller;

	public void navigateToApp() {
		try {
			driver.navigate().to(new URL(PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal())));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public PDPage navigateToAllCategoriesMenu() {
		clickAction(allOptionsMenu);
		clickOnListOption(By.xpath(NAV_HAMBURGER_MENU_OPTIONS), MENU_OPTION_TO_SELECT_1);
		return new PDPage(driver);
	}

	public PDPage navigateProductPage() {
		clickAction(firstBestSeller);
		return new PDPage(driver);
	}
}
