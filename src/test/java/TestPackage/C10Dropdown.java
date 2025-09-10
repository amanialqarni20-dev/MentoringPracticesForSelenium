package TestPackage;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class C10Dropdown {
    WebDriver driver;
    String url = "https://demoqa.com/select-menu";

    // Locator for single dropdown
    By dropdownById = By.id("oldSelectMenu");

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

    // ✅ اختبار القائمة العادية (Single Select)
    @Test
    void oldDropDownMenuTest() {
        driver.get(url);

        WebElement dropdown = driver.findElement(dropdownById);
        Select select = new Select(dropdown);

        // Select by index
        select.selectByIndex(0);
        System.out.println("Selected option: " + select.getFirstSelectedOption().getText());

        // Select by value
        select.selectByValue("red");
        System.out.println("Selected option: " + select.getFirstSelectedOption().getText());

        // Select by visible text
        select.selectByVisibleText("Green");
        System.out.println("Selected option: " + select.getFirstSelectedOption().getText());

        // ✅ تحقق أن النص يساوي "Green"
        Assertions.assertEquals("Green", select.getFirstSelectedOption().getText());
    }

    // ✅ اختبار القائمة المتعددة (Multi Select)
    @Test
    void multiSelectTest() {
        driver.get(url);

        // Locator for multi-select dropdown
        WebElement multiSelect = driver.findElement(By.id("cars"));
        Select select = new Select(multiSelect);

        // Select multiple options
        select.selectByIndex(0);     // Volvo
        select.selectByVisibleText("Audi");

        // ✅ اطبع كل الخيارات المحددة
        List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
        System.out.println("Selected options:");
        for (WebElement option : allSelectedOptions) {
            System.out.println(option.getText());
        }

        // ✅ تحقق أن "Volvo" من ضمن الخيارات
        Assertions.assertTrue(allSelectedOptions.get(0).getText().contains("Volvo"));

        // ✅ تحقق أن "Audi" موجودة
        Assertions.assertEquals("Audi", allSelectedOptions.get(1).getText());

        // ✅ تحقق أن القائمة تحتوي على "Opel"
        List<WebElement> options = select.getOptions();
        boolean hasOpel = false;
        for (WebElement option : options) {
            if (option.getText().equals("Opel")) {
                hasOpel = true;
                break;
            }
        }
        Assertions.assertTrue(hasOpel);
    }
}
