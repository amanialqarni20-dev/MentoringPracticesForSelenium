package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

public class C38DownLoadFile02 extends TestBase {
    @Test
    void name() throws InterruptedException, IOException {
        String name = "Admin";
        String password = "admin123";
        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Login page valid credentials.
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click PIM on the left side bar
        driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper'][2]")).click();

        //Click Configuration and select Data Import
        driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent']")).click();
        driver.findElement(By.xpath("//a[.='Data Import']")).click();
        driver.findElement(By.xpath("//*[.='Download']")).click();
        Thread.sleep(3000);

        //Download sample CSV file.

        //Verify if the file downloaded successfully.
  }
}