package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class EditCalendarPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Delete Calendar")
    private RemoteWebElement deleteCalendarButton;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Delete Calendar'`]")
    private RemoteWebElement confirmDeleteCalendarButton;

    public EditCalendarPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Delete calendar")
    public void deleteCalendar() {
        deleteCalendarButton.click();
        confirmDeleteCalendarButton.click();
    }
}
