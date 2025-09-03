package assignments01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T2Day01 {
    public static void main(String[] args) throws InterruptedException {

        // Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

        // Go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        // انتظر 3 ثواني قبل جلب العنوان
        Thread.sleep(3000); // توقف 3 ثواني لانتظار تحميل الصفحة

        // Verify the page title contains the word video
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        if(title.toLowerCase().contains("video")) {
            System.out.println("Title verification PASSED");
        } else {
            System.out.println("Title verification FAILED");
        }

        // Close the driver
        driver.quit();
    }
}