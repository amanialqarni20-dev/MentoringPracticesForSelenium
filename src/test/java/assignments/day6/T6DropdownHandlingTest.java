package assignments.day6;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class T6DropdownHandlingTest extends TestBase {

    @Test
    public void dropdownTaskTest() {
        // Go to Dropdowns page
        driver.get("https://claruswaysda.github.io/Dropdowns.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // 1. Traditional Dropdown select 'Ford'
        WebElement traditionalDropdown = driver.findElement(By.id("carSelect"));
        Select selectTraditional = new Select(traditionalDropdown);
        selectTraditional.selectByValue("Ford");

        // 2. Multi-Select Dropdown select 'Mercedes'
        WebElement multiDropdown = driver.findElement(By.id("multiCarSelect"));
        Select selectMulti = new Select(multiDropdown);
        selectMulti.selectByValue("Mercedes");

        // 3. Custom Dropdown (Bootstrap-like) select 'BMW'
        WebElement customDropdown = driver.findElement(By.id("customDropdown"));
        customDropdown.click(); // Click to select BMW

        // 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
        WebElement staticInput = driver.findElement(By.id("staticInput"));
        staticInput.sendKeys("Tes");
        WebElement staticSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='suggestion-item' and text()='Tesla Model 3']")));
        staticSuggestion.click();

        // 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
        WebElement dynamicInput = driver.findElement(By.id("dynamicInput"));
        dynamicInput.sendKeys("Toy");
        WebElement dynamicSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='suggestion-item' and contains(text(),'Toyota')]")));
        dynamicSuggestion.click();
    }
}
