package assignments.day10;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase2;

import java.util.List;

public class Task4FindYoungestRecord extends TestBase2 {

    /*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add 10 records using Faker.
    Find the name of the youngest record.
    */

    @Test
    void findYoungestRecord() {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        logger.info("Add Record WebTable page is opened...");
        for (int i = 0; i < 10; i++) {
            actionHelper.sendKeys(By.id("nameInput"), Faker.instance().name().firstName());
            actionHelper.sendKeys(By.id("ageInput"), Faker.instance().number().numberBetween(18, 50) + "");
            Select select = new Select(actionHelper.findElement(By.id("countrySelect")));
            int idx = Faker.instance().number().numberBetween(1, 5);
            select.selectByIndex(idx);
            actionHelper.click(By.xpath("//button[.='Add Record']"));
        }
        List<WebElement> nameCells = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> ageCells = driver.findElements(By.xpath("//table//td[2]"));

        String youngestName = "";
        int youngestAge = Integer.MAX_VALUE;

        for (int i = 0; i < ageCells.size(); i++) {
            int age = Integer.parseInt(ageCells.get(i).getText());
            if (age < youngestAge) {
                youngestAge = age;
                youngestName = nameCells.get(i).getText();
            }
        }
        logger.info("The youngest person is: " + youngestName + " with age: " + youngestAge);
        System.out.println("The youngest person is: " + youngestName + " with age: " + youngestAge);
    }
}
