package com.pursuit.handy_helper_app.recyclerviewComponenets;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pursuit.handy_helper_app.FragmentInterface;
import com.pursuit.handy_helper_app.Fragments.DetailFragment;
import com.pursuit.handy_helper_app.Job;
import com.pursuit.handy_helper_app.R;

public class JobViewHolder extends RecyclerView.ViewHolder {
    FragmentInterface fragmentInterface;
       private TextView dateTextView;
       private TextView addressTextview;
       private TextView notesTextView;
       private Bundle bundle;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(final Job job) {
            dateTextView = itemView.findViewById(R.id.date_textView);
            addressTextview = itemView.findViewById(R.id.address_textView);
            notesTextView = itemView.findViewById(R.id.notes_textView);
            dateTextView.setText(job.getDate());
            addressTextview.setText(job.getAddress());
            notesTextView.setText(job.getNote());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentInterface.showDetailFragment();
                }
            });
        }
    }

