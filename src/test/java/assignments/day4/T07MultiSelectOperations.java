package assignments.day4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T07MultiSelectOperations {

    // Go to https://demoqa.com/select-menu
    // Select Standard Multi-Select using element id
    // Verify element is multi-select
    // Select 'Opel' using index, then deselect using index
    // Select 'Saab' using value, then deselect using value
    // Deselect all options

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";
    By multiSelectById = By.id("cars");

    @Test
    void testMultiSelectOperations() {
        driver.get(url);

        // استخدام WebDriverWait لضمان ظهور العنصر
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement multiSelectElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(multiSelectById)
        );

        Select select = new Select(multiSelectElement);

        // التحقق من أن العنصر متعدد الاختيار
        Assertions.assertTrue(select.isMultiple(), "Dropdown should support multiple selection");
        System.out.println("Dropdown is multi-select: " + select.isMultiple());

        // اختيار 'Opel' بالـ index ثم إلغاء الاختيار
        select.selectByIndex(2); // index 2 = Opel
        System.out.println("Selected by index: " + select.getFirstSelectedOption().getText());
        Assertions.assertEquals("Opel", select.getFirstSelectedOption().getText());
        select.deselectByIndex(2);
        System.out.println("Deselected by index, selected count: " + select.getAllSelectedOptions().size());

        // اختيار 'Saab' بالـ value ثم إلغاء الاختيار
        select.selectByValue("saab");
        System.out.println("Selected by value: " + select.getFirstSelectedOption().getText());
        Assertions.assertEquals("Saab", select.getFirstSelectedOption().getText());
        select.deselectByValue("saab");
        System.out.println("Deselected by value, selected count: " + select.getAllSelectedOptions().size());

        // اختيار عدة خيارات ثم إلغاء الكل
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Opel");
        System.out.println("Selected multiple: ");
        select.getAllSelectedOptions().forEach(opt -> System.out.println(" - " + opt.getText()));
        Assertions.assertEquals(2, select.getAllSelectedOptions().size());

        // إلغاء الكل
        select.deselectAll();
        System.out.println("Deselected all, selected count: " + select.getAllSelectedOptions().size());
        Assertions.assertEquals(0, select.getAllSelectedOptions().size());
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
