package pageobjects;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.interactions.Actions;

public class InterestsPage extends BasePage{
	
	
	@FindBy(css="li:nth-child(1) > div.interests-list__item--slider > div > div > div > div.rc-slider-handler-tooltip > div")
	private WebElement museumesGaleries;
	@FindBy(css="li:nth-child(2) > div.interests-list__item--slider > div > div > div > div.rc-slider-handler-tooltip > div")
	private WebElement sitesAtttractions;
	@FindBy(css="li:nth-child(3) > div.interests-list__item--slider > div > div > div > div.rc-slider-handler-tooltip > div")
	private WebElement shows;
	@FindBy(css="li:nth-child(4) > div.interests-list__item--slider > div > div > div > div.rc-slider-handler-tooltip > div")
	private WebElement gastronomy;
	@FindBy(css="li:nth-child(5) > div.interests-list__item--slider > div > div > div > div.rc-slider-handler-tooltip > div")
	private WebElement shopping;
	@FindBy(css="li:nth-child(6) > div.interests-list__item--slider > div > div > div > div.rc-slider-handler-tooltip > div")
	private WebElement nightlife;
	@FindBy(css="li:nth-child(7) > div.interests-list__item--slider > div > div > div > div.rc-slider-handler-tooltip > div")
	private WebElement sports;
	@FindBy(css="li:nth-child(8) > div.interests-list__item--slider > div > div > div > div.rc-slider-handler-tooltip > div")
	private WebElement recreation;
	@FindBy(css = ".interests-form__body > ul > li")
	List<WebElement> interest_li_item;
	@FindBy(css="[class=\"btn-blue btn\"]")
	private WebElement showResults;
	
	
	public InterestsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void setRandoInterests() {
		List<WebElement> list = Arrays.asList(museumesGaleries, sitesAtttractions, shows, gastronomy, shopping, nightlife, sports, recreation);
		for (WebElement el : list) {
		Random random = new Random() ;
		int max = 200;
		int min = 10;
		int randomNumber = random.nextInt(max - min + 20) + min;
		System.out.println(max);
		System.out.println(min);
		System.out.println(randomNumber);
		System.out.println(random);
		Actions action  = new Actions(driver);
		action.moveToElement(el).dragAndDropBy(el, randomNumber, 0).build().perform();
		
		}
		sleep(1000);
		click(showResults);
	}
	
	
}
