package com.example.b00729310.dndcompanion;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class CreateFragment extends Fragment  {
    private View rootView;

    private int strCount = 8;
    private int dexCount = 8;
    private int conCount = 8;
    private int intCount = 8;
    private int wisCount = 8;
    private int chaCount = 8;

    private int remCount = 27;
    int BaseValue = 8;

    Spinner spinnerRace;
    Spinner spinnerClass;

    ArrayAdapter<CharSequence> adapterRace;
    ArrayAdapter<CharSequence> adapterClass;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {

        //Set Rootview as character_creator layout file
        rootView = inflater.inflate(R.layout.character_creator, container, false);

        //Spinner Classes onCreate
        spinnerRace = (Spinner) rootView.findViewById(R.id.spinnerRace);
        spinnerClass = (Spinner) rootView.findViewById(R.id.spinnerClass);

        TextView characterNameTextView = rootView.findViewById(R.id.characterName);
        TextView pronounsTextView = rootView.findViewById(R.id.pronouns);
        TextView titleTextView = rootView.findViewById(R.id.cctitle1);

        Spinner raceSpinner = rootView.findViewById(R.id.spinnerRace);
        Spinner classSpinner = rootView.findViewById(R.id.spinnerClass);

        //Declare Buttons
        Button saveButton = (Button) rootView.findViewById(R.id.btnSave);

        saveButton.setOnClickListener(v -> {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();

            Character character = new Character(
                    characterNameTextView.getText().toString(),
                    pronounsTextView.getText().toString(),
                    raceSpinner.getSelectedItem().toString(),
                    classSpinner.getSelectedItem().toString(),
                    strCount,
                    dexCount,
                    conCount,
                    intCount,
                    wisCount,
                    chaCount
            );

            Log.d("MAINACTIVITY", "This button works");
            System.out.println(gson.toJson(character));
        });

        characterNameTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    titleTextView.setText(characterNameTextView.getText());
                }
            }
        });


        return rootView;
    } // End OnCreate




    //Add data to the spinner from the Character Race and Class StringArrays
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Set Contents of Drop Down Menu
        adapterRace = ArrayAdapter.createFromResource(
                getContext(),
                R.array.characterRaces,
                android.R.layout.simple_spinner_dropdown_item);
        adapterRace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRace.setAdapter(adapterRace);

        adapterClass = ArrayAdapter.createFromResource(
                getContext(),
                R.array.characterClasses,
                android.R.layout.simple_spinner_dropdown_item);
        adapterClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClass.setAdapter(adapterClass);
    }

    //CREATE A CHARACTER CODE

    //Methods for adding amd removing strength
    public void addStr(View view) {

        if (remCount > 0 && strCount < 16) {
            strCount += 1;
            updateStr(strCount);

            remCount -= 1;
            updateRem(remCount);
        } else if (strCount >= 16 && remCount != 0) {
            strCount += 2;
            updateStr(strCount);

            remCount -= 2;
            updateRem(remCount);

        } else if (remCount == 0) {
            updateStr(strCount);

            updateRem(remCount);

            Toast error1 = Toast.makeText(
                    getContext(),
                    R.string.toastErrorNoPoints,
                    Toast.LENGTH_LONG);
            error1.show();

        }

        if (strCount == 16) {
            Toast statadvice = Toast.makeText(
                    getContext(),
                    R.string.advice1,
                    Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusStr(View view) {
        if (strCount > 8 && strCount < 16) {
            strCount -= 1;
            updateStr(strCount);

            remCount = remCount - 1;
            updateRem(remCount);
        } else if (strCount == 8) {
            updateStr(strCount);

            updateRem(remCount);

            Toast advice2 = Toast.makeText(
                    getContext(),
                    R.string.lowestvalue,
                    Toast.LENGTH_LONG);
            advice2.show();

        } else if (strCount > 16) {
            strCount -= 2;
            remCount -= 2;
        }
    }

    //Methods for adding amd removing Dex
    public void addDex(View view) {

        if (remCount > 0 && dexCount < 16) {
            dexCount += 1;
            updateDex(dexCount);

            remCount -= 1;
            updateRem(remCount);
        } else if (dexCount >= 16 && remCount != 0) {
            dexCount += 2;
            updateDex(dexCount);

            remCount -= 2;
            updateRem(remCount);

        } else if (remCount == 0) {
            updateDex(dexCount);
            updateRem(remCount);

            Toast error1 = Toast.makeText(
                    getContext(),
                    R.string.toastErrorNoPoints,
                    Toast.LENGTH_LONG);
            error1.show();

        }

        if (dexCount == 16) {
            Toast statadvice = Toast.makeText(
                    getContext(),
                    R.string.advice1,
                    Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusDex(View view) {
        if (dexCount != 8 && dexCount < 16) {
            dexCount -= 1;
            updateDex(dexCount);

            remCount -= 1;
            updateRem(remCount);
        } else if (dexCount == 8) {
            updateDex(dexCount);
            updateRem(remCount);

            Toast advice2 = Toast.makeText(
                    getContext(),
                    R.string.lowestvalue,
                    Toast.LENGTH_LONG);
            advice2.show();
        } else if (strCount > 16) {
            dexCount -= 2;
            updateDex(dexCount);
            remCount -= 2;
            updateRem(remCount);
        }
    }

    //Con Methods
    public void addCon(View view) {

        if (remCount > 0 && conCount < 16) {
            conCount += 1;
            updateCon(conCount);

            remCount -= 1;
            updateRem(remCount);
        } else if (conCount >= 16 && remCount != 0) {
            conCount += 2;
            updateCon(conCount);

            remCount -= 2;
            updateRem(remCount);

        } else if (remCount == 0) {
            updateCon(conCount);
            remCount -= 1;
            updateRem(remCount);

            Toast error1 = Toast.makeText(
                    getContext(),
                    R.string.toastErrorNoPoints,
                    Toast.LENGTH_LONG);
            error1.show();

        }

        if (conCount == 16) {
            Toast statadvice = Toast.makeText(
                    getContext(),
                    R.string.advice1,
                    Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusCon(View view) {
        if (conCount > 8 && conCount < 16) {
            conCount -= 1;
            updateCon(conCount);

            remCount -= 1;
            updateRem(remCount);
        } else if (strCount == 8) {
            updateCon(conCount);

            updateRem(conCount);
            updateRem(remCount);

            Toast advice2 = Toast.makeText(
                    getContext(),
                    R.string.lowestvalue,
                    Toast.LENGTH_LONG);
            advice2.show();

        } else if (conCount > 16) {
            conCount -= 2;
            remCount -= 2;
        }
    }


    //Int Methods
    public void addInt(View view) {

        if (intCount > 0 && intCount < 16) {
            intCount += 1;
            updateInt(intCount);

            remCount -= 1;
            updateRem(remCount);
        } else if (intCount >= 16) {
            intCount += 2;
            updateInt(intCount);

            remCount -= 2;
            updateRem(remCount);

        } else if (remCount == 0) {
            updateInt(intCount);
            remCount -= 1;
            updateRem(remCount);

            Toast error1 = Toast.makeText(
                    getContext(),
                    R.string.toastErrorNoPoints,
                    Toast.LENGTH_LONG);
            error1.show();
        }

        if (intCount == 16) {
            Toast statadvice = Toast.makeText(
                    getContext(),
                    R.string.advice1,
                    Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusInt(View view) {
        if (intCount != 8 && intCount < 16) {
            intCount = intCount - 1;
            updateInt(intCount);

            intCount = remCount - 1;
            updateRem(remCount);
        } else if (strCount == 8) {
            updateInt(intCount);

            updateInt(intCount);
            updateRem(remCount);

            Toast advice2 = Toast.makeText(
                    getContext(),
                    R.string.lowestvalue,
                    Toast.LENGTH_LONG);
            advice2.show();

        } else if (intCount > 16) {
            intCount = intCount - 2;
            updateInt(intCount);
            remCount = remCount - 2;
            updateRem(remCount);
        }
    }

    //Wiz Methods
    public void addWis(View view) {

        if (wisCount > 0 && wisCount < 16) {
            wisCount = wisCount + 1;
            updateWis(wisCount);

            wisCount = wisCount - 1;
            updateRem(remCount);
        } else if (wisCount >= 16) {
            wisCount += 2;
            updateStr(strCount);

            remCount -= 2;
            updateRem(remCount);

        } else if (remCount == 0) {
            updateWis(wisCount);
            remCount -= 1;
            updateRem(remCount);

            Toast error1 = Toast.makeText(
                    getContext(),
                    R.string.toastErrorNoPoints,
                    Toast.LENGTH_LONG);
            error1.show();

        }

        if (wisCount == 16) {
            Toast statadvice = Toast.makeText(
                    getContext(),
                    R.string.advice1,
                    Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusWis(View view) {
        if (wisCount != 8 && wisCount < 16) {
            wisCount -= 1;
            updateWis(wisCount);

            remCount -= 1;
            updateRem(remCount);
        } else if (wisCount == 8) {
            updateWis(wisCount);

            Toast advice2 = Toast.makeText(
                    getContext(),
                    R.string.lowestvalue,
                    Toast.LENGTH_LONG);
            advice2.show();

        } else if (wisCount > 16) {
            wisCount -= 2;
            updateWis(wisCount);
            remCount = remCount - 2;
            updateRem(remCount);
        }
    }

    //Int Methods
    public void addCha(View view) {

        if (chaCount > 0 && chaCount < 16) {
            chaCount += 1;
            updateCha(chaCount);

            remCount -= 1;
            updateRem(remCount);
        } else if (chaCount >= 16) {
            chaCount += 2;
            updateStr(chaCount);

            remCount -= 2;
            updateRem(chaCount);

        } else if (remCount == 0) {
            updateCha(chaCount);
            remCount -= 1;
            updateRem(remCount);

            Toast error1 = Toast.makeText(
                    getContext(),
                    R.string.toastErrorNoPoints,
                    Toast.LENGTH_LONG);
            error1.show();
        }

        if (chaCount == 16) {
            Toast statadvice = Toast.makeText(
                    getContext(),
                    R.string.advice1,
                    Toast.LENGTH_LONG);
            statadvice.show();
        }

    }

    public void minusCha(View view) {
        if (chaCount != 8 && chaCount < 16) {
            chaCount -= 1;
            updateCha(chaCount);

            remCount -= 1;
            updateRem(remCount);
        } else if (chaCount == 8) {
            chaCount = conCount;
            updateCha(chaCount);

            updateRem(remCount);

            Toast advice2 = Toast.makeText(
                    getContext(),
                    R.string.lowestvalue,
                    Toast.LENGTH_LONG);
            advice2.show();

        } else if (chaCount > 16) {
            chaCount -= 2;
            updateCha(chaCount);
            remCount -= 2;
            updateRem(remCount);
        }
    }

    // Methods for Updating Text Views
    private void updateStr(int num) {
        TextView updateStr = (TextView) rootView.findViewById(R.id.strValue);
        updateStr.setText("" + num);
    }

    private void updateDex(int num) {
        TextView updateDex = (TextView) rootView.findViewById(R.id.dexValue);
        updateDex.setText("" + num);
    }

    private void updateCon(int num) {
        TextView updateCon = (TextView) rootView.findViewById(R.id.conValue);
        updateCon.setText("" + num);
    }

    private void updateInt(int num) {
        TextView updateInt = (TextView) rootView.findViewById(R.id.intValue);
        updateInt.setText("" + num);
    }

    private void updateWis(int num) {
        TextView updateWis = (TextView) rootView.findViewById(R.id.wisValue);
        updateWis.setText("" + num);
    }

    private void updateCha(int num) {
        TextView updateCha = (TextView) rootView.findViewById(R.id.charValue);
        updateCha.setText("" + num);
    }

    private void updateRem(int num) {
        TextView update = (TextView) rootView.findViewById(R.id.unusedPoints);
        update.setText("" + num);
    }

} // End Fragment
