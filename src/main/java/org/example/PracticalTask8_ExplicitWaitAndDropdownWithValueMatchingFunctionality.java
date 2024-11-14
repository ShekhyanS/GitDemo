package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PracticalTask8_ExplicitWaitAndDropdownWithValueMatchingFunctionality {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("ind");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("ui-id-1")), "style", "display: block;"));
        List<WebElement> searchResult =  driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));

        for(WebElement item : searchResult){
            if(item.getText().equals("India")){
                item.click();
                break;
            }
        }

        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));



    }
}
