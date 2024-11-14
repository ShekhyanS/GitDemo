package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("[id = 'start'] button")).click();
        Wait<WebDriver> fw = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        WebElement text = fw.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                if(driver.findElement(By.cssSelector("[id = 'loading'] img")).isDisplayed()) {
                   return driver.findElement(By.cssSelector("[id = 'loading'] img"));
                } else return null;
            }
        });
       //Verifying that loader is reflected
       Assert.assertTrue(driver.findElement(By.cssSelector("[id = 'loading'] img")).isDisplayed());

    }
}
