package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFiilterUsedInSearch {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> products = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> searchedProducts = products.stream().filter(s->s.getText().contains("Rice"))
                .collect(Collectors.toList());

        Assert.assertEquals(searchedProducts.size(), products.size()  );

    }
}
