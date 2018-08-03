package basicweb;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowSwitch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		//create driver object for chrome
		WebDriver driver= new ChromeDriver();	
		driver.get("https://www.google.com/");
			
		////////////////////////////////////////////////////////////
		//////////////selenium explict wait
		////////////////////////////////////////////////////////////
		WebDriverWait d=new WebDriverWait(driver,10); 
		WebElement about = driver.findElement(By.xpath("//*[@id='hptl']/a[1]"));
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hptl']/a[1]")));	
		System.out.println("window id: " +driver.getWindowHandle());
		
		//*[@id="hptl"]/a[1]
		
		///////////////////////////////////////////////////////////
		//// setup Action class object
		///////////////////////////////////////////////////////	
		Actions a = new Actions(driver);
		a.moveToElement(about).keyDown(Keys.CONTROL).click().build().perform();
	//	a.keyDown(Keys.CONTROL).click().build().perform();
		
		System.out.println("window id: " +driver.getWindowHandle());
		
		Set<String> handIDs = driver.getWindowHandles();
		
		System.out.println("*****************");
		for(String str: handIDs) {
			
			System.out.println(str);
			String title = driver.switchTo().window(str).getTitle();			
			System.out.println(title);
			driver.close();
			
		//	WebDriver win2 = driver.switchTo().window(str);
			
		}
		
	
	}

}
