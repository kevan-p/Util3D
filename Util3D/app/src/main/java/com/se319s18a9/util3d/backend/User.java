package com.se319s18a9.util3d.backend;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

/**
 * Created by Mason on 2/14/2018.
 */

public class User {
    private static final User instance = new User();
    private FirebaseAuth mAuth;

    private User() {
        mAuth = FirebaseAuth.getInstance();
    }

    public static User getInstance(){
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

    public void sendPasswordResetEmail(String email){
        mAuth.sendPasswordResetEmail(email);
    }

    //TODO: add display name registration
    public boolean createAccount(String email, String password){
        return mAuth.createUserWithEmailAndPassword(email, password).isSuccessful();
    }

    public boolean changeEmail(String email){
        return isAlreadyLoggedIn() ? mAuth.getCurrentUser().updateEmail(email).isSuccessful() : false;
    }

    public boolean changeDisplayName(String displayName){
        UserProfileChangeRequest.Builder change = new UserProfileChangeRequest.Builder();
        return isAlreadyLoggedIn() ? mAuth.getCurrentUser().updateProfile(change.setDisplayName(displayName).build()).isSuccessful() : false;
    }

    public boolean changePassword(String password){
        return isAlreadyLoggedIn() ? mAuth.getCurrentUser().updatePassword(password).isSuccessful() : false;
    }

    public void signOut() {
        mAuth.signOut();
    }
}