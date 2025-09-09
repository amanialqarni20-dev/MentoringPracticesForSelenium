package assignments.day3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class T08ElementStateVerification {

    // Utility Method لفحص حالة العناصر
    public Map<WebElement, String> checkElementsState(List<WebElement> elements) {
        Map<WebElement, String> result = new HashMap<>();

        for (WebElement el : elements) {
            StringBuilder status = new StringBuilder();

            status.append("Displayed: ").append(el.isDisplayed()).append(", ");
            status.append("Enabled: ").append(el.isEnabled());

            // لو العنصر ممكن يكون selected (checkbox, radio, option)
            try {
                status.append(", Selected: ").append(el.isSelected());
            } catch (Exception e) {
                status.append(", Selected: N/A");
            }

            result.put(el, status.toString());
        }
        return result;
    }

    @Test
    public void testFormElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        // عناصر باستخدام Relative XPath
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement maleRadio = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        WebElement hobbiesCheckbox = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));

