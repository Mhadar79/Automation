package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyTripPage extends BasePage{
	
	@FindBy(css="[class=\"trip-item\"]")
	private WebElement tripItem;
	@FindBy(css="[class=\"trip-item__control\"]")
	private WebElement editTripName;
	@FindBy(css="[class=\"trip-item__control trip-item__control--delete\"]")
	private WebElement deleteTrip;
	@FindBy(css="[class=\"btn btn-link\"]")
	private WebElement tripInfo;
	@FindBy(css="[class=\"input__input\"]")
	private WebElement nameField;
	@FindBy(css="[class=\"input__input input__input--error\"]")
	private WebElement emptyNameField;
	@FindBy(css="[class=\"btn btn-dark-blue-outlined btn-fluid trip-title-form__control-cancel btn\"]")
	private WebElement cancelBtn;
	@FindBy(css="[class=\"btn-blue btn-fluid trip-title-form__control-save btn\"]")
	private WebElement saveBtn;
	@FindBy(css="[class=\"trip-title-form__title\"]")
	private WebElement renameTitle;
	@FindBy(css="[class=\"btn-blue btn-small btn\"]")
	private WebElement removeBtn;
	@FindBy(css="[class=\"confirm-modal__title\"]")
	private WebElement removeTitle;

	public MyTripPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean validatePage(String name) {
		sleep(5000);
		List<WebElement> list = driver.findElements(By.cssSelector("[class=\"trip-item\"]"));
		//	System.out.println("length = " + list.size());
			for (WebElement el : list) {
				WebElement title = el.findElement(By.cssSelector("[class=\"trip-item__title\"]"));
				if (getText(title).equalsIgnoreCase(name)) {
					return true;
				}
			}return false;
			
		
	}
	
	public void editName(String name, String newName ) {
		sleep(5000);
		List<WebElement> list = driver.findElements(By.cssSelector("[class=\"trip-item\"]"));
		//	System.out.println("length = " + list.size());
			for (WebElement el : list) {
				WebElement title = el.findElement(By.cssSelector("[class=\"trip-item__title\"]"));
				if (getText(title).equalsIgnoreCase(name)) {
					WebElement edit = el.findElement(By.cssSelector("[class=\"trip-item__control\"]"));
					click(edit);
					break;
				}
			}
		sleep(800);
		deleteKeys(nameField);
		sleep(800);
		fillTextNoClear(emptyNameField, newName);
		sleep(800);
		click(saveBtn);
	}
	
	public void clickOnTripInfo() {
		click(tripInfo);
	}
	
	public void deleteTrip(String name) {
		sleep(5000);
		List<WebElement> list = driver.findElements(By.cssSelector("[class=\"trip-item\"]"));
		//	System.out.println("length = " + list.size());
			for (WebElement el : list) {
				WebElement title = el.findElement(By.cssSelector("[class=\"trip-item__title\"]"));
				if (getText(title).equalsIgnoreCase(name)) {
					WebElement delete = el.findElement(By.cssSelector("[class=\"trip-item__control trip-item__control--delete\"]"));
					click(delete);
					break;
				}
			}
	}
	
	public String validateRemoveTitle() {
		return getText(removeTitle);
	}
	
	public void clickOnRemove() {
		sleep(1500);
		click(removeBtn);
	}
	
	public boolean checkItemRemoved(String name) {
		sleep(5000);
		List<WebElement> list = driver.findElements(By.cssSelector("[class=\"trip-item\"]"));
		//	System.out.println("length = " + list.size());
			for (WebElement el : list) {
				WebElement title = el.findElement(By.cssSelector("[class=\"trip-item__title\"]"));
				if (getText(title).equalsIgnoreCase(name)) {
					return true;
				}
			}return false;
			
		
	}
}
