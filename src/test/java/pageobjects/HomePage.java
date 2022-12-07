package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	@FindBy(css="[alt=\"Close\"]")
	private WebElement closeWindow;
	@FindBy(css="[class=\"nav-right__user-profile\"] [class=\"btn\"]")
	private WebElement nameOfUser;
	@FindBy(css=".app-header__desktop > nav > div > a:nth-child(1)")
	private WebElement destinationsBtn;
	@FindBy(css="a.btn-blue-outlined.btn.btn-link")
	private WebElement buildYourOwnTripBtn;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void closeWindow() {
		sleep(12000);
		waitForLoad(closeWindow);
		click(closeWindow);
	}
	
	public String getName() {
		waitForLoad(nameOfUser);
		return getText(nameOfUser);
	}
	
	public void clickOnDestinations() {
		sleep(1500);
		waitForLoad(destinationsBtn);
		click(destinationsBtn);
	}
	
	public void StartPlanBtn() {
		sleep(1600);
		waitForLoad(buildYourOwnTripBtn);
		click(buildYourOwnTripBtn);
	}
	
	

}
