package assignments.day7;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class Task5JavaScriptEventsTesting extends TestBase {

    @Test
    public void triggerAllEventsFixed() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement onblur = driver.findElement(By.id("onblur"));
        js.executeScript("arguments[0].focus(); arguments[0].blur();", onblur);
        js.executeScript("arguments[0].click();", driver.findElement(By.id("onclick")));
        WebElement oncontextmenu = driver.findElement(By.id("oncontextmenu"));
        js.executeScript(
                "arguments[0].dispatchEvent(new MouseEvent('contextmenu', {bubbles:true}));",
                oncontextmenu
        );
        WebElement ondblclick = driver.findElement(By.id("ondoubleclick"));
        js.executeScript(
                "arguments[0].dispatchEvent(new MouseEvent('dblclick', {bubbles:true}));",
                ondblclick
        );
        js.executeScript("arguments[0].focus();", driver.findElement(By.id("onfocus")));


        WebElement onkeydown = driver.findElement(By.id("onkeydown"));
        js.executeScript(
                "arguments[0].focus();" +
                        "arguments[0].dispatchEvent(new KeyboardEvent('keydown', {key:'a', bubbles:true}));",
                onkeydown
        );

        WebElement onkeypress = driver.findElement(By.id("onkeypress"));
        js.executeScript(
                "arguments[0].focus();" +
                        "arguments[0].dispatchEvent(new KeyboardEvent('keypress', {key:'a', bubbles:true}));",
                onkeypress
        );

        WebElement onkeyup = driver.findElement(By.id("onkeyup"));
        js.executeScript(
                "arguments[0].focus();" +
                        "arguments[0].dispatchEvent(new KeyboardEvent('keyup', {key:'a', bubbles:true}));",
                onkeyup
        );

        WebElement onmouseover = driver.findElement(By.id("onmouseover"));
        js.executeScript(
                "arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles:true}));",
                onmouseover
        );

        WebElement onmouseleave = driver.findElement(By.id("onmouseleave"));
        js.executeScript(
                "arguments[0].dispatchEvent(new MouseEvent('mouseleave', {bubbles:true}));",
                onmouseleave
        );


        WebElement onmousedown = driver.findElement(By.id("onmousedown"));
        js.executeScript(
                "arguments[0].dispatchEvent(new MouseEvent('mousedown', {bubbles:true}));",
                onmousedown
        );




        Thread.sleep(1000);
    }
}
