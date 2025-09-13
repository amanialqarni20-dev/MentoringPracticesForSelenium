package tests.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Task11MultipleiFrames extends TestBase {

    @Test
    public void task11_multipleIFrames() throws InterruptedException {

        // Step 1: Go to the URL
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();

        // Step 2: Find the number of iframes on the page
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        int frameCount = frames.size();
        System.out.println("Number of iframes on page = " + frameCount);
        Assertions.assertTrue(frameCount > 0, "Expected at least 1 iframe on the page");

        // Step 3: Switch to the third iframe (or last one if أقل من 3)
        if (frameCount >= 3) {
            driver.switchTo().frame(2);
        } else {
            driver.switchTo().frame(frameCount - 1);
        }

        // Step 4: Click the link inside the iframe (with explicit wait)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'live-selenium-project')]")
        ));
        link.click();

        // Step 5: Exit the iframe and return to the main page
        driver.switchTo().defaultContent();

        // Step 6: Verify main page body is displayed
        Assertions.assertTrue(driver.findElement(By.tagName("body")).isDisplayed(),
                "Main page body should be displayed");

        Thread.sleep(4000);
    }
}
