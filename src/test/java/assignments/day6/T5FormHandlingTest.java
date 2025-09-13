package assignments.day6;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T5FormHandlingTest extends TestBase {

    // Method to highlight elements using JavaScript
    public void flashElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    @Test
    public void formHandlingWithJSExecutor() {
        // Go to https://claruswaysda.github.io/form.html
        driver.get("https://claruswaysda.github.io/form.html");

        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Register a user
        WebElement ssn = driver.findElement(By.id("ssn"));
        flashElement(ssn);
        js.executeScript("arguments[0].value='123-45-6789';", ssn);

        WebElement firstName = driver.findElement(By.id("first-name"));
        flashElement(firstName);
        js.executeScript("arguments[0].value='Amani';", firstName);

        WebElement lastName = driver.findElement(By.id("last-name"));
        flashElement(lastName);
        js.executeScript("arguments[0].value='Alqarni';", lastName);

        WebElement address = driver.findElement(By.id("address"));
        flashElement(address);
        js.executeScript("arguments[0].value='Riyadh, Saudi Arabia';", address);

        WebElement phone = driver.findElement(By.id("phone"));
        flashElement(phone);
        js.executeScript("arguments[0].value='+966501234567';", phone);

        WebElement username = driver.findElement(By.id("username"));
        flashElement(username);
        js.executeScript("arguments[0].value='amani_user';", username);

        WebElement email = driver.findElement(By.id("email"));
        flashElement(email);
        js.executeScript("arguments[0].value='amani@example.com';", email);

        WebElement password = driver.findElement(By.id("password"));
        flashElement(password);
        js.executeScript("arguments[0].value='Password123';", password);

        WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
        flashElement(confirmPassword);
        js.executeScript("arguments[0].value='Password123';", confirmPassword);

        WebElement registerBtn = driver.findElement(By.cssSelector("button.button"));
        flashElement(registerBtn);
        js.executeScript("arguments[0].click();", registerBtn);

        // Login
        WebElement loginUsername = driver.findElement(By.id("username"));
        flashElement(loginUsername);
        js.executeScript("arguments[0].value='amani_user';", loginUsername);

        WebElement loginPassword = driver.findElement(By.id("password"));
        flashElement(loginPassword);
        js.executeScript("arguments[0].value='Password123';", loginPassword);

        WebElement loginBtn = driver.findElement(By.cssSelector("button.button"));
        flashElement(loginBtn);
        js.executeScript("arguments[0].click();", loginBtn);

        // Celebrate the login!
        WebElement celebrateMessage = driver.findElement(By.id("loginMessage"));
        flashElement(celebrateMessage);
        System.out.println("Login Message: " + celebrateMessage.getText());
    }
}
