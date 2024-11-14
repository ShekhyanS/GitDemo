package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticalTask2_Dropdowns {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("Sona");
        driver.findElement(By.name("email")).sendKeys("sona@email.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password");
        driver.findElement(By.id("exampleCheck1")).click();
        Select genderDropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        genderDropdown.selectByVisibleText("Female");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("06/17/1987");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        Assert.assertTrue(driver.findElement(By.className("alert")).getText().contains("Success! The Form has been submitted successfully!.") );
    }
}
