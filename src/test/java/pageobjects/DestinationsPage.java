package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DestinationsPage extends BasePage{
	
	@FindBy(css="[class=\"destinations-header__title\"]")
	private WebElement destinationsHeader;
	@FindBy(css="[class=\"app-header__logo\"]")
	private WebElement logo;
	@FindBy(css="[class=\"destination-description__heading\"]")
	private WebElement destinationPageHeader;

	public DestinationsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getDestiHeader() {
		return getText(destinationsHeader);
	}
	
	public void popularDestinations(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector("[class=\"destinations-page-item__title font-weight-medium\"]"));
		//	System.out.println("length = " + list.size());
			for (WebElement el : list) {
				if (getText(el).equalsIgnoreCase(name)) {
					click(el);
					break;
				}
				
			}sleep(2000);
	}
	
	public String destination() {
		return getText(destinationPageHeader);
	}
}
