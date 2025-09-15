package assignments.day8;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class C02RegisterLoginScreenshots extends TestBase {

    @Test
    public void registerLoginTakeScreenshots() throws IOException, InterruptedException {

        driver.get("https://claruswaysda.github.io/homepage.html");
        takeScreenshot("01_homepage.png");

        // *** 2) Click on Register link inside menu (using menu id then <a>)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menu = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu")));
        WebElement registerLink = menu.findElement(By.xpath(".//a[contains(text(),'Register')]"));
        registerLink.click();
        takeScreenshot("02_registerPage.png");

        // *** 3) Fill out the registration form
        driver.findElement(By.id("ssn")).sendKeys("123-45-6789");
        driver.findElement(By.id("first-name")).sendKeys("Amani");
        driver.findElement(By.id("last-name")).sendKeys("AlQarni");
        driver.findElement(By.id("address")).sendKeys("Riyadh - KSA");
        driver.findElement(By.id("phone")).sendKeys("0555555555");
        String uniqueUser = "user" + System.currentTimeMillis();
        driver.findElement(By.id("username")).sendKeys(uniqueUser);
        driver.findElement(By.id("email")).sendKeys(uniqueUser + "@mail.com");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("confirm-password")).sendKeys("Password123");

        // *** 4) Click the Register button
        driver.findElement(By.cssSelector("button.button")).click();
        takeScreenshot("03_afterRegistration.png");

        // هنا تقدر تضيف خطوات تسجيل الدخول + أخذ لقطات زر Celebrate لاحقًا
    }

    // ---------- Helper Methods ----------
    private void takeScreenshot(String fileName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path dest = Path.of("screenshots", fileName);
        Files.createDirectories(dest.getParent());
        Files.copy(src.toPath(), dest);
        System.out.println("Saved screenshot: " + dest.toAbsolutePath());
    }
}
