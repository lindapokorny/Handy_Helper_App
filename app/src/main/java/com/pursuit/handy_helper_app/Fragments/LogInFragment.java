package com.pursuit.handy_helper_app.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.pursuit.handy_helper_app.FragmentInterface;
import com.pursuit.handy_helper_app.R;


public class LogInFragment extends Fragment {
    private static final String SHARED_PREFS_KEY = "sharedPrefs";

    private EditText usernameTextView;
    private EditText passwordTextView;
    private EditText passwordConfirmTextView;
    private Button logInButton;
    private TextView signUpNowTextView;
    private SharedPreferences login;
    private static FragmentInterface fragmentInterface;

    private static final String ARG_PARAM_USERNAME = "username";
    private static final String ARG_PARAM_PASSWORD = "password";
    private static final String ARG_PARAM_PASSWORD_CONFIRM = "confirm";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        login = getContext().getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        if (login.getBoolean("isChecked", false)){
            usernameTextView.setText(login.getString("username", null));
            passwordTextView.setText(login.getString("password", null));
            passwordConfirmTextView.setText(login.getString("confirm", null));
        }
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM_USERNAME);
            mParam2 = getArguments().getString(ARG_PARAM_PASSWORD);
            mParam3 = getArguments().getString(ARG_PARAM_PASSWORD_CONFIRM);
        }
        if ((ARG_PARAM_USERNAME) == SignUpFragment.getArgParamUserChoice() && (mParam2 == mParam3));
        }

    public LogInFragment() {
    }

    public static String getArgParamUsername() {
        return ARG_PARAM_USERNAME;
    }
    public static String getArgParamPassword() {
        return ARG_PARAM_PASSWORD;
    }

    public static String getArgParamPasswordConfirm() {
        return ARG_PARAM_PASSWORD_CONFIRM;
    }

    public static LogInFragment newInstance(String username, String password, String passwordConfirm) {
        LogInFragment fragment = new LogInFragment();
        Bundle args = new Bundle();
        args.getString(ARG_PARAM_USERNAME, username);
        args.getString(ARG_PARAM_PASSWORD, password);
        args.getString(ARG_PARAM_PASSWORD_CONFIRM, passwordConfirm);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_log_in, container, false);
        usernameTextView = rootView.findViewById(R.id.username_input);
        passwordTextView = rootView.findViewById(R.id.password_input);
        passwordConfirmTextView = rootView.findViewById(R.id.password_input_confirm);
        logInButton = rootView.findViewById(R.id.log_in_button);
        signUpNowTextView = rootView.findViewById(R.id.sign_up_now);


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.showJobsListFragment();
            }
        });
    }
        /*signUpNowTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  fragmentInterface.showSignUpFragment();
            }
        });*/


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentInterface = (FragmentInterface) context;
    }
}
