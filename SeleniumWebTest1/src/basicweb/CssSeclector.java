package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CssSeclector {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		//create driver object
		WebDriver driver= new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("hotwings");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("jj234");
		driver.findElement(By.cssSelector("input[id='rememberUn']")).click();
		
		driver.findElement(By.cssSelector("input[id='Login']")).click();
		
		String err = driver.findElement(By.cssSelector("div[id='error']")).getText();
		
		System.out.println(err);
		
		//go to spicejet
		driver.navigate().to("http://www.spicejet.com/");
		
		//find element and click on the radio button=multicity		
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_2']")).click();
		
		//if get alert	
		System.out.println(driver.findElement(By.cssSelector("div[class='MultiCityContent']")).getText());
		//System.out.println(driver.findElement(By.cssSelector("div[id='MultiCityModelPopup']")).getText());	
		
		driver.findElement(By.cssSelector("a[id='MultiCityModelAlert']")).click();
		
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_0']")).click();
		
		
		Select s=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")));
		
		s.selectByValue("AMD");
		
	//	driver.findElement(By.xpath("//h2[@id='login']")).click();
		
	//	String txt = driver.findElement(By.xpath("(//a[@href='https://login.salesforce.com/'])[1]")).getAttribute("href");
	//	String txt = driver.findElement(By.xpath("//a[@href='https://login.salesforce.com/']")).getAttribute("class");
		
		
		//System.out.println(txt);
		
	}

}
