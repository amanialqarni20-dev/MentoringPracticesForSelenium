package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02WindowsComments {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().maximize();
        // Thread.sleep(2000);

        driver.navigate().to("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        // Thread.sleep(2000);

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.quit();
    }
}