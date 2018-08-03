package testNG;

import org.testng.annotations.Test;

public class Loans {
	
	@Test
	public void WebLoan() {
		
		System.out.println("Web loan");
	}

	@Test
	public void MobileLoan() {
		System.out.println("mobile loan");
	}
	
	@Test
	public void APILoan() {
		System.out.println("API loan");
	}
	
	
}
