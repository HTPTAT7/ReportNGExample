package by.htp.testreport.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingletone {
    private static WebDriver driver;

    private DriverSingletone() {}

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
        	System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver\\chromedriver.exe");
    		driver = new ChromeDriver();
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeWebBrowser(){
        if (null != driver){
            driver.quit();
        }
        driver = null;
    }
}