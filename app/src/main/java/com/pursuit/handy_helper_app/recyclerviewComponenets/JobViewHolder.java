package com.pursuit.handy_helper_app.recyclerviewComponenets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pursuit.handy_helper_app.Job;
import com.pursuit.handy_helper_app.R;

public class JobViewHolder extends RecyclerView.ViewHolder {
       private TextView dateTextView;
       private TextView addressTextview;
       private TextView notesTextView;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Job job) {
            dateTextView = itemView.findViewById(R.id.date_textView);
            addressTextview = itemView.findViewById(R.id.address_textView);
            notesTextView = itemView.findViewById(R.id.notes_textView);
            dateTextView.setText(job.getDate());
            addressTextview.setText(job.getAddress());
            notesTextView.setText(job.getNote());
        }
    }

