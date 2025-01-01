package org.testingacademy.ex01_SeleniumBasics;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium01 {

    @Description("Open the App.vwo.com and Get the title")
    @Test
    public void test_Selenium01(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://vwo.com/");
        System.out.println(driver.getTitle());
    }
}
