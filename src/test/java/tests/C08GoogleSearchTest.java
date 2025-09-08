package Tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class C08GoogleSearchTest {
    static WebDriver driver;
    static WebDriverWait wait;
    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void searchMovies() {
        String[] movies = {"Green Mile", "Premonition", "The Curious Case of Benjamin Button"};

        for (String movie : movies) {
            //  صندوق البحث
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            searchBox.clear();
            searchBox.sendKeys(movie);
            searchBox.sendKeys(Keys.ENTER);
            WebElement resultStats = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
            System.out.println(movie + " → " + resultStats.getText());
            driver.navigate().back();
            wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}