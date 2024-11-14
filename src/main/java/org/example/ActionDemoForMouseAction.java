package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemoForMouseAction {
    public static void main(String[] args) throws InterruptedException {
        // simulate mouse actions
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");


        Actions move = new Actions(driver);
        move.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        move.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
        Thread.sleep(3000);

        //new thing to be removed
        //second thing to remove
// develop branch change


    }
}
