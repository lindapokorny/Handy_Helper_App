package com.pursuit.handy_helper_app.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.pursuit.handy_helper_app.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionsFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner optionsSpinner;
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.options_array, android.R.layout.simple_spinner_item);



    public OptionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_options, container, false);
        optionsSpinner = view.findViewById(R.id.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        optionsSpinner.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(0);
        parent.getItemAtPosition(1);
        parent.getItemAtPosition(2);
        optionsSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) adapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Context context = getContext();
        CharSequence text = "Please select an Option.";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        //figure out how to make Toast --> Toast.makeText(this, "Please select an Option", Toast.LENGTH_LONG);

    }
}

