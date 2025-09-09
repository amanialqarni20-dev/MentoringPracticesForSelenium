package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C09ChekBoxes {

    @Test
    void checkboxes() throws InterruptedException {
        // إعداد خيارات المتصفح
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // يفتح المتصفح مكبر

        // تشغيل المتصفح
        WebDriver driver = new ChromeDriver(options);

        // الانتقال إلى صفحة الـ Checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // تحديد العناصر (checkboxes)
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        // اضغط على checkbox 1 إذا ما كان محدد
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

        // اضغط على checkbox 2 إذا ما كان محدد
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

        // تحقق أن checkbox 1 محدد
        assertTrue(checkbox1.isSelected(), " Checkbox 1 is not selected!");

        // خليه يوقف 3 ثواني عشان تشوف النتيجة
        Thread.sleep(3000);

        // إغلاق المتصفح
        driver.quit();
    }
}