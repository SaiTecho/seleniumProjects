package com.internal.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverHelper {
	private static Logger LOG = Logger.getLogger(DriverHelper.class);
	public static Properties prop;
	private static WebDriver driver;

	private static GlobalValues globalValues;

	static {
		prop = new Properties();
		globalValues = new GlobalValues();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			prop.load(fis);
			LOG.info("SuccessFully Loaded The Config Properties");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public static void launchBrowser() {
		String browser = prop.getProperty("browser");
		LOG.info("Browser : " + browser);
		try {
			if (Boolean.parseBoolean(prop.getProperty("browser.autoDownload"))) {
				LOG.info("Auto Download is Enabled, Browser is downloading");
				if (browser.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					options.addArguments("--disable-notifications");
					options.addArguments("--disable-extensions");
					driver = new ChromeDriver(options);
					LOG.info("Launching the chromeDriver.....");
				} else if (browser.equalsIgnoreCase("edge")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}
			} else {
				LOG.info("Auto Download is disabled, Checking for existing driver");
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + prop.getProperty("chromedriver"));
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					options.addArguments("--disable-notifications");
					options.addArguments("--disable-extensions");
					driver = new ChromeDriver(options);
				} else if (browser.equalsIgnoreCase("edge")) {
					System.setProperty("webdriver.edge.driver",
							System.getProperty("user.dir") + prop.getProperty("edgedriver"));
					driver = new EdgeDriver();
				}
			}
			globalValues.dataBuffer.put("webDriver", driver);
		} catch (Exception e) {
			LOG.info("Exception occurred: " + e.getMessage());
			throw e;
		}
	}

	public static void QuitBrowser() {
		WebDriver driver = (WebDriver) globalValues.dataBuffer.get("webDriver");
		driver.quit();
	}

}
