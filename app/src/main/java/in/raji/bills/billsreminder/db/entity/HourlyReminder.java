package in.raji.bills.billsreminder.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import in.raji.bills.billsreminder.db.entity.dao.util.DateConverter;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "HourlyReminder",
        foreignKeys = @ForeignKey(entity = Reminder.class, parentColumns = "id", childColumns = "id", onDelete = CASCADE))

public class HourlyReminder {

    private long id;

    public long getHourlyId() {
        return hourlyId;
    }

    public void setHourlyId(long hourlyId) {
        this.hourlyId = hourlyId;
    }

    @PrimaryKey
    private long hourlyId;

    private long offset;

    @TypeConverters(DateConverter.class)
    private Date from;

    @TypeConverters(DateConverter.class)
    private Date to;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
