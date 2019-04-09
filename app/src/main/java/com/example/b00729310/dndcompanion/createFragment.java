package com.example.b00729310.dndcompanion;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class createFragment extends Fragment {

    //Root View
    private View rootView;

    //spinners
    Spinner spinnerRace;
    Spinner spinnerClass;

    //Array Adapters
    ArrayAdapter<CharSequence> adapterRace;
    ArrayAdapter<CharSequence> adapterClass;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        //Set Rootview as current layout file
        rootView = inflater.inflate(R.layout.character_creator, container, false);

        //Spinner Classes onCreate
        spinnerRace = (Spinner)rootView.findViewById(R.id.spinnerRace);

        return rootView;

    }


    //Create an Array Adapter From the Character StringArray


}
