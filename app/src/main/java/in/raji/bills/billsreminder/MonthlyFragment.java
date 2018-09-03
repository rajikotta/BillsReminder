package in.raji.bills.billsreminder;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;
import java.util.GregorianCalendar;

import in.raji.bills.billsreminder.databinding.FragmentMonthlyBinding;
import in.raji.bills.billsreminder.db.entity.Reminder;
import in.raji.bills.billsreminder.viewmodels.MonthlyReminderViewModel;
import in.raji.bills.billsreminder.viewmodels.TestViewModel;

public class MonthlyFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        FragmentMonthlyBinding binding = DataBindingUtil.inflate(inflater, R.layout.test, container, false);

        // monthlyReminderViewModel = ViewModelProviders.of(getActivity()).get(MonthlyReminderViewModel.class);
        TestViewModel testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);

        binding.setViewModel(testViewModel);

//        binding.setViewModel(monthlyReminderViewModel);
        return binding.getRoot();
    }


}
