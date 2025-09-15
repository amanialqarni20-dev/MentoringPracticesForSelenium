package assignments.day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

public class C02FileUploadVerification extends TestBase {
    /*
        Go to https://claruswaysda.github.io/downloadUpload.html
        Upload a PDF using single upload button
        Verify that 'Files uploaded successfully!'
        Do negative test (No file or other than PDF)
        Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
        Test multiple PDFs as well
    */

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        String home = System.getProperty("user.home");


        Path pdf1 = Path.of(home, "Downloads", "sample (3).pdf");
        Assertions.assertTrue(Files.exists(pdf1));
        driver.findElement(By.id("uploadInput")).sendKeys(pdf1.toString());
        driver.findElement(By.className("submit-btn")).click();
        Assertions.assertEquals("Files uploaded successfully!",
                driver.findElement(By.id("message")).getText());

        driver.navigate().refresh();
        driver.findElement(By.className("submit-btn")).click();
        Assertions.assertEquals("Please upload at least one PDF file. Only PDF files are allowed!",
                driver.findElement(By.id("message")).getText());

        driver.navigate().refresh();
        Path invalid = Path.of(home, "Downloads", "sample.txt");
        if (Files.exists(invalid)) {
            driver.findElement(By.id("uploadInput")).sendKeys(invalid.toString());
            driver.findElement(By.className("submit-btn")).click();
            Assertions.assertEquals("Please upload at least one PDF file. Only PDF files are allowed!",
                    driver.findElement(By.id("message")).getText());
        }

        driver.navigate().refresh();
        Path pdf2 = Path.of(home, "Downloads", "sample (2).pdf");
        Assertions.assertTrue(Files.exists(pdf2));
        driver.findElement(By.id("multiUploadInput"))
                .sendKeys(pdf1.toString() + "\n" + pdf2.toString());
        driver.findElement(By.className("submit-btn")).click();
        Assertions.assertEquals("Files uploaded successfully!",
                driver.findElement(By.id("message")).getText());
    }
}
