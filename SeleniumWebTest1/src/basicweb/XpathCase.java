package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathCase {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		//create driver object
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.google.com");
		
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("hamburger");
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String txt = driver.findElement(By.xpath("//*[@id='rso']/div[2]/div/div/div")).getText();
		System.out.println("result: " + txt);

		String strArray[] = txt.split("\n");
		
		System.out.println("****************");
		System.out.println(strArray[0]);
		System.out.println(strArray[1]);
		System.out.println(strArray[2]);
		
		String url = strArray[1];
		driver.navigate().to(url);
		
	//	String txt = driver.findElement(By.xpath("//*[@id='rso']/div[4]")).getText();
	//	System.out.println("result: " + txt);
		
	/*
		String txt = driver.findElement(By.xpath("//*[@id='rso']/div[2]/div/div/div/h3[@class='r']")).getText();
		System.out.println("result: " + txt);
	*/	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.navigate().back();
		
		
		driver.close();
		
		
		

	}

}
