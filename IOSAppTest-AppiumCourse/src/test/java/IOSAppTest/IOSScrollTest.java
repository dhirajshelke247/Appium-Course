package IOSAppTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IOSScrollTest extends IOSBaseTest{

    @Test
    public void scrollTest() throws InterruptedException{
        WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
        scrollGesture(ele);
        ele.click();
        Thread.sleep(3000);
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("30");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("200");
        driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("100");




    }
}
