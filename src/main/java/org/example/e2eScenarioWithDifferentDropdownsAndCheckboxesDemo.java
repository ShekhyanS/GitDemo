package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2eScenarioWithDifferentDropdownsAndCheckboxesDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction"));
        Thread.sleep(3000L);
        driver.findElements(By.xpath("//a[@value='MAA']")).get(1).click();// in case

        driver.findElement(By.cssSelector("a.ui-state-highlight")).click();

        Assert.assertFalse( driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        Assert.assertTrue( driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));


        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);
        int count = 1;
        while (count<5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            count = Integer.parseInt(driver.findElement(By.id("spanAudlt")).getText());
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("USD");

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }
}