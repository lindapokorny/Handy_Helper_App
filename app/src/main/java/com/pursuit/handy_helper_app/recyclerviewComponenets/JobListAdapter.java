package com.pursuit.handy_helper_app.recyclerviewComponenets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.handy_helper_app.Job;
import com.pursuit.handy_helper_app.R;

import java.util.List;

public class JobListAdapter extends RecyclerView.Adapter<JobViewHolder> {
    List<Job> jobList;

    public JobListAdapter(List<Job> jobList) {
        this.jobList = jobList;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View recyclerLayout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.job_item_view, viewGroup, false);

        return new JobViewHolder(recyclerLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder jobViewHolder, int i) {
    jobViewHolder.bind(jobList.get(i));
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }
}
