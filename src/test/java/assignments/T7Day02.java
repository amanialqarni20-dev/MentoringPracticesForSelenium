package assignments;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3 {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        // تشغيل المتصفح Chrome
        driver = new ChromeDriver();
    }

    @Test
    public void testBrowserSize() {
        // افتح موقع BBC
        driver.get("https://www.bbc.com");

        // تغيير حجم النافذة إلى 800x600
        Dimension dimension = new Dimension(800, 600);
        driver.manage().window().setSize(dimension);

        // تحقق أن الحجم فعلاً صار 800x600
        Dimension currentSize = driver.manage().window().getSize();
        assertEquals(800, currentSize.getWidth());
        assertEquals(600, currentSize.getHeight());
    }

    @Test
    public void testBrowserPosition() {
        // افتح موقع BBC
        driver.get("https://www.bbc.com");

        // نقل النافذة إلى إحداثيات (100, 100)
        Point point = new Point(100, 100);
        driver.manage().window().setPosition(point);

        // تحقق أن النافذة فعلاً انتقلت إلى (100, 100)
        Point currentPosition = driver.manage().window().getPosition();
        assertEquals(100, currentPosition.getX());
        assertEquals(100, currentPosition.getY());
    }

    @AfterEach
    public void tearDown() {
        // إغلاق المتصفح بعد كل اختبار
        if (driver != null) {
            driver.quit();
        }
    }
}