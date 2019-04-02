package com.pursuit.handy_helper_app;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class LogInFragment extends Fragment {
    private static final String SHARED_PREFS_KEY = "sharedPrefs";

    private EditText usernameTextView;
    private EditText passwordTextView;
    private EditText passwordConfirmTextView;
    private CheckBox checkBox;
    private Button logInButton;
    private SharedPreferences login;
    private static FragmentInterface fragmentInterface;

    private static final String ARG_PARAM_USERNAME = "username";
    private static final String ARG_PARAM_PASSWORD = "password";
    private static final String ARG_PARAM_PASSWORD_CONFIRM = "confirmPassword";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        login = getContext().getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        if (login.getBoolean("isChecked", false)){
            usernameTextView.getText(login.getString(ARG_PARAM_USERNAME, null));
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false);
    }

}
