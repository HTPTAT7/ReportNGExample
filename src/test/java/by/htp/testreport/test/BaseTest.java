package by.htp.testreport.test;


import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import by.htp.testreport.pageobject.MainPage;

public class BaseTest {
	
	protected WebDriver driver;

	@Test(enabled=false)
	protected void skipTest() {
		throw new SkipException("!!!!!Skipped");
	}

	protected MainPage navigate(String url) {
	
		driver.get(url);
		return new MainPage(driver);
	}

	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void closeBrowser(){
		if(driver!=null){
			driver.quit();
		}
	}
}
