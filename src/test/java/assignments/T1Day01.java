package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1Day01 {
    public static void main(String[] args) {
        // TC - 01

        // Create Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open Google home page
        driver.get("https://www.google.com");

        // Get Title on page
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);

        // Get Current URL on page
        String url = driver.getCurrentUrl();
        System.out.println("Current URL of the page is: " + url);

        // Close/Quit the browser
        driver.quit();
    }
}