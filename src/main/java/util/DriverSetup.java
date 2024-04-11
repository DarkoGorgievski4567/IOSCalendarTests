package util;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import io.qameta.allure.Step;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

@Listeners({ ITestListenerUtility.class })
public class DriverSetup extends ConfigReader{

    public static IOSDriver driver;

    protected CalendarHomePage calendarHomePage;
    protected CreateEventPage createEventPage;
    protected CalendarMonthPage calendarMonthPage;
    protected CalendarsPage calendarsPage;
    protected CreateNewCalendarPage createNewCalendarPage;
    protected EditCalendarPage editCalendarPage;

    @Step("Driver is started")
    @BeforeMethod
    public void setUp() {

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(getProperty("device.name"))
                .setPlatformVersion(getProperty("platform.version"))
                .setBundleId(getProperty("bundle.id"))
                .setNoReset(true)
                .setAutoAcceptAlerts(true);

        try {
            driver = new IOSDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        calendarHomePage = new CalendarHomePage(driver);
        createEventPage = new CreateEventPage(driver);
        calendarMonthPage = new CalendarMonthPage(driver);
        calendarsPage = new CalendarsPage(driver);
        createNewCalendarPage = new CreateNewCalendarPage(driver);
        editCalendarPage = new EditCalendarPage(driver);
    }

    @Step("Driver is closed")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

