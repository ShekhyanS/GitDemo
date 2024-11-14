package org.example;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OvercomeSSLCheck_OptionsUsageForFileDownload_ForProxyEtc {
    public static void main(String[] args) {

        //Below code is for accepting expired or wrong ssl on browser
        ChromeOptions options = new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();
        // EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

        //Proxy usage code
        ChromeOptions options1 = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options1.setCapability("proxy", proxy);
        WebDriver driver1= new ChromeDriver(options1);
        driver1.get("");

        //to see info on how to user options https://developer.chrome.com/docs/chromedriver/capabilities
        //here you can find the option how to block different popups
        //how to download a file

    }
}
