package TestUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.AndroidActions;
import utils.AppiumUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtils {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;


    @BeforeClass(alwaysRun = true)
    public void configureAppium() throws Exception {

        // Setting up Properties
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
        prop.load(fis);
        String ipAddress = prop.getProperty("ipaddress");
        String port = prop.getProperty("port");

        // Build and Start Appium Server
        service = startAppiumServer(ipAddress, Integer.parseInt(port));

        // List of Capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("appPackage", "ca.manypenny");
        cap.setCapability("appActivity", "ca.manypenny.MainActivity");
        cap.setCapability("app", "/Users/dhirajkailasshelke/Downloads/app-release (12).apk");
        cap.setCapability("chromedriverExecutable", "/Users/dhirajkailasshelke/Downloads/chromedriver 2");


//        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(service.getUrl(), cap);

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
