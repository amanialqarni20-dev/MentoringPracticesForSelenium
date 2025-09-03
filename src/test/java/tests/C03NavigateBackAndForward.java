package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03NavigateBackAndForward {
    public static void main(String[] args) throws InterruptedException {
        // TC – 03
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open URL of Website
        driver.navigate().to("https://www.amazon.com/");

        // Maximize Window
        driver.manage().window().maximize();

        // Get Title of current Page
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);

        // Validate/Compare Page Title
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        System.out.println(actualTitle.equals(expectedTitle));

        // Close Browser
        driver.close();
        driver.quit();
    }
    }