package iOSTests;


import TestUtils.IOSBaseTest;
import iOS.AlertViewsPage;
import iOS.HomePage;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

public class iOSAppTest extends IOSBaseTest {



    @Test
    public void homePageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectAlertViews();
    }

    @Test(priority = 1)
    public void AlertViewsPageTest() {
        AlertViewsPage alertViewsPage = new AlertViewsPage(driver);
        alertViewsPage.selectTextEntry();
        alertViewsPage.setInputValue("Dhiraj");
        alertViewsPage.ConfirmCancelActionSheet();
    }





}
