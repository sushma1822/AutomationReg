package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Electronics {
   static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\soft\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.linkText("Electronics")).click();
        driver.findElement(By.linkText("Cell phones")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]/div[3]/div[2]/input[1]")).click();
        driver.findElement(By.linkText("HTC One Mini Blue")).click();
        driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-19\"]")).click();
        driver.findElement(By.linkText("Shopping cart")).click();
        String pageText=driver.findElement(By.linkText("HTC One M8 Android L 5.0 Lollipop")).getText();
       System.out.println(pageText);
       pageText=driver.findElement(By.linkText("HTC One Mini Blue")).getText();
        System.out.println(pageText);

    }
}
