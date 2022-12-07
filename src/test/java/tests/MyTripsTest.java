package tests;

import java.util.ArrayList;


import org.testng.Assert;
import org.testng.annotations.Test;


import pageobjects.LogInPage;
import pageobjects.MyTripPage;
import pageobjects.PersonalizedPage;

public class MyTripsTest extends BaseTest{

	
	@Test
	public void tc01_MyTripsTest() {
		LogInPage lp = new LogInPage(driver);
		lp.login("mh18979@gmail.com", "M18h09#79");
		PersonalizedPage pp = new PersonalizedPage(driver);
		pp.navMyTrips();
		MyTripPage mtp = new MyTripPage(driver);
		mtp.editName("Amsterdam","Test1");
	}
	
	@Test
	public void tc02_MyTripsTest() {
		MyTripPage mtp = new MyTripPage(driver);
		mtp.clickOnTripInfo();
		PersonalizedPage pp = new PersonalizedPage(driver);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		String expected = "Your personalized trip to Amsterdam";
		String actual = pp.getTitle1();
		Assert.assertEquals(actual, expected);
		driver.switchTo().window(tabs2.get(0));
	}
	
	@Test
	public void tc03_MyTripsTest() {
		MyTripPage mtp = new MyTripPage(driver);
		mtp.deleteTrip("Test1");
		String actual = mtp.validateRemoveTitle();
		String expected = "Remove trip?";
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void tc04_MyTripsTest() {
		MyTripPage mtp = new MyTripPage(driver);
		mtp.clickOnRemove();
		Assert.assertFalse(mtp.checkItemRemoved("Step1"));
	}
	
	
	
	
}
