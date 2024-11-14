package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class iFrameHandlingDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        Actions a=new Actions(driver);
        a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
        driver.switchTo().defaultContent(); // this step you need to switch to main window content

    }
}
