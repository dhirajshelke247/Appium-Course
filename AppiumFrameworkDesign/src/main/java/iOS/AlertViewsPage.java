package iOS;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.IOSActions;

public class AlertViewsPage extends IOSActions {

    IOSDriver driver;

    public AlertViewsPage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "Text Entry")
    private WebElement textEntry;

    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    private WebElement inputValue;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement OKBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
    private WebElement ConfirmCancelBtn;


    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message'")
    private WebElement message;


    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Confirm\"")
    private WebElement ConfirmBtn;



    public void selectTextEntry(){
        textEntry.click();
    }

    public void setInputValue(String text){
        inputValue.sendKeys(text);
        OKBtn.click();
    }

    public void ConfirmCancelActionSheet(){
        ConfirmCancelBtn.click();
        String text = message.getText();
        System.out.println(text);
        ConfirmBtn.click();

    }



}
