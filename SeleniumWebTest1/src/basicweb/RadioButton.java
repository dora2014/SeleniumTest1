package basicweb;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		//create driver object
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //implicit time wait
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		
		////////////////////////////////////////////////////////////////////
		// Radio Button - HTML
		///////////////////////////////////////////////////////////////////
		
		int size = driver.findElements(By.cssSelector("input[name='group1']")).size();

		System.out.println(size);
		
		driver.findElement(By.cssSelector("input[value='Water']")).click();
		
		for(int i=0; i<size; i++) {
			
			System.out.println("inside for loop");
			if((driver.findElements(By.cssSelector("input[name='group1']")).get(i).getAttribute("value")).equals("Cheese")) {
				System.out.println(i);
				
			}
			
			driver.findElements(By.cssSelector("input[name='group1']")).get(i).click();
			
			
		}
		
		driver.findElement(By.cssSelector("input[value='Water']")).click();	
		
		////////////////////////////////////////////////////////////////////
		// Alert - JavaScript
		///////////////////////////////////////////////////////////////////
		
		driver.navigate().to("http://www.echoecho.com/javascript4.htm");
		
		//alert box - ok
		driver.findElement(By.cssSelector("input[value='alert box']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		//confrim box-cancel
		driver.findElement(By.cssSelector("input[value='confirm box']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		//prompt box -enter text
		driver.findElement(By.cssSelector("input[value='prompt box']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("username");
		//driver.switchTo().alert().sendKeys("username");
		Thread.sleep(5000);
		alert.accept();
		//System.out.println(alert.getText());  //error
		
		
	}

}
