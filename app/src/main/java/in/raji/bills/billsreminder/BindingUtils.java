package in.raji.bills.billsreminder;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseMethod;
import android.widget.EditText;
import android.widget.TimePicker;

public class BindingUtils {

    public static TimePicker setHour(TimePicker view, int value) {
        view.setHour(value);
        return view;
    }

//    @InverseBindingAdapter(attribute = "android:hour")
    public static int getHour(TimePicker view) {
        return view.getHour();
    }

//    @BindingAdapter("android:minute")
    public static void setMinute(TimePicker view, int value) {
        view.setMinute(value);
    }

//    @InverseBindingAdapter(attribute = "android:minute")
    public static int getMinute(TimePicker view) {
        return view.getMinute();
    }

//    @BindingAdapter("android:value")
    public static void setValue(CustomNumberPicker view, int value) {
        view.setValue(value);
    }

//    @InverseBindingAdapter(attribute = "android:value")
    public static int getValue(CustomNumberPicker view) {
        return view.getValue();
    }
}