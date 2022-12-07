package tests;

import java.awt.AWTException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import org.testng.Assert;
import pageobjects.CreateTripPage;
import pageobjects.HomePage;
import pageobjects.LogInPage;
import pageobjects.MyTripPage;
import pageobjects.PersonalizedPage;

public class PlaningFlowTest extends BaseTest{
	
	public static List<String> monthList = Arrays.asList("January ", "February ", "March ", "April ", "May ", "June ", "July ", "August ", "September ", "October ", "November ", "December ");
	public static Random r1 = new Random();
	public static int randomitem1 = r1.nextInt(monthList.size());
	public static String randomMonth = monthList.get(randomitem1);
	public static List<String> financial = Arrays.asList("Shoestring","Economy", "Comfort", "Luxury");
	public static Random r = new Random();
	public static int randomitem = r.nextInt(financial.size());
	public static String randomfinance = financial.get(randomitem);
	public static List<String> interests = Arrays.asList("business","Family trip","Theme","Nature","romantic","sport");
	public static Random r2 = new Random();
	public static int randomitem2 = r2.nextInt(interests.size());
	public static String randominterests = interests.get(randomitem2);
	
	@Test
	public void tc01_PlaningTest() throws AWTException, InterruptedException {
		LogInPage lp = new LogInPage(driver);
		lp.login("mh18979@gmail.com", "M18h09#79");
	}
	
	@Test
	public void tc02_planningTest() {
		HomePage hp = new HomePage(driver);
		hp.StartPlanBtn();
	}
	
	@Test
	public void tc03_planningTest() {
		CreateTripPage ctp = new CreateTripPage(driver);
		ctp.clickOnStart("Start planning");
		ctp.chooseDestination("amste");
		ctp.clickOnNextStep();
	}
	
	@Test
	public void tc04_planningTest() {
		CreateTripPage ctp = new CreateTripPage(driver);
		ctp.chooseDates("22", "11");
		
		}
	
	@Test
	public void tc05_planningTest() {
		CreateTripPage ctp = new CreateTripPage(driver);
		ctp.whoCome();
		ctp.whoCome();
		ctp.decreaseAge("18 - 30 y.o.");
		ctp.increaseAge("31 - 45 y.o.");
		ctp.increaseAge("31 - 45 y.o.");
		ctp.increaseAge("4 - 8 y.o.");
		ctp.increaseAge("9 - 13 y.o.");
	}
	
	@Test
	public void tc06_planningTest() {
		CreateTripPage ctp = new CreateTripPage(driver);
		ctp.chooseHowMuch(randomfinance);
	}
	
	@Test
	public void tc07_planningTest() {
		CreateTripPage ctp = new CreateTripPage(driver);
		ctp.chooseWhat(randominterests);
	}

	@Test
	public void tc08_planningTest() {
		PersonalizedPage pp = new PersonalizedPage(driver);
		String expected = "Your personalized trip to Amsterdam";
		String actual = pp.getTitle1();
		Assert.assertEquals(actual, expected);
		pp.saveTrip();
	}
	
	@Test
	public void tc09_planningTest() {
	PersonalizedPage pp = new PersonalizedPage(driver);
	pp.navMyTrips();
	MyTripPage mtp = new MyTripPage(driver);
	Assert.assertTrue(mtp.validatePage("Amsterdam"));
	}
}
