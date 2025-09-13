package assignments.day6;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T4DrawingTest extends TestBase {

    @Test
    public void drawTriangleAndReset() {
        // Go to URL
        driver.get("https://claruswaysda.github.io/Draw.html");

        Actions actions = new Actions(driver);

        // Locate the canvas
        WebElement canvas = driver.findElement(By.id("myCanvas"));

        // Draw a triangle on the canvas
        actions
                .moveToElement(canvas, 50, 50)   // start point
                .clickAndHold()
                .moveByOffset(100, 0)            // horizontal line
                .moveByOffset(-50, 100)          // diagonal down
                .moveByOffset(-50, -100)         // back to start
                .release()
                .perform();

        // Click the reset button
        driver.findElement(By.id("resetButton")).click();
    }
}
