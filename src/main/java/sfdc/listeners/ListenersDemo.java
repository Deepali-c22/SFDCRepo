package sfdc.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import sfdc.tests.BaseTest;
import sfdc.utils.Utilities;

public class ListenersDemo extends BaseTest implements ITestListener  {
	public WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		System.out.print("Test has started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		/*
		 * try {
		 * 
		 * //BaseTest.CaptureScreenshot(driver);
		 * BaseTest.test.addScreenCaptureFromPath(Utilities.CaptureScreenshot(this.
		 * driver)); } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
}

	@Override
	public void onTestFailure(ITestResult result) {
		/*
		 * try {
		 * 
		 * //BaseTest.CaptureScreenshot(driver);
		 * BaseTest.test.addScreenCaptureFromPath(Utilities.CaptureScreenshot(driver));
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}

	
}
