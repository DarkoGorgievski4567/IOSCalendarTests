package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class CreateNewCalendarPage{

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == 'Add Calendar'`]")
    private RemoteWebElement newCalendarPageHeader;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == 'Calendar Name'`]")
    private RemoteWebElement calendarTitleField;

    @iOSXCUITFindBy(accessibility = "Purple")
    private RemoteWebElement colorPurpleCalendarButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Add Calendar'`]")
    private RemoteWebElement addCalendarButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Done'`]")
    private RemoteWebElement doneButton;

    public CreateNewCalendarPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Create new calendar page is loaded")
    public boolean createNewCalendarPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newCalendarPageHeader)).isDisplayed();
    }

    @Step("Add calendar title")
    public void addCalendarTitle(String title){
        calendarTitleField.sendKeys(title);
    }

    @Step("Add color to calendar")
    public void changeColor(String color){
        colorPurpleCalendarButton.click();
        WebElement element = driver.findElement(AppiumBy.accessibilityId(color));
        element.click();
        addCalendarButton.click();
    }

    @Step("Save calendar")
    public void saveCalendar(){
        doneButton.click();
    }
}
