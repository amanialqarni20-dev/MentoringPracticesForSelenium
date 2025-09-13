package practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T2IframeTask extends TestBase {
    /*
    Go to https://claruswaysda.github.io/iframe.html
    Type your name in input
    Click on 'Bold' button
    Assert the alert message
     */

    // Locators
    By iframe = By.id("mce_0_ifr");             // iframe الخاص بالمحرر
    By inputBox = By.id("tinymce");             // داخل iframe
    By boldBtn = By.cssSelector("button[title='Bold']");  // زر Bold بالـ title

    @Test
    void test01() {
        // افتح الصفحة
        driver.get("https://claruswaysda.github.io/iframe.html");

        // انتقل للـ iframe
        WebElement frameElement = driver.findElement(iframe);
        driver.switchTo().frame(frameElement);

        // اكتب الاسم داخل المحرر
        WebElement input = driver.findElement(inputBox);
        input.clear();
        input.sendKeys("Amani");

        // ارجع للمحتوى الرئيسي
        driver.switchTo().defaultContent();

        // اضغط على زر Bold
        driver.findElement(boldBtn).click();

        // التعامل مع الـ Alert
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text = " + alertText);

        // Assert نفس طريقة T1Ali
        assertTrue(alertText.toLowerCase().contains("bold"));

        // اغلق الـ alert
        alert.accept();
    }
}
