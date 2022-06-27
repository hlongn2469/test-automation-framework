package com.framework.uiTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepoTabTests extends BaseTest{
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
