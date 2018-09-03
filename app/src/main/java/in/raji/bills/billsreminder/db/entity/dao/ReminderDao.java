package in.raji.bills.billsreminder.db.entity.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

import in.raji.bills.billsreminder.db.entity.DailyReminder;
import in.raji.bills.billsreminder.db.entity.HourlyReminder;
import in.raji.bills.billsreminder.db.entity.MonthlyReminder;
import in.raji.bills.billsreminder.db.entity.Reminder;
import in.raji.bills.billsreminder.db.entity.dao.util.BooleanArrayConverter;
import in.raji.bills.billsreminder.db.entity.dao.util.DateConverter;

@Dao
@TypeConverters({DateConverter.class, BooleanArrayConverter.class})
public interface ReminderDao {

    @Query("Select * from Reminder")
    public LiveData<List<Reminder>> getAllReminders();

    @Query("SELECT * FROM HourlyReminder " +
            "INNER JOIN Reminder ON  HourlyReminder.id = Reminder.id " +
            "WHERE HourlyReminder.id = :id")
    public HourlyReminder getHourlyReminder(int id);

    @Query("SELECT * FROM DailyReminder " +
            "INNER JOIN Reminder ON  DailyReminder.id = Reminder.id " +
            "WHERE DailyReminder.id = :id")
    public DailyReminder getDailyReminder(int id);

    @Query("SELECT * FROM MonthlyReminder " +
            "INNER JOIN Reminder ON  MonthlyReminder.id = Reminder.id " +
            "WHERE MonthlyReminder.id = :id")
    public MonthlyReminder getMonthlyReminder(int id);

    @Insert
    public void insertHourlyReminder(HourlyReminder hourlyReminder);

    @Insert
    public void insertDailyReminder(DailyReminder dailyReminderm);

    @Insert
    public void insertMonthlyReminder(MonthlyReminder monthlyReminder);

    @Insert
    public long insertReminder(Reminder reminder);

    @Query("Delete from Reminder where id =:id")
    public void deleteReminder(int id);
}
