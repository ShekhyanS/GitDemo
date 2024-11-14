package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeXpaths {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        System.out.println(driver.findElement(with(By.tagName("label")).above(driver.findElement(By.id("exampleInputPassword1")))).getText());

        // driver.findElement(with(By.tagName("input")).below(driver.findElement(By.cssSelector("[for='exampleInputPassword1']")))).click();
//        WebElement checkbox = driver.findElement(By.xpath("//label[text() ='Check me out if you Love IceCreams!']"));
//        driver.findElement(with(By.tagName("input")).toLeftOf(checkbox)).click();

        WebElement radiobutton = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radiobutton)).getText());
    }
}
