package com.testframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver getChromeDriver(){
        // 1) SET UP
        // Locate chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        // Set full screen option
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        // Create Selenium web driver object
        WebDriver driver = new ChromeDriver(options);

        // give selenium some times to locate properties
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
}
