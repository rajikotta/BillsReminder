package in.raji.bills.billsreminder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class AddReminderActivity extends AppCompatActivity {

    public static String BUNDLE_ARG = "BUNDLE_ARG";

    public static final int MONTHLY_REMINDER = 1;
    public static final int WEEKLY_REMINDER = 2;
    public static final int DAILY_REMINDER = 3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        switch (getIntent().getExtras().getInt(BUNDLE_ARG)) {
            case MONTHLY_REMINDER:

                getSupportFragmentManager().beginTransaction().add(R.id.main_container, new MonthlyFragment()).commit();

                break;


        }

    }
}
