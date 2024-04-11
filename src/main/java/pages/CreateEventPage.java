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

public class CreateEventPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Title")
    private RemoteWebElement createEventTitleField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"New Event\"`]")
    private RemoteWebElement newEventPageHeader;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[1]")
    private RemoteWebElement hourPicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[2]")
    private RemoteWebElement minutePicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[contains(@name, 'Starts')]/XCUIElementTypeButton/XCUIElementTypeButton)[2]")
    private RemoteWebElement startsHourPickerButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[contains(@name, 'Starts')]/XCUIElementTypeButton/XCUIElementTypeButton)[1]")
    private RemoteWebElement startsDatePickerButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Starts')]")
    private RemoteWebElement startsPickerButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Show year picker')]")
    private RemoteWebElement datePickerButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[1]")
    private RemoteWebElement monthPicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[2]")
    private RemoteWebElement yearPicker;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,'Forward')]")
    private RemoteWebElement switchToDayButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[contains(@name, 'Ends')]/XCUIElementTypeButton/XCUIElementTypeButton)[2]")
    private RemoteWebElement endsHourPickerButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Ends')]")
    private RemoteWebElement endsPickerButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'Travel Time')]")
    private RemoteWebElement travelTimePickerButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`name == 'All-day'`]")
    private RemoteWebElement allDayToogle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Add'`]")
    private RemoteWebElement addEventButton;


    public CreateEventPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("New event page is loaded")
    public boolean createEventPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newEventPageHeader)).isDisplayed();
    }

    @Step("Add event title")
    public void addEventTitle(String title) {
        createEventTitleField.sendKeys(title);
    }
    @Step("Choose start hour {0}, minute {1}")
    public void chooseStartHour(String hour, String minutes) {
        startsHourPickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(hourPicker)).sendKeys(hour);
        minutePicker.sendKeys(minutes);
    }

    @Step("Tap to starts of event")
    public void tapOnStartsEvent(){
        startsPickerButton.click();
    }

    @Step("Choose date {0}, month {1}, year {2}")
    public void chooseDate(String day, String month, String year) {
        datePickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(monthPicker)).sendKeys(month);
        yearPicker.sendKeys(year);
        switchToDayButton.click();
        WebElement element = driver.findElement(AppiumBy.accessibilityId(day));
        element.click();
    }

    @Step("Choose end hour {0}, minute {1}")
    public void chooseEndHour(String hour, String minutes) {
        endsHourPickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(hourPicker)).sendKeys(hour);
        minutePicker.sendKeys(minutes);
    }

    @Step("Tap ends of event")
    public void tapOnEndsEvent(){
        endsPickerButton.click();
    }

    @Step("Choose travel time")
    public void chooseTravelTime(String time){
        travelTimePickerButton.sendKeys(time);
    }

    @Step("Choose all day")
    public void chooseAllDay(){
        allDayToogle.click();
    }

    @Step("Add event")
    public void createEvent(){
        addEventButton.click();
    }

}

