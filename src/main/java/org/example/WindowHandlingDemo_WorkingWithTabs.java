package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandlingDemo_WorkingWithTabs {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); //[parentId, childId] we put into set object ids of windows
        Iterator<String> it = windows.iterator();
        String parenId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        String email = driver.findElement(By.cssSelector(".red a")).getText();
        driver.switchTo().window(parenId);
        driver.findElement(By.id("username")).sendKeys(email);

    }
}
