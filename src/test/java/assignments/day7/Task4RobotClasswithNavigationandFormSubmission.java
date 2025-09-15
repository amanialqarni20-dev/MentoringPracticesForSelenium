package assignments.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Task4RobotClasswithNavigationandFormSubmission extends TestBase {

    @Test
    public void robotLoginTest() throws AWTException, InterruptedException {

        // 1. Navigate to the demo login page
        driver.get("https://the-internet.herokuapp.com/login");

        // 2. Locate username field and click on it
        WebElement usernameBox = driver.findElement(By.id("username"));
        usernameBox.click();

        // 3. Type username using sendKeys
        usernameBox.sendKeys("tomsmith");

        // 4. Use Robot class to press TAB to go to the password field
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        // 5. Type the password using sendKeys
        WebElement passwordBox = driver.switchTo().activeElement();
        passwordBox.sendKeys("SuperSecretPassword!");

        // 6. Press ENTER to submit the form
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // 7. Wait for the page to load (optional small sleep or use explicit wait)
        Thread.sleep(2000);

        // 8. Verify login success or error message
        WebElement flashMsg = driver.findElement(By.id("flash"));
        String flashText = flashMsg.getText();
        System.out.println("[INFO] Flash message: " + flashText);

        Assertions.assertTrue(
                flashText.contains("You logged into a secure area!") ||
                flashText.contains("Your username is invalid!"),
                "Flash message not found!"
        );
    }
}
