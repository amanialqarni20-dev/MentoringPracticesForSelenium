package assignments.day6;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class T1WindowHandleTest {

    @Test
    public void testWindowHandle() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://claruswaysda.github.io/");

            driver.findElement(By.linkText("Window Handle")).click();

            String mainWindow = driver.getWindowHandle();

            Set<String> allWindows = driver.getWindowHandles();
            for (String window : allWindows) {
                if (!window.equals(mainWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement openIndexButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='openIndex']"))
            );

            openIndexButton.click();

            allWindows = driver.getWindowHandles();
            for (String window : allWindows) {
                if (!window.equals(mainWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            String expectedUrl = "https://claruswaysda.github.io/index.html";
            String actualUrl = driver.getCurrentUrl();
            if (expectedUrl.equals(actualUrl)) {
                System.out.println("URL verification PASSED");
            } else {
                System.out.println("URL verification FAILED");
            }

            //  Close the index page and return to main window
            driver.close();  // يغلق الصفحة الحالية
            driver.switchTo().window(mainWindow);  // يرجع للمين
Thread .sleep(4000); // فقط للمشاهدة
        } finally {
            driver.quit();
        }
    }
}
