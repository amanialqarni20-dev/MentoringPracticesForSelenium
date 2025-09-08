package assignments;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T9Day03 {
    static WebDriver driver;

    // Absolute XPath
    String absoluteUsernameXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[1]/div/div[2]/input";
    String absolutePasswordXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input";
    String absoluteLoginBtnXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[3]/button";

    // Relative XPath
    String relativeUsernameXPath = "//input[@name='username']";
    String relativePasswordXPath = "//input[@name='password']";
    String relativeLoginBtnXPath = "//button[@type='submit']";

    @BeforeAll
    static void setUp() {
       // مهم: يضبط نسخة ChromeDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void relativeXpathTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement username = driver.findElement(By.xpath(relativeUsernameXPath));
        WebElement password = driver.findElement(By.xpath(relativePasswordXPath));
        WebElement loginBtn = driver.findElement(By.xpath(relativeLoginBtnXPath));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginBtn.click();

        // تحقق أن النص Dashboard موجود في الصفحة بعد تسجيل الدخول
        WebElement dashboardText = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        assertTrue(dashboardText.isDisplayed(), "Dashboard text was not displayed - Login failed!");
    }

    @Test
    void absoluteXpathTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement username = driver.findElement(By.xpath(absoluteUsernameXPath));
        WebElement password = driver.findElement(By.xpath(absolutePasswordXPath));
        WebElement loginBtn = driver.findElement(By.xpath(absoluteLoginBtnXPath));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginBtn.click();

        // تحقق أن العنوان الجديد يحتوي على "dashboard"
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("dashboard"), "Current URL does not contain 'dashboard' - Login failed!");
    }
}