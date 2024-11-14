package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GetDriverTitleAndCurrentUrl {
    public static void main(String[] args) {
       // WebDriver driver = new ChromeDriver();
       // WebDriver driver = new FirefoxDriver();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.quit();
    }
}
