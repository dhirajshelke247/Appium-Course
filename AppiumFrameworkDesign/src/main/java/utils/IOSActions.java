package utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActions /*extends AppiumUtils */{

    IOSDriver driver;

    public IOSActions(IOSDriver driver) {
        this.driver = driver;
    }

    public void touchAndHold(WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        params.put("duration", 5);

        driver.executeScript("mobile:touchAndHold", params);

    }

    public void scrollGesture(WebElement ele) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) ele).getId());
        params.put("direction", "down");

        driver.executeScript("mobile:scroll", params);
    }

    public void swipeGesture() {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left"); // it will swipe from center by default (no need for coordinates)
        driver.executeScript("mobile:swipe", params);
    }

}
