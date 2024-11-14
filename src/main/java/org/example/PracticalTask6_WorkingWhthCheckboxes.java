package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticalTask6_WorkingWhthCheckboxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement selectedCheckbox = driver.findElement(By.id("checkBoxOption2"));
        selectedCheckbox.click();
        String checkboxLabel = driver.findElement(By.cssSelector("label[for='benz']")).getText().trim();

        Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropdown.selectByVisibleText(checkboxLabel);

        driver.findElement(By.id("name")).sendKeys(checkboxLabel);

        driver.findElement(By.id("alertbtn")).click();

        Assert.assertTrue(driver.switchTo().alert().getText().contains(checkboxLabel));



    }
}
