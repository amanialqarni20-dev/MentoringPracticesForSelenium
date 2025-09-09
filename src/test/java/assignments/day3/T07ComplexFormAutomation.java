package assignments.day3;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T07ComplexFormAutomation {
    static WebDriver driver;
    static Faker faker;

    @BeforeAll
    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // تشغيل بدون واجهة
        driver = new ChromeDriver(options);
        faker = new Faker();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void testFormAutomation() {
        driver.get("https://demoqa.com/automation-practice-form");

        // بيانات أساسية
        driver.findElement(By.id("firstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("lastName")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("userEmail")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("userNumber")).sendKeys(faker.number().digits(10));

        // Gender
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();

        // Hobbies
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();

        // Submit
        driver.findElement(By.id("submit")).click();

        // تحقق من نجاح التسجيل
        WebElement modal = driver.findElement(By.id("example-modal-sizes-title-lg"));
        assertTrue(modal.isDisplayed(), " Form submission failed!");
    }
}