package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdateDropdown_OneDropdownValuesDependOnSecondDropdownSelection {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //click checkbox
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //count checkboxes
        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
        //click multiple times the element
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);
        int count = 1;
        while (count<5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            count = Integer.parseInt(driver.findElement(By.id("spanAudlt")).getText());
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

    }
}
