package com.internal.Challenges.redBusWebsite;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.internal.base.GlobalValues;
import com.internal.base.PageActions;

public class validateDates extends PageActions{
	
	private static Properties prop;


	public validateDates(GlobalValues globalValues) {
		super((WebDriver) globalValues.dataBuffer.get("webDriver"));
	}
	
	public void getWeekEndDates() {
		NavigateTo(prop.getProperty("redBusUrl"));
	}
	

}
