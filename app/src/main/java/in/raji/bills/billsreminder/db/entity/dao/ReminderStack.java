package in.raji.bills.billsreminder.db.entity.dao;

import in.raji.bills.billsreminder.db.entity.DailyReminder;
import in.raji.bills.billsreminder.db.entity.HourlyReminder;
import in.raji.bills.billsreminder.db.entity.MonthlyReminder;
import in.raji.bills.billsreminder.db.entity.Reminder;

public class ReminderStack {
    Reminder reminder;
    HourlyReminder hourlyReminder;
    DailyReminder dailyReminder;
    MonthlyReminder monthlyReminder;

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public HourlyReminder getHourlyReminder() {
        return hourlyReminder;
    }

    public void setHourlyReminder(HourlyReminder hourlyReminder) {
        this.hourlyReminder = hourlyReminder;
    }

    public DailyReminder getDailyReminder() {
        return dailyReminder;
    }

    public void setDailyReminder(DailyReminder dailyReminder) {
        this.dailyReminder = dailyReminder;
    }

    public MonthlyReminder getMonthlyReminder() {
        return monthlyReminder;
    }

    public void setMonthlyReminder(MonthlyReminder monthlyReminder) {
        this.monthlyReminder = monthlyReminder;
    }

    public ReminderStack(Reminder reminder, HourlyReminder hourlyReminder) {
        this.reminder = reminder;
        this.hourlyReminder = hourlyReminder;
    }

    public ReminderStack(Reminder reminder, DailyReminder dailyReminder) {
        this.reminder = reminder;
        this.dailyReminder = dailyReminder;
    }

    public ReminderStack(Reminder reminder, MonthlyReminder monthlyReminder) {
        this.reminder = reminder;
        this.monthlyReminder = monthlyReminder;
    }
}
