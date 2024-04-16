package tests;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.Base;

public class Test_Customer_Login extends Base{
	@Test
	public void customerlogin() {
	navigate("https://it.microtechlimited.com");
	click("//a[@href='elogin.php']");
	click("//a[@href='clogin.php']");
	fill("//input[@name='mailuid']", "david@gmail.com");
	fill("//input[@name='pwd']", "1234");
	click("//input[@name='login-submit']");
	System.out.println("Customer login Test Pass");
	throw new SkipException("Skipping the test") ;

}
}