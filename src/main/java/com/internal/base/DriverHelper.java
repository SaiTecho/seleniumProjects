package com.internal.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverHelper {
	private static Logger LOG = Logger.getLogger(DriverHelper.class);
	private static Properties prop;
	private static WebDriver driver;

	public GlobalValues globalValues;

	public DriverHelper(GlobalValues globalValues) {
		this.globalValues = globalValues;
	}

	public void loadAllProperties() {
		prop = new Properties();
		try {
			FileInputStream FIS = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			prop.load(FIS);
			for (String key : prop.stringPropertyNames()) {
				LOG.info(key + "--" + prop.getProperty(key));
			}
			GlobalValues.envConfig = prop;
			LOG.info("SuccessFully Loaded The Config Properties");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void launchBrowser(GlobalValues globalValues) {
		loadAllProperties();
		String browser = prop.getProperty("browser");
		LOG.info("Browser : " + browser);
		if (this.globalValues == null) {
			this.globalValues = globalValues;
		}
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
			this.globalValues.dataBuffer.put("webDriver", driver);
		} catch (Exception e) {
			LOG.info("Exception occurred: " + e.getMessage());
			throw e;
		}
	}

	public void quitBrowser() {
		WebDriver driver = (WebDriver) globalValues.dataBuffer.get("webDriver");
		driver.quit();
	}
}
