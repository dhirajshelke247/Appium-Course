package androidTests;

import TestUtils.AndroidBaseTest;
import android.CartPage;
import android.FormPage;
import android.ProductCatalogue;
import android.WebView;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GeneralStoreAppTest extends AndroidBaseTest {

    @Test(groups = {"Smoke"})
    public void fillform() throws InterruptedException {

        FormPage formPage = new FormPage(driver);

//        formPage.clickLogin();

        formPage.setCountryCode("Belgium");
        formPage.setNameField("Dhiraj");
        formPage.setGender("Male");
        formPage.submitForm();
        Thread.sleep(2000);

    }

    @Test(priority = 1, groups = {"Smoke"})
    public void productCatalogue() throws InterruptedException {

        ProductCatalogue productCatalogue = new ProductCatalogue(driver);

        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0);

        productCatalogue.goToCart();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void cartPage() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);

//        cartPage.getTotalAmount();
        cartPage.setCheckBox();
        cartPage.viewTnC();
        cartPage.proceedOrder();

    }

    @Test(priority = 3)
    public void webView() throws InterruptedException {
        WebView webView = new WebView(driver);

        Thread.sleep(10000);

        webView.verifyGoogleLogo();
        webView.setContext();
        webView.autmateWebView("GeekyAnts");
    }
}
