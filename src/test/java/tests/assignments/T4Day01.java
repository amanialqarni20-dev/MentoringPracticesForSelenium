package tests.assignments;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4Day01 {
    public static void main(String[] args) throws InterruptedException {

        // 1Open URL: https://www.google.com/
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        // 2Maximize the window
        driver.manage().window().maximize();

        // 3Print the position and size of the page
        Point position = driver.manage().window().getPosition();
        Dimension size = driver.manage().window().getSize();
        System.out.println("Maximized position: " + position);
        System.out.println("Maximized size: " + size);

        //4 Minimize the page
        driver.manage().window().minimize();
        Thread.sleep(5000);

        // 5Maximize the page again
        driver.manage().window().maximize();

        // 6Print the position and dimensions of the page in maximized state
        Point newPosition = driver.manage().window().getPosition();
        Dimension newSize = driver.manage().window().getSize();
        System.out.println("After maximize position: " + newPosition);
        System.out.println("After maximize size: " + newSize);

        // 7Make the page fullscreen
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        // 8Close the Browser
        driver.quit();
    }
}