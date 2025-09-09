package assignments.day3;

/*
Task: Create a test method that opens a browser with the following configurations:
      Maximize window on startup
      Disable extensions
      Run in incognito mode
      Disable infobars
      Navigate to "https://www.example.com" and verify the title contains "Example"
*/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T01ChromeOptionsConfigurationTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        // Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize window
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--incognito"); // Incognito mode
        options.addArguments("--disable-infobars"); // Disable infobars

        driver = new ChromeDriver(options);
    }

    @Test
    public void testExampleComTitle() {
        driver.get("https://www.example.com");

        String title = driver.getTitle();
        System.out.println("Page title: " + title);

        // Verify title contains "Example"
        assertTrue(title.contains("Example"), "Title does not contain 'Example'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
