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

import java.time.Duration;

public class T02CalculatorOperations02Test {

    // Task:
    // Go to https://testpages.eviltester.com/styled/calculator
    // Type any number in first and second input
    // Click Calculate for each operation (+, -, *, /)
    // Get and verify results for all operations

    WebDriver driver;
    String url = "https://testpages.eviltester.com/styled/calculator";
    By firstInput = By.id("number1");
    By secondInput = By.id("number2");

    String num1 = "20";
    String num2 = "5";

    String[] operations = {"plus", "minus", "times", "divide"};

    @Test
    void testCalculatorOperations() throws InterruptedException {

        // Go to calculator page
        driver.get(url);

        for (String operation : operations) {

            // كتابة الأرقام في الحقول
            WebElement first = driver.findElement(firstInput);
            WebElement second = driver.findElement(secondInput);
            first.clear();
            first.sendKeys(num1);
            second.clear();
            second.sendKeys(num2);

            // اختيار العملية
            WebElement functionSelect = driver.findElement(By.id("function"));
            Select select = new Select(functionSelect);
            select.selectByValue(operation);

            // الضغط على زر Calculate
            driver.findElement(By.id("calculate")).click();

            // الحصول على النتيجة والتحقق منها
            String resultText = driver.findElement(By.id("answer")).getText();
            int expectedResult = 0;

            switch (operation) {
                case "plus" -> expectedResult = Integer.parseInt(num1) + Integer.parseInt(num2);
                case "minus" -> expectedResult = Integer.parseInt(num1) - Integer.parseInt(num2);
                case "times" -> expectedResult = Integer.parseInt(num1) * Integer.parseInt(num2);
                case "divide" -> expectedResult = Integer.parseInt(num1) / Integer.parseInt(num2);
            }

            Assertions.assertEquals(String.valueOf(expectedResult), resultText);

            System.out.println(operation + " Result: " + resultText);

            // لتجنب مشاكل stale element
            driver.navigate().refresh();
        }
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
