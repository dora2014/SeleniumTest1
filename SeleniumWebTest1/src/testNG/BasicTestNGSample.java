package testNG;

import org.testng.annotations.Test;

public class BasicTestNGSample {
	
	@Test //testNG annotation, indicate use testNG lib 
	public void Demo() {
		
		System.out.println("Hello Welcome to TestNG");
	}
	
	@Test //testNG annotation, indicate use testNG lib 
	public void Customers() {
		
		System.out.println("Hello Customer");
	}
	
	@Test //testNG annotation, indicate use testNG lib 
	public void Partners() {
		
		System.out.println("Hello Partners");
	}

}
