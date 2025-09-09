package assignments.day3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02CheckboxInteraction {

    @Test
    public void testCheckboxes() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

        System.out.println("Checkbox 1 selected? " + checkbox1.isSelected());
        System.out.println("Checkbox 2 selected? " + checkbox2.isSelected());

        // انتظر 3 ثواني عشان تشوف
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
