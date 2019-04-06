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
import android.widget.EditText;

import com.pursuit.handy_helper_app.FragmentInterface;
import com.pursuit.handy_helper_app.R;


public class SignUpFragment extends Fragment {
    private static final String SHARED_PREFS_KEY = "sharedPrefs";
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText passwordConfirmEditText;
    private Button signUpButton;
    private SharedPreferences signUp;
    private static FragmentInterface fragmentInterface;
    private static final String ARG_PARAM_USER_CHOICE = "username";
    private static final String ARG_PARAM_EMAIL_INPUT = "email";
    private static final String ARG_PARAM_PASSWORD_CHOICE = "password";
    private static final String ARG_PARAM_PASSWORD_CHOICE_CONFIRM = "passwordConfirm";

    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        signUp = getContext().getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        if (signUp.getBoolean("isClicked", false)) {
            usernameEditText.setText(signUp.getString("username", null));
            emailEditText.setText(signUp.getString("email", null));
            passwordEditText.setText(signUp.getString("password", null));
            passwordConfirmEditText.setText(signUp.getString("passwordConfirm", null));
        }
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM_USER_CHOICE);
            mParam2 = getArguments().getString(ARG_PARAM_EMAIL_INPUT);
            mParam3 = getArguments().getString(ARG_PARAM_PASSWORD_CHOICE);
            mParam4 = getArguments().getString(ARG_PARAM_PASSWORD_CHOICE_CONFIRM);
        }
    }
    public SignUpFragment() {
    }

    public static String getArgParamUserChoice() {
        return ARG_PARAM_USER_CHOICE;
    }

    public static String getArgParamEmailInput() {
        return ARG_PARAM_EMAIL_INPUT;
    }

    public static String getArgParamPasswordChoice() {
        return ARG_PARAM_PASSWORD_CHOICE;
    }

    public static String getArgParamPasswordChoiceConfirm() {
        return ARG_PARAM_PASSWORD_CHOICE_CONFIRM;
    }

    public static SignUpFragment newInstance(String username, String email, String password, String passwordConfirm, FragmentInterface fraginterface) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_USER_CHOICE, username);
        args.putString(ARG_PARAM_EMAIL_INPUT, email);
        args.putString(ARG_PARAM_PASSWORD_CHOICE, password);
        args.putString(ARG_PARAM_PASSWORD_CHOICE_CONFIRM, passwordConfirm);
        fragment.setArguments(args);
        return fragment;
    }
    public static SignUpFragment newInstance2(){
        return new SignUpFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentInterface = (FragmentInterface) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usernameEditText = view.findViewById(R.id.editText_username);
        emailEditText = view.findViewById(R.id.editText_email);
        passwordEditText = view.findViewById(R.id.editText_password);
        passwordConfirmEditText = view.findViewById(R.id.editText_password_confirm);
        signUpButton = view.findViewById(R.id.sign_up_button);

        usernameEditText.setText(mParam1);
        emailEditText.setText(mParam2);
        passwordEditText.setText(mParam3);
        passwordConfirmEditText.setText(mParam4);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = signUp.edit();
                if (usernameEditText.getText() != null && emailEditText.getText() != null && passwordEditText.getText() != null && passwordConfirmEditText.getText() != null) {
                    editor.putString("username", usernameEditText.getText().toString());
                    editor.putString("email", emailEditText.getText().toString());
                    editor.putString("password", passwordEditText.getText().toString());
                    editor.putString("confirm", passwordConfirmEditText.getText().toString());
                    editor.commit();
                }
                fragmentInterface.showLogInFragment();
            }

//
//
        });
    }
}
