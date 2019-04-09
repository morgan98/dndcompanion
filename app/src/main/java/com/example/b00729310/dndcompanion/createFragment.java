package com.example.b00729310.dndcompanion;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class createFragment extends Fragment  {

    private OnFragmentInteractionListener mListener;


    //Root View
    private View rootView;

    //spinners
    Spinner spinnerRace;
    Spinner spinnerClass;

    //Array Adapters
    ArrayAdapter<CharSequence> adapterRace;
    ArrayAdapter<CharSequence> adapterClass;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        //Set Rootview as character_creator layout file
        rootView = inflater.inflate(R.layout.character_creator, container, false);

        //Spinner Classes onCreate
        spinnerRace = (Spinner) rootView.findViewById(R.id.spinnerRace);
        spinnerClass = (Spinner) rootView.findViewById(R.id.spinnerClass);

        //Declare Next Button
        Button btnNxt = (Button) rootView.findViewById(R.id.btnNext);

        return rootView;
    }

    //Add data to the spinner from the Character Race and Class StringArrays
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Set Contents of Drop Down Menu
        adapterRace = ArrayAdapter.createFromResource(getContext(), R.array.characterRaces, android.R.layout.simple_spinner_dropdown_item);
        adapterRace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRace.setAdapter(adapterRace);

        adapterClass = ArrayAdapter.createFromResource(getContext(), R.array.characterClasses, android.R.layout.simple_spinner_dropdown_item);
        adapterClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClass.setAdapter(adapterClass);
    }

}//End Fragment
