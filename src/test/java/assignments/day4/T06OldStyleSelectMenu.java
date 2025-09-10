package assignments.day4;

import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T06OldStyleSelectMenu {

    // Go to https://demoqa.com/select-menu
    // Select Old Style Select Menu using element id
    // Create method selectByIndexTest and Select Option 1 using index.
    // Create method selectByValueTest Select Option 2 by value.
    // Create method selectByVisibleTextTest Select Option 1 value by visible text.
    // Create method printAllTest Print all dropdown value.
    // Verify the dropdown has Option "Red".

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";
    By oldSelectById = By.id("oldSelectMenu");

    @Test
    void selectByIndexTest() {
        driver.get(url);

        WebElement dropDown = driver.findElement(oldSelectById);
        Select select = new Select(dropDown);

        select.selectByIndex(1); // Option 1 = Blue
        Assertions.assertEquals("Blue", select.getFirstSelectedOption().getText());
    }

    @Test
    void selectByValueTest() {
        driver.get(url);

        WebElement dropDown = driver.findElement(oldSelectById);
        Select select = new Select(dropDown);

        select.selectByValue("1"); // value = 1 -> Blue
        Assertions.assertEquals("Blue", select.getFirstSelectedOption().getText());
    }

    @Test
    void selectByVisibleTextTest() {
        driver.get(url);

        WebElement dropDown = driver.findElement(oldSelectById);
        Select select = new Select(dropDown);

        select.selectByVisibleText("Yellow");
        Assertions.assertEquals("Yellow", select.getFirstSelectedOption().getText());
    }

    @Test
    void printAllTest() {
        driver.get(url);

        WebElement dropDown = driver.findElement(oldSelectById);
        Select select = new Select(dropDown);

        List<WebElement> allOptions = select.getOptions();
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        boolean hasRed = allOptions.stream().anyMatch(o -> o.getText().equals("Red"));
        Assertions.assertTrue(hasRed, "Dropdown should contain 'Red'");
    }

    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
