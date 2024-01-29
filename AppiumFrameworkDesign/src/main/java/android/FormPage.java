package android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AndroidActions;

import java.time.Duration;

public class FormPage extends AndroidActions {

    AndroidDriver driver;


    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countryDropDownBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleRadioBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleRadioBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopBtn;



    @AndroidFindBy(xpath ="//android.widget.TextView[@text=\"Login\"]")
    private WebElement loginBtn;




    public void clickLogin(){
        loginBtn.click();
    }


    public void setCountryCode(String countryName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(countryDropDownBtn));
        countryDropDownBtn.click();
        scrollToText(countryName);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"" + countryName + "\"]")).click();
    }

    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();

    }

    public void setGender(String gender) {
        if (gender == "Female") {
            femaleRadioBtn.click();
        } else {
            maleRadioBtn.click();
        }
    }

    public void submitForm() {
        letsShopBtn.click();
    }
}
