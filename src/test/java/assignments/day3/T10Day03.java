package assignments.day3;

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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T10Day03 {
    static WebDriver driver;
    static WebDriverWait wait;
    String url = "https://testpages.herokuapp.com/styled/index.html";

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void assignmentTest() {
        driver.get(url);

        WebElement locatorsLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Locators - Find By Playground Test Page')]")));
        locatorsLink.click();
        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println("After back: " + driver.getCurrentUrl());

        WebElement webDriverExampleLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'WebDriver Example Page')]")));
        webDriverExampleLink.click();
        System.out.println("WebDriver Example Page URL: " + driver.getCurrentUrl());

        WebElement numberInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='numentry']")));
        numberInput.clear();
        numberInput.sendKeys("20");


        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='submit-to-server']")));
        submitButton.click();

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@id='message']")));
        String resultText = result.getText();
        System.out.println("Result Text: " + resultText);
        assertTrue(resultText.contains("two, zero"), "Expected message not found!");
    }
}