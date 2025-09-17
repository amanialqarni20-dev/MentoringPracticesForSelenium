package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C49WebTables02 extends TestBase {
    /*
        Go to URL: https://the-internet.herokuapp.com/tables
        Print the entire table
        Print All Rows
        Print Last row data only
        Print column 5 data in the table body
        Write a method that accepts 2 parameters
        parameter 1 = row number
        parameter 2 = column number
    */

    @Test
    public void webTableTest() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println("=== Entire Table ===");
        System.out.println(table.getText());
        System.out.println("\n=== All Rows ===");
        List<WebElement> allRows = table.findElements(By.xpath(".//tbody/tr"));
        for (WebElement row : allRows) {
            System.out.println(row.getText());
        }

        System.out.println("\n=== Last Row ===");
        WebElement lastRow = table.findElement(By.xpath(".//tbody/tr[last()]"));
        System.out.println(lastRow.getText());
        System.out.println("\n=== Column 5 Data ===");
        List<WebElement> col5 = table.findElements(By.xpath(".//tbody/tr/td[5]"));
        for (WebElement cell : col5) {
            System.out.println(cell.getText());
        }


        System.out.println("\n=== Cell (row=2, col=3) ===");
        String cellValue = getCellValue(2, 3);
        System.out.println(cellValue);
    }

    private String getCellValue(int rowNumber, int colNumber) {
        String xpath = "//table[@id='table1']//tbody//tr[" + rowNumber + "]//td[" + colNumber + "]";
        WebElement cell = driver.findElement(By.xpath(xpath));
        return cell.getText();
    }
}
