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
public class RecyclerviewFragment extends Fragment {
//ShowJobListFragment
    //work on XML for recyclerView Frag - Button and then Recyclerview container; also work on the logic in the recyclerviewFrag
    //add logic for button (IF ADDNEWJOBBUTTONGETSCLICKED.ONCLICKLISTENER);  to take u to another fragment.
    // a  new xml for that so the user can enter the info for class. newjobFormFrag <bunch of edit texts ; textView Title;hints -
    // Create Job (submit/finishdone/) ONCE THAT IS CLICKED THATS WHEN WE WANT TO to add it to the daata base

    public RecyclerviewFragment() {
        // Required empty public constructor
    }

    public static RecyclerviewFragment newInstance() {
        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

}
