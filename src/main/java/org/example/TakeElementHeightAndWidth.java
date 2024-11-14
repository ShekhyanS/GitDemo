package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class TakeElementHeightAndWidth {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> windows =  driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        String courceTitle = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.switchTo().window(parentWindow);
        WebElement field = driver.findElement(By.cssSelector("[name='name']"));
        field.sendKeys(courceTitle);
        File file = field.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C://Users//Sona_Shekhyan//Pictures//Screenshots//screenshotSonaTest.png")); // in case you mention just the name of file then you will see in the project at the bottom

        System.out.println("height = " + field.getRect().getDimension().getHeight());
        System.out.println("width = " + field.getRect().getDimension().getWidth());

    }
}
