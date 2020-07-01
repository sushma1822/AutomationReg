package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
public class ComputerTwo {
     static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\soft\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Digital Storm VANQUISH 3 Custom Performance PC")).click();
        driver.findElement(By.xpath("//input[@value=\"Email a friend\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"send-email\"]")).click();
        String pageText=driver.findElement(By.xpath("//span[@id=\"FriendEmail-error\"]")).getText();
                System.out.println(pageText);
        pageText=driver.findElement(By.xpath("//span[@id=\"YourEmailAddress-error\"]")).getText();
        System.out.println(pageText);
    }



}