package com.internal.Challenges.redBusWebsite;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.internal.base.GlobalValues;
import com.internal.base.PageActions;

public class validateDates extends PageActions {
	private static Logger LOG = Logger.getLogger(validateDates.class);
	private static Properties prop;

	public validateDates() {
		super((WebDriver) GlobalValues.dataBuffer.get("webDriver"));
//		 if (!(GlobalValues.dataBuffer.get("webDriver") instanceof WebDriver)) {
//           throw new IllegalArgumentException("webDriver not found in dataBuffer or not instance of WebDriver");
//       }
		this.prop = GlobalValues.getEnvConfig();
	}

//	public ValidateDates() {
//        super((WebDriver) GlobalValues.dataBuffer.get("webDriver"));
//        if (!(GlobalValues.dataBuffer.get("webDriver") instanceof WebDriver)) {
//            throw new IllegalArgumentException("webDriver not found in dataBuffer or not instance of WebDriver");
//        }
//        this.prop = GlobalValues.getEnvConfig();
//    }
	public void getWeekEndDates() {
		if (GlobalValues.dataBuffer.get("webDriver") == null) {
			LOG.info("driver was null");
		}else {
			LOG.info("Not null");
		}
		LOG.info(prop.getProperty("redBusUrl"));
//		NavigateTo("https://www.google.com");
	}
}
