package com.pursuit.handy_helper_app;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pursuit.handy_helper_app.Fragments.JobsListFragment;
import com.pursuit.handy_helper_app.Fragments.LogInFragment;
import com.pursuit.handy_helper_app.Fragments.NewJobFormFragment;
import com.pursuit.handy_helper_app.Fragments.SignUpFragment;

public class MainActivity extends AppCompatActivity implements FragmentInterface {
    FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SignUpFragment.newInstance(SignUpFragment.getArgParamUserChoice(),
                        SignUpFragment.getArgParamEmailInput(),
                        SignUpFragment.getArgParamPasswordChoice(), SignUpFragment.getArgParamPasswordChoiceConfirm(), this)).addToBackStack(null).commit();
    }

    @Override
    public void showLogInFragment() {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LogInFragment.newInstance(LogInFragment.getArgParamUsername(), LogInFragment.getArgParamPassword(), LogInFragment.getArgParamPasswordConfirm()))
                .addToBackStack(null).commit();

    }

    @Override
    public void showJobsListFragment() {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, JobsListFragment.newInstance())
                .addToBackStack(null).commit();
    }

    @Override
    public void showNewFormList() {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NewJobFormFragment.newInstance())
                .addToBackStack(null).commit();
    }

    public void showSignUpFragment(View view) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SignUpFragment.newInstance2())
                .addToBackStack(null).commit();
    }

   /* @Override
    public void showSignUpFragment() {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SignUpFragment.newInstance2())
                .addToBackStack(null).commit();
    }

    //showJobsList(){}
//*/
//   JobDataBaseHelper jobDataBaseHelper = new JobDataBaseHelper(getApplicationContext());
//   jobDataBaseHelper.addJob(new Job);

}