package IOSAppTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.sql.rowset.WebRowSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOSSwipeTest extends IOSBaseTest {
    @Test
    public void swipe() throws InterruptedException {
        List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(allPhotos.size());

        driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell[1]")).click();

        Thread.sleep(2000);

        for (int i = 0; i < allPhotos.size(); i++) {
            System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
            swipeGesture(); //swipes from center by default (no need for coordinates)
        }

        driver.navigate().back();

    }
}
