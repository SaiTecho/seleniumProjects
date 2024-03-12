package com.internal.Challenges.redBusWebsite;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
		String dateTxt = getText(redbusDatesXpaths.dateTxt).replaceAll("\n", " & Num of Holidays : ");
		boolean enter = true;
		while (enter) {
			if (dateTxt.toLowerCase().contains(date.toLowerCase())) {
				enter = false;
				dateTxt = getText(redbusDatesXpaths.dateTxt).replaceAll("\n", " & Num of Holidays : ");
				LOG.info("Date : " + dateTxt);
				getDates();
			} else {
				LOG.info("Date : " + dateTxt);
				click(redbusDatesXpaths.navigator);
				dateTxt = getText(redbusDatesXpaths.dateTxt).replaceAll("\n", " & Num of Holidays : ");
			}
		}
	}

	public void getDates() {
		List<WebElement> dates = getMultipleElements(redbusDatesXpaths.getweekEndDates);
		LOG.info("Weekend dates ..........................");
		for (WebElement getdate : dates) {
			getWebDriverWait().until(ExpectedConditions.visibilityOf(getdate));
			LOG.info(getdate.getText());
		}
	}
}
