package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PracticalTask5_WorkingWighIFrames {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("[href='/nested_frames']")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame(driver.findElement(By.name("frame-middle")));

        Assert.assertEquals(driver.findElement(By.id("content")).getText(),"MIDDLE");
    }
}
