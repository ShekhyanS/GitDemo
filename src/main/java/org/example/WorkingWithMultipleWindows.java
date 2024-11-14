package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WorkingWithMultipleWindows {
    public static void main(String[] args) {
       //OPEN ONE MORE TAB CASE
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://rahulshettyacademy.com/angularpractice/");
//        driver.switchTo().newWindow(WindowType.TAB);
//        Set<String> windows =  driver.getWindowHandles();
//        Iterator<String> it = windows.iterator();
//        String parentWindow = it.next();
//        String childWindow = it.next();
//        driver.switchTo().window(childWindow);
//        driver.get("https://rahulshettyacademy.com/");
//        String courceTitle = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
//        driver.switchTo().window(parentWindow);
//        driver.findElement(By.cssSelector("[name='name']")).sendKeys(courceTitle);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> windows =  driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        String courceTitle = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.switchTo().window(parentWindow);
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(courceTitle);
    }
}
