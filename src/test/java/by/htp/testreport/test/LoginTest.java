package by.htp.testreport.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.testreport.driver.DriverSingletone;
import by.htp.testreport.pageobject.MainPage;

public class LoginTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(LoginTest.class);
	// private static Logger logger = LogManager.getRootLogger();

	
	@Test
	public void testLog4j2() {

		List<String> list = null;
		// Assert.assertNotNull(list);
		logger.info("This is an info message");
		logger.trace("This is a trace message");
		logger.debug("This is a debug message");

		logger.warn("This is a warn message");
		logger.error("This is an error message");
	}

	@Test(enabled = true)
	public void doLogin() {

		MainPage mainPage = navigate(MainPage.URL);
		mainPage.login("tathtp@mail.ru", "Klopik123");
		closeBrowser();
	}
}
