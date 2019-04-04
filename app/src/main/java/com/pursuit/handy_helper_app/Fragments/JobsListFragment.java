package com.pursuit.handy_helper_app.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.handy_helper_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobsListFragment extends Fragment {


    public JobsListFragment() {
        // Required empty public constructor
    }

    public static JobsListFragment newInstance() {
        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jobs_list, container, false);
    }

}
