package com.se319s18a9.util3d.backend;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Mason on 2/14/2018.
 */

public class Login {
    private static final Login instance = new Login();
    private FirebaseAuth mAuth;

    private Login() {
        mAuth = FirebaseAuth.getInstance();
    }

    public static Login getInstance(){
        return instance;
    }

    public boolean isAlreadyLoggedIn(){
        return mAuth.getCurrentUser() != null;
    }

    //TODO: If user is already logged in, decide how to handle this request
    public boolean validateAndLogin(String username, String password) {
        mAuth.signInWithEmailAndPassword(username, password);
        return isAlreadyLoggedIn();
    }
}