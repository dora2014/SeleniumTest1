package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) {
		// selenium code to run tests
		
		//webdriver.chrome.driver: C:\selenium\chromedriver_win32\chromedriver.exe
		//webdriver.gecko.driver
		//webdriver.ie.driver
		
		//get .exe file
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		//create driver object
		WebDriver drObj= new ChromeDriver();
		drObj.get("http://www.google.com");
		
		System.out.println(drObj.getTitle());
		System.out.println(drObj.getCurrentUrl());
		
		drObj.navigate().to("https://www.facebook.com/");
		drObj.findElement(By.id("email")).sendKeys("my first selenium code");
		//drObj.findElement(By.id("email")).sendKeys(Keys.TAB); //tab to the next text field
		drObj.findElement(By.name("pass")).sendKeys("ihateyou");
		drObj.findElement(By.linkText("Forgot account?")).click();
		
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		drObj.navigate().back();
		drObj.navigate().back();
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		drObj.close(); //close current browser window
		
	}

}
