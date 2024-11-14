package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities_BackToForwardActionsOnBrowser {
    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver", "path to driver");
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");//will wait till page is fully loaded and ready, simulate entering manually into address line, is used when page is first loaded
        driver.navigate().to("https://rahulshettyacademy.com");//allows movement within browser hystory and can be sued when go back and forth within same session
        driver.navigate().back();
        driver.navigate().forward();;
    }
}
