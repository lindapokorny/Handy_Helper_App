package com.pursuit.handy_helper_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
}