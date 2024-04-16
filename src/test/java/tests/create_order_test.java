package tests;

import org.testng.annotations.Test;

import base.Base;

public class create_order_test extends Base {
@Test	
public static void create_Order_test() {
		
		System.out.println("     create_order_test()");

		page.navigate("https://it.microtechlimited.com");
		page.locator("//a[@href='elogin.php']").click();
		page.locator("//input[@name='mailuid']").fill("testpilot@gmail.com");
		page.locator("//input[@name='pwd']").fill("1234");
		page.locator("//input[@name='login-submit']").click();
		page.locator("//a[text()='Product Order']").click();
		page.selectOption("//select[@name='prodId']", "Camera");
		page.locator("//input[@name='ordDate']").fill("11/21/2023");
		page.locator("//button[@type='submit']").click();
		 
		
	}
	

}
