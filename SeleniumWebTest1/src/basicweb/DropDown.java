package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		//create driver object
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit time wait
		driver.get("http://www.spicejet.com/");
		
		////////////////////////////////////////////////////////////////////
		// Drop Down Button - Static
		///////////////////////////////////////////////////////////////////
		int size =driver.findElements(By.cssSelector("select[id='ctl00_mainContent_DropDownListCurrency']")).size();
		System.out.println(size);
		
		Select s = new Select(driver.findElement(By.cssSelector("select[id='ctl00_mainContent_DropDownListCurrency']")));
		s.selectByValue("USD");
		System.out.println(s.getOptions().size());
		System.out.println(s.getOptions().get(0).getText());
		System.out.println(s.getOptions().get(1).getText());
		System.out.println(s.getOptions().get(2).getText());
		System.out.println(s.getOptions().get(3).getText());
		
		s.selectByValue("AED");
		
		driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();
		//Thread.sleep(5000);  //avoid using thread sleep(java code)
		
		////////////////////////////////////////////////////////////
		//////////////selenium explict wait
		////////////////////////////////////////////////////////////
		WebDriverWait d=new WebDriverWait(driver,10); 
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='hrefIncAdt']")));	
		
		driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		
		System.out.println("starting.....");
		System.out.println(driver.findElement(By.xpath("//span[@id='hrefDecAdt']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("#hrefIncChd")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("#hrefIncInf")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("#btnclosepaxoption")).isDisplayed());
		
		System.out.println(driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).isEnabled());
		
		driver.findElement(By.cssSelector("#hrefIncChd")).click();
		driver.findElement(By.cssSelector("#hrefIncChd")).click();  //click twice
		driver.findElement(By.cssSelector("#hrefIncChd")).click();
		driver.findElement(By.cssSelector("#hrefDecChd")).click();
		driver.findElement(By.cssSelector("#hrefIncInf")).click();
		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
	
		driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();
		System.out.print(driver.findElement(By.xpath("//span[@id='hrefDecAdt']")).isDisplayed());
		System.out.print(driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).isDisplayed());
		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		
		/////////////////////////////////////////////////////////////////
		/////////use explicit wait again
		//////////////////////////////////////////////////////////////////
		//use parent/child traverse method since target tag is dynamically changing
		//////////////////////////////////////////////////////////////////
		/// wait until target is ready to click, then click
		//////////////////////////////////////////////////////////////////////
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[1]/a")));
				
		int length = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]")).size();
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[1]/a")).click();
		
		System.out.println("size of:" + length);
		
		//*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[3]/td[1]/a
		//System.out.println(driver.getTitle());
		//System.out.println(driver.findElement(By.cssSelector("#hrefIncAdt")).getText());
		
	//	driver.findElement(By.cssSelector("#hrefIncAdt")).click();
	//	driver.findElement(By.cssSelector("#hrefIncChd")).click();
	//	driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		
		//Select s2 = new Select(driver.findElement(By.cssSelector("div[id='divpaxinfo']")));
		//s2.selectByValue(arg0);
		
		driver.close();
		

	}

}
