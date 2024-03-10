package com.internal.Challenges.redBusWebsite;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.internal.base.GlobalValues;
import com.internal.base.PageActions;

public class validateDates {
	private static Logger LOG = Logger.getLogger(validateDates.class);
	PageActions pageactions;
	Properties prop;
	

	public validateDates(GlobalValues globalValues) {
		LOG.info(globalValues.dataBuffer.get("webDriver"));
		if(globalValues.dataBuffer.get("webDriver") == null) {
			LOG.info("NULL");
		}else {
			LOG.info("NOT NULL");
		}
		pageactions = new PageActions((WebDriver) globalValues.dataBuffer.get("webDriver"));
		this.prop = GlobalValues.envConfig;
	}

	public void getWeekEndDates() {
		LOG.info(prop.getProperty("redBusUrl"));
		pageactions.NavigateTo("https://www.google.com");
	}
}
