package basicweb;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MultiWindows {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		//create driver object for chrome
		WebDriver driver= new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.qaclickacademy.com/");
		
		String mainPageTitle = driver.getTitle();
		String parentWin = driver.getWindowHandle();
		
	//	WebElement footerDriver = driver.findElement(By.xpath("//*[@id='prefooter']/div/div"));
		WebElement footerDriver = driver.findElement(By.xpath("//*[@id='prefooter']/div/div/div[1]"));
	
		int size = footerDriver.findElements(By.tagName("a")).size();
		System.out.println(size);
		
		//////////////////////////////////////////////////////////
		///// click on each link(open a new tab)
		////////////////////////////////////////////////////////
		Actions a = new Actions(driver);
		List<WebElement> footList = footerDriver.findElements(By.tagName("a"));
		
		for(int i=0; i<4; i++) {
					
		
		//	System.out.println(footList.get(i).getText()); // link text
			a.moveToElement(footList.get(i)).keyDown(Keys.CONTROL).click().build().perform();
			
			//String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			//footerDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			
			Thread.sleep(2000);
			System.out.println(driver.getWindowHandle());
			System.out.println(driver.getTitle());
		
	
		}
	
	}

}
