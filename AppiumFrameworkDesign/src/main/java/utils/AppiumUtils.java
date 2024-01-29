package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class AppiumUtils {

    AppiumServiceBuilder builder;

    AppiumDriverLocalService service;

    public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
        builder = new AppiumServiceBuilder();
        builder.withIPAddress(ipAddress);
        builder.usingPort(port);
        builder.withArgument(() -> "--relaxed-security"); // Add this line to enable relaxed security
        builder.withArgument(() -> "--allow-insecure", "chromedriver_autodownload");

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        return service;

    }

    //screenshot method
    public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destination));
        return destination;
    }
}
