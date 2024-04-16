package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

public class Test_Employee_Login extends Base {
	@Test
	public void emplogin() {
		System.out.println("Login as employee");
	navigate("https://it.microtechlimited.com");
	click("//a[@href='elogin.php']");
	//click("//a[@href='clogin.php']");
	fill("//input[@name='mailuid']", "testpilot@gmail.com");
	fill("//input[@name='pwd']", "1234");
	click("//input[@name='login-submit']");
	
	// Assertion EMP Id
	String employeeId = innerText("//h2[1]");
	Assert.assertEquals(employeeId, "Employee Id: 1002");
	

}
}