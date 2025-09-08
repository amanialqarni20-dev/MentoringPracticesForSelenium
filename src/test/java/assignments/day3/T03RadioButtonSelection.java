package assignments;

/*
Task: Navigate to "https://demoqa.com/radio-button"
      Create a test that:

      Attempts to select each radio button (Yes, Impressive, No)
      Prints whether each option is enabled/disabled
      For enabled options, select them and verify selection
      Print confirmation message for each successful selection
*/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T03RadioButtonSelection {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/radio-button");
    }

    @Test
    public void testRadioButtonSelection() {
        // XPath locators for the input elements
        By yesRadio = By.xpath("//input[@id='yesRadio']");
        By impressiveRadio = By.xpath("//input[@id='impressiveRadio']");
        By noRadio = By.xpath("//input[@id='noRadio']");

        selectRadioButton(yesRadio, "Yes");
        selectRadioButton(impressiveRadio, "Impressive");
        selectRadioButton(noRadio, "No");
    }

    private void selectRadioButton(By locator, String name) {
        WebElement radioButton = driver.findElement(locator);

        System.out.println(name + " button enabled? " + radioButton.isEnabled());

        if (radioButton.isEnabled()) {
            // Click on the label associated with the button
            WebElement radioLabel = driver.findElement(By.xpath("//label[@for='" + radioButton.getAttribute("id") + "']"));
            radioLabel.click();

            if (radioButton.isSelected()) {
                System.out.println(name + " button successfully selected!");
            } else {
                System.out.println(name + " button could not be selected.");
            }
        } else {
            System.out.println(name + " button is disabled, cannot select.");
        }

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
