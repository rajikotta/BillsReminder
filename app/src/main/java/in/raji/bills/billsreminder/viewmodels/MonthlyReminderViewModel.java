package in.raji.bills.billsreminder.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import in.raji.bills.billsreminder.db.AppDatabase;
import in.raji.bills.billsreminder.db.ReminderRepository;
import in.raji.bills.billsreminder.db.entity.MonthlyReminder;
import in.raji.bills.billsreminder.db.entity.Reminder;
import in.raji.bills.billsreminder.db.entity.dao.ReminderDao;
import in.raji.bills.billsreminder.db.entity.dao.ReminderStack;

public class MonthlyReminderViewModel extends AndroidViewModel {
    private MutableLiveData<MonthlyReminder> monthlyReminder = new MutableLiveData<>();

    private MutableLiveData<Reminder> reminder = new MutableLiveData<>();
private MutableLiveData<String> test=new MutableLiveData<>();

    public MutableLiveData<String> getTest() {
        return test;
    }

    public void setTest(MutableLiveData<String> test) {
        this.test = test;
    }

    private ReminderRepository reminderRepository;

    public MonthlyReminderViewModel(@NonNull Application application) {
        super(application);
        reminderRepository = new ReminderRepository(application.getApplicationContext());

    }

    public void insert() {
        reminder.getValue().setStatus(true);
        reminder.getValue().setType(3);

        reminderRepository.insertMonthlyReminder(new ReminderStack(reminder.getValue(), monthlyReminder.getValue()));
    }

    public MutableLiveData<MonthlyReminder> getMonthlyReminder() {
        return monthlyReminder;
    }

    public void setMonthlyReminder(MutableLiveData<MonthlyReminder> monthlyReminder) {
        this.monthlyReminder = monthlyReminder;
    }

    public MutableLiveData<Reminder> getReminder() {
        return reminder;
    }

    public void setReminder(MutableLiveData<Reminder> reminder) {
        this.reminder = reminder;
    }
}
