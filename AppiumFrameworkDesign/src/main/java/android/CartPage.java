package android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidActions;

import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBox;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement Tnc;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement OKBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceedBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productPrices;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmountLbl;

//    public void getTotalAmount() throws InterruptedException {
//        int productCount = productPrices.size();
//        double totalAmountSum = 0;
//        for (int i = 0; i < productCount; i++) {
//            String amountString = productPrices.get(i).getText();
//            Double price = Double.parseDouble(amountString.substring(1));
//            totalAmountSum = totalAmountSum + price;
//        }
//        Thread.sleep(1000);
//
//        String displaySum = totalAmountLbl.getText();
//        Assert.assertEquals("$ " + totalAmountSum, displaySum);
//
//    }

    public void setCheckBox() {
        checkBox.click();
    }

    public void viewTnC() {
        longPressAction(Tnc);
        OKBtn.click();
    }

    public void proceedOrder() {
        proceedBtn.click();
    }

}
