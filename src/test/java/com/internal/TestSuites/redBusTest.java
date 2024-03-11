package com.internal.TestSuites;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.internal.Challenges.redBusWebsite.validateDates;
import com.internal.base.DriverHelper;
import com.internal.base.GlobalValues;

public class redBusTest {

	GlobalValues globalValues = new GlobalValues();
	DriverHelper driverHelper = new DriverHelper(globalValues);
	validateDates buses;

	@BeforeSuite
	public void launchBrowser() {
		driverHelper.launchBrowser(globalValues);
	}

	@Test
	public void test() {
		buses = new validateDates(globalValues);
		buses.getWeekEndDates("Jun 2024");
	}

	@AfterSuite
	public void onTestFailure() {
		driverHelper.quitBrowser();
	}

}
