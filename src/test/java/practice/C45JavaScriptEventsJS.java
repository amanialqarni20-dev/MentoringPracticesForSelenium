package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C45JavaScriptEventsJS extends TestBase {

    @Test
    public void javaScriptEventsWithJSExecutor() throws InterruptedException {

        // 1. Navigate to the JavaScript events test page
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        // 2. Locate all the buttons on the page
        List<WebElement> buttons = driver.findElements(By.cssSelector("#events > button"));
        System.out.println("[INFO] Total buttons: " + buttons.size());

        // 3. Create JavascriptExecutor instance
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 4. Trigger different events for each button
        for (WebElement button : buttons) {
            String btnId = button.getAttribute("id");

            // Choose the event type according to the button text/id
            if (btnId.contains("double")) {
                js.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', {bubbles:true}))", button);
            } else if (btnId.contains("context")) {
                js.executeScript("arguments[0].dispatchEvent(new MouseEvent('contextmenu', {bubbles:true}))", button);
            } else if (btnId.contains("mouseover")) {
                js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles:true}))", button);
            } else if (btnId.contains("mousedown")) {
                js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mousedown', {bubbles:true}))", button);
            } else if (btnId.contains("mouseup")) {
                js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseup', {bubbles:true}))", button);
            } else if (btnId.contains("mousemove")) {
                js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mousemove', {bubbles:true}))", button);
            } else if (btnId.contains("blur")) {
                // focus then blur
                js.executeScript("arguments[0].focus(); arguments[0].blur();", button);
            } else if (btnId.contains("focus")) {
                js.executeScript("arguments[0].focus();", button);
            } else {
                // default: simple click
                js.executeScript("arguments[0].click();", button);
            }
            Thread.sleep(200); // Small wait to see the effect
        }

        // 5. Verify that all events were triggered
        List<WebElement> msgs = driver.findElements(By.cssSelector("p[id^='event']"));
        long triggered = msgs.stream()
                .filter(m -> m.getText().contains("Event Triggered"))
                .count();

        System.out.println("[INFO] Triggered events count: " + triggered);

        // 6. Assert all buttons fired their event
        Assertions.assertEquals(buttons.size(), triggered,
                "Some buttons did not fire their events!");
    }
}
