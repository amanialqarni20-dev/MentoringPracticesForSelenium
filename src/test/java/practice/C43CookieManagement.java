package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C43CookieManagement extends TestBase {

    /*
        Go to https://claruswaysda.github.io/CookiesWait.html
        Print the cookies
        Delete all cookies and assert
    */

    @Test
    void cookieManagementTest() {


        driver.get("https://claruswaysda.github.io/CookiesWait.html");
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("[INFO] Total cookies: " + cookies.size());
        for (Cookie cookie : cookies) {
            System.out.println("[COOKIE] " + cookie.getName() + " = " + cookie.getValue());
        }
        driver.manage().deleteAllCookies();
        System.out.println("[INFO] All cookies deleted.");

        Assertions.assertTrue(driver.manage().getCookies().isEmpty(),
                " Cookies were not deleted successfully");
        System.out.println("[INFO] Cookies cleared successfully!");
    }
}
