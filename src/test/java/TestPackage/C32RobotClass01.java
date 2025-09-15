package TestPackage;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class C32RobotClass01 {
    @Test
    public void robotClassKeyboardTest1() throws AWTException , InterruptedException {

        // This pause is given so that we can click on the script. Robot will write "sout" on the screen
        Robot robot = new Robot();
        Thread .sleep(5000);
        robot .keyPress(KeyEvent.VK_S);
        robot .keyRelease(KeyEvent.VK_S);
        robot .keyPress(KeyEvent.VK_O);
        robot .keyRelease(KeyEvent.VK_O);
        robot .keyPress(KeyEvent.VK_U);
        robot .keyRelease(KeyEvent.VK_U);
        robot .keyPress(KeyEvent.VK_T);
        robot .keyRelease(KeyEvent.VK_T);
        robot .keyPress(KeyEvent.VK_ENTER);
        robot .keyRelease(KeyEvent.VK_ENTER);
        // Bir tuşa basma ve tuşu serbest bırakma

        // Select All
        robot  .keyPress(KeyEvent.VK_CONTROL); // Windows users
        robot  .keyPress(KeyEvent.VK_A); // Windows users
        robot  .keyRelease(KeyEvent.VK_A); // Windows users
        robot  .keyRelease(KeyEvent.VK_CONTROL); // Windows users
        Thread.sleep(2000);
        // robot.keyPress(KeyEvent.VK_CONTROL); // Windows users

        // robot.keyRelease(KeyEvent.VK_CONTROL); // Windows users

        // Copy the selected text
        robot .keyPress(KeyEvent.VK_CONTROL); // Windows users
        robot .keyPress(KeyEvent.VK_C); // Windows users
        robot .keyRelease(KeyEvent.VK_C); // Windows users
        robot .keyRelease(KeyEvent.VK_CONTROL); // Windows users
        Thread.sleep(2000);
        // Delete
        robot .keyPress(KeyEvent.VK_DELETE); // Windows users
        robot .keyRelease(KeyEvent.VK_DELETE); // Windows users
        Thread.sleep(2000);
        // Paste the copied text
        robot .keyPress(KeyEvent.VK_CONTROL); // Windows users
        robot .keyPress(KeyEvent.VK_V); // Windows users
        robot .keyRelease(KeyEvent.VK_V); // Windows users
        robot .keyRelease(KeyEvent.VK_CONTROL); // Windows users
        Thread.sleep(2000);
        // Press Entersout


    }

    @Test
    public void robotClassKeyboardTest2(){

    }
}