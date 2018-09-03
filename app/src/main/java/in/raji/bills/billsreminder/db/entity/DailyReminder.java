package in.raji.bills.billsreminder.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import in.raji.bills.billsreminder.db.entity.dao.util.DateConverter;
import in.raji.bills.billsreminder.db.entity.dao.util.BooleanArrayConverter;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "DailyReminder",
        foreignKeys = @ForeignKey(entity = Reminder.class, parentColumns = "id", childColumns = "id", onDelete = CASCADE))
public class DailyReminder {

    private long id;

    public long getDailyId() {
        return dailyId;
    }

    public void setDailyId(long dailyId) {
        this.dailyId = dailyId;
    }

    @PrimaryKey
    private long dailyId;

    @TypeConverters(DateConverter.class)
    private Date time;

    @TypeConverters(BooleanArrayConverter.class)
    private Boolean[] daysToExclude;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Boolean[] getDaysToExclude() {
        return daysToExclude;
    }

    public void setDaysToExclude(Boolean[] daysToExclude) {
        this.daysToExclude = daysToExclude;
    }
}
