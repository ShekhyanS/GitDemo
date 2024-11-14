package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        String name = "rahul";
       // System.setProperty("webdriver.chrome.driver", "path to the driver"); this can be done or use driver manaber bonigarcia
       WebDriver driver = new ChromeDriver();
       // WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String password = getPassword(driver);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);//* means that this is regex, so matching by partial text
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();// when there are more then 1 class then in xpath need to mention all //button[@class='submit signInBtn'], as an alternative you can use contains functionality
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class = 'login-container'] h2")).getText(), "Hello "+name+",");

   //     driver.findElement(By.xpath("//*[text()='Log Out']")).click();


//        driver.quit();
    }

    public  static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String[] pswd = driver.findElement(By.cssSelector("form p")).getText().split("'");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        return pswd[1];
    }
}
