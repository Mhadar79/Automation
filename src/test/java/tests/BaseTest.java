package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import utils.Utils;

public class BaseTest {
WebDriver driver;
	
	@BeforeClass
	public void setup() throws AWTException {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
		driver = WebDriverManager.chromedriver().capabilities(options).avoidShutdownHook().create();
		driver.manage().window().maximize();
		Utils u = new Utils();
		driver.get(u.readProperty("url"));
		Robot robot = new Robot();
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		HomePage hp = new HomePage(driver);
		hp.closeWindow();
	}
	/*
	 * This method will run after each test,
	 * it will take screen shot only for tests that failed
	 */
	@AfterMethod
	public void failedTest(ITestResult result) {
	  //check if the test failed
		if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SUCCESS){
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//result.getname() method will give you current test case name. 
			//./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
		}
	}
	
	//@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
