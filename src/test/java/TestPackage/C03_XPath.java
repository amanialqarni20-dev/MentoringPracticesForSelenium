package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XPath {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver(); // يفتح متصفح Chrome
        driver.manage().window().maximize(); // يكبر النافذة
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // ينتظر تلقائيًا حتى 10 ثواني لأي عنصر
        driver.get("https://thinking-tester-contact-list.herokuapp.com/"); // يفتح موقع الاختبار
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000); // ينتظر 3 ثواني (تشوف النتيجة قبل الإغلاق)
        driver.quit(); // يغلق المتصفح كليًا
    }


    @Test
    void absoluteXPathTest() {
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/form/p[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/form/p[2]/input"));
        emailInput.sendKeys("johndoeSDA@yahoo.com");
        passwordInput.sendKeys("John.123", Keys.ENTER);
    }

    @Test
    void relativeXPathTest() {

        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        emailInput.sendKeys("johndoeSDA@yahoo.com");
        passwordInput.sendKeys("John.123", Keys.ENTER);
        WebElement logoutButton = driver.findElement(By.xpath("//button[@id='logout']"));
        Assertions.assertTrue(logoutButton.isDisplayed());
    }

}