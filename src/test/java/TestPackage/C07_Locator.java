import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C07_Locator {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Set path to chromedriver if needed
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/login"); // Navigate to LinkedIn login page
    }

    @Test
    public void testLoginElements() {
        // Locate email field by id
        WebElement emailField = driver.findElement(By.id("username"));
        // Locate password field by name
        WebElement passwordField = driver.findElement(By.name("session_password"));
        // Locate sign-in button by xpath
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // Enter test credentials

        emailField.sendKeys("test@email.com");
        passwordField.sendKeys("TestPassword123");
WebElement passfield = driver.findElement(By.name("session_password"));

        // Verify elements are displayed
        assertTrue(emailField.isDisplayed(), "Email field should be displayed");
        assertTrue(passwordField.isDisplayed(), "Password field should be displayed");
        assertTrue(signInButton.isDisplayed(), "Sign-in button should be displayed");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit(); // Close browser and end session
        }
    }
}