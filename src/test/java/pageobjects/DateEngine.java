package pageobjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

public class DateEngine extends BasePage{
	
	private String[] months=new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"};
	private    int currentMonth = Integer.parseInt(getCurrentMonth());
	private    int monthSize;
	
	public DateEngine(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getCurrentMonth() {
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MMMM");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 return date1;
	}
	
	public String getCurrentDay() {
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("dd");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 return date1;
	}
	
	public int getCurrentYear() {
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("yyyy");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 int output = Integer.valueOf(date1);
		 return output;
	}
	
	public String[] setMonths() {
		return months;
	}
	
	public int setReqMonth() {
		return (int)Math.ceil(Math.random()*12);
	}
	
	public int getMonthSize() {
		return monthSize;
	}
	
	public int setReqDay() {
		switch(currentMonth) {
			
			case 2 :
				monthSize=29;
		    	return (int)Math.round(Math.random()*29);
		    	
			case 4 :
				monthSize=30;
				return (int)Math.round(Math.random()*30);
				
			case 6:
				monthSize=30;
				return (int)Math.round(Math.random()*30);
				
			case 9:
				monthSize=30;
				return (int)Math.round(Math.random()*30);
				
			case 11:
				monthSize=30;
				return (int)Math.round(Math.random()*30);
				
			default:
				monthSize=31;
				return (int)Math.round(Math.random()*31);
		}
	}
	
	
	
}
