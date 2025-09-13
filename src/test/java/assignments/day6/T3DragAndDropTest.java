package assignments.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class T3DragAndDropTest extends TestBase {

    @Test
    public void dragAndDropPuzzlePieces() {
        /*
        Task 3: Drag and Drop Practice
        Go to https://claruswaysda.github.io/dragAndDrop.html
        Drag the items in their right places
        Assert the success message
        */

        // Open the page
        driver.get("https://claruswaysda.github.io/dragAndDrop.html");

        // Create Actions object
        Actions actions = new Actions(driver);

        // Create WebDriverWait to ensure elements are visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Locate the draggable items
        WebElement piece1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("piece1")));
        WebElement piece2 = driver.findElement(By.id("piece2"));
        WebElement piece3 = driver.findElement(By.id("piece3"));

        // Locate the target slots
        WebElement slot1 = driver.findElement(By.id("slot1"));
        WebElement slot2 = driver.findElement(By.id("slot2"));
        WebElement slot3 = driver.findElement(By.id("slot3"));

        // Drag each piece to its correct slot
        actions.dragAndDrop(piece1, slot1).perform();
        actions.dragAndDrop(piece2, slot2).perform();
        actions.dragAndDrop(piece3, slot3).perform();

        // Assert the success message
        Assertions.assertEquals(
                "Well done!",
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success"))).getText(),
                "The pieces were not placed correctly!"
        );


    }
}
