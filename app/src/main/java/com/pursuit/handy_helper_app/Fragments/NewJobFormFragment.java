package com.pursuit.handy_helper_app.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pursuit.handy_helper_app.FragmentInterface;
import com.pursuit.handy_helper_app.Job;
import com.pursuit.handy_helper_app.JobDataBaseHelper;
import com.pursuit.handy_helper_app.R;

import java.util.ArrayList;
import java.util.List;

public class NewJobFormFragment extends Fragment implements FragmentInterface {

    EditText date;
    EditText address;
    EditText notes;

    FragmentInterface fragmentInterface;
    Button addJobButton;
    JobDataBaseHelper jobDataBaseHelper;

    public NewJobFormFragment() {
    }

    public static NewJobFormFragment newInstance() {
        NewJobFormFragment fragment = new NewJobFormFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_job_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        date = view.findViewById(R.id.date_editText);
        address = view.findViewById(R.id.address_editText);
        notes = view.findViewById(R.id.note_editText);
        addJobButton = view.findViewById(R.id.addnewJob);


        addJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String dateInput = date.getText().toString();
                final String addressInput = address.getText().toString();
                final String notesInput = notes.getText().toString();
                jobDataBaseHelper.addJob(new Job(dateInput, addressInput, notesInput));
                fragmentInterface.showJobsListFragment();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentInterface = (FragmentInterface) context;
        jobDataBaseHelper = new JobDataBaseHelper(context);
    }

    @Override
    public void showLogInFragment() {

    }

    @Override
    public void showJobsListFragment() {

    }

    @Override
    public void showNewFormList() {

    }

    @Override
    public void showSignUpFragment() {

    }

    @Override
    public void showDetailFragment() {

    }
}
