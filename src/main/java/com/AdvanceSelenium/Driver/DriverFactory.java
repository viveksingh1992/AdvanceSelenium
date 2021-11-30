package com.AdvanceSelenium.Driver;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

import com.AdvanceSelenium.Utils.PropKey;
import com.AdvanceSelenium.Utils.PropertyReader;
import com.AdvanceSelenium.Utils.TimeUtil;

public class DriverFactory {

	public static PropertyReader prop;

	protected static WebDriver driver;

	private static ThreadLocal<WebDriver> driverthreadlocal = new ThreadLocal<>();

	public static WebDriver getDriver() {
		if (driver == null) {
			driverthreadlocal.set(getBrowser().getWebDriver());
		}

		driverthreadlocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUtil.getImplicitWait()));
		return driverthreadlocal.get();
	}

	public static void quitDriver() {
		driverthreadlocal.get().quit();
	}

	private static BrowserType getBrowser() {

		if (prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("CHROME")) {
			return BrowserType.CHROME;

		} else if (prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("FIREFOX")) {
			return BrowserType.FIREFOX;

		} else if (prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("EDGE")) {
			return BrowserType.EDGE;

		} else {
			return BrowserType.CHROME;
		}
	}
}
