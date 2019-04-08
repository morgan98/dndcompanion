package com.example.b00729310.dndcompanion;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

//Import Fragments
import com.example.b00729310.dndcompanion.homeFragment;
import com.example.b00729310.dndcompanion.diceFragment;
import com.example.b00729310.dndcompanion.createFragment;
import com.example.b00729310.dndcompanion.loadFragment;
import com.example.b00729310.dndcompanion.sessionFragment;


public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Load Home Fragment on Launch
        toolbar.setTitle("Home");
        loadFragment(new homeFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Home");
                    fragment = new homeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_dice:
                    toolbar.setTitle("Dice");
                    fragment = new diceFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_create:
                    toolbar.setTitle("Create");
                    fragment = new createFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_load:
                    toolbar.setTitle("Load");
                    fragment = new loadFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_session:
                    toolbar.setTitle("Session");
                    fragment = new sessionFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    //Load Fragment method for handling the change of fragments
    private void loadFragment(Fragment fragment)
    {
        //Load Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}