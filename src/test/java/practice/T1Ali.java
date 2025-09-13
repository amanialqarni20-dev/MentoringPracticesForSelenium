package practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class T1Ali extends TestBase {
    /*
    Go to https://claruswaysda.github.io/ActionsForm.html
    Fill the form
    Generate Passcode
    Use passcode to submit form
     */
    By nameId = By.id("name");
    By ageId = By.id("age");
    By selectID = By.id("options");
    By checkbox1value = By.xpath("//label[normalize-space()='Coding']");
    By checkbox2value = By.xpath("//label[normalize-space()='design']");
    By checkbox3value = By.xpath("//label[.=' Management']");
    By radioMale = By.xpath("//input[@value='male']");
    By radioFemale = By.xpath("//input[@value='female']");
    By radioOther = By.xpath("//input[@value='other']");
    By submitButton = By.xpath("//button[@type='button']");

    @Test
    void test01() {
        driver.get("https://claruswaysda.github.io/ActionsForm.html");
        driver.findElement(nameId).sendKeys("John Doe");
        driver.findElement(ageId).sendKeys("30");
        Select select = new Select(driver.findElement(selectID));
        select.selectByValue("it");
        driver.findElement(checkbox1value).click();
        driver.findElement(checkbox3value).click();
        driver.findElement(radioMale).click();
        driver.findElement(submitButton).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String passcode = alertText.substring(alertText.indexOf(":") +1).trim();
        System.out.println("Passcode is: " + passcode);
        alert.accept();
        alert.sendKeys(passcode);
        alert.accept();
    }
}
