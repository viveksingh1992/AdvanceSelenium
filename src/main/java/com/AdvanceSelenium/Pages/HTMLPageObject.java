package com.AdvanceSelenium.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AdvanceSelenium.Driver.DriverManager;
import com.AdvanceSelenium.Utils.TimeUtil;

import io.netty.handler.timeout.TimeoutException;

public class HTMLPageObject extends DriverManager {

	public WebElement findElementbyCSS(String cssLocator) {
		try {
			By by = By.cssSelector(cssLocator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeUtil.getExplicitWait()));

			return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (TimeoutException t) {
			throw new org.openqa.selenium.TimeoutException();
		}
	}

	public WebElement findElementbyxPath(String xpathLocator) {
		try {
			By by = By.xpath(xpathLocator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeUtil.getExplicitWait()));

			return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (TimeoutException t) {
			throw new org.openqa.selenium.TimeoutException();
		}
	}

	public WebElement findElementbyId(String idLocator) {
		try {
			By by = By.id(idLocator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeUtil.getExplicitWait()));

			return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (TimeoutException t) {
			throw new org.openqa.selenium.TimeoutException();
		}
	}

	public WebElement findElementBy(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeUtil.getExplicitWait()));

			return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (TimeoutException t) {
			throw new org.openqa.selenium.TimeoutException();
		}
	}

	public List<WebElement> findElementsBy(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeUtil.getExplicitWait()));

			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		} catch (TimeoutException t) {
			throw new org.openqa.selenium.TimeoutException();
		}
	}

	public void enterTextIntoTextBox(By by, String text) {
		WebElement textBox = findElementBy(by);
		textBox.clear();
		textBox.sendKeys(text);
	}

	public void enterTextIntoTextBox(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void clickAction(By by) {
		WebElement elementToClick = findElementBy(by);
		elementToClick.click();
	}

	public void clickAction(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeUtil.getExplicitWait()));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public String getTextFromElement(By by) {
		WebElement elementForText = findElementBy(by);
		return elementForText.getText();
	}

	public String getTextFromElement(WebElement element) {
		return element.getText();
	}

	public String getAttribute(By by, String attr) {
		WebElement elementForText = findElementBy(by);
		return elementForText.getAttribute(attr);
	}

	public String getAttribute(WebElement element, String attr) {
		return element.getAttribute(attr);
	}

	public void selectByVisibleText(By by, String visibleText) {
		WebElement selectBox = findElementBy(by);
		Select select = new Select(selectBox);
		select.selectByVisibleText(visibleText);
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public boolean selectCheckbox(By by) {
		WebElement checkbox = findElementBy(by);
		if (checkbox.isSelected()) {
			return true;
		} else {
			checkbox.click();
			return true;
		}
	}

	public boolean isTextPresentOnPage(String text) {
		String pageSource = driver.getPageSource();
		if (pageSource.contains(text)) {
			return true;
		}

		return false;
	}

	public void clickOnListOption(By by, String optionValue) {

		List<WebElement> listWebElement = driver.findElements(by);
		try {
			for (int i = 0; i <= listWebElement.size(); i++) {
				if (listWebElement.get(i).getText().contentEquals(optionValue)) {
					clickAction(listWebElement.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
