package TestUtils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import utils.AppiumUtils;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class IOSBaseTest extends AppiumUtils {
    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public AppiumServiceBuilder builder;



    @BeforeClass(alwaysRun = true)
    public void configureAppium() throws Exception {

        // Setting up Properties
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
        prop.load(fis);
        String ipAddress = prop.getProperty("ipaddress");
        String port = prop.getProperty("port");



        // Build and Start Appium Server
        service = startAppiumServer(ipAddress,Integer.parseInt(port));

        // List of Capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability("deviceName", "iPhone 15 Pro");
        cap.setCapability("platformVersion", "17.0");
//        cap.setCapability("bundleId","com.apple.mobileslideshow");
//        cap.setCapability("bundleId","io.appium.TestApp");
        cap.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
        cap.setCapability("autoGrantPermissions", "true");
//        cap.setCapability("WdaLaunchTimeout","20000");

//        <-- capabilities for real iOS device -->
//        cap.setCapability("xcodeOrgId",""); //ask developers or Team
//        cap.setCapability("xcodeSigningId","iPhone Developer");
//        cap.setCapability("udid",""); //mobile specific
//        cap.setCapability("updateWDABundleId","");

        URL url = new URL("http://127.0.0.1:4723");
        driver = new IOSDriver(url, cap);

        System.out.println("AndroidBaseTest passed, App Started");

    }

    @AfterClass(alwaysRun = true)
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
