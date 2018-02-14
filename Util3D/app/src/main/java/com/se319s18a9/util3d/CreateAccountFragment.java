package com.se319s18a9.util3d;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountFragment extends Fragment implements View.OnClickListener {

    OnAccountCreatedListener mCallback;

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText securityQuestionEditText;
    private EditText securityAnswerEditText;

    Button createButton;
    Button cancelButton;

    public interface OnAccountCreatedListener {
        void onAccountCreated(String username, String password);
    }

    public CreateAccountFragment() {
        // Empty constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnAccountCreatedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnAccountCreatedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_createaccount, container, false);

        // Initialize EditTexts and Buttons

        usernameEditText = v.findViewById(R.id.fragment_createAccount_editText_username);
        emailEditText = v.findViewById(R.id.fragment_createAccount_editText_email);
        passwordEditText = v.findViewById(R.id.fragment_createAccount_editText_password);
        securityQuestionEditText= v.findViewById(R.id.fragment_createAccount_editText_securityQuestion);
        securityAnswerEditText= v.findViewById(R.id.fragment_createAccount_editText_securityAnswer);

        createButton= v.findViewById(R.id.fragment_createAccount_button_create);
        createButton.setOnClickListener(this);

        cancelButton= v.findViewById(R.id.fragment_createAccount_button_cancel);
        cancelButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.fragment_createAccount_button_create:
                Toast.makeText(this.getContext(), R.string.s_fragment_createAccount_debug_create, Toast.LENGTH_SHORT).show(); // DEBUG

                String username = this.getEditTextValue(usernameEditText);
                String email = this.getEditTextValue(emailEditText);
                String password = this.getEditTextValue(passwordEditText);
                String securityQuestion = this.getEditTextValue(securityQuestionEditText);
                String securityAnswer = this.getEditTextValue(securityAnswerEditText);

                if(validateFields(username, password, email, securityQuestion, securityAnswer)) {
                    // TODO: Store new credentials in Firebase
                    mCallback.onAccountCreated(username, password);
                } else {
                    Toast.makeText(this.getContext(), R.string.s_fragment_createAccount_error_fieldError, Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.fragment_createAccount_button_cancel:
                // TODO: Discard credentials and return to LoginFragment
                Toast.makeText(this.getContext(), R.string.s_fragment_createAccount_debug_cancel, Toast.LENGTH_SHORT).show(); // DEBUG
                break;
        }
    }

    private String getEditTextValue(EditText editText) {
        return editText.getText().toString();
    }

    private boolean validateFields(String username, String email, String password, String securityQuestion, String securityAnswer) {
        // TODO: Check against Firebase existing credentials table

        // TODO: TEST (REMOVE) =====

        if((username.equals("")) || (email.equals("")) || (password.equals("")) || (securityQuestion.equals("")) || (securityAnswer.equals(""))) {
            return false;
        }

        // TODO: TEST (REMOVE) =====

        return true;
    }
}