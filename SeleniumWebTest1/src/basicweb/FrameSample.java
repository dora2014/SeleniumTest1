package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameSample {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		//////////////////////////////////////////////////////////////
		//// frame, drag and drop
		/////////////////////////////////////////////////////////////
		//Actions a = new Actions(driver);
		
		////////////////////////////////////////////////////////////////////
		//////// print draggable size(in the frame):
		///////  0 - nonexsit
		//////   0 > exist
		////// check to see if object present in the scope - size()
		//////////////////////////////////////////////////////////////////////
		System.out.println("Draggable size:" +driver.findElements(By.id("draggable")).size());
				
		driver.findElement(By.tagName("iframe")).click();
		////////////////////////////////////////////////////
		//identify number of frames in the page
		////////////////////////////////////////////
		int size = driver.findElements(By.tagName("iframe")).size();

		System.out.println("Size: " + size);
		
		////////////////////////////////////////////////////
		//Find frame element in the page
		////////////////////////////////////////////
		WebElement element = driver.findElement(By.cssSelector("iframe.demo-frame"));
		
////////////////////////////////////////////////////
//switch to the frame by element, ID, index
////////////////////////////////////////////
		WebDriver frameDriver=null;
		//WebDriver frameDriver = driver.switchTo().frame(element); //by webElement
		for(int i=0; i<size; i++) {
			frameDriver = driver.switchTo().frame(i); //by index
		}
				
		//////////////////////////////////////////////////////////////
		/////pass the frame driver to action object class
		/////  mouse related acitons
		///////////////////////////////////////////////////////////
		Actions a = new Actions(frameDriver);
		/////////////////////////////////////////////////////////////
		/// identify source, desti for drag and drop
		WebElement source = frameDriver.findElement(By.id("draggable"));
		WebElement target = frameDriver.findElement(By.id("droppable"));		
	
		a.dragAndDrop(source, target).build().perform();
		
		/////////////////////////////////////////////////////////////
		//////////  switch back to the normal window page
		///////////////////////////////////////////////////////////
		String title = driver.switchTo().defaultContent().getTitle();
		System.out.println(title);
		
		driver.close();
		
	}

}
