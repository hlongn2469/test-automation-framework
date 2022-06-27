package com.framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class firstUITest {
    @Test
    void checkGithubUsername(){
        // 1) SET UP
        // Locate chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        // Set full screen option
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        // Create Selenium web driver object
        WebDriver driver = new ChromeDriver(options);

        // give selenium some times to locate properties
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Define username allowing the driver to get
        String user = "Bong0202";
        driver.get("https://github.com/" + user);

        // 2) ACT
        String test_user = driver.findElement(By.className("p-nickname")).getText();

        // 3) Assert
        Assertions.assertEquals(user, test_user);
        driver.close();
    }

    @Test
    void checkRepoLink(){
        // 1) SET UP
        // Locate chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        // Set full screen option
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        // Create Selenium web driver object
        WebDriver driver = new ChromeDriver(options);

        // give selenium some times to locate properties
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Define username allowing the driver to get
        String user = "Bong0202";
        driver.get("https://github.com/" + user);

        // 2) ACT
        String repo_link = "CO2-web-app";
        WebElement repo_element = driver.findElement(By.linkText(repo_link));

        repo_element.click();
        String actual_url = driver.getCurrentUrl();

        // 3) ASSERT
        Assertions.assertEquals("https://github.com/" + user + "/" + repo_link, actual_url);
        driver.close();
    }

    @Test
    void repositoryCount(){
        // 1) SET UP
        // Locate chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        // Set full screen option
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        // Create Selenium web driver object
        WebDriver driver = new ChromeDriver(options);

        // give selenium some times to locate properties
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // 2) ACT
        driver.get("https://github.com/Bong0202?tab=repositories");

        // store all repo into a list
        List<WebElement> repos = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        // 3) Assertions
        Assertions.assertEquals(4, repos.size());
        driver.close();
    }

}
