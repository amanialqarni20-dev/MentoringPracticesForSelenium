package practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;


public class T2StarOperations extends TestBase {

    By addButton = By.xpath("//*[@id='push-button']");
    By deleteButton = By.xpath("//*[@id='delete-button']");
    By starsLocator = By.xpath("//*[@id='stars']/span");

    WebDriverWait wait;

    public void addStars(int count) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int i = 0; i < count; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        }
    }

    public void deleteStars(int count) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int i = 0; i < count; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
        }
    }

    public int getStarCount() {
        List<WebElement> stars = driver.findElements(starsLocator);
        return stars.size();
    }
    @Test
    void starTest() {
        driver.get("https://claruswaysda.github.io/addDeleteStar.html");

        addStars(5);
        System.out.println("Stars after adding: " + getStarCount());

        deleteStars(2);
        System.out.println("Stars after deleting: " + getStarCount());

        if (getStarCount() == 3) {
            System.out.println("Verification successful: 2 stars deleted");
        } else {
            System.out.println("Verification failed");
        }
    }
}
