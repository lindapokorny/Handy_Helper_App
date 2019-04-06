package com.pursuit.handy_helper_app.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pursuit.handy_helper_app.FragmentInterface;
import com.pursuit.handy_helper_app.Job;
import com.pursuit.handy_helper_app.R;


public class JobsListFragment extends Fragment implements FragmentInterface {
    FragmentInterface fragmentInterface;
/*
    ShowJobListFragment
    work on XML for recyclerView Frag - Button and then Recyclerview container; also work on the logic in the recyclerviewFrag
    add logic for button (IF ADDNEWJOBBUTTONGETSCLICKED.ONCLICKLISTENER);  to take u to another fragment.
    a  new xml for that so the user can enter the info for class. newjobFormFrag <bunch of edit texts ; textView Title;hints -
    Create Job (submit/finishdone/) ONCE THAT IS CLICKED THATS WHEN WE WANT TO to add it to the daata base
    */

    //addButton() onClickListener ( - goes to newFormList .replace code -
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentInterface = (FragmentInterface) context;

    }

    public JobsListFragment() {
    }

    public static JobsListFragment newInstance() {
        JobsListFragment jobsListFragment = new JobsListFragment();
        return jobsListFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jobs_list, container, false);
    }

    @Override
    public void showLogInFragment() {

    }

    @Override
    public void showJobsListFragment() {

    }

    public class JobViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView;
        TextView addressTextview;
        TextView notesTextView;
        Button addButton;
        Button deleteButton;
        Button editbutton;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Job job) {
            final boolean clicked = true;
            dateTextView = itemView.findViewById(R.id.date_textView);
            addressTextview = itemView.findViewById(R.id.address_textView);
            notesTextView = itemView.findViewById(R.id.notes_textView);
            addButton = itemView.findViewById(R.id.addJob);
            deleteButton = itemView.findViewById(R.id.delete_job);
            editbutton = itemView.findViewById(R.id.edit_job);
        }
    }

    public class JobAdapter extends JobViewHolder {

        @Override
        public void bind(Job job) {
            super.bind(job);
        }

        public JobAdapter(@NonNull View itemView) {
            super(itemView);

        }
    }
}
