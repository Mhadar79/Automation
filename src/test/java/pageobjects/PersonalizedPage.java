package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalizedPage extends BasePage{
	
	@FindBy(css="[class=\"trip2-hero__title\"]")
	private WebElement title1;
	@FindBy(css="[class=\"btn-dark-blue btn\"]")
	private WebElement saveBtn;
	@FindBy(css=".app-header__desktop > nav > div > a:nth-child(2)")
	private WebElement myTripsBtn;
	
	
	
	

	public PersonalizedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public String getTitle1() {
		sleep(5000);
		return getText(title1);
	}
	
	public void saveTrip() {
		sleep(5000);
		click(saveBtn);
	}
	
	public void navMyTrips() {
		sleep(5000);
		click(myTripsBtn);
	}

}
