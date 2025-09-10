package assignments.day4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

public class T06OldStyleSelectMenu {

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";

    // Locator للـ Old Style Select Menu
    By oldStyleSelectMenuById = By.id("oldSelectMenu");

    @Test
    void testOldStyleSelectMenu() {
        driver.get(url);

        WebElement selectElement = driver.findElement(oldStyleSelectMenuById);
        Select select = new Select(selectElement);

        System.out.println("All options in Old Style Select Menu:");
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        select.selectByIndex(4); // Index يبدأ من 0
        System.out.println("Selected by index: " + select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Magenta");
        System.out.println("Selected by visible text: " + select.getFirstSelectedOption().getText());

        select.selectByValue("3"); // Yellow
        System.out.println("Selected by value: " + select.getFirstSelectedOption().getText());
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}