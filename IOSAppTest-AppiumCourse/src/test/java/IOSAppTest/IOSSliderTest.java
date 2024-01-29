package IOSAppTest;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IOSSliderTest extends IOSBaseTest{

    @Test
    public void sliderTest() throws  InterruptedException{
       WebElement slider =  driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \"AppElem\"`]"));
       slider.sendKeys("0.3%");
       System.out.println(slider.getAttribute("value"));
       Thread.sleep(3000);
       slider.sendKeys("0.75%");
       System.out.println(slider.getAttribute("value"));
       Thread.sleep(2000);


    }
}
