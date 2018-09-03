package in.raji.bills.billsreminder.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import in.raji.bills.billsreminder.db.entity.dao.util.DateConverter;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "MonthlyReminder",
        foreignKeys = @ForeignKey(entity = Reminder.class, parentColumns = "id", childColumns = "id", onDelete = CASCADE))
public class MonthlyReminder {


    private long id;

    public long getMonthlyId() {
        return monthlyId;
    }

    public void setMonthlyId(long monthlyId) {
        this.monthlyId = monthlyId;
    }

    @PrimaryKey
    private long monthlyId;

    public int date;

    public int hour;
    public int minute;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
