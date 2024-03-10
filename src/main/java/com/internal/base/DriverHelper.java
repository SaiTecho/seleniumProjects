package com.internal.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverHelper {

	public static Properties prop;
	private static WebDriver driver;
	private static Logger LOG = Logger.getLogger(DriverHelper.class);
	private static GlobalValues globalValues;

	public DriverHelper() {
		globalValues = new GlobalValues();
	}

	static {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public static void launchBrowser() {
		String browser = prop.getProperty("browser");
		try {
			if (Boolean.parseBoolean(prop.getProperty("browser.autoDownload"))) {
				LOG.info("Auto Download is Enabled, Browser is downloading");
				if (browser.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver((ChromeOptions) capabilities());
				} else if (browser.equalsIgnoreCase("edge")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}
			} else {
				LOG.info("Auto Download is disabled, Checking for existing driver");
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + prop.getProperty("chromedriver"));
					driver = new ChromeDriver((ChromeOptions) capabilities());
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

	private static MutableCapabilities capabilities() {
		MutableCapabilities capabilities = new MutableCapabilities();
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		}
		return capabilities;
	}

}
