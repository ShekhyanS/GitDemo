package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PracticalTask7_WorkingWithTableRowsAndColumns {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        Assert.assertEquals(driver.findElements(By.xpath("//legend[text()='Web Table Example']/following-sibling::table//tr")).size(), 11);
        Assert.assertEquals(driver.findElements(By.xpath("//legend[text()='Web Table Example']/following-sibling::table//tr[2]/td")).size(), 3);
        System.out.println(driver.findElement(By.xpath("//legend[text()='Web Table Example']/following-sibling::table//tr[3]")).getText());
    }
}
