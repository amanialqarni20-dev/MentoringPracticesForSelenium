package assignments.day8;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

public class C03WebTableActions extends TestBase {

    @Test
    public void manageWebTable() throws IOException {
        // Step 1: Navigate to web table page
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 2: Add 3 new records with test data
        for (int i = 1; i <= 3; i++) {
            // Click "Add New Record" button
            driver.findElement(By.id("addNewRecordButton")).click();

            // Fill the form
            driver.findElement(By.id("firstName")).sendKeys("TestFirst" + i);
            driver.findElement(By.id("lastName")).sendKeys("TestLast" + i);
            driver.findElement(By.id("userEmail")).sendKeys("test" + i + "@email.com");
            driver.findElement(By.id("age")).sendKeys(String.valueOf(20 + i));
            driver.findElement(By.id("salary")).sendKeys(String.valueOf(1000 * i));
            driver.findElement(By.id("department")).sendKeys("Dept" + i);

            // Submit form
            driver.findElement(By.id("submit")).click();
        }

        // Optional: Capture screenshot after adding records
        takeScreenshot("AfterAdding3Records.png");

        // Step 3: Edit the 5th record
        List<WebElement> editButtons = driver.findElements(By.cssSelector("span[title='Edit']"));
        if (editButtons.size() >= 5) {
            editButtons.get(4).click(); // Index 4 = 5th record
            WebElement firstNameInput = driver.findElement(By.id("firstName"));
            firstNameInput.clear();
            firstNameInput.sendKeys("EditedName");
            driver.findElement(By.id("submit")).click();
        }

        // Optional: Screenshot after editing
        takeScreenshot("AfterEditing5thRecord.png");

        // Step 4: Delete the 1st record
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("span[title='Delete']"));
        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(0).click();
        }

        // Optional: Screenshot after deletion
        takeScreenshot("AfterDeleting1stRecord.png");

        // Step 5: Verify operations completed successfully
        List<WebElement> tableRows = driver.findElements(By.cssSelector(".rt-tbody .rt-tr-group"));
        System.out.println("Total rows after operations: " + tableRows.size());

        // You can add more assertions depending on your verification needs
    }

    // Helper method to take screenshots
    public void takeScreenshot(String fileName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/screenshots/" + fileName);
        Files.createDirectories(target.getParentFile().toPath());
        Files.copy(src.toPath(), target.toPath());
    }
}
