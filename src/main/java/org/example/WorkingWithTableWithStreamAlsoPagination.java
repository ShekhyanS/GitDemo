package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class WorkingWithTableWithStreamAlsoPagination {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//        Below is small case not related to the rest

//        driver.findElement(By.className("sort-icon")).click();
//        List<WebElement> elements = elements = driver.findElements(By.xpath("//tr/td[1]"));
//        List<String> names = elements.stream().map(s -> s.getText()).collect(Collectors.toList());
//        List<String> nameValues = names.stream().sorted().collect(Collectors.toList());

//        Assert.assertTrue(names.equals(nameValues));
        List<String> price;
        List<WebElement> elements;
        do {
            elements = driver.findElements(By.xpath("//tr/td[1]"));
            price = elements.stream().filter(s -> s.getText().equals("Guava"))
                    .map(s -> getPrice(s))
                    .collect(Collectors.toList());

            price.forEach(s -> System.out.println(s));

            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Pagination']")).click();
            }
        } while (price.size() < 1);
    }


    private static String getPrice(WebElement el) {
        return el.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

}
