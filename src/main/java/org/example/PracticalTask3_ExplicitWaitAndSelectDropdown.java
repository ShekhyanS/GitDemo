package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PracticalTask3_ExplicitWaitAndSelectDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait waitFor = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.cssSelector("input[value='user']")).click();

        waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();


        Select dropdown = new Select(driver.findElement(By.cssSelector("[data-style='btn-info']")));
        dropdown.selectByVisibleText("Consultant");

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

        waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn-primary")));

        List<WebElement> buttons = driver.findElements(By.cssSelector("button.btn-info"));
        for(WebElement button : buttons){
            button.click();
        }

        driver.findElement(By.cssSelector("a.btn-primary")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-success")).isDisplayed());

    }
}
