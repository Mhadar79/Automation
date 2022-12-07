package tests;

import java.awt.AWTException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.DestinationsPage;
import pageobjects.HomePage;
import pageobjects.LogInPage;

public class DestinationTest extends BaseTest{
	
	public static List<String> destList = Arrays.asList("London, United Kingdom", "Zurich, Switzerland", "Geneva, Switzerland", "Amsterdam, Netherlands", "Vienna, Austria",
			"Brussels, Belgium", "Munich, Germany", "Berlin, Germany","Paris, France", "Budapest, Hungary", "Dubai, United Arab Emirates", "Istanbul, Turkey",
			"Prague, Czech Republic","Warsaw, Poland","Madrid, Spain","Barcelona, Spain","Barcelona, Spain");
	public static Random r1 = new Random();
	public static int randomitem1 = r1.nextInt(destList.size());
	public static String randomdestination = destList.get(randomitem1);
		
	@Test
	public void tc01_destinationTest() throws AWTException, InterruptedException {
		LogInPage lp = new LogInPage(driver);
		lp.login("mh18979@gmail.com", "M18h09#79");
		HomePage hp = new HomePage(driver);
		hp.clickOnDestinations();
		DestinationsPage dp = new DestinationsPage(driver);
		String actual = dp.getDestiHeader();
		String expected = "Travel anywhere";
		Assert.assertEquals(actual, expected, "Wrong page");
	}
	
	@Test
	public void tc02_destinationTest() {
		DestinationsPage dp = new DestinationsPage(driver);
		dp.popularDestinations(randomdestination);
		String actual = dp.destination();
		String str = "Explore " + randomdestination;
		int end = str.indexOf(",");
		int start = str.indexOf("Explore");
		String expected = str.substring(start , end);
		Assert.assertEquals(actual, expected, "Wrong page");
	}
	
	
}
