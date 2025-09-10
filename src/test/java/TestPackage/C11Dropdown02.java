package TestPackage;

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

import static org.junit.jupiter.api.Assertions.*;

public class C11Dropdown02 {
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/dropdown";

    // Locator for the dropdown
    By dropdownById = By.id("dropdown");

    // 🟢 Before each test: open browser
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    // 🟢 After each test: close browser
    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void dropdownTest() {
        // 1- Go to URL
        driver.get(url);

        // 2- Create Select object for the dropdown
        Select select = new Select(driver.findElement(dropdownById));

        // 3- Select Option 1 using index
        selectByIndexTest(select, 1);

        // 4- Select Option 2 by value
        selectByValueTest(select, "2");

        // 5- Select Option 1 by visible text
        selectByVisibleTextTest(select, "Option 1");

        // 6- Print all dropdown values
        printAllTest(select);

        // 7- Print first selected option
        printFirstSelectedOptionTest(select);

        // 8- Verify the dropdown has "Option 2"
        boolean hasOption2 = select.getOptions().stream()
                .anyMatch(opt -> opt.getText().equals("Option 2"));
        assertTrue(hasOption2, "Dropdown should contain 'Option 2'");

        // 9- Find the size of the dropdown
        List<WebElement> options = select.getOptions();
        if (options.size() != 3) {
            System.out.println("Expected Is Not Equal Actual");
        }
        assertEquals(3, options.size(), "Expected Is Not Equal Actual");
    }

    // 🔹 Method to select by index
    private void selectByIndexTest(Select select, int index) {
        select.selectByIndex(index);
        System.out.println("Selected by index: " + select.getFirstSelectedOption().getText());
    }

    // 🔹 Method to select by value
    private void selectByValueTest(Select select, String value) {
        select.selectByValue(value);
        System.out.println("Selected by value: " + select.getFirstSelectedOption().getText());
    }

    // 🔹 Method to select by visible text
    private void selectByVisibleTextTest(Select select, String text) {
        select.selectByVisibleText(text);
        System.out.println("Selected by visible text: " + select.getFirstSelectedOption().getText());
    }

    // 🔹 Method to print all dropdown values
    private void printAllTest(Select select) {
        System.out.println("All options in dropdown:");
        for (WebElement option : select.getOptions()) {
            System.out.println(option.getText());
        }
    }

    // 🔹 Method to print first selected option
    private void printFirstSelectedOptionTest(Select select) {
        WebElement firstSelected = select.getFirstSelectedOption();
        System.out.println("First selected option: " + firstSelected.getText());
    }
}
