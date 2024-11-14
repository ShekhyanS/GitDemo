package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class PracticalTask4_WorkingWithTabs {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("[href='/windows']")).click();
        driver.findElement(By.cssSelector("[href = '/windows/new']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        Assert.assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "New Window");
        driver.switchTo().window(parentId);
        Assert.assertEquals(driver.findElement(By.cssSelector(".example h3")).getText(), "Opening a new window");

    }
}
