package com.internal.TestSuites;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.internal.Challenges.redBusWebsite.validateDates;
import com.internal.base.DriverHelper;
import com.internal.base.GlobalValues;

public class redBusTest {
	private validateDates buses;

	public redBusTest(GlobalValues globalValues) {
		DriverHelper.launchBrowser();
		buses = new validateDates(globalValues);
	}
	
	@Test
	public void test() {
		buses.getWeekEndDates();
	}
	
	@AfterSuite
	public void closeBrowser() {
		
	}

}
