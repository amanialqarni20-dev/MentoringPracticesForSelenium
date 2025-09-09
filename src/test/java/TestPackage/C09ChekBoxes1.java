package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C09ChekBoxes1 {

    @Test
    void demoqaCheckboxTest() throws InterruptedException {
        // إعداد خيارات المتصفح
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // تشغيل المتصفح
        WebDriver driver = new ChromeDriver(options);

        // الذهاب إلى URL
        driver.get("https://demoqa.com/");

        // الضغط على Elements
        WebElement elementsButton = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsButton.click();

        // الضغط على Check Box
        WebElement checkboxButton = driver.findElement(By.xpath("//span[text()='Check Box']"));
        checkboxButton.click();

        // اختيار الـ Home checkbox
        WebElement homeCheckbox = driver.findElement(By.cssSelector("span.rct-checkbox"));
        homeCheckbox.click();

        // التحقق إذا الـ Home checkbox محدد
        WebElement homeCheckboxInput = driver.findElement(By.cssSelector("input[id='tree-node-home']"));
        assertTrue(homeCheckboxInput.isSelected(), "❌ Home checkbox is not selected!");

        // التحقق أن النص "You have selected" ظاهر
        WebElement resultText = driver.findElement(By.id("result"));
        assertTrue(resultText.isDisplayed(), "❌ Result message is not visible!");

        // توقف بسيط عشان تلاحظ النتيجة
        Thread.sleep(3000);

        // إغلاق المتصفح
        driver.quit();
    }
}
