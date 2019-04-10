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
    private int dexCount= 8;
    private int conCount = 8;
    private int intCount = 8;
    private int wisCount = 8;
    private int chaCount = 8;

    //Var for handling the unused points
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




        }//end OnCreate

    //CREATE A CHARACTER CODE

   //Methods for adding amd removing strength
    public void addStr(View view)
    {

        if(remCount > 0 && strCount < 16) {
            strCount = strCount + 1;
            updateStr(strCount);

            remCount = remCount - 1;
            updateRem(remCount);
        }
        else if(strCount >= 16 && remCount != 0)
        {
            strCount = strCount + 2;
            updateStr(strCount);

            remCount = remCount - 2;
            updateRem(remCount);

        }
        else if(remCount == 0)
        {

            strCount = strCount ;
            updateStr(strCount);

            remCount = remCount;
            updateRem(remCount);

            Toast error1 = Toast.makeText(this,R.string.toastErrorNoPoints, Toast.LENGTH_LONG);
            error1.show();

        }

        if(strCount ==16)
        {
            Toast statadvice = Toast.makeText(this,R.string.advice1, Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusStr(View view)
    {
        if (strCount != 8 && strCount < 16)
        {
            strCount = strCount - 1;
            updateStr(strCount);

            remCount = remCount - 1;
            updateRem(remCount);
        }
        else if(strCount == 8)
        {
            strCount = strCount;
            updateStr(strCount);

            remCount = remCount ;
            updateRem(remCount);

            Toast advice2 = Toast.makeText(this,R.string.lowestvalue, Toast.LENGTH_LONG);
            advice2.show();

        }
        else if(strCount > 16)
        {
            strCount = strCount - 2;
            remCount = remCount - 2;
        }
    }

    //Methods for adding amd removing Dex
    public void addDex(View view)
    {

        if(remCount > 0 && dexCount < 16) {
            dexCount = dexCount + 1;
            updateDex(dexCount);

            remCount = remCount - 1;
            updateRem(remCount);
        }
        else if(dexCount >= 16 && remCount != 0)
        {
            dexCount = dexCount + 2;
            updateDex(dexCount);

            remCount = remCount - 2;
            updateRem(remCount);

        }
        else if(remCount == 0)
        {

            dexCount = dexCount;
            updateDex(dexCount);
            remCount = remCount;
            updateRem(remCount);

            Toast error1 = Toast.makeText(this,R.string.toastErrorNoPoints, Toast.LENGTH_LONG);
            error1.show();

        }

        if(dexCount ==16)
        {
            Toast statadvice = Toast.makeText(this,R.string.advice1, Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusDex(View view)
    {
        if (dexCount != 8 && dexCount < 16)
        {
            dexCount = dexCount - 1;
            updateDex(dexCount);

            remCount = remCount - 1;
            updateRem(remCount);
        }
        else if(dexCount == 8)
        {
            dexCount = dexCount;
            updateDex(dexCount);

            remCount = remCount ;
            updateRem(remCount);

            Toast advice2 = Toast.makeText(this,R.string.lowestvalue, Toast.LENGTH_LONG);
            advice2.show();

        }
        else if(strCount > 16)
        {
            dexCount = dexCount - 2;
            updateDex(dexCount);
            remCount = remCount - 2;
            updateRem(remCount);
        }
    }

    //Con Methods
    public void addCon(View view)
    {

        if(remCount > 0 && conCount < 16) {
            conCount = conCount + 1;
            updateCon(conCount);

            remCount = remCount - 1;
            updateRem(remCount);
        }
        else if(conCount >= 16 && remCount != 0)
        {
            conCount = conCount + 2;
            updateCon(conCount);

            remCount = remCount - 2;
            updateRem(remCount);

        }
        else if(remCount == 0)
        {

            conCount = conCount ;
            updateCon(conCount);
            remCount = remCount -1 ;
            updateRem(remCount);

            Toast error1 = Toast.makeText(this,R.string.toastErrorNoPoints, Toast.LENGTH_LONG);
            error1.show();

        }

        if(conCount ==16)
        {
            Toast statadvice = Toast.makeText(this,R.string.advice1, Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusCon(View view)
    {
        if (conCount != 8 && conCount < 16)
        {
            conCount = conCount - 1;
            updateCon(conCount);

            remCount = remCount - 1;
            updateRem(remCount);
        }
        else if(strCount == 8)
        {
            conCount = conCount;
            updateCon(conCount);

            conCount = conCount ;
            updateRem(conCount);
            remCount = remCount ;
            updateRem(remCount);

            Toast advice2 = Toast.makeText(this,R.string.lowestvalue, Toast.LENGTH_LONG);
            advice2.show();

        }
        else if(conCount > 16)
        {
            conCount = conCount - 2;
            remCount = remCount - 2;
        }
    }



    //Int Methods
    public void addInt(View view)
    {

        if(intCount > 0 && intCount < 16) {
            intCount = intCount + 1;
            updateInt(intCount);

            remCount = remCount - 1;
            updateRem(remCount);
        }
        else if(intCount >= 16 && intCount != 0)
        {
            intCount = intCount + 2;
            updateInt(intCount);

            remCount = remCount - 2;
            updateRem(remCount);

        }
        else if(remCount == 0)
        {

            intCount = intCount ;
            updateInt(intCount);
            remCount = remCount -1 ;
            updateRem(remCount);

            Toast error1 = Toast.makeText(this,R.string.toastErrorNoPoints, Toast.LENGTH_LONG);
            error1.show();

        }

        if(intCount ==16)
        {
            Toast statadvice = Toast.makeText(this,R.string.advice1, Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusInt(View view)
    {
        if (intCount != 8 && intCount < 16)
        {
            intCount = intCount - 1;
            updateInt(intCount);

            intCount = remCount - 1;
            updateRem(remCount);
        }
        else if(strCount == 8)
        {
            intCount = intCount;
            updateInt(intCount);

            intCount = intCount ;
            updateInt(intCount);
            remCount = remCount;
            updateRem(remCount);

            Toast advice2 = Toast.makeText(this,R.string.lowestvalue, Toast.LENGTH_LONG);
            advice2.show();

        }
        else if(intCount > 16)
        {
            intCount = intCount - 2;
            updateInt(intCount);
            remCount = remCount - 2;
            updateRem(remCount);
        }
    }

    //Wiz Methods
    public void addWis(View view)
    {

        if(wisCount > 0 && wisCount < 16) {
            wisCount = wisCount + 1;
            updateWis(wisCount);

            wisCount = wisCount - 1;
            updateRem(remCount);
        }
        else if(wisCount >= 16 && wisCount != 0)
        {
            wisCount = wisCount + 2;
            updateStr(strCount);

            remCount = remCount - 2;
            updateRem(remCount);

        }
        else if(remCount == 0)
        {

            wisCount = wisCount ;
            updateWis(wisCount);
            remCount = remCount -1 ;
            updateRem(remCount);

            Toast error1 = Toast.makeText(this,R.string.toastErrorNoPoints, Toast.LENGTH_LONG);
            error1.show();

        }

        if(wisCount ==16)
        {
            Toast statadvice = Toast.makeText(this,R.string.advice1, Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusWis(View view)
    {
        if (wisCount != 8 && wisCount < 16)
        {
            wisCount = wisCount - 1;
            updateWis(wisCount);

            remCount = remCount - 1;
            updateRem(remCount);
        }
        else if(wisCount == 8)
        {
            wisCount = wisCount;
            updateWis(wisCount);


            remCount = remCount ;

            Toast advice2 = Toast.makeText(this,R.string.lowestvalue, Toast.LENGTH_LONG);
            advice2.show();

        }
        else if(wisCount > 16)
        {
            wisCount = wisCount - 2;
            updateWis(wisCount);
            remCount = remCount - 2;
            updateRem(remCount);
        }
    }

    //Int Methods
    public void addCha(View view)
    {

        if(chaCount > 0 && chaCount < 16) {
            chaCount = chaCount + 1;
            updateCha(chaCount);

            remCount = remCount - 1;
            updateRem(remCount);
        }
        else if(chaCount >= 16 && chaCount != 0)
        {
            chaCount = chaCount + 2;
            updateStr(chaCount);

            remCount = remCount - 2;
            updateRem(chaCount);

        }
        else if(remCount == 0)
        {

            chaCount = chaCount ;
            updateCha(chaCount);
            remCount = remCount -1 ;
            updateRem(remCount);

            Toast error1 = Toast.makeText(this,R.string.toastErrorNoPoints, Toast.LENGTH_LONG);
            error1.show();

        }

        if(chaCount ==16)
        {
            Toast statadvice = Toast.makeText(this,R.string.advice1, Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusCha(View view)
    {
        if (chaCount != 8 && chaCount < 16)
        {
            chaCount = chaCount - 1;
            updateCha(chaCount);

            remCount = remCount - 1;
            updateRem(remCount);
        }
        else if(chaCount == 8)
        {
            chaCount = conCount;
            updateCha(chaCount);


            remCount = remCount ;
            updateRem(remCount);

            Toast advice2 = Toast.makeText(this,R.string.lowestvalue, Toast.LENGTH_LONG);
            advice2.show();

        }
        else if(chaCount > 16)
        {
            chaCount = chaCount - 2;
            updateCha(chaCount);
            remCount = remCount - 2;
            updateRem(remCount);
        }
    }



    //Methods for Updating Text Views

    private void updateStr(int num)
    {
        //Update the Strength Value
        TextView updateStr = (TextView) findViewById(R.id.strValue);
        updateStr.setText(""+ num);
    }

    private void updateDex(int num)
    {
        //Update the Strength Value
        TextView updateDex = (TextView) findViewById(R.id.dexValue);
        updateDex.setText(""+ num);
    }

    private void updateCon(int num)
    {
        //Update the Strength Value
        TextView updateCon = (TextView) findViewById(R.id.conValue);
        updateCon.setText(""+ num);
    }

    private void updateInt(int num)
    {
        //Update the Strength Value
        TextView updateInt = (TextView) findViewById(R.id.intValue);
        updateInt.setText(""+ num);
    }

    private void updateWis(int num)
    {
        //Update the Strength Value
        TextView updateWis = (TextView) findViewById(R.id.wisValue);
        updateWis.setText(""+ num);
    }

    private void updateCha(int num)
    {
        //Update the Strength Value
        TextView updateCha = (TextView) findViewById(R.id.charValue);
        updateCha.setText(""+ num);
    }





    //Method for adding removing points to the unusedpoints Textview
    private void updateRem(int num)
    {
        TextView update = (TextView) findViewById(R.id.unusedPoints);
        update.setText(""+num);

    }


}//End Main Activity