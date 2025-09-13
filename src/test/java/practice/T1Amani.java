package practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

class T1Amani extends TestBase {
    /*
      Go to https://claruswaysda.github.io/ActionsForm.html
      Fill all fields
      Generate Passcode
      Use passcode to submit form
      Go to iframe page
      Type name and click Bold button
      Assert alert message
     */

    // --- ActionsForm locators ---
    By nameId = By.id("name");
    By emailId = By.id("email");
    By passwordId = By.id("password");

    By radioMale = By.id("male");
    By expRadio = By.id("exp-5");

    By professionManual = By.id("manual");
    By professionAutomation = By.id("automation");

    By toolSelenium = By.id("tool-2");

    By continentSelect = By.id("continents");
    By commandsSelect = By.id("selenium_commands");

    By generateBtn = By.id("generate");
    By passcodeInput = By.id("passcodeInput");
    By submitBtn = By.id("submitBtn");
    By successMsg = By.id("successMessage");

    // --- Iframe locators ---
    By iframe = By.id("mce_0_ifr");
    By inputBox = By.id("tinymce");
    By boldBtn = By.xpath("//button[@title='Bold']");

    @Test
    void testCompleteFlow() {
        // --- Fill ActionsForm ---
        driver.get("https://claruswaysda.github.io/ActionsForm.html");

        driver.findElement(nameId).sendKeys("Amani AlQarni");
        driver.findElement(emailId).sendKeys("amani@example.com");
        driver.findElement(passwordId).sendKeys("Password123");

        driver.findElement(radioMale).click();
        driver.findElement(expRadio).click();

        driver.findElement(professionManual).click();
        driver.findElement(professionAutomation).click();

        driver.findElement(toolSelenium).click();

        Select continent = new Select(driver.findElement(continentSelect));
        continent.selectByVisibleText("Europe");

        Select commands = new Select(driver.findElement(commandsSelect));
        commands.selectByVisibleText("Navigation Commands");
        commands.selectByVisibleText("WebElement Commands");

        // Generate passcode
        driver.findElement(generateBtn).click();

        // استخراج passcode من الـ alert
        Alert passAlert = driver.switchTo().alert();
        String passcode = passAlert.getText().substring(passAlert.getText().indexOf(":") +1).trim();
        System.out.println("Passcode: " + passcode);
        passAlert.accept();

        // إدخال passcode + Submit
        driver.findElement(passcodeInput).sendKeys(passcode);
        driver.findElement(submitBtn).click();

        // تأكيد نجاح الإرسال
        assertTrue(driver.findElement(successMsg).isDisplayed());

        // --- انتقل لصفحة iframe ---
        driver.get("https://claruswaysda.github.io/iframe.html");

        // switch to iframe
        WebElement frame = driver.findElement(iframe);
        driver.switchTo().frame(frame);

        // اكتب الاسم داخل المحرر
        WebElement input = driver.findElement(inputBox);
        input.clear();
        input.sendKeys("Amani AlQarni");

        // ارجع للمحتوى الرئيسي
        driver.switchTo().defaultContent();

        // اضغط على زر Bold
        driver.findElement(boldBtn).click();

        // التعامل مع الـ Alert
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text = " + alertText);

        // تحقق من نص الـ alert
        assertTrue(alertText.toLowerCase().contains("bold"));
        alert.accept();
    }
}
