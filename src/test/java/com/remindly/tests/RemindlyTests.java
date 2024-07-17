/*
 * created by max$
 */


package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemindlyTests extends TestBase {
    @Test
    public void addReminderTitlePositiveTest() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderTitlePresent().contains("Holiday"));
    }

    @Test
    public void addReminderWithDatePositiveTest() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");

        app.getReminder().tapOnDateField();
        app.getReminder().swipeToMonth("past", "MAY",2);
        app.getReminder().selectDate(0);
        app.getReminder().tapOnYear();
        app.getReminder().swipeToYear("past","2020");
        app.getReminder().tapOnOk();
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("1/5/2020"));


    }

    @Test
    public void addReminderWithTimeTest(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnTimeField();
        app.getReminder().selectTime("am",540,1200,540,660);
        app.getReminder().tapOnOk();
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("6:00"));

    }

    @Test
    public void offReminderRepeat(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnRepeatSwitch();
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("Repeat Off"));

    }
    @Test
    public void addRepeatInterval(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");

        app.getReminder().tapOnRepetitionInterval();
        app.getReminder().enterNumber("17");
        app.getReminder().tapOnOkRepeatInterval();

        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("Every 17 Hour(s)"));

    }
    @Test
    public void addTypeOfRepetitions(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");

        app.getReminder().tapOnTypeOfRepetition();
        app.getReminder().tapOnType("month");

        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("Every 1 Month(s)"));

    }


}
