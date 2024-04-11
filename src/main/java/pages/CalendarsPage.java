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

public class CalendarsPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == 'Calendars'`]")
    private RemoteWebElement calendarsPageHeader;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Add Calendar'`]")
    private RemoteWebElement addCalendarButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Hide All'`]")
    private RemoteWebElement hideAllButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeImage")
    private RemoteWebElement firstCalendarRadioButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeImage")
    private RemoteWebElement secondCalendarRadioButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText")
    private RemoteWebElement firstCalendarLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText")
    private RemoteWebElement secondCalendarLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton")
    private RemoteWebElement secondCalendarInfoButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Done')]")
    private RemoteWebElement doneButton;

    public CalendarsPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendars page is loaded")
    public boolean calendarsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarsPageHeader)).isDisplayed();
    }

    @Step("Add new calendar")
    public void addNewCalendar() {
        addCalendarButton.click();
        addCalendarButton.click();
    }

    @Step("Calendars exists")
    public boolean calendarExists(String calendarName) {
        WebElement element = driver.findElement(AppiumBy.accessibilityId(calendarName));
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    @Step("Hide all calendars")
    public void chooseHideAll() {
        hideAllButton.click();
    }

    @Step("Check if first calendar is selected")
    public boolean firstCalendarIsSelected(String calendarName) {
        if (firstCalendarLabel.getAttribute("value").equals(calendarName)) {
            return (firstCalendarRadioButton.isSelected());
        } else {
            System.out.println("Calendar doesn't exist");
            return true;
        }
    }

    @Step("Check if second calendar is selected")
    public boolean secondCalendarIsSelected(String calendarName) {
        if (secondCalendarLabel.getAttribute("value").equals(calendarName)) {
            return (secondCalendarRadioButton.isSelected());
        } else {
            System.out.println("Calendar doesn't exist");
            return true;
        }
    }

    @Step("Choose more info of second calendar")
    public void chooseMoreInfo() {
        secondCalendarInfoButton.click();
    }

    @Step("Exit calendars page")
    public void exitCalendars(){
        doneButton.click();
    }
}
