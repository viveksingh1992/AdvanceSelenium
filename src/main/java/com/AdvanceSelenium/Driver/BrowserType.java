package com.AdvanceSelenium.Driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public enum BrowserType implements DriverSetup {

	CHROME {
		@Override
		public Capabilities getBrowserCapabilities() {
			Capabilities capabilities = getBrowserOptions();

			return capabilities;
		}

		@Override
		public ChromeOptions getBrowserOptions() {
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("--start-maximized");
			chromeoptions.addArguments("--ignore-certificate-errors");
			chromeoptions.addArguments("--incognito");
			return chromeoptions;
		}

		@Override
		public WebDriver getWebDriver() {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeoptions = getBrowserOptions();
			return new ChromeDriver(chromeoptions);
		}
	},

	FIREFOX {
		@Override
		public Capabilities getBrowserCapabilities() {
			Capabilities capabilities = getBrowserOptions();
			return capabilities;
		}

		@SuppressWarnings("deprecation")
		@Override
		public FirefoxOptions getBrowserOptions() {
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			firefoxoptions.addArguments("--start-maximized");
			firefoxoptions.addArguments("--incognito");

			FirefoxProfile firefoxprofile = new FirefoxProfile();
			firefoxprofile.setAcceptUntrustedCertificates(true);
			firefoxprofile.setAssumeUntrustedCertificateIssuer(true);

			firefoxoptions.setCapability(FirefoxDriver.PROFILE, firefoxprofile);

			return firefoxoptions;
		}

		@Override
		public WebDriver getWebDriver() {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxoptions = getBrowserOptions();
			return new FirefoxDriver(firefoxoptions);
		}
	},

	EDGE {
		@Override
		public Capabilities getBrowserCapabilities() {
			Capabilities capabilities = getBrowserOptions();
			return capabilities;
		}

		@Override
		public EdgeOptions getBrowserOptions() {
			EdgeOptions edgeoptions = new EdgeOptions();
			edgeoptions.addArguments("--start-maximized");
			edgeoptions.addArguments("--incognito");
			return edgeoptions;
		}

		@Override
		public WebDriver getWebDriver() {
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeoptions = getBrowserOptions();
			return new EdgeDriver(edgeoptions);
		}
	};

}
