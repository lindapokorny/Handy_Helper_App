package com.pursuit.handy_helper_app;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.pursuit.handy_helper_app.Fragments.DetailFragment;
import com.pursuit.handy_helper_app.Fragments.JobsListFragment;
import com.pursuit.handy_helper_app.Fragments.LogInFragment;
import com.pursuit.handy_helper_app.Fragments.NewJobFormFragment;
import com.pursuit.handy_helper_app.Fragments.SignUpFragment;

public class MainActivity extends AppCompatActivity implements FragmentInterface {
    FragmentManager fragmentManager = getSupportFragmentManager();
    private Toolbar toolbar;
    Job job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_slideshow);

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LogInFragment.newInstance(LogInFragment.getArgParamUsername(), LogInFragment.getArgParamPassword(), LogInFragment.getArgParamPasswordConfirm()))
                .addToBackStack(null).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_favorite){
            Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
                .replace(R.id.fragment_container, JobsListFragment.newInstance(job))
                .addToBackStack(null).commit();
    }

    @Override
    public void showNewFormList() {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NewJobFormFragment.newInstance())
                .addToBackStack(null).commit();
    }

    @Override
    public void showSignUpFragment() {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SignUpFragment.newInstance(SignUpFragment.getArgParamUserChoice(),
                        SignUpFragment.getArgParamEmailInput(),
                        SignUpFragment.getArgParamPasswordChoice(), SignUpFragment.getArgParamPasswordChoiceConfirm(), this)).addToBackStack(null).commit();

    }

    @Override
    public void showDetailFragment() {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, DetailFragment.newInstance(DetailFragment.getArgParamDate(),
                        DetailFragment.getArgParamAddress(),
                        DetailFragment.getArgParamNotes()))
                .addToBackStack(null).commit();

    }
}