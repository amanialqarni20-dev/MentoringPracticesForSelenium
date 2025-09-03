package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04NavigateBackAndForward {
    /* TC – 04
     * Go to the w3school URL : https://www.w3schools.com/
     * Print the position and size of the page.
     * Adjust the position and size of the page as desired.
     * Test that the page is in the position and size you want.
     * Close the page.
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // Go to the w3school URL
        driver.get("https://www.w3schools.com/");

        // Print the position and size of the page
        System.out.println("Initial Position: " + driver.manage().window().getPosition());
        System.out.println("Initial Size: " + driver.manage().window().getSize());

        Thread.sleep(2000);
// Adjust the position and size of the page as desired
        Point expectedPosition = new Point(100, 50);
        Dimension expectedSize = new Dimension(1200, 800);

        driver.manage().window().setPosition(expectedPosition);
        driver.manage().window().setSize(expectedSize);

        Thread.sleep(2000);

        // Get the new position and size
        Point actualPosition = driver.manage().window().getPosition();
        Dimension actualSize = driver.manage().window().getSize();

        System.out.println("New Position: " + actualPosition);
        System.out.println("New Size: " + actualSize);

        // Test that the page is in the position and size you want
        if (actualPosition.equals(expectedPosition) && actualSize.equals(expectedSize)) {
            System.out.println("Test Passed!");
        } else {
            System.err.println("Test Failed!");
        }

        // Close the page
        driver.quit();
    }
}