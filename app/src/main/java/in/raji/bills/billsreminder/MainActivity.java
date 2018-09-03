package in.raji.bills.billsreminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.databinding.DataBindingUtil;

import in.raji.bills.billsreminder.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Animation fabOpenAnimation;
    private Animation fabCloseAnimation;
    private boolean isFabMenuOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setFabHandler(new FabHandler());

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));


        getAnimations();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getAnimations() {

        fabOpenAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_expand_anim);

        fabCloseAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_collapse_anim);

    }

    private void expandFabMenu() {

        ViewCompat.animate(binding.baseFloatingActionButton).rotation(45.0F).withLayer().setDuration(300).setInterpolator(new OvershootInterpolator(10.0F)).start();
        binding.createLayout.startAnimation(fabOpenAnimation);
        binding.shareLayout.startAnimation(fabOpenAnimation);
        binding.createFab.setClickable(true);
        binding.shareFab.setClickable(true);
        isFabMenuOpen = true;


    }

    private void collapseFabMenu() {

        ViewCompat.animate(binding.baseFloatingActionButton).rotation(0.0F).withLayer().setDuration(300).setInterpolator(new OvershootInterpolator(10.0F)).start();
        binding.createLayout.startAnimation(fabCloseAnimation);
        binding.shareLayout.startAnimation(fabCloseAnimation);
        binding.createFab.setClickable(false);
        binding.shareFab.setClickable(false);
        isFabMenuOpen = false;

    }


    public class FabHandler {

        public void onBaseFabClick(View view) {

            if (isFabMenuOpen)
                collapseFabMenu();
            else
                expandFabMenu();


        }

        public void onCreateFabClick(View view) {


            Snackbar.make(binding.coordinatorLayout, "Create FAB tapped", Snackbar.LENGTH_SHORT).show();

        }

        public void onMonthlyReminderFabClick(View view) {


            moveToCreator(AddReminderActivity.MONTHLY_REMINDER);

        }


    }


    private void moveToCreator(int selection) {
        Intent intent = new Intent(this, AddReminderActivity.class);
        intent.putExtra(AddReminderActivity.BUNDLE_ARG, selection);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {

        if (isFabMenuOpen)
            collapseFabMenu();
        else
            super.onBackPressed();
    }
}
