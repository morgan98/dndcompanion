package com.example.b00729310.dndcompanion;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity
{

    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)  findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_home:
                        selectedFragment = new homeFragment();
                        break;
                    case R.id.navigation_dice:
                        selectedFragment = new diceFragment();
                        break;
                    case R.id.navigation_create:
                        selectedFragment = new createFragment();
                        break;
                    case R.id.navigation_load:
                        selectedFragment = new loadFragment();
                        break;
                    case R.id.navigation_session:
                        selectedFragment = new sessionFragment();
                        break;

                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, selectedFragment);
                transaction.commit();
                return true;
            }

        });
        //Display Home Fragment on Launch
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, new homeFragment());
        transaction.commit();





    }//end OnCreate


}//End Main Activity