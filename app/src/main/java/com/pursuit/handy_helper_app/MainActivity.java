package com.pursuit.handy_helper_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pursuit.handy_helper_app.Fragments.JobsListFragment;
import com.pursuit.handy_helper_app.Fragments.LogInFragment;
import com.pursuit.handy_helper_app.Fragments.RecyclerviewFragment;
import com.pursuit.handy_helper_app.Fragments.SignUpFragment;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, SignUpFragment.newInstance(SignUpFragment.getArgParamUserChoice(),
                        SignUpFragment.getArgParamEmailInput(),
                        SignUpFragment.getArgParamPasswordChoice(), SignUpFragment.getArgParamPasswordChoiceConfirm(), this)).addToBackStack(null).commit();
    }

    @Override
    public void showLogInFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, LogInFragment.newInstance(LogInFragment.getArgParamUsername(), LogInFragment.getArgParamPassword(), LogInFragment.getArgParamPasswordConfirm()))
                .addToBackStack(null).commit();

    }
    public void showJobsListFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, JobsListFragment.newInstance())
                .addToBackStack(null).commit();
    }
    //showJobsList(){}
}