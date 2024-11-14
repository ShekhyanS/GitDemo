package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;

public class CheckIfLinksWorkAndAreNotBroken_UsingSoftAssertion {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert softAssert = new SoftAssert(); // create soft assertion object
        List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            System.out.println(code);
            //call assert on soft assertion object
            softAssert.assertTrue(code < 400, "Link Text: " + link.getText() + " URL: " + link.getAttribute("href"));
        }
        softAssert.assertAll(); // once the code is fully executed actual errors will be reflected in the log

    }
}
