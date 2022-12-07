package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CreateTripPage;
import pageobjects.HomePage;
import pageobjects.InterestsPage;
import pageobjects.LogInPage;

public class InspireMeTest extends BaseTest{

	
	
	
	@Test
	public void tc01_InspireMeTest() {
		LogInPage lp = new LogInPage(driver);
		lp.login("mh18979@gmail.com", "M18h09#79");
		HomePage hp = new HomePage(driver);
		hp.StartPlanBtn();
		CreateTripPage ctp = new CreateTripPage(driver);
		ctp.inspireMe();
		ctp.chooseFlexible();
		String actual = ctp.testHebrew();
		String expected = "Business";
		Assert.assertEquals(actual, expected, "The page is in hebrew");
	}
	@Test
	public void tc02_InspireMeTest() {
		CreateTripPage ctp = new CreateTripPage(driver);
		ctp.chooseActivity();
		ctp.chooseSubActivity();
		ctp.clickOnNextStep();
		InterestsPage ip = new InterestsPage(driver);
		ip.setRandoInterests();
	}
}
