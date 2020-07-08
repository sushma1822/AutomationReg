package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Computer {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\soft\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.linkText("Desktops")).click();
        String actualText=driver.findElement(By.linkText("Build your own computer")).getText();
        System.out.println(actualText);


    }
}