package com.framework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class UITestRefactored {

    public static final String BASE_URL = "https://github.com/";
    static WebDriver driver;

    @BeforeAll
    static void setUp(){
        // 1) SET UP
        // Locate chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        // Set full screen option
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        // Create Selenium web driver object
        driver = new ChromeDriver(options);

        // give selenium some times to locate properties
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterAll
    static void cleanUp(){
        driver.close();
    }

    @Test
    void checkGithubUsername(){
        // Define username allowing the driver to get
        String user = "Bong0202";
        driver.get(BASE_URL + user);

        // 2) ACT
        String test_user = driver.findElement(By.className("p-nickname")).getText();

        // 3) Assert
        assertEquals(user, test_user);
    }

    @Test
    void checkRepoLink(){
        // Define username allowing the driver to get
        String user = "Bong0202";
        driver.get(BASE_URL + user);

        // 2) ACT
        String repo_link = "CO2-web-app";
        WebElement repo_element = driver.findElement(By.linkText(repo_link));

        repo_element.click();
        String actual_url = driver.getCurrentUrl();

        // 3) ASSERT
        assertEquals(BASE_URL + user + "/" + repo_link, actual_url);

    }

    @Test
    void repositoryCount(){
        // 2) ACT
        driver.get("https://github.com/Bong0202?tab=repositories");

        // store all repo into a list
        List<WebElement> repos = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        // 3) Assertions
        assertEquals(4, repos.size());
    }
}
