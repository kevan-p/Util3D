package com.se319s18a9.util3d;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements
        LoginFragment.OnSuccessfulLoginListener,
        CreateAccountFragment.OnAccountCreatedListener {

//    static final boolean LOGGED_IN = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        selectStartingFragment();
    }

    public void selectStartingFragment() {
        /*
        Order:
            1. Splash screen
            2. If logged in --> Start MainActivity (DONE)
                       else --> Load LoginFragment
                            (can go to CreateAccountFragment or ForgotPassword fragment from here)
            3. When login is valid --> Start MainActivity (DONE)
         */

        Fragment startingFragment;

        // TODO: Splash screen

        // TODO: Validate login
//        if(LOGGED_IN) {
//            startingFragment = new MainActivity(); // Remove LoginActivity from back stack
//        } // else...

        startingFragment = new LoginFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_login_fragment, startingFragment);
        fragmentTransaction.commit();
    }

    public void onSuccessfulLogin(String name, String password) {
        // TODO: Login
        Toast.makeText(this, name + " - " + password, Toast.LENGTH_SHORT).show();
    }

    public void onAccountCreated(String name, String password) {
        // TODO: Automatically login
        Toast.makeText(this, name + " : " + password + " - created", Toast.LENGTH_SHORT).show();
    }
}
