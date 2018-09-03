package in.raji.bills.billsreminder.db;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import in.raji.bills.billsreminder.db.entity.DailyReminder;
import in.raji.bills.billsreminder.db.entity.HourlyReminder;
import in.raji.bills.billsreminder.db.entity.MonthlyReminder;
import in.raji.bills.billsreminder.db.entity.Reminder;
import in.raji.bills.billsreminder.db.entity.dao.ReminderDao;
import in.raji.bills.billsreminder.db.entity.dao.ReminderStack;

public class ReminderRepository {
    ReminderDao reminderDao;

    public ReminderRepository(Context context) {
        AppDatabase database = AppDatabase.getDatabaseInstance(context);
        reminderDao = database.getReminderDao();
    }

    public LiveData<List<Reminder>> getAllReminders() {
        return reminderDao.getAllReminders();
    }

    public HourlyReminder getHourlyReminder(int id) {
        return reminderDao.getHourlyReminder(id);
    }

    public DailyReminder getDailyReminder(int id) {
        return reminderDao.getDailyReminder(id);
    }

    public MonthlyReminder getMonthlyReminder(int id) {
        return reminderDao.getMonthlyReminder(id);
    }

    public void deleteReminder(int id) {
        new DeleteReminderAsync().execute(id);
    }

    public void insertHourlyReminder(ReminderStack hourlyReminder) {
        new InsertHourlyReminder().execute(hourlyReminder);
    }

    public void insertMonthlyReminder(ReminderStack monthlyReminder) {
        new InsertMonthlyReminder().execute(monthlyReminder);
    }

    private class DeleteReminderAsync extends AsyncTask<Integer, Void, Void> {


        @Override
        protected Void doInBackground(Integer... id) {
            reminderDao.deleteReminder(id[0].intValue());
            return null;
        }
    }

    private class InsertHourlyReminder extends AsyncTask<ReminderStack, Void, Void> {

        @Override
        protected Void doInBackground(ReminderStack... hourlyReminders) {
            long id = reminderDao.insertReminder(hourlyReminders[0].getReminder());
            HourlyReminder hourlyReminder = hourlyReminders[0].getHourlyReminder();
            hourlyReminder.setId(id);
            reminderDao.insertHourlyReminder(hourlyReminder);
            return null;
        }
    }

    private class InsertDailyReminder extends AsyncTask<ReminderStack, Void, Void> {
        @Override
        protected Void doInBackground(ReminderStack... dailyReminders) {
            reminderDao.insertDailyReminder(dailyReminders[0].getDailyReminder());
            return null;
        }
    }

    private class InsertMonthlyReminder extends AsyncTask<ReminderStack, Void, Void> {
        @Override
        protected Void doInBackground(ReminderStack... monthlyReminders) {
            long id = reminderDao.insertReminder(monthlyReminders[0].getReminder());
            MonthlyReminder monthlyReminder = monthlyReminders[0].getMonthlyReminder();
            monthlyReminder.setId(id);
            reminderDao.insertMonthlyReminder(monthlyReminder);
            return null;
        }
    }
}
