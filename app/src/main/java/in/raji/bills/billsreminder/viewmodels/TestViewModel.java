package in.raji.bills.billsreminder.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

public class TestViewModel extends AndroidViewModel {

    MutableLiveData<String> test=new MutableLiveData<>();


    public TestViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getTest() {
        return test;
    }

    public void setTest(MutableLiveData<String> test) {
        this.test = test;
    }
}
