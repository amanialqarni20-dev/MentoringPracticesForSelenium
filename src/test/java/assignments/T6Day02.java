package assignments;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T6Day02 {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        // تشغيل المتصفح Chrome
        driver = new ChromeDriver();
        // تكبير نافذة المتصفح
        driver.manage().window().maximize();
    }

    @Test
    public void testSeleniumPageSource() {
        // افتح موقع Selenium الرسمي
        driver.get("https://www.selenium.dev/");
        // تحقق أن الصفحة تحتوي كلمة "WebDriver"
        assertTrue(driver.getPageSource().contains("WebDriver"));
    }

    @Test
    public void testPythonPageSource() {
        // افتح موقع Python الرسمي
        driver.get("https://www.python.org/");
        // تحقق أن الصفحة تحتوي كلمة "Python"
        assertTrue(driver.getPageSource().contains("Python"));
    }

    @AfterEach
    public void tearDown() {
        // إغلاق المتصفح بعد كل اختبار
        if (driver != null) {
            driver.quit();
        }
    }
}