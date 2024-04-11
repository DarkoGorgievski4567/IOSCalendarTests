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

public class CalendarHomePage{

    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Allow Once")
    private RemoteWebElement allowOnceButton;

    @iOSXCUITFindBy(accessibility = "Calendar")
    private RemoteWebElement calendarHomePageContainer;

    @iOSXCUITFindBy(accessibility = "Add")
    private RemoteWebElement addNewEventButton;

    @iOSXCUITFindBy(accessibility = "Calendars")
    private RemoteWebElement calendarsButton;

    public CalendarHomePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("User clicks on allow once button location pop-up")
    public void clickAllowOnceButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(allowOnceButton)).click();
    }

    @Step("Calendar home page is loaded")
    public boolean calendarHomePageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarHomePageContainer)).isDisplayed();
    }

    @Step("Add new event")
    public void addNewEvent(){
        addNewEventButton.click();
    }

    @Step("Navigate to month {0}")
    public void navigateToMonthView(String month){
        WebElement element = driver.findElement(AppiumBy.accessibilityId(month));
        element.click();
    }

    @Step("Choose calendars")
    public void chooseCalendars(){
        calendarsButton.click();
    }
}
