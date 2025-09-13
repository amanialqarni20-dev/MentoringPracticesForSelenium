package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T3DeleteChars extends TestBase {

    /*
    Go to https://claruswaysda.github.io/deleteChars.html
    Enter your full name
    Delete the letters
    Verify the message 'Deleted'
    */

    By field = By.xpath("//input[@type='text']");
    By enterButton = By.id("enterButton");
    By deleteButton = By.id("deleteButton");
    By messageId = By.id("deletedMessage");
    String deletedMessage = "Deleted";
    String nameExample = "John Doe";

    @Test
    void test03() {
        driver.get("https://claruswaysda.github.io/deleteChars.html");
        driver.findElement(field).sendKeys(nameExample);
        driver.findElement(enterButton).click();

        for(int i= 0 ; i < nameExample.length(); i++){
            driver.findElement(deleteButton).click();
        }

        String message = driver.findElement(messageId).getText();
        Assertions.assertEquals(deletedMessage,message);
    }

}