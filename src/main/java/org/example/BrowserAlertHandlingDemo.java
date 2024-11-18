package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BrowserAlertHandlingDemo {
    public static void main(String[] args) {
        String text = "Sona";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        text = "Sona";
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "Hello Sona, share this practice page and share your knowledge");
        //alert with ok button only
        driver.switchTo().alert().accept();
        //alert with ok and cancel button
        driver.findElement(By.id("confirmbtn")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "Hello , Are you sure you want to confirm?");
        driver.switchTo().alert().dismiss();

    }
}
