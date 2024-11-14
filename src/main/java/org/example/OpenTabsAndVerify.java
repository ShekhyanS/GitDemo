package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.*;

public class OpenTabsAndVerify {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Assert.assertEquals(driver.findElements(By.tagName("a")).size(), 27);

        Assert.assertEquals(driver.findElements(By.cssSelector(".footer_top_agile_w3ls a")).size(), 20);

        WebElement footer = driver.findElement(By.cssSelector(".footer_top_agile_w3ls"));
        Assert.assertEquals(footer.findElements(By.tagName("a")).size(), 20);

        WebElement column = footer.findElement(By.xpath("//ul[1]"));
        List<String> titles = new ArrayList<>();
        List<String> expectedTitles = new ArrayList<>(Arrays.asList("Practice Page", "Apache JMeter - Apache JMeter™", "Learn REST API Design - REST API Tutorial", "Practice Page", "Appium Mobile Automation Testing from Scratch + Frameworks Tutorial | Udemy", "The World's Most Popular API Testing Tool | SoapUI"));
        Collections.sort(expectedTitles);
        List<WebElement> links = column.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String separatTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            link.sendKeys(separatTab);
        }
        Thread.sleep(3000);

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            titles.add(driver.getTitle().trim());
        }
        Collections.sort(titles);

        Assert.assertTrue(titles.equals(expectedTitles));


    }
}
