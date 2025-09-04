package assignments;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class T8Day02 {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        // تشغيل متصفح Chrome
        driver = new ChromeDriver();
        // تكبير النافذة
        driver.manage().window().maximize();
    }

    @Test
    public void testNavigationAndTitles() {
        // افتح Google
        driver.get("https://www.google.com");
        assertTrue(driver.getTitle().contains("Google"));

        // افتح YouTube
        driver.navigate().to("https://www.youtube.com");
        assertTrue(driver.getTitle().contains("YouTube"));

        // افتح LinkedIn
        driver.navigate().to("https://www.linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"));
    }

    @Test
    public void testBackAndForwardNavigation() {
        // افتح Google
        driver.get("https://www.google.com");

        // افتح YouTube
        driver.navigate().to("https://www.youtube.com");

        // افتح LinkedIn
        driver.navigate().to("https://www.linkedin.com");

        // ارجع مرتين (إلى Google)
        driver.navigate().back();
        driver.navigate().back();
        assertEquals("https://www.google.com/", driver.getCurrentUrl());

        // تقدم مرتين (إلى LinkedIn)
        driver.navigate().forward();
        driver.navigate().forward();
        assertTrue(driver.getCurrentUrl().contains("linkedin.com"));
    }

    @AfterEach
    public void tearDown() {
        // إغلاق المتصفح بعد كل اختبار
        if (driver != null) {
            driver.quit();
        }
    }
}