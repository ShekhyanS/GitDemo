package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.*;

public class InteractionWithCalendarDemo {
    public static void main(String[] args) {

        String monthNumber = "6";
        String date = "15";
        String year = "2027";
        List<String> values = new ArrayList<>(Arrays.asList(monthNumber, date, year));
        Collections.sort(values);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.className("react-date-picker__inputGroup")).click();
        driver.findElement(By.className("react-calendar__navigation")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber) - 1).click();
        driver.findElement(By.xpath("//button/abbr[text()='" + date + "']")).click();

        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        List<String> actualListValues = new ArrayList<>();

        for (WebElement value : actualList) {

            actualListValues.add(value.getAttribute("value"));
        }
        Collections.sort(actualListValues);
        Assert.assertTrue(actualListValues.equals(values));
        driver.quit();
    }

}
