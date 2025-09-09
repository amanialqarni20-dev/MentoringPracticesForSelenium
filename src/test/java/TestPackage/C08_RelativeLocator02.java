package TestPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C08_RelativeLocator02 {

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");        // يفتح مكبر
        options.addArguments("--incognito");             // وضع التخفي
        options.addArguments("--disable-extensions");    // تعطيل الإضافات
        options.addArguments("--disable-popup-blocking");// تعطيل النوافذ المنبثقة
        options.addArguments("--disable-infobars");      // إخفاء رسالة التحكم

        WebDriver driver = new ChromeDriver(options);

        // افتح Google
        driver.get("https://www.google.com");

        // خليه شغال شوي عشان تشوفه
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.quit();
    }
}
