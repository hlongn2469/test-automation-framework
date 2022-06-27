package com.framework.uiTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverviewTabTests extends BaseTest{
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
}
