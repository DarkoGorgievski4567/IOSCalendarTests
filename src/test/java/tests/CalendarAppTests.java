package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.DriverSetup;

public class CalendarAppTests extends DriverSetup {

    @Test(testName = "Calendar add new event test")
    @Severity(SeverityLevel.CRITICAL)
    public void calendarAddNewEventTest() {
        calendarHomePage.clickAllowOnceButton();
        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");
        calendarHomePage.addNewEvent();
        Assert.assertTrue(createEventPage.createEventPageLoaded(), "Event page is not loaded");
        createEventPage.addEventTitle("Meeting with HR");
        createEventPage.chooseStartHour("11", "10");
        createEventPage.tapOnStartsEvent();
        createEventPage.chooseDate("24","4","2024");
        createEventPage.tapOnStartsEvent();
        createEventPage.chooseEndHour("12", "25");
        createEventPage.tapOnEndsEvent();
        createEventPage.chooseDate("25","4","2024");
        createEventPage.chooseTravelTime("30 minutes");
        createEventPage.chooseAllDay();
        createEventPage.chooseAllDay();
        createEventPage.createEvent();
        calendarHomePage.navigateToMonthView("April");
        Assert.assertTrue(calendarMonthPage.calendarMonthPageLoaded(), "Calendar month page is not loaded");
        Assert.assertTrue(calendarMonthPage.eventExists("Wednesday, 24 April"), "Event doesn't exist");
        Assert.assertTrue(calendarMonthPage.eventExists("Wednesday, 25 April"), "Event doesn't exist");
    }

    @Test(testName = "Add new calendar test")
    public void addNewCalendarTest() {
        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");
        calendarHomePage.chooseCalendars();
        Assert.assertTrue(calendarsPage.calendarsPageLoaded(), "Calendars page is not loaded");
        calendarsPage.addNewCalendar();
        Assert.assertTrue(createNewCalendarPage.createNewCalendarPageLoaded(), "Create new calendar page is not loaded");
        createNewCalendarPage.addCalendarTitle("My new calendar");
        createNewCalendarPage.changeColor("Blue");
        createNewCalendarPage.saveCalendar();
        Assert.assertTrue(calendarsPage.calendarExists("My new calendar"), "My new calendar doesn't exist");
        calendarsPage.chooseHideAll();
        Assert.assertFalse(calendarsPage.firstCalendarIsSelected("Calendar"), "Calendar is selected");
        Assert.assertFalse(calendarsPage.secondCalendarIsSelected("My new calendar"), "Calendar is selected");
        calendarsPage.chooseMoreInfo();
        editCalendarPage.deleteCalendar();
        Assert.assertTrue(calendarsPage.calendarExists("Calendar"), "Calendar doesn't exist");
        calendarsPage.exitCalendars();
        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");
    }
}
