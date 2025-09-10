package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
In Selenium, waits are used to handle the synchronization between the script
and the web application. Since web elements may take time to load, appear, or
become clickable, using waits ensures that the script interacts with elements
only when they are ready. Without waits, tests may fail due to timing issues
like ElementNotFoundException.

Selenium provides three types of waits:
    1)  Implicit Wait (applies a global timeout for element searches),
    2)  Explicit Wait (waits for specific conditions like visibility or clickability)
    3)  Fluent Wait (a more flexible wait with polling frequency and exception handling).

    Using waits properly makes tests more stable and reliable.
 */
public class C13ExplicitWaitAndFluentWait {
    WebDriver driver;
    String url = "";

    @Test
    void expliciteWaitTest()  {
/*
    Specifies the condition and the time that WebDriver should wait.
    In practice, WebDriverWait and Explicit Wait are synonymous,
    since their definitions and usage perfectly match.

    // How to use Explicit Wait
    // 1- Create a WebDriverWait object
    // 2- Pass the desired condition to the 'until' method of the wait object
*/

        //    Go to https://webdriveruniversity.com/Popup-Alerts/index.html

        //    Click on Ajax Loader

        //    Click on 'Click Me'

        //    Assert text "Well Done For Waiting....!!!"

    }
    @Test
    void fluemtWaitTest() throws InterruptedException {
/*
   Fluent Wait is a type of Explicit Wait that allows you to define:
   - The maximum time to wait for a condition
   - The polling period (how often to check the condition)
   - Ignored exceptions while waiting (e.g., NoSuchElementException)
   It provides more flexibility than Implicit and Explicit Wait.
*/


        //    Go to https://webdriveruniversity.com/Popup-Alerts/index.html

        //    Click on Ajax Loader

        //    Click on 'Click Me'

        //    Assert text "Well Done For Waiting....!!!"

    }
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
/*

        // 1. elementToBeClickable

        wait.until(ExpectedConditions.elementToBeClickable(clickButtonId));
        // Custom static method equivalent
        public static WebElement elementToBeClickable (WebDriver driver, By locator){
            WebElement element = driver.findElement(locator);
            if (element.isDisplayed() && element.isEnabled()) {
                return element;
            }
            return null;
        }
// Lambda equivalent
        wait.until(d -> {
            WebElement e = d.findElement(clickButtonId);
            return (e.isDisplayed() && e.isEnabled()) ? e : null;
        });

// 2. visibilityOfElementLocated
        wait.until(ExpectedConditions.visibilityOfElementLocated(textByXpath));
        // Custom static method equivalent
        public static WebElement visibilityOfElementLocated (WebDriver driver, By locator){
            WebElement element = driver.findElement(locator);
            if (element.isDisplayed() && element.getSize().getHeight() > 0 && element.getSize().getWidth() > 0) {
                return element;
            }
            return null;
        }
// Lambda equivalent
        wait.until(d -> {
            WebElement e = d.findElement(textByXpath);
            return (e.isDisplayed() && e.getSize().getHeight() > 0 && e.getSize().getWidth() > 0) ? e : null;
        });

// 3. presenceOfElementLocated
        wait.until(ExpectedConditions.presenceOfElementLocated(someBy));
        // Custom static method
        public static WebElement presenceOfElementLocated (WebDriver driver, By locator){
            return driver.findElement(locator); // returns immediately if present in DOM
        }
// Lambda equivalent
        wait.until(d -> d.findElement(someBy));

// 4. invisibilityOfElementLocated
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBy));
        // Custom static method
        public static Boolean invisibilityOfElementLocated (WebDriver driver, By locator){
            try {
                WebElement e = driver.findElement(locator);
                return !e.isDisplayed();
            } catch (NoSuchElementException ex) {
                return true;
            }
        }
// Lambda equivalent
        wait.until(d -> {
            try {
                WebElement e = d.findElement(loadingBy);
                return !e.isDisplayed();
            } catch (NoSuchElementException ex) {
                return true;
            }
        });

// 5. textToBePresentInElement
        wait.until(ExpectedConditions.textToBePresentInElement(messageBy, "Success"));
        // Custom static method
        public static Boolean textToBePresentInElement (WebDriver driver, By locator, String text){
            try {
                return driver.findElement(locator).getText().contains(text);
            } catch (NoSuchElementException ex) {
                return false;
            }
        }
// Lambda equivalent
        wait.until(d -> {
            try {
                return d.findElement(messageBy).getText().contains("Success");
            } catch (NoSuchElementException ex) {
                return false;
            }
        });

// 6. titleContains
        wait.until(ExpectedConditions.titleContains("Dashboard"));
// Lambda equivalent
        wait.until(d -> d.getTitle().contains("Dashboard"));

// 7. urlContains
        wait.until(ExpectedConditions.urlContains("account"));
// Lambda equivalent
        wait.until(d -> d.getCurrentUrl().contains("account"));


 */
