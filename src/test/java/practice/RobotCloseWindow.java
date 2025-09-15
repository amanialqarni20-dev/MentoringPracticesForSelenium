package practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotCloseWindow extends TestBase {

    /*
       Go to https://claruswaysda.github.io/downloadUpload.html
       Click on 'Upload'
       Close the opening page using a keyboard shortcut
       (CTRL+F4 for Windows / CMD+W for Mac)
    */

    @Test
    void test() throws AWTException, InterruptedException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        // Click the Upload button by its ID
        driver.findElement(By.id("uploadInput")).click();

        Thread.sleep(1500); // wait for the dialog or tab

        // Close depending on OS
        closeWindowWithRobot();
    }

    /**
     * Presses the right key combination to close a window/tab
     * depending on the operating system.
     */
    private void closeWindowWithRobot() throws AWTException {
        Robot robot = new Robot();
        robot.setAutoDelay(200);

        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            // Mac shortcut: CMD + W
            robot.keyPress(KeyEvent.VK_META);   // ⌘
            robot.keyPress(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_META);
        } else {
            // Windows/Linux shortcut: CTRL + F4
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }
}
