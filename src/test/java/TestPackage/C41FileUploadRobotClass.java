package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;

public class C41FileUploadRobotClass extends TestBase {

    @Test
    public void uploadTest() {
        // Go to URL
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        // Find the path of the file that you want to upload.
        Path filePath = Path.of(System.getProperty("user.home"), "Downloads", "Screenshot (1).png");
        String fileStrPath = filePath.toString();

        // Store path in the clipboard
        StringSelection ss = new StringSelection(fileStrPath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        // Click the file input
        WebElement fileInput = driver.findElement(By.xpath("(//td)[4]"));
        fileInput.click();

        try {
            Robot robot = new Robot();
            robot.setAutoDelay(200);

            // Windows: لصق المسار ثم Enter
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        // Click on Upload button
        driver.findElement(By.xpath("//input[@name='submitbutton'][2]")).click();

        // Verify the upload message
        Assertions.assertTrue(
                driver.findElement(By.id("_valuefilename"))
                        .getText()
                        .contains("Screenshot (1).png"),
                "File upload message not found!"
        );
    }
}
