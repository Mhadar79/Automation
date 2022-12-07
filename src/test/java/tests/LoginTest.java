package tests;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LogInPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void tc01_login() {
		LogInPage lp = new LogInPage(driver);
		lp.clickOnLogin();
		lp.clearEmailField("");
		String actual = lp.requiredMsg();
		String expected = "Required";
		Assert.assertEquals(actual, expected, "Error message is not valid");
	}
	@Test
	public void tc02_login() {
		LogInPage lp = new LogInPage(driver);
		lp.clearEmailField("abcd");
		String actual = lp.requiredMsg();
		String expected = "Please enter a valid email address";
		Assert.assertEquals(actual, expected, "Error message is not valid");
	}
	@Test(dataProvider = "getData")
	public void tc03_login (String user, String password) {
		LogInPage lp = new LogInPage(driver);
		lp.closeLogIn();
		lp.login(user, password);
		String actual = lp.errorDetails();
		String expected = "Unable to log in with provided credentials.";
		Assert.assertEquals(actual, expected, "Error message is not valid");
	}
	@Test
	public void tc04_login() {
		LogInPage lp = new LogInPage(driver);
		lp.closeLogIn();
		lp.login("mh18979@gmail.com", "M18h09#79");
		HomePage hp = new HomePage(driver);
		String actual = hp.getName();
		String expected = "Hi, Maor";
		Assert.assertEquals(actual, expected, "Login failed");
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"mh18979@gmail.com", "dsfsdf"},
				{"mh18979@gmail.co.il","M18h09#79"},
				{"mh18979@gmail.com", "dsf"},
		};
		return myData;
	}
	
	
}
