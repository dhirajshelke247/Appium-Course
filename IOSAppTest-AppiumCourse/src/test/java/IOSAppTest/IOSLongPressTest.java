package IOSAppTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IOSLongPressTest extends IOSBaseTest{

    @Test
    public void longPressTest(){
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Increment\"`][3]"));
        touchAndHold(ele);


    }
}
