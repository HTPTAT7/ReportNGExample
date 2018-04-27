package by.htp.testreport.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import by.htp.testreport.driver.DriverSingletone;

public class ScreenshotOnFailListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println(" a ");
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println(" b ");
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println(" c ");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println(" d ");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(" e ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(" f ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(" g ");
		takeScreenshot();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(" h ");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(" i ");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(" j ");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" k ");
	}

	private void takeScreenshot(){
		
		System.out.println("!!!! Scrreeenshots !!!!!!!!!!!!!!!!");
        File screenCapture = ((TakesScreenshot)DriverSingletone
                .getWebDriverInstance())
                .getScreenshotAs(OutputType.FILE);
        try {
        	
        	File f = new File(".//target/screenshots/screenshot.png" );
            FileUtils.copyFile(screenCapture, f);
            Reporter.log("<img src=" + f.getAbsolutePath()+ "/>");
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }
}
