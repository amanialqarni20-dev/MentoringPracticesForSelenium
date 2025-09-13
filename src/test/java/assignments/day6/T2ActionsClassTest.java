package assignments.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class T2ActionsClassTest extends TestBase {

    @Test
    public void actionsTaskTest() {
        // Go to initial URL
        driver.get("https://claruswaysda.github.io/submit-button.html");

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Click on submit
        WebElement submitButton = driver.findElement(By.id("submitButton"));
        actions.click(submitButton).perform();

        // Handle new tab if it opens
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Wait until URL contains expected text
        wait.until(ExpectedConditions.urlContains("actionsClickDrag"));
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("actionsClickDrag"), "URL does not contain 'actionsClickDrag'");

        // Drag 'Drag me' to 'Drop here'
        WebElement drag = driver.findElement(By.id("drag1"));
        WebElement drop = driver.findElement(By.id("drop1"));
        actions.dragAndDrop(drag, drop).perform();

        // Right-click (double-click right mouse) on element
        WebElement rightClick = driver.findElement(By.id("showSuccessButton"));
        actions.contextClick(rightClick).perform(); // Right click
        actions.contextClick(rightClick).perform(); // Second right click

        // Double-click on 'Double-click me'
        WebElement doubleClick = driver.findElement(By.id("doubleClickButton"));
        actions.doubleClick(doubleClick).perform();

        // Hover on 'Hover over me'
        WebElement hover = driver.findElement(By.id("hoverButton"));
        actions.moveToElement(hover).perform();

        // Verify all actions' success messages
        WebElement dragMessage = driver.findElement(By.id("droppable"));
        Assertions.assertEquals("Dropped!", dragMessage.getText());

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        Assertions.assertEquals("Right-clicked!", rightClickMessage.getText());

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        Assertions.assertEquals("Double-clicked!", doubleClickMessage.getText());

        WebElement hoverMessage = driver.findElement(By.id("hoverMessage"));
        Assertions.assertEquals("Hovered!", hoverMessage.getText());
    }
}
