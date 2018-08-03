package basicweb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;


public class SuggestDropDown {

	
	public static WebDriver initDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		return driver;
		
	}
	
	public static void closeDriver(WebDriver theDriver) {
		theDriver.close();
		
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver theDriver = initDriver();
		
		theDriver.get("http://www.ksrtc.in/oprs-web/");
		
		//////////////////////////////////////////////////////
		/////// use keys stroke + javascript executor
		////////////////////////////////////////////////////
		JavascriptExecutor js =(JavascriptExecutor) theDriver;
		theDriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys("BEN");
		theDriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.UP);
		theDriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.UP);
		
		Thread.sleep(1000);
		theDriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.DOWN);
		
		Thread.sleep(1000);

		String obj = js.executeScript("return document.getElementById(\"fromPlaceName\").value;").toString();	
		
		while(!obj.contains("AIPORT")) {
			
			theDriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.DOWN);
			Thread.sleep(1000);
			obj = js.executeScript("return document.getElementById(\"fromPlaceName\").value;").toString();
		}
		
		theDriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.ENTER);
		theDriver.manage().window().maximize();
		Thread.sleep(1000);
		
		File src = ((TakesScreenshot) theDriver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Waising\\screenshot.png");
		
		Files.copy(src.toPath(), dest.toPath());

		/*
		
		theDriver.navigate().to("https://www.google.com/");
	    theDriver.manage().window().maximize();
		
		System.out.println(theDriver.getTitle());
		
		theDriver.findElement(By.id("lst-ib")).sendKeys("Miami");
		Thread.sleep(1000);
		theDriver.findElement(By.cssSelector("#lst-ib")).sendKeys(Keys.DOWN);
		
		obj = js.executeScript("return document.getElementById(\"lst-ib\").value;").toString();
	//	System.out.println(obj);
		
		while(!obj.contains("dolphins")) {
			
			theDriver.findElement(By.cssSelector("#lst-ib")).sendKeys(Keys.DOWN);
			Thread.sleep(1000);
			obj = js.executeScript("return document.getElementById(\"lst-ib\").value;").toString();
		}
		
		theDriver.findElement(By.cssSelector("#lst-ib")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		closeDriver(theDriver);
		
		*/
		///////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////
		/*
		
		System.out.println(obj);
		
		theDriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		
		obj = js.executeScript("return document.getElementById(\"fromPlaceName\").value;").toString();	
		System.out.println(obj);
		*/
		//int size =theDriver.findElements(By.xpath("//*[@id='ui-id-1']/li")).size();
		//System.out.println(size);
		
		//List<WebElement> list = theDriver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
		
		//System.out.println(list.get(0).getText());		
	/*
			for(WebElement place: list) {
				
			   if(place.getText().contains("AIPORT")) {
				   place.click();
				   break;
				   
			   }
			   else {
				   
				   theDriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.DOWN);  
			   }
			   
			   Thread.sleep(1000);
		
			}
		
		*/
	//	String obj = js.executeScript("return document.getElementById(\"fromPlaceName\").value;").toString();
	//	System.out.println(obj);
		
		
	/*	
		while(true) {
			//theDriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER));
			theDriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.DOWN);
			
			
		}
		*/		
	
	
		
		/////////////////////////////////////////////////////////////
		//////////// use javascript executor
		////////////////////////////////////////////////////////////
		
		
		//String obj = js.executeScript("return document.getElementById(\"fromPlaceName\").value;").toString();
		
		
		
//		theDriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.TAB);
		
	/*	
		int size = theDriver.findElements(By.xpath("//*[@id='ui-id-1']/li")).size();
		
		System.out.println(size);
		
		List<WebElement> fromPlaces = theDriver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
		
		for(WebElement place: fromPlaces) {
			
			System.out.println(place.getText());
		}
	*/	
		
		
		
		
		
		
	}

}
