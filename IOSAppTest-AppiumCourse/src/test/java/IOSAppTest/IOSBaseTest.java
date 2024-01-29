package IOSAppTest;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class IOSBaseTest {
    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public AppiumServiceBuilder builder;

    @BeforeClass
    public void configureAppium() throws Exception {
        // Build and Start Appium Server
        builder = new AppiumServiceBuilder();
        builder.usingPort(4723);
        builder.withArgument(() -> "--relaxed-security"); // Add this line to enable relaxed security
        builder.withArgument(() -> "--allow-insecure", "chromedriver_autodownload");

        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        // Setting up Properties


        // List of Capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability("deviceName","iPhone 15 Pro");
        cap.setCapability("platformVersion","17.0");
        cap.setCapability("bundleId","com.apple.mobileslideshow");
//        cap.setCapability("bundleId","io.appium.TestApp");
//        cap.setCapability("bundleId","com.example.apple-samplecode.UICatalog");
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("WdaLaunchTimeout","20000");


//        <-- capabilities for real iOS device -->
//        cap.setCapability("xcodeOrgId",""); //ask developers or Team
//        cap.setCapability("xcodeSigningId","iPhone Developer");
//        cap.setCapability("udid",""); //mobile specific
//        cap.setCapability("updateWDABundleId","");


        URL url = new URL("http://127.0.0.1:4723");
        driver = new IOSDriver(url, cap);

        System.out.println("BaseTest passed, App Started");



    }
    public void touchAndHold(WebElement element){
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration", 5);

        driver.executeScript("mobile:touchAndHold",params);

    }

    public void scrollGesture(WebElement ele){
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)ele).getId());
        params.put("direction","down");

        driver.executeScript("mobile:scroll", params);
    }

    public void swipeGesture(){
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left"); // it will swipe from center by default (no need for coordinates)
        driver.executeScript("mobile:swipe", params);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver Quit");
        }

        if (service != null) {
            service.stop();
            System.out.println("Stopping Appium Service");
        }
    }
}
