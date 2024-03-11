package com.internal.Challenges.redBusWebsite;

import org.openqa.selenium.By;

public class redbusDatesXpaths {

	public static By dateBtn = By.cssSelector("#onwardCal");

	public static By dateTxt = By.cssSelector("div[class^='DayNavigator__CalendarHeader']>div:nth-child(2)");
	
	public static By holidaysCount = By.cssSelector("div.holiday_count");
	
	public static By navigator = By.cssSelector("div[class^='DayNavigator__CalendarHeader']>div:nth-child(3)");

}
