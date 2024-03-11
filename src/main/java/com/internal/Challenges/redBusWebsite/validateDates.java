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

	public void getWeekEndDates(String date) {
		NavigateTo(prop.getProperty("redBusUrl"));
		click(redbusDatesXpaths.dateBtn);
		String dateTxt = getText(redbusDatesXpaths.dateTxt);
		LOG.info("Date : " + dateTxt);
		String holidaysCount = getText(redbusDatesXpaths.holidaysCount);
		LOG.info("Holidays : " + holidaysCount);
		boolean enter = true;
		while (enter) {
			if (!dateTxt.equalsIgnoreCase(date)) {
				click(redbusDatesXpaths.navigator);
				dateTxt = getText(redbusDatesXpaths.dateTxt);
				LOG.info("Date : " + dateTxt);
				holidaysCount = getText(redbusDatesXpaths.holidaysCount);
				LOG.info("Holidays : " + holidaysCount);
			}else {
				enter=false;
				dateTxt = getText(redbusDatesXpaths.dateTxt);
				LOG.info("Date : " + dateTxt);
				holidaysCount = getText(redbusDatesXpaths.holidaysCount);
				LOG.info("Holidays : " + holidaysCount);
			}
		}

//		delayExecution(10);
	}
}
