package com.example.b00729310.dndcompanion;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{



    //Var for handling adding or subtracting from character stat
    private int strCount = 8;

    private  int remCount = 27;

    int BaseValue = 8;



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
        transaction.replace(R.id.frame_container, new createFragment());
        transaction.commit();


        //Generate Calls to Toast Messages


        }//end OnCreate

    //CREATE A CHARACTER CODE

   //Methods for adding amd removing strength
    public void addStr(View view)
    {
        if(remCount != 0 && strCount < 16) {
            strCount = strCount + 1;
            updateStr(strCount);

            remCount = remCount - 1;
            updateRem(remCount);
        }
        else if(strCount >= 16)
        {
            strCount = strCount + 2;
            updateStr(strCount);

            remCount = remCount - 2;
            updateRem(remCount);

            Toast statadvice = Toast.makeText(this,R.string.advice1, Toast.LENGTH_LONG);
            statadvice.show();
        }
        else
        {
            Toast error1 = Toast.makeText(this,R.string.toastErrorNoPoints, Toast.LENGTH_LONG);
            error1.show();
        }

    }

    public void minusStr(View view)
    {

        strCount = strCount - 1;
        updateStr(strCount);

    }
    private void updateStr(int num)
    {
        //Update the Strength Value
        TextView updateStr = (TextView) findViewById(R.id.strValue);
        updateStr.setText(""+ num);
    }





    //Method for adding removing points to the unusedpoints Textview
    private void updateRem(int num)
    {
        TextView update = (TextView) findViewById(R.id.unusedPoints);
        update.setText(""+num);

    }


}//End Main Activity