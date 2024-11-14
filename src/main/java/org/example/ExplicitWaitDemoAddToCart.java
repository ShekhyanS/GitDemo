package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ExplicitWaitDemoAddToCart {
    public static void main(String[] args) {
        //explicite wait
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
        WebDriver driver = new ChromeDriver();
        //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait waitFor= new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //Find add to cart button by xpath
        // driver.findElement(By.xpath("//*[contains(@alt, 'Cucumber')]/ancestor::div[@class='product']//button")).click();
        addToCart(driver, itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
        waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
        WebElement message = driver.findElement(By.cssSelector(".promoInfo"));
        Assert.assertEquals(message.getText(), "Code applied ..!");
        Assert.assertEquals(message.getAttribute("style"),"color: green;");
    }

    public static void addToCart(WebDriver driver, String[] itemsToAdd) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int count = 0;

        for (int i = 0; i < products.size(); i++) {
            String productName = products.get(i).getText().split("-")[0].trim();

            List<String> itemsNeededList = Arrays.asList(itemsToAdd);

            if (itemsNeededList.contains(productName)) {
                count++;

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (count == itemsToAdd.length) {
                    break;
                }
            }

        }
    }
}
