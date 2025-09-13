package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigate {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        driver.navigate().to("https://www.example.com");
driver.navigate().back();
driver.navigate().forward();
driver.navigate().refresh();
driver.manage().window().maximize();

        Thread.sleep(5000);
driver.manage().window().minimize();

driver.quit();

    }
}