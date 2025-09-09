package assignments.day2;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class T5Day02 {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testBrowserNavigationHistory() {
        // Step 1: Go to Wikipedia
        driver.get("https://www.wikipedia.org/");
        assertTrue(driver.getTitle().contains("Wikipedia"));

        // Step 2: Go to Google
        driver.navigate().to("https://www.google.com/");
        assertTrue(driver.getTitle().contains("Google"));

        // Step 3: Navigate Back (to Wikipedia)
        driver.navigate().back();
        assertTrue(driver.getTitle().contains("Wikipedia"));

        // Step 4: Navigate Forward (to Google)
        driver.navigate().forward();
        assertTrue(driver.getTitle().contains("Google"));

        // Step 5: Back again
        driver.navigate().back();
        assertTrue(driver.getTitle().contains("Wikipedia"));
    }

    @Test
    public void testPageRefreshOnGoogle() {
        driver.get("https://www.google.com/");
        String titleBefore = driver.getTitle();

        // Refresh
        driver.navigate().refresh();
        String titleAfter = driver.getTitle();

        assertTrue(titleAfter.contains("Google"));
        assertEquals(titleBefore, titleAfter);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}