package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


	abstract class BasePage {
		WebDriver driver;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions action;
		
		public BasePage(WebDriver driver) {
			this.driver = driver;
			js=(JavascriptExecutor)driver;
			PageFactory.initElements(driver,this);
		}
		
		
		
		public void fillText(WebElement el, String text) {
			//highlight
			js.executeScript("arguments[0].setAttribute('style', 'font-color:Black', 'background-color: #00FFFF', 'border: 1px solid blue;');", el);
			el.clear();
			el.sendKeys(text);
		}
		
		public void fillTextNoClear(WebElement el, String text) {
			el.sendKeys(text);
		}
		
		public void click(WebElement el) {
			//highlight
		//	JavascriptExecutor js=(JavascriptExecutor)driver; 
		//	js.executeScript("arguments[0].setAttribute('style', 'background-color: #00FFFF', 'border: 1px solid yellow;');", el);
			el.click();
		}
		
		public void deleteKeys(WebElement el) {
			el.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			el.sendKeys(Keys.chord(Keys.TAB));
			
		}
		
		
		//wait for the element to be click able.
		public void waitForLoad(WebElement el) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(360));
			wait.until(ExpectedConditions.elementToBeClickable(el));
		}
		
	
		
		//wait for element to disappear
		public void waitForFinish(WebElement el) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(360));
			wait.until(ExpectedConditions.invisibilityOf(el));
		}
		public void sendKeysJS(WebElement el, String text) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
			//set the text
			jsExecutor.executeScript("document.getElementByCss().value='testuser'");  
			//get the text
			text = (String) jsExecutor.executeScript("return document.getElementById('firstName').value"); 
		}
		
		//get the text from the element
		public String getText(WebElement el) {
			js.executeScript("arguments[0].setAttribute('style', 'font-color:Black', 'background-color: #00FFFF', 'border: 1px solid blue;');", el);
			return el.getText();
		}
		
		//get the source of the element
		public String getSrc(WebElement el) {
			return el.getAttribute("src");
		}
		
		//clear the text in the element (field)
		public void clearText(WebElement el) {
			el.clear();
		}
		
		public void robotFile(String pathFile) throws AWTException {
			Robot rb = new Robot();
			StringSelection str = new StringSelection(pathFile);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		    System.out.println("1");
		    sleep(2000);
		     // press Control+V for pasting
		     rb.keyPress(KeyEvent.VK_CONTROL);
		     rb.keyPress(KeyEvent.VK_V);
		     System.out.println("2");
		     sleep(2000);
		    // release Control+V for pasting
		    rb.keyRelease(KeyEvent.VK_CONTROL);
		    rb.keyRelease(KeyEvent.VK_V);
		    System.out.println("3");
		    sleep(2000);
		    // for pressing and releasing Enter
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
		    System.out.println("4");
		}
		
		//double click on element
		public void doubleClick(WebElement el) {
			//JavascriptExecutor js=(JavascriptExecutor)driver; 
			//js.executeScript("arguments[0].setAttribute('style', 'border: 1px solid yellow;');", el);
			Actions actions = new Actions(driver);
			actions.moveToElement(el);
			sleep(1000);
			actions.doubleClick(el).perform();;
		}
		
		//right click with mouse on the element
		public void rightClick(WebElement el) {
			//JavascriptExecutor js=(JavascriptExecutor)driver; 
		//	js.executeScript("arguments[0].setAttribute('style', 'border: 1px solid yellow;');", el);
			Actions actions = new Actions(driver);
			actions.moveToElement(el);
			actions.contextClick(el).perform();
		}
		
		public void getAtribute() {
			
		}
		
		public void getUrl(String url, String name) {
			url = driver.getCurrentUrl();
		//	url.endsWith(name);
			
		}
		
		public void browser() {
		
		}
		public void sleep(long mills) {
			try {
				Thread.sleep(mills);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void waitAndSwitch(String name) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
			
		}
		public String currentMonth() {
			 // Create object of SimpleDateFormat class and decide the format
			 DateFormat dateFormat = new SimpleDateFormat("MMMM");
			 
			 //get current date time with Date()
			 Date date = new Date();
			 
			 // Now format the date
			 String date1= dateFormat.format(date);
			 return date1;
		}

	
}
