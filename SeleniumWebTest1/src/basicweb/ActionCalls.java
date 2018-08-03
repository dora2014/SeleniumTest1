package basicweb;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionCalls {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		//create driver object for chrome
		WebDriver driver= new ChromeDriver();
		
		///////////////////////////////////////////
		/// implicit wait 
		///////////////////////////////////////////
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit time wait
		driver.get("https://www.amazon.com/");
		
		//System.out.println("window id: " +driver.getWindowHandle());
		///////////////////////////////////////////////////////////
		//// setup Action class object
		///////////////////////////////////////////////////////
		
		Actions a = new Actions(driver);
		//////////////////////////////////////////////////
		// move(hover over) to the target element on webpage
		/////////////////////////////////////////////
		a.moveToElement(driver.findElement(By.xpath("//*[@id='nav-tools']/a[2]/span[2]"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']/a/span"))).click().build().perform();
		
		//////////////////////////////////////////////////////////////
		/// enter capital letter in the textfield
		////////////////////////////////////////////////////////////
		//System.out.println("window id: " +driver.getWindowHandle());
		
		WebElement sign = driver.findElement(By.xpath("//*[@id='ap_email']"));
		a.moveToElement(sign).keyDown(Keys.SHIFT).sendKeys("username").build().perform();
		WebElement go = driver.findElement(By.xpath("//input[@id='continue']"));
		a.moveToElement(go).click().build().perform();
		
		Set<String> handIDs = driver.getWindowHandles();
		
		System.out.println("*****************");
		for(String str: handIDs) {
			
			System.out.println(str);
			String title = driver.switchTo().window(str).getTitle();			
			System.out.println(title);
			//driver.close();
			
		//	WebDriver win2 = driver.switchTo().window(str);
			
		}
		
		
	//	System.out.println("window id: " +driver.getWindowHandle());
	//	String txt = "There was a problem";
	//	WebDriverWait d = new WebDriverWait(driver, 20);
	//	d.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id='auth-error-message-box']/div/h4")), txt));
	//	driver.findElement(By.xpath("//*[@id='auth-error-message-box']/div/h4")).getText();
		//a.moveToElement(driver.findElement(By.xpath("//*[@id='auth-error-message-box']/div/h4"))).click().build().perform();
		//a.moveToElement(driver.findElement(By.xpath("//*[@id='auth-error-message-box']/div"))).g
	//	WebDriverWait d = new WebDriverWait(driver, 10);
		//WebElement errTxt=
	//	System.out.println(driver.findElement(By.xpath("//*[@id='auth-error-message-box']/div/h4")).isDisplayed());
	//	d.until(ExpectedConditions.presenceOfElementLocated(driver.findElement(By.xpath("//*[@id='auth-error-message-box']/div/h4"))));
		String err = driver.findElement(By.xpath("//*[@id='auth-error-message-box']/div/h4")).getText();
		System.out.println(err);
		
		//driver.findElement(By.id("continue")).sendKeys(Keys.TAB);
		
	//	driver.close();
		
	}

}
