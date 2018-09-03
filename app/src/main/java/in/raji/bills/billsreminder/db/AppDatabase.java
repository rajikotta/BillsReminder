package in.raji.bills.billsreminder.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import in.raji.bills.billsreminder.db.entity.DailyReminder;
import in.raji.bills.billsreminder.db.entity.HourlyReminder;
import in.raji.bills.billsreminder.db.entity.MonthlyReminder;
import in.raji.bills.billsreminder.db.entity.Reminder;
import in.raji.bills.billsreminder.db.entity.dao.ReminderDao;
import in.raji.bills.billsreminder.db.entity.dao.util.DateConverter;
import in.raji.bills.billsreminder.db.entity.dao.util.BooleanArrayConverter;

@Database(entities = {Reminder.class, HourlyReminder.class, DailyReminder.class, MonthlyReminder.class}, version = 1)
@TypeConverters({DateConverter.class, BooleanArrayConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase database;

    public static AppDatabase getDatabaseInstance(Context context) {
        database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Reminder_db").build();
        return database;
    }

    public abstract ReminderDao getReminderDao();


}
