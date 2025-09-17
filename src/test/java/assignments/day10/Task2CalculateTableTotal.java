package assignments.day10;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase2;

import java.util.List;

public class Task2CalculateTableTotal extends TestBase2 {

    /*
    Go to https://claruswaysda.github.io/webTable.html
    Calculate and assert the total price in Table 2.
    */

    @Test
    void calculateTableTotal() {

        driver.get("https://claruswaysda.github.io/webTable.html");
        logger.info("WebTable page is opened...");

        List<WebElement> priceCells = driver.findElements(By.xpath("//table[2]//tr/td[3]"));
        double[] prices = new double[priceCells.size()];
        double totalPrice = 0.0;

        for (int i = 0; i < priceCells.size(); i++) {
            String priceText = priceCells.get(i).getText().replace("$", "").trim();
            prices[i] = Double.parseDouble(priceText);
            totalPrice += prices[i];
        }

        logger.info("Prices in Table 2:");
        for (double p : prices) {
            logger.info("$" + p);
        }

        logger.info("Calculated Total Price: $" + totalPrice);
        double expectedTotalPrice = 0.0;
        for (double p : prices) expectedTotalPrice += p;
        assert totalPrice == expectedTotalPrice : "Total price mismatch! Expected: $" + expectedTotalPrice + ", but got: $" + totalPrice;
    }
}
