package assignments.day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

public class C01FileDownloadVerification extends TestBase {
    /*
        Go to https://claruswaysda.github.io/downloadUpload.html
        Click on download
        Verify that 'QAProgram.png' file is downloaded
    */
    @Test
    public void fileDownloadTest() throws Exception {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        By downloadButton = By.className("download-btn");
        driver.findElement(downloadButton).click();
        Path filePath = Path.of(System.getProperty("user.home"), "Downloads", "QAProgram.png");
        Thread.sleep(3000);
        Assertions.assertTrue(Files.exists(filePath), "The file QAProgram.png was not found in Downloads folder");
        System.out.println("File downloaded successfully: " + filePath);
        Files.deleteIfExists(filePath);
    }
}
