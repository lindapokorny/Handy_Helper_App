package com.pursuit.handy_helper_app.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pursuit.handy_helper_app.FragmentInterface;
import com.pursuit.handy_helper_app.Job;
import com.pursuit.handy_helper_app.JobDataBaseHelper;
import com.pursuit.handy_helper_app.R;
import android.support.v7.widget.RecyclerView;

import com.pursuit.handy_helper_app.recyclerviewComponenets.JobListAdapter;
import com.pursuit.handy_helper_app.recyclerviewComponenets.JobViewHolder;

import java.util.ArrayList;
import java.util.List;


public class JobsListFragment extends Fragment implements FragmentInterface {
    RecyclerView recyclerView;
    FragmentInterface fragmentInterface;
    Button addJobButton;
    List<Job> jobList;
    JobDataBaseHelper jobDataBaseHelper;
    JobListAdapter jobListAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentInterface = (FragmentInterface) context;
        jobDataBaseHelper = new JobDataBaseHelper(context);

    }

    public JobsListFragment() {
    }

    public static JobsListFragment newInstance() {
        JobsListFragment jobsListFragment = new JobsListFragment();
        return jobsListFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recylerview_container);

         addJobButton = view.findViewById(R.id.addJob);
         addJobButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fragmentInterface.showNewFormList();
             }
         });

        jobList = new ArrayList<>();
        jobList.addAll(jobDataBaseHelper.getJobList());
        jobListAdapter = new JobListAdapter(jobList);
        recyclerView.setAdapter(jobListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

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

    @Override
    public void showNewFormList() {

    }
}

