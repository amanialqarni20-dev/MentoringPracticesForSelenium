package assignments;

// Import Selenium classes
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T06AdvancedCaptchaHandling {

    private WebDriver driver;

    // Setup browser before each test
    @BeforeEach
    public void setup() {
        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        // Start browser maximized
        options.addArguments("--start-maximized");
        // Initialize WebDriver
        driver = new ChromeDriver(options);

        // Navigate to the captcha form page
        driver.get("https://form.jotform.com/73302671092956");
    }

    @Test
    public void testCaptchaHandling() {
        // Locate the captcha question element
        WebElement captchaQuestion = driver.findElement(By.id("captcha_question"));

        // Get text of captcha question (e.g., "12 / 4")
        String questionText = captchaQuestion.getText().trim();
        System.out.println("Captcha Question: " + questionText);

        // Split the question into parts (operand1 operator operand2)
        String[] parts = questionText.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int num2 = Integer.parseInt(parts[2]);

        // Variable to hold captcha answer
        int result = 0;

        try {
            // Handle operations based on operator
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    // Handle division by zero
                    if (num2 == 0) {
                        System.out.println("Division by zero detected! Defaulting result to 0.");
                        result = 0;
                    } else {
                        // Perform division and round to nearest integer
                        result = (int) Math.round((double) num1 / num2);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported operator: " + operator);
            }
        } catch (Exception e) {
            // Handle unexpected errors gracefully
            System.out.println("Error while solving captcha: " + e.getMessage());
        }

        // Locate the captcha input field
        WebElement captchaInput = driver.findElement(By.id("captcha_input"));
        // Enter the calculated result
        captchaInput.sendKeys(String.valueOf(result));

        // Locate submit button
        WebElement submitBtn = driver.findElement(By.id("input_2"));
        // Click submit
        submitBtn.click();

        // Assert page contains success or confirmation message
        assertTrue(driver.getPageSource().contains("Thank You") ||
                        driver.getPageSource().contains("Your submission has been received"),
                "Form submission failed or captcha not solved correctly!");
    }

    // Close browser after each test
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
