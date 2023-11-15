package project1;
/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl= %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field. 14. Click on Login Button.
 * 15. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class NopCommerce {
    static String browser = "Chrome";    //setting browser
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;      //declaring webdriver interface

    public static void main(String[] args) throws InterruptedException{
        //checking for multiple browsers to launch
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver= new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("wrong browser name");
        }

        //launching url
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //setting Implicit wait to driver until page is fully loaded
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //printing website title on console
        System.out.println("Title of website is: "+ driver.getTitle());
        //printing current URL
        System.out.println("The current URL is: "+ driver.getCurrentUrl());
        //printing page source
        System.out.println("The page source is: "+ driver.getPageSource());


        Thread.sleep(5000);

        //navigation
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl= %2F");
        System.out.println("The current URL is: "+ driver.getCurrentUrl());
        driver.navigate().back();
        driver.navigate().forward();
        System.out.println("The current URL is: "+ driver.getCurrentUrl());
        driver.navigate().refresh();

        //find email element and entering email id
        driver.findElement(By.id("Email")).sendKeys("meghavij123@gmail.com");
        //find password element and entering password
        driver.findElement(By.id("Password")).sendKeys("megha@123");
        //find login button element and clicking on it
        driver.findElement(By.linkText("Log in")).click();

        driver.quit(); //to close browser
    }
}
