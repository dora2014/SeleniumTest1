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


public class ScopeSample {
	

	public static void regularClick(WebDriver wd, WebElement we) throws InterruptedException {
		
		System.out.println(wd.getTitle());
		String str = wd.getWindowHandle();
		
		//find links
		List<WebElement> footList = we.findElements(By.tagName("a"));
		System.out.println("link size:" +footList.size());
		
		//System.out.println(footList.get(0).getText());
		//Thread.sleep(2000);
		footList.get(0).click();
		 Thread.sleep(1000);
		 wd.navigate().back();
		 Thread.sleep(1000);
		 System.out.println(wd.getTitle());
		
		 WebElement fd = wd.findElement(By.xpath("//*[@id='prefooter']/div/div/div[1]"));
		 
		 List<WebElement> list = fd.findElements(By.tagName("a"));
		 System.out.println(list.size());
		 list.get(1).click();
		// System.out.println(we.findElements(By.tagName("a")).size());
		// System.out.println("link size:" +footList.size());
	

//		 System.out.println(footList.get(2).getText());
		 Thread.sleep(1000);
		 wd.navigate().back();
		 Thread.sleep(1000);
		 
		 WebElement fd2 = wd.findElement(By.xpath("//*[@id='prefooter']/div/div/div[1]"));
		 
		 List<WebElement> list2 = fd2.findElements(By.tagName("a"));
		 System.out.println(list2.size());
		 list2.get(2).click();
		 
		 Thread.sleep(1000);
		 wd.navigate().back();
		 Thread.sleep(1000);

		
		//click on the link
	/*	for (int i=0; i< footList.size(); i++ ) {
			 footList.get(i).click();
			 Thread.sleep(1000);
		//	 wd.close();
			 
		}
*/		
		 wd.close();
	}
	
	
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
		
	//	int size = footerDriver.findElements(By.id("links")).size();
	
		int size = footerDriver.findElements(By.tagName("a")).size();
		System.out.println(size);
		
		//////////////////////////////////////////////////////////
		///// click on each link(open a new tab)
		////////////////////////////////////////////////////////
		Actions a = new Actions(driver);
		List<WebElement> footList = footerDriver.findElements(By.tagName("a"));
		
		for(int i=0; i<4; i++) {
					
			System.out.println(footList.get(i).getText());
		
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(2000);
			
		//	a.moveToElement(footList.get(i)).keyDown(Keys.CONTROL).click().build().perform();
	
		}
	
		///////////////////////////////////////////////////////
		//////// get windows handler IDs
		///////////////////////////////////////////////////////
		Set<String> winIds = driver.getWindowHandles();
		Iterator<String> it = winIds.iterator();
		
		it.next();
		
		while(it.hasNext()) {
			String nextValue= it.next();
			//System.out.println(nextValue);
			driver.switchTo().window(nextValue);
			System.out.println(driver.getTitle());
			
			if(!driver.getTitle().equals(mainPageTitle)) {
				driver.close(); //close each window except main page
			}
				
		}
		
		/////////////////////////////////////////////////////////
		///// must explicitly switch back to parent window
		///////////////////////////////////////////////////////
		driver.switchTo().window(parentWin);
		
		regularClick(driver, footerDriver);

	}

}
