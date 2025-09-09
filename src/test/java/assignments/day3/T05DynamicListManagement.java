package assignments.day3;

import com.github.javafaker.Faker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T05DynamicListManagement {

    private WebDriver driver;
    private Faker faker; //  متغير كلاس

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        faker = new Faker(); //  تهيئة
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
    }

    @Test
    public void testDynamicTodoList() throws InterruptedException {
        // 1. Generate 5 random task names and add them to the list
        for (int i = 0; i < 5; i++) {
            String task = faker.lorem().word(); // ✅ يشتغل الآن
            WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));
            inputField.sendKeys(task);
            inputField.sendKeys(Keys.ENTER);
        }

        List<WebElement> tasks = driver.findElements(By.xpath("//li"));

        // 3. Mark every other task as completed (strikethrough)
        for (int i = 0; i < tasks.size(); i += 2) {
            tasks.get(i).click();
        }

        Thread.sleep(1000); // Small wait to see changes

        // 4. Delete all completed tasks
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//li[@class='completed']/i"));
        for (WebElement deleteBtn : deleteButtons) {
            deleteBtn.click();
        }

        Thread.sleep(1000); // Small wait after deletion

        // 5. Verify only incomplete tasks remain
        List<WebElement> remainingTasks = driver.findElements(By.xpath("//li[not(@class='completed')]"));
        for (WebElement task : remainingTasks) {
            System.out.println("Remaining task: " + task.getText());
            assertTrue(!task.getAttribute("class").contains("completed"));
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
