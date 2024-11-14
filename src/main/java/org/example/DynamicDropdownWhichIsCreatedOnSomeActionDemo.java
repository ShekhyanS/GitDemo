package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDropdownWhichIsCreatedOnSomeActionDemo {
    public static void main(String[] args) throws InterruptedException {
        //dynamic dropdown us dropdown, for which options are generated only after it is expanded. In collapsed state in inspect element you will not see them
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction"));
        Thread.sleep(3000L);
        driver.findElements(By.xpath("//a[@value='MAA']")).get(1).click();// in case you don't want to use index then //*[@id ='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='B3000L);
        driver.findElement(By.cssSelector("a.ui-state-highlight")).click();

        Assert.assertFalse( driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        Assert.assertTrue( driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));


    }
}
