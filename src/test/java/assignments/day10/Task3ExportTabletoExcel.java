package assignments.day10;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Task3ExportTabletoExcel extends TestBase2 {

    /*
    Go to https://claruswaysda.github.io/webTable.html
    Write the entire Table 1 to a new Excel sheet.
    */

    @Test
    void exportTableToExcel() throws IOException {
        driver.get("https://claruswaysda.github.io/webTable.html");
        logger.info("WebTable page is opened...");

        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tr"));
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Table1");
        for (int i = 0; i < rows.size(); i++) {
            Row excelRow = sheet.createRow(i);
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.isEmpty()) {
                cells = rows.get(i).findElements(By.tagName("th"));
            }

            for (int j = 0; j < cells.size(); j++) {
                Cell excelCell = excelRow.createCell(j);
                excelCell.setCellValue(cells.get(j).getText());
            }
        }

        String filePath = "WebTable1.xlsx";
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
        workbook.close();

        logger.info("Table 1 exported to Excel file: " + filePath);
    }
}
