package tests;

public class C03NavigateBackAndForward {

    package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    public class C03TitleValidation {

        // TC – 03
        // Expected Title
// Set Path of the Chrome driver
// Launch Chrome browser
// Open URL of Website
// Maximize Window
// Get Title of current Page
// Validate/Compare Page Title
// Close Browser
        public static void main(String[] args) {
            // Launch Chrome browser
            WebDriver driver = new ChromeDriver();

            // Open URL of Website
            driver.navigate().to("https://www.amazon.com");

            // Maximize Window
            driver.manage().window().maximize();

            driver.quit();

            driver.getTitle();
            String actualTitle = driver.getTitle();

        }
    }

}
