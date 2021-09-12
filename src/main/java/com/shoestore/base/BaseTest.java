package com.shoestore.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    public static void init(){
        System.setProperty("webdriver.chrome.driver","/Users/vinay/Downloads/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rb-shoe-store.herokuapp.com/");
    }
}
