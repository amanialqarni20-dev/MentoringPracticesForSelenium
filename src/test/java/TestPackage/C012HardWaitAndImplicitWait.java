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
public class C012HardWaitAndImplicitWait {
    WebDriver driver;
    String url = "";

    @Test
    void hardWaitTest() throws InterruptedException {
        // Time-based synchronization - Static wait
        // Static wait represents waiting for a fixed amount of time
        // The execution continues only after the specified time has passed
        // In Selenium with Java, we use the Thread.sleep() method to implement static waits
        // It is not recommended for dynamic web applications, as it may cause unnecessary delays or failures


        //    Go to https://webdriveruniversity.com/Popup-Alerts/index.html
        //    Click on Ajax Loader
        //    Click on 'Click Me'
        //    Assert text "Well Done For Waiting....!!!"

    }

    @Test
    void implicitWaitTest() throws InterruptedException {
/*
    Implicit wait assigns a default waiting time for all elements on the page.
    However, once the element is found, it stops waiting immediately.
    This applies to all elements on the page and waits until the specified time for an element to be located.
    In other words, it waits for the given duration to avoid NoSuchElementException.
    Implicit wait is global, meaning the same wait time is applied to all web elements.
*/
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Sets a global wait for all elements (no need to set again for each one)

        //    Go to https://webdriveruniversity.com/Popup-Alerts/index.html
        //    Click on Ajax Loader
        //Thread.sleep(6000);
        //    Click on 'Click Me'
        //    Assert text "Well Done For Waiting....!!!"

    }
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
