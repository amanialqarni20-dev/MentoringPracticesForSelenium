package TestPackage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C09GoogleSearchTest {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void calculatorTest() {
        // Navigate to website
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on Calculator under Micro Apps
        WebElement calculatorLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("calculatetest"))
        );
        calculatorLink.click();

        // Type any number in the first input
        WebElement firstInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("number1"))
        );
        firstInput.sendKeys("5");

        // Type any number in the second input
        WebElement secondInput = driver.findElement(By.id("number2"));
        secondInput.sendKeys("7");

        // Click on Calculate
        WebElement calculateButton = driver.findElement(By.id("calculate"));
        calculateButton.click();

        // Get the result
        WebElement answer = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("answer"))
        );
        String resultText = answer.getText();

        // Verify the result (5 + 7 = 12)
        assertEquals("12", resultText);

        // Print the result
        System.out.println("Result is: " + resultText);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}