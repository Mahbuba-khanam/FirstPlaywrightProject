package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Base;

public class Sky_It_School_Listener extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(">>>>>onTestStart<<<<<");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		String filename = System.getProperty("user.dir") + "\\target\\screenshots2\\" + result.getName()
				+ generateNumber() + ".jpg";
		generateScreenshot(filename);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("''''onTestFailure''''");
		String filename = System.getProperty("user.dir") + "\\target\\screenshots\\" + result.getName()
				+ generateNumber() + ".jpg";
		generateScreenshot(filename);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(".....onTestSkipped......");
		String filename = System.getProperty("user.dir") + "\\target\\screenshots2\\" + result.getName()
				+ generateNumber() + ".jpg";
		generateScreenshot(filename);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(".......onTestFailedButWithinSuccessPercentage........");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("......onTestFailedWithTimeout........");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("......onStart.........");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("....onFinish......");
	}

}
