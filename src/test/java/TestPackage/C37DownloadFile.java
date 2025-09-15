package TestPackage;

import jdk.javadoc.doclet.Taglet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C37DownloadFile extends TestBase {

    private Taglet path;

    @Test
    public void FileDownLoadTest() {
        By seleniumSnapLinkText = By.linkText("login_exeption.png");

        // Go to URL
        driver.get("https://the-internet.herokuapp.com/download");

        // Download the file
        driver.findElement(seleniumSnapLinkText).click();
        try {
            Thread .sleep(3000); // Wait for the download to complete
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Verify if the file downloaded successfully
        String filePath = "C:\\Users\\amani\\Downloads\\bfffe755-2cb1-4e4f-8410-b067cadd8b8a.tmp";
        Assertions.assertTrue(Files.exists(Paths.get(filePath)), "File was not found!");
        System.out.println("path.toString() = " + path.toString());
        try {
            Files.deleteIfExists(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
