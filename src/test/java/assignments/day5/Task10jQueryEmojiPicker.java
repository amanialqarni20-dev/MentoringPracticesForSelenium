package assignments.day5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task10jQueryEmojiPicker extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // Go to URL
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // Maximize the page
        driver.manage().window().maximize();

        // Switch to iframe ندخل الفريم
        driver.switchTo().frame(driver.findElement(By.id("emoojis")));

        // Click on the second emoji tab
        driver.findElement(By.xpath("//a[@href='#nature']")).click();

        // Click all second emoji
        List<WebElement> emojis = driver.findElements(By.xpath("//div[@id='nature']//img"));
        for (WebElement emoji : emojis) {
            emoji.click();
        }

        // Switch back to parent frame
        driver.switchTo().defaultContent();

        // Fill the form
        driver.findElement(By.id("text")).sendKeys("smiles");
        driver.findElement(By.id("smiles")).sendKeys("smiles");
        driver.findElement(By.id("nature")).sendKeys("tree");
        driver.findElement(By.id("food")).sendKeys("pizza");
        driver.findElement(By.id("activities")).sendKeys("soccer");
        driver.findElement(By.id("places")).sendKeys("city");
        driver.findElement(By.id("objects")).sendKeys("car");
        driver.findElement(By.id("symbols")).sendKeys("heart");
        driver.findElement(By.id("flags")).sendKeys("saudi");
Thread .sleep(2000);

        // Click on apply button
        driver.findElement(By.id("send")).click();
    }
}