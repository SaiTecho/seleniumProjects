package com.internal.base;

import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions {
	public WebDriver driver;

	private static final Logger LOG = Logger.getLogger(PageActions.class);
	private static Properties prop;

	public PageActions(WebDriver driver) {
		this.driver = driver;
		this.prop = GlobalValues.envConfig;
	}

	public void NavigateTo(String url) {
		try {
			this.driver.navigate().to(url);
			waitForPageLoad();
			LOG.info("Navigated to : " + url);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForPageLoad() {
		int implicitWaitSeconds = Integer.parseInt(prop.getProperty("implicitWait"));
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(implicitWaitSeconds));
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
	}

	public void click(By by) {
		try {
			waitTillElementClickable(by);
			this.driver.findElement(by).click();
		} catch (Exception e) {
			LOG.info("Normal click Doesn't worked ,trying again with jsClick");
			jsClick(by);
		}
	}

	public void click(WebElement element) {
		try {
			waitTillElementVisible(element);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void jsClick(By by) {
		try {
			waitTillElementClickable(by);
			WebElement element = driver.findElement(by);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void waitTillElementClickable(By by) {
		LOG.info("waiting for the element to click " + by);
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitForExpectedElement(By by) {
		LOG.info("waiting for the element to be visible " + by);
		getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitTillElementVisible(WebElement element) {
		LOG.info("waiting for the element to be visible ");
		getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
	}

	public WebDriverWait getWebDriverWait() {
		int explicitWaitSeconds = Integer.parseInt(prop.getProperty("explicitWait"));
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(explicitWaitSeconds));
		return wait;
	}

}
