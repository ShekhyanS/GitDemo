package org.example;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticalTask1_Assertions {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
        driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());

        Assert.assertEquals(driver.findElements(By.cssSelector("input[id*='checkBoxOption']")).size(), 3);
    }
}
