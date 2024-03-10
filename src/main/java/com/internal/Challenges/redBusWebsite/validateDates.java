package com.internal.Challenges.redBusWebsite;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.internal.base.GlobalValues;
import com.internal.base.PageActions;

public class validateDates extends PageActions {
	private static Logger LOG = Logger.getLogger(validateDates.class);
	private final Properties prop;

	public validateDates(GlobalValues globalValues) {
		super((WebDriver) globalValues.dataBuffer.get("webDriver"));
		this.prop = GlobalValues.envConfig;
	}

	public void getWeekEndDates() {
		NavigateTo(prop.getProperty("redBusUrl"));
	}
}
