package IOSAppTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Test
public class IOSBasicsTest extends IOSBaseTest{

    public void IOSBasics(){
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Text Entry")).click();
        driver.findElement(AppiumBy.className("XCUIElementTypeTextField")).sendKeys("Dhiraj");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();

        driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
        String text = driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText();
        System.out.println(text);
        driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Confirm\"") ).click();

    }


}
