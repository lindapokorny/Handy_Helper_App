package com.pursuit.handy_helper_app.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pursuit.handy_helper_app.FragmentInterface;
import com.pursuit.handy_helper_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements FragmentInterface {
    Bundle args = new Bundle();
    private TextView date;
    private TextView address;
    private TextView notes;
    public static final String ARG_PARAM_DATE = "date";
    public static final String ARG_PARAM_ADDRESS = "address";
    public static final String ARG_PARAM_NOTES = "notes";
    private SharedPreferences details;
    private static final String SHARED_PREFS_KEY = "detailSharedPrefs";
    FragmentInterface fragmentInterface;

    private String mParam1;
    private String mParam2;
    private String mParam3;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(String date, String address, String notes) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.getString(DetailFragment.ARG_PARAM_DATE, date);
        args.getString(ARG_PARAM_ADDRESS, address);
        args.getString(ARG_PARAM_NOTES, notes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        details = getContext().getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        if (details.getBoolean("isChecked", false)) {
            date.setText(details.getString("date", null));
            address.setText(details.getString("address", null));
            notes.setText(details.getString("notes", null));
        }

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM_DATE);
            mParam2 = getArguments().getString(ARG_PARAM_ADDRESS);
            mParam3 = getArguments().getString(ARG_PARAM_NOTES);
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        date = rootView.findViewById(R.id.date_detailView);
        address = rootView.findViewById(R.id.address_detailView);
        notes = rootView.findViewById(R.id.notes_detailView);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentInterface = (FragmentInterface) context;
    }

    @Override
    public void showLogInFragment() {

    }

    @Override
    public void showJobsListFragment() {

    }


    public static String getArgParamDate() {
        return ARG_PARAM_DATE;
    }

    public static String getArgParamAddress() {
        return ARG_PARAM_ADDRESS;
    }

    public static String getArgParamNotes() {
        return ARG_PARAM_NOTES;
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