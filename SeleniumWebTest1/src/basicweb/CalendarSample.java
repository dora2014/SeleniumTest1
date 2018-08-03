package basicweb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarSample {

	
	public static WebDriver initDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		return driver;
		
	}
	
	public static void closeDriver(WebDriver theDriver) {
		theDriver.close();
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		

		WebDriver theDriver = initDriver();
		
		theDriver.get("http://www.spicejet.com/");
		
		//click on the calender box
		theDriver.findElement(By.xpath("//*[@class='picker-first2']/input")).click();
		
		// find Month Day
	//	String leftBoxRows = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr";
	//	String leftBoxDaysAval = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td[contains(@data-handler,'Day')]";
		
		String month = "//*[@id='ui-datepicker-div']/div/div/div/span[contains(@class, 'month')]"; //both left and right side
		//String month = "//*[@id='ui-datepicker-div']/div[1]/div/div"; //only the left side
		
		
		//WebElement leftCalendarBox = theDriver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table"));
		//int numRows = leftCalendarBox.findElements(By.xpath("//tbody/tr")).size();
		int numMonths = theDriver.findElements(By.xpath(month)).size();
		System.out.println(numMonths);
		List<WebElement> months = theDriver.findElements(By.xpath(month));
		
		/////////////////////////////////////////////////////////////
		/////// Find Month
		////////////////////////////////////////////////////////////
		boolean foundMonth=false;
		int monthIndex=0;
		while(true) {
			monthIndex=0;
			for(WebElement theMon: months) {
			//	System.out.println(theMon.getText());
				
				if(theMon.getText().equals("December")) {
					foundMonth=true;
					break;	
				}
				monthIndex++;
			}//end for
			
			if(foundMonth)
				break;
			Thread.sleep(1000);
			String nextButton = "(//*[@id='ui-datepicker-div'])/div[2]/div/a";
			theDriver.findElement(By.xpath(nextButton)).click();
			months = theDriver.findElements(By.xpath(month));
					
		} //end while true
	
		
		//////////////////////////////////////////////////////////////
		////// find day
		/////////////////////////////////////////////////////////////
		
		String index = String.valueOf(monthIndex+1);
		
		String avalableDays = "//*[@id='ui-datepicker-div']/div[" + index +"]" +"/table/tbody/tr/td[contains(@data-handler,'Day')]";
		
		List<WebElement> days = theDriver.findElements(By.xpath(avalableDays));
		
		//target date=21
		for(WebElement theDay: days) {
			
			System.out.print(theDay.getText() +" ");
			
			if (theDay.getText().equals("18")){
				
				//click on it
				theDay.click();
				break;
				
			}
		}
		
		closeDriver(theDriver);
	
	}

}
