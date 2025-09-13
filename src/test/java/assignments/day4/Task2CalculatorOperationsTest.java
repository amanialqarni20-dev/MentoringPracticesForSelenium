package assignments.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Task2CalculatorOperationsTest extends TestBase {

    @Test
    public void calculatorAllOperations() {

        // Go to https://testpages.eviltester.com/styled/calculator
        driver.get("https://testpages.eviltester.com/styled/calculator");

        // Type any number in first and second input
        WebElement firstInput = driver.findElement(By.id("number1"));
        WebElement secondInput = driver.findElement(By.id("number2"));
        firstInput.sendKeys("10");
        secondInput.sendKeys("5");

        // Locate the dropdown for operations
        WebElement operationDropdown = driver.findElement(By.id("function"));
        Select select = new Select(operationDropdown);

        // Click Calculate for Add and verify result
        select.selectByVisibleText("Add");
        driver.findElement(By.id("calculate")).click();
        WebElement result = driver.findElement(By.id("answer"));
        Assertions.assertEquals("15", result.getText());

        // Click Calculate for Subtract and verify result
        select.selectByVisibleText("Subtract");
        driver.findElement(By.id("calculate")).click();
        result = driver.findElement(By.id("answer"));
        Assertions.assertEquals("5", result.getText());

        // Click Calculate for Multiply and verify result
        select.selectByVisibleText("Multiply");
        driver.findElement(By.id("calculate")).click();
        result = driver.findElement(By.id("answer"));
        Assertions.assertEquals("50", result.getText());

        // Click Calculate for Divide and verify result
        select.selectByVisibleText("Divide");
        driver.findElement(By.id("calculate")).click();
        result = driver.findElement(By.id("answer"));
        Assertions.assertEquals("2", result.getText());
    }
}
