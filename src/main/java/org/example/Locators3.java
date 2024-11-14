package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Locators3 {
    public static void main(String[] args) {
        String name = "rahul";
        // System.setProperty("webdriver.chrome.driver", "path to the driver"); this can be done or use driver manaber bonigarcia
         WebDriver driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/child::button[2]")).getText());

}
}
