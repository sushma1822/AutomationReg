package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class Practice {
    static WebDriver driver;
    //reusable method to wait until element is clickable
    public static void waitUntilElementIsClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //reusable method to clickOnElement
     public static void clickOnElement(By by,int time){
         driver.findElement(by).click();
     }
     //method for type text
     public static void typeText(By by,String text, int time){
         driver.findElement(by).sendKeys(text);
     }
     // reusable method to get text from elements
     public static String getTextFromElement(By by){
         return driver.findElement(by).getText();
     }
     // method for times stamp
     public static long timestamp(){
         return(System.currentTimeMillis());
     }
     //method for select from drop down  by visible text
     public static void selectFromDropDownByVisibleText(By by, String text){
      Select select = new Select(driver.findElement(by));
      select.selectByVisibleText(text);
      }
      // method for select drop down by value
      public static void selectFromDropDownByValue(By by,String value){
         Select select = new Select(driver.findElement(by));
         select.deselectByValue(value);
      }
      // method for drop down by index
      public static void selectFromDropDownByIndex(By by,int n){
         Select select = new Select(driver.findElement(by));
         select.selectByIndex(n);
      }
    @BeforeMethod
   public static void setBrowser() {
        //setting up chrome driver path
        System.setProperty("webdriver.chrome.driver", "C:\\soft\\chromedriver.exe");
        //creating object to open chrome driver
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);// allows to avoid chrome pop ups while running programme
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.nopcommerce.com/");
    }
   @AfterMethod
    public static void closeBrowser(){
            driver.close();
        }
       @Test(priority = 1)
       public static void register(){        //this method to be fill the registration form
        clickOnElement(By.xpath("//a[@class=\"ico-register\"]"),30);
        clickOnElement(By.xpath("//span[@class=\"female\"]"),40);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           waitUntilElementIsClickable(By.xpath("//input[@id=\"FirstName\"]"),30); //call from method  explicit wait object
           typeText(By.xpath("//input[@id=\"FirstName\"]"), "Sushma",20);;

        typeText(By.xpath("//input[@name=\"LastName\"]"),"patel", 20);
        clickOnElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"),20);
        selectFromDropDownByIndex(By.xpath("//select[@name=\"DateOfBirthDay\"]"),20);
        clickOnElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),20);
        selectFromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),"August");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(By.xpath("//select[@name=\"DateOfBirthYear\"]"),20);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        selectFromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"1989");
        //selectFromDropDownByIndex(By.xpath("//select[@name=\"DateOfBirthYear\"]"), 1912);
        typeText(By.xpath("//input[@id=\"Email\"]"),"priyal+"+timestamp()+"@gmail.com", 20);
        typeText(By.xpath("//input[@id=\"Company\"]"),"ABC Ltd.", 20);
        typeText(By.xpath("//input[@name=\"Password\"]"),"priyal", 20);
        typeText(By.xpath("//input[@id=\"ConfirmPassword\"]"),"priyal", 20);
         clickOnElement(By.xpath("//input[@name=\"register-button\"]"),20);
         String expectedText = "Your registration completed";   // message  to be shown in expected result
         waitUntilElementIsClickable(By.xpath("//div[@class=\"result\"]"),30);
         String actualText = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
         Assert.assertEquals(actualText,expectedText);
     }
     @Test(priority = 2)
     public static void EmailFriend(){ //method to be send message for friend
       register();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); // put the implicit wait
        clickOnElement(By.linkText("Computers"),40);
        waitUntilElementIsClickable(By.linkText("Desktops"),30);
        clickOnElement(By.linkText("Desktops"),40);
      //  waitUntilElementIsClickable(By.linkText("Build your own computer"),20);
        clickOnElement(By.linkText("Build your own computer"),20);
        clickOnElement(By.xpath("//input[@value=\"Email a friend\"]"),40);
        waitUntilElementIsClickable(By.xpath("//input[@class=\"friend-email\"]"),30);// call the method from the  explicit wait
        typeText(By.xpath("//input[@class=\"friend-email\"]"),"priyal2020@gmail.com", 20);
       // typeText(By.xpath("//input[@id=\"YourEmailAddress\"]"),"cheshta2016@yahoo.com",20);
         typeText(By.xpath("//textarea[@id=\"PersonalMessage\"]"),"Happy friendship day",20);
         clickOnElement(By.xpath("//input[@name=\"send-email\"]"),20);
         String expectedText1 = "Your message has been sent";
         waitUntilElementIsClickable(By.linkText("Your message has been sent."),30);
         String actualText1 = getTextFromElement(By.linkText("Your message has been sent."));
         Assert.assertEquals(actualText1,expectedText1);
     }
     @Test(priority = 3)
    public static void AddToCart(){ //  method for two item to add in shopping cart
         clickOnElement(By.linkText("Electronics"),40);
         waitUntilElementIsClickable(By.linkText("Cell phones"),30);
         clickOnElement(By.linkText("Cell phones"),40);
         clickOnElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]/div[3]/div[2]/input[1]"),40);
         //clickOnElement(By.linkText("Electronics"),40);
         clickOnElement(By.linkText("HTC One Mini Blue"),40); // click on  main page
         clickOnElement(By.xpath("//input[@id=\"add-to-cart-button-19\"]"),40); // click from inside  the the page
         clickOnElement(By.linkText("Shopping cart"),40);
         String expectedText = "HTC One M8 Android L 5.0 Lollipop";
         String actualText = getTextFromElement(By.linkText("HTC One M8 Android L 5.0 Lollipop"));
         Assert.assertEquals(actualText,expectedText);
         String expectedText1 = "HTC One Mini Blue";
         String actualText1 = getTextFromElement(By.linkText("HTC One Mini Blue"));
         Assert.assertEquals(actualText1,expectedText1);
     }
}
