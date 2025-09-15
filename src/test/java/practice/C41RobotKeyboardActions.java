package practice;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
import java.awt.*;
import java.awt.event.KeyEvent;

public class C41RobotKeyboardActions extends TestBase {
    /*
       Go to https://claruswaysda.github.io/downloadUpload.html
       Click on 'Upload'
       Close the opening page using 'CTRL+F4'
    */
    @Test
    void test() throws AWTException, InterruptedException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        driver.findElement(By.xpath("//label[normalize-space()='Upload']")).click();

        Thread.sleep(1500);
        Robot robot = new Robot();

        robot.setAutoDelay(200);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
}
