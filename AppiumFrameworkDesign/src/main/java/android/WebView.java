package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidActions;

public class WebView extends AndroidActions {
    AndroidDriver driver;

    public WebView(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Image[@resource-id=\"hplogo\"]")
    private WebElement logo;

    @FindBy(name = "q")
    private WebElement searchField;

    public void verifyGoogleLogo()
    {
        String verifyLogo = logo.getAttribute("text");
        Assert.assertEquals(verifyLogo,"Google");
    }

    public void setContext()
    {
        driver.context("WEBVIEW_com.androidsample.generalstore");
    }

    public void autmateWebView(String searchTerm) throws InterruptedException {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
        driver.context("NATIVE_APP");
    }
}
